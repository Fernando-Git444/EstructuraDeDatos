package Unidad3Praticos.swing;


import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 * 
 * Simulador de DOM (Document Object Model) usando JTree en Swing
 * Permite visualizar la estructura HTML como un árbol jerárquico
 * y ver su representación HTML en tiempo real.
 */
public class SimuladorDOM extends JFrame {
    
    // Componentes principales de la interfaz
    private JTree tree;
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JTextArea htmlView;
    private JTextField nodeNameField;
    private JTextField nodeContentField;
    private JComboBox<String> nodeTypeCombo;
    
    // Tipos de nodos HTML disponibles
    private final String[] HTML_TAGS = {
        "html", "head", "title", "body", "div", "p", "h1", "h2", "h3", 
        "span", "a", "img", "ul", "ol", "li", "table", "tr", "td", "form", "input"
    };
    
    /**
     * Constructor principal - inicializa la interfaz gráfica
     */
    public SimuladorDOM() {
        setTitle("Simulador DOM - Árbol de Página Web");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear nodo raíz del árbol DOM
        root = new DefaultMutableTreeNode("document");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        
        initializeComponents();
        setupLayout();
        addListeners();
        
        // Crear estructura HTML básica inicial
        createInitialStructure();
    }
    
    /**
     * Inicializa todos los componentes de la interfaz
     */
    private void initializeComponents() {
        // Configurar el árbol visual
        tree.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tree.setRowHeight(25);
        
        // Área de texto para visualización HTML
        htmlView = new JTextArea();
        htmlView.setFont(new Font("Consolas", Font.PLAIN, 13));
        htmlView.setEditable(false);
        htmlView.setBackground(new Color(40, 44, 52));
        htmlView.setForeground(new Color(171, 178, 191));
        htmlView.setMargin(new Insets(10, 10, 10, 10));
        
        // Campos de entrada para nuevos nodos
        nodeNameField = new JTextField(15);
        nodeContentField = new JTextField(20);
        nodeTypeCombo = new JComboBox<>(HTML_TAGS);
        
        // Estilo de los campos
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);
        nodeNameField.setFont(fieldFont);
        nodeContentField.setFont(fieldFont);
        nodeTypeCombo.setFont(fieldFont);
    }
    
    /**
     * Configura el diseño de la interfaz usando BorderLayout y paneles
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel izquierdo: Árbol DOM
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(66, 135, 245), 2),
            "Estructura del Árbol DOM",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        
        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setPreferredSize(new Dimension(400, 0));
        leftPanel.add(treeScroll, BorderLayout.CENTER);
        
        // Panel derecho: Vista HTML
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(40, 167, 69), 2),
            "Vista HTML Generada",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        
        JScrollPane htmlScroll = new JScrollPane(htmlView);
        rightPanel.add(htmlScroll, BorderLayout.CENTER);
        
        // Panel de controles superior
        JPanel controlPanel = createControlPanel();
        
        // Agregar paneles al frame principal
        add(controlPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }
    
    /**
     * Crea el panel de controles con botones y campos de entrada
     * @return Panel configurado con todos los controles
     */
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        // Etiquetas y campos
        panel.add(new JLabel("Tipo de Etiqueta:"));
        panel.add(nodeTypeCombo);
        
        panel.add(new JLabel("ID/Clase:"));
        panel.add(nodeNameField);
        
        panel.add(new JLabel("Contenido:"));
        panel.add(nodeContentField);
        
        // Botones de acción
        JButton addButton = createStyledButton("➕ Agregar Nodo", new Color(40, 167, 69));
        JButton deleteButton = createStyledButton("🗑️ Eliminar Nodo", new Color(220, 53, 69));
        JButton updateButton = createStyledButton("🔄 Actualizar Vista", new Color(0, 123, 255));
        JButton clearButton = createStyledButton("🗑️ Limpiar Todo", new Color(108, 117, 125));
        
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        panel.add(clearButton);
        
        // Asociar acciones a botones
        addButton.addActionListener(e -> addNode());
        deleteButton.addActionListener(e -> deleteNode());
        updateButton.addActionListener(e -> updateHTMLView());
        clearButton.addActionListener(e -> clearTree());
        
        return panel;
    }
    
    /**
     * Crea un botón con estilo personalizado
     * @param text Texto del botón
     * @param color Color de fondo
     * @return Botón estilizado
     */
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(150, 35));
        
        // Efecto hover
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
        
        return button;
    }
    
    /**
     * Agrega listeners para actualizar la vista HTML automáticamente
     */
    private void addListeners() {
        tree.addTreeSelectionListener(e -> updateHTMLView());
        
        // Actualizar vista al presionar Enter en los campos
        ActionListener updateListener = e -> updateHTMLView();
        nodeNameField.addActionListener(updateListener);
        nodeContentField.addActionListener(updateListener);
    }
    
    /**
     * Crea la estructura HTML inicial básica
     * Implementa el concepto de árbol jerárquico del DOM
     */
    private void createInitialStructure() {
        // Nodo html (raíz del documento)
        DefaultMutableTreeNode htmlNode = new DefaultMutableTreeNode("<html>");
        
        // Nodo head
        DefaultMutableTreeNode headNode = new DefaultMutableTreeNode("<head>");
        DefaultMutableTreeNode titleNode = new DefaultMutableTreeNode("<title>Mi Página Web</title>");
        headNode.add(titleNode);
        
        // Nodo body
        DefaultMutableTreeNode bodyNode = new DefaultMutableTreeNode("<body>");
        DefaultMutableTreeNode h1Node = new DefaultMutableTreeNode("<h1>Bienvenido al Simulador DOM</h1>");
        DefaultMutableTreeNode pNode = new DefaultMutableTreeNode("<p>Este es un ejemplo de estructura HTML</p>");
        
        bodyNode.add(h1Node);
        bodyNode.add(pNode);
        
        // Construir jerarquía del árbol
        htmlNode.add(headNode);
        htmlNode.add(bodyNode);
        root.add(htmlNode);
        
        // Expandir todos los nodos para visualización
        expandAllNodes(tree, 0, tree.getRowCount());
        updateHTMLView();
    }
    
    /**
     * Agrega un nuevo nodo al árbol DOM
     * Valida que haya un nodo seleccionado como padre
     */
    private void addNode() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        
        if (selectedNode == null) {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecciona un nodo padre donde agregar el nuevo elemento",
                "Nodo padre requerido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Construir el nuevo nodo HTML
        String tag = (String) nodeTypeCombo.getSelectedItem();
        String name = nodeNameField.getText().trim();
        String content = nodeContentField.getText().trim();
        
        StringBuilder nodeText = new StringBuilder("<" + tag);
        
        // Agregar atributos si existen
        if (!name.isEmpty()) {
            if (name.startsWith(".")) {
                nodeText.append(" class=\"").append(name.substring(1)).append("\"");
            } else if (name.startsWith("#")) {
                nodeText.append(" id=\"").append(name.substring(1)).append("\"");
            } else {
                nodeText.append(" id=\"").append(name).append("\"");
            }
        }
        
        nodeText.append(">");
        
        if (!content.isEmpty()) {
            nodeText.append(content);
        }
        
        nodeText.append("</").append(tag).append(">");
        
        // Crear y agregar el nuevo nodo al árbol
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeText.toString());
        selectedNode.add(newNode);
        
        // Actualizar modelo y vista
        treeModel.reload(selectedNode);
        tree.expandPath(new TreePath(selectedNode.getPath()));
        updateHTMLView();
        
        // Limpiar campos
        nodeNameField.setText("");
        nodeContentField.setText("");
        
        JOptionPane.showMessageDialog(this,
            "Nodo agregado exitosamente",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Elimina el nodo seleccionado del árbol
     * Valida que no sea el nodo raíz
     */
    private void deleteNode() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        
        if (selectedNode == null) {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecciona un nodo para eliminar",
                "Nodo no seleccionado",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (selectedNode == root) {
            JOptionPane.showMessageDialog(this,
                "No se puede eliminar el nodo raíz del documento",
                "Operación no permitida",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Confirmar eliminación
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de eliminar este nodo y todos sus hijos?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
            treeModel.removeNodeFromParent(selectedNode);
            updateHTMLView();
            
            JOptionPane.showMessageDialog(this,
                "Nodo eliminado exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Actualiza la vista HTML generando el código desde el árbol
     * Recorre recursivamente la estructura del árbol DOM
     */
    private void updateHTMLView() {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        generateHTML(root, html, 0);
        htmlView.setText(html.toString());
        htmlView.setCaretPosition(0);
    }
    
    /**
     * Genera el código HTML recursivamente desde un nodo
     * @param node Nodo actual del árbol
     * @param html StringBuilder para construir el HTML
     * @param level Nivel de indentación
     */
    private void generateHTML(DefaultMutableTreeNode node, StringBuilder html, int level) {
        String indent = "  ".repeat(level);
        String nodeText = node.toString();
        
        // El nodo raíz "document" no se imprime
        if (!nodeText.equals("document")) {
            html.append(indent).append(nodeText).append("\n");
        }
        
        // Procesar todos los hijos recursivamente
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            generateHTML(child, html, nodeText.equals("document") ? level : level + 1);
        }
    }
    
    /**
     * Limpia todo el árbol excepto el nodo raíz
     */
    private void clearTree() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de limpiar toda la estructura del árbol?",
            "Confirmar limpieza",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            root.removeAllChildren();
            treeModel.reload();
            updateHTMLView();
            
            JOptionPane.showMessageDialog(this,
                "Árbol limpiado. Puedes crear una nueva estructura.",
                "Árbol limpiado",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Expande todos los nodos del árbol para mejor visualización
     * @param tree Árbol a expandir
     * @param startingIndex Índice inicial
     * @param rowCount Cantidad de filas
     */
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
    
    /**
     * Método principal - punto de entrada de la aplicación
     */
    public static void main(String[] args) {
        try {
            // Usar el Look and Feel del sistema para mejor apariencia
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            SimuladorDOM simulator = new SimuladorDOM();
            simulator.setVisible(true);
        });
    }
}
