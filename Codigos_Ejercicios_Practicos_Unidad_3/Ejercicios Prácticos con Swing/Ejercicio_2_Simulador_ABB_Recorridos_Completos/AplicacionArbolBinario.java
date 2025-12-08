package Unidad3Praticos.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 * 
 * Aplicación educativa para comprender Árboles Binarios de Búsqueda (ABB)
 * Incluye operaciones de inserción, eliminación, búsqueda y recorridos
 */
public class AplicacionArbolBinario extends JFrame {
    
    // Componentes de la interfaz
    private TreePanel treePanel;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton insertBtn, deleteBtn, searchBtn;
    private JButton inOrderBtn, preOrderBtn, postOrderBtn;
    private JButton clearBtn;
    private JComboBox<String> testCombo;
    
    // Árbol binario de búsqueda
    private BinarySearchTree bst;
    
    /**
     * Constructor principal de la aplicación
     */
    public AplicacionArbolBinario() {
        bst = new BinarySearchTree();
        
        setTitle("Simulador de Árbol Binario de Búsqueda (ABB)");
        setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initializeComponents();
        setupLayout();
        addListeners();
    }
    
    /**
     * Inicializa todos los componentes de la interfaz
     */
    private void initializeComponents() {
        treePanel = new TreePanel();
        
        inputField = new JTextField(10);
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        outputArea = new JTextArea(8, 30);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(248, 249, 250));
        outputArea.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        
        // Botones de operaciones básicas
        insertBtn = createButton("➕ Insertar", new Color(40, 167, 69));
        deleteBtn = createButton("🗑️ Eliminar", new Color(220, 53, 69));
        searchBtn = createButton("🔍 Buscar", new Color(0, 123, 255));
        clearBtn = createButton("🔄 Limpiar", new Color(108, 117, 125));
        
        // Botones de recorridos
        inOrderBtn = createButton("InOrden", new Color(111, 66, 193));
        preOrderBtn = createButton("PreOrden", new Color(253, 126, 20));
        postOrderBtn = createButton("PostOrden", new Color(32, 201, 151));
        
        // ComboBox con pruebas predefinidas
        String[] tests = {
            "Seleccionar Prueba...",
            "P1.1: Árbol Balanceado (50,30,70,20,40,60,80)",
            "P1.2: Degenerado Derecha (10,20,30,40,50,60,70)",
            "P1.3: Degenerado Izquierda (70,60,50,40,30,20,10)",
            "P1.4: Duplicados (50,50)",
            "P4: Setup Eliminación (50,30,70,20,40,60,80)"
        };
        testCombo = new JComboBox<>(tests);
        testCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }
    
    /**
     * Configura el diseño de la interfaz
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel superior: Controles
        JPanel topPanel = createControlPanel();
        
        // Panel central: Visualización del árbol
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 2),
            "Visualización del Árbol Binario de Búsqueda",
            0, 0, new Font("Segoe UI", Font.BOLD, 14)
        ));
        centerPanel.add(new JScrollPane(treePanel), BorderLayout.CENTER);
        
        // Panel derecho: Salida de resultados
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(40, 167, 69), 2),
            "Resultados y Recorridos",
            0, 0, new Font("Segoe UI", Font.BOLD, 14)
        ));
        rightPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        rightPanel.setPreferredSize(new Dimension(350, 0));
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }
    
    /**
     * Crea el panel de controles con todos los botones
     */
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(new Color(248, 249, 250));
        
        panel.add(new JLabel("Valor:"));
        panel.add(inputField);
        panel.add(insertBtn);
        panel.add(deleteBtn);
        panel.add(searchBtn);
        panel.add(clearBtn);
        
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        
        JLabel recLabel = new JLabel("Recorridos:");
        recLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel.add(recLabel);
        panel.add(inOrderBtn);
        panel.add(preOrderBtn);
        panel.add(postOrderBtn);
        
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        
        panel.add(new JLabel("Pruebas:"));
        panel.add(testCombo);
        
        return panel;
    }
    
    /**
     * Crea un botón estilizado
     */
    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }
    
    /**
     * Agrega listeners a los componentes
     */
    private void addListeners() {
        insertBtn.addActionListener(e -> insertValue());
        deleteBtn.addActionListener(e -> deleteValue());
        searchBtn.addActionListener(e -> searchValue());
        clearBtn.addActionListener(e -> clearTree());
        
        inOrderBtn.addActionListener(e -> performTraversal("InOrden"));
        preOrderBtn.addActionListener(e -> performTraversal("PreOrden"));
        postOrderBtn.addActionListener(e -> performTraversal("PostOrden"));
        
        testCombo.addActionListener(e -> loadTest());
        
        inputField.addActionListener(e -> insertValue());
    }
    
    /**
     * Inserta un valor en el árbol
     */
    private void insertValue() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            boolean inserted = bst.insert(value);
            
            if (inserted) {
                outputArea.append("✓ Insertado: " + value + "\n");
                treePanel.setTree(bst);
                treePanel.repaint();
                inputField.setText("");
            } else {
                outputArea.append("⚠ Valor duplicado: " + value + " (no insertado)\n");
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error de entrada",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Elimina un valor del árbol
     */
    private void deleteValue() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            boolean deleted = bst.delete(value);
            
            if (deleted) {
                outputArea.append("✓ Eliminado: " + value + "\n");
                treePanel.setTree(bst);
                treePanel.repaint();
                inputField.setText("");
            } else {
                outputArea.append("✗ No encontrado: " + value + "\n");
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error de entrada",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Busca un valor en el árbol
     */
    private void searchValue() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            boolean found = bst.search(value);
            
            if (found) {
                outputArea.append("🔍 Encontrado: " + value + "\n");
                treePanel.highlightNode(value);
            } else {
                outputArea.append("🔍 No encontrado: " + value + "\n");
                treePanel.clearHighlight();
            }
            
            treePanel.repaint();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error de entrada",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Realiza un recorrido del árbol
     */
    private void performTraversal(String type) {
        List<Integer> result = new ArrayList<>();
        
        switch (type) {
            case "InOrden":
                result = bst.inOrder();
                break;
            case "PreOrden":
                result = bst.preOrder();
                break;
            case "PostOrden":
                result = bst.postOrder();
                break;
        }
        
        outputArea.append("\n" + type + ": ");
        for (int val : result) {
            outputArea.append(val + " ");
        }
        outputArea.append("\n");
    }
    
    /**
     * Limpia el árbol
     */
    private void clearTree() {
        bst.clear();
        treePanel.setTree(bst);
        treePanel.repaint();
        outputArea.append("\n=== Árbol limpiado ===\n\n");
    }
    
    /**
     * Carga una prueba predefinida
     */
    private void loadTest() {
        int index = testCombo.getSelectedIndex();
        if (index == 0) return;
        
        clearTree();
        
        int[] values = {};
        String testName = "";
        
        switch (index) {
            case 1: // P1.1
                values = new int[]{50, 30, 70, 20, 40, 60, 80};
                testName = "P1.1: Árbol Balanceado";
                break;
            case 2: // P1.2
                values = new int[]{10, 20, 30, 40, 50, 60, 70};
                testName = "P1.2: Degenerado Derecha";
                break;
            case 3: // P1.3
                values = new int[]{70, 60, 50, 40, 30, 20, 10};
                testName = "P1.3: Degenerado Izquierda";
                break;
            case 4: // P1.4
                values = new int[]{50, 50};
                testName = "P1.4: Prueba de Duplicados";
                break;
            case 5: // P4
                values = new int[]{50, 30, 70, 20, 40, 60, 80};
                testName = "P4: Setup para Eliminación";
                break;
        }
        
        outputArea.append("=== " + testName + " ===\n");
        outputArea.append("Insertando: ");
        
        for (int val : values) {
            bst.insert(val);
            outputArea.append(val + " ");
        }
        
        outputArea.append("\n");
        treePanel.setTree(bst);
        treePanel.repaint();
        
        testCombo.setSelectedIndex(0);
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            AplicacionArbolBinario app = new AplicacionArbolBinario();
            app.setVisible(true);
        });
    }
}

/**
 * Clase que representa un nodo del árbol binario
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

/**
 * Clase que implementa el Árbol Binario de Búsqueda
 */
class BinarySearchTree {
    private TreeNode root;
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    /**
     * Inserta un valor en el árbol
     * @param value Valor a insertar
     * @return true si se insertó, false si es duplicado
     */
    public boolean insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        return insertRec(root, value);
    }
    
    private boolean insertRec(TreeNode node, int value) {
        if (value == node.value) {
            return false; // No permitir duplicados
        }
        
        if (value < node.value) {
            if (node.left == null) {
                node.left = new TreeNode(value);
                return true;
            }
            return insertRec(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(value);
                return true;
            }
            return insertRec(node.right, value);
        }
    }
    
    /**
     * Busca un valor en el árbol
     * @param value Valor a buscar
     * @return true si existe, false si no
     */
    public boolean search(int value) {
        return searchRec(root, value);
    }
    
    private boolean searchRec(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        
        if (value == node.value) {
            return true;
        }
        
        if (value < node.value) {
            return searchRec(node.left, value);
        } else {
            return searchRec(node.right, value);
        }
    }
    
    /**
     * Elimina un valor del árbol
     * @param value Valor a eliminar
     * @return true si se eliminó, false si no existe
     */
    public boolean delete(int value) {
        if (!search(value)) {
            return false;
        }
        root = deleteRec(root, value);
        return true;
    }
    
    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        
        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Caso 1: Nodo hoja (sin hijos)
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // Caso 2: Nodo con un solo hijo
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // Caso 3: Nodo con dos hijos
            // Encontrar el sucesor inorden (mínimo del subárbol derecho)
            TreeNode successor = findMin(node.right);
            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }
        
        return node;
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    /**
     * Recorrido InOrden (Izquierda-Raíz-Derecha)
     * Devuelve los elementos en orden ascendente
     */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }
    
    private void inOrderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.value);
            inOrderRec(node.right, result);
        }
    }
    
    /**
     * Recorrido PreOrden (Raíz-Izquierda-Derecha)
     */
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }
    
    private void preOrderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preOrderRec(node.left, result);
            preOrderRec(node.right, result);
        }
    }
    
    /**
     * Recorrido PostOrden (Izquierda-Derecha-Raíz)
     */
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }
    
    private void postOrderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            postOrderRec(node.left, result);
            postOrderRec(node.right, result);
            result.add(node.value);
        }
    }
    
    /**
     * Limpia el árbol
     */
    public void clear() {
        root = null;
    }
    
    public TreeNode getRoot() {
        return root;
    }
}

/**
 * Panel personalizado para dibujar el árbol gráficamente
 */
class TreePanel extends JPanel {
    private BinarySearchTree tree;
    private int highlightedValue = -1;
    private boolean shouldHighlight = false;
    
    private static final int NODE_RADIUS = 25;
    private static final int LEVEL_HEIGHT = 80;
    private static final Color NODE_COLOR = new Color(0, 123, 255);
    private static final Color HIGHLIGHT_COLOR = new Color(220, 53, 69);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color LINE_COLOR = new Color(108, 117, 125);
    
    public TreePanel() {
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.WHITE);
    }
    
    public void setTree(BinarySearchTree tree) {
        this.tree = tree;
        shouldHighlight = false;
    }
    
    public void highlightNode(int value) {
        this.highlightedValue = value;
        this.shouldHighlight = true;
    }
    
    public void clearHighlight() {
        this.shouldHighlight = false;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (tree != null && tree.getRoot() != null) {
            int width = getWidth();
            drawTree(g2d, tree.getRoot(), width / 2, 50, width / 4, 0);
        } else {
            g2d.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            g2d.setColor(Color.GRAY);
            String msg = "El árbol está vacío. Inserta valores para comenzar.";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(msg)) / 2;
            g2d.drawString(msg, x, getHeight() / 2);
        }
    }
    
    /**
     * Dibuja el árbol recursivamente
     */
    private void drawTree(Graphics2D g2d, TreeNode node, int x, int y, int xOffset, int level) {
        if (node == null) return;
        
        // Dibujar conexiones a los hijos
        if (node.left != null) {
            int childX = x - xOffset;
            int childY = y + LEVEL_HEIGHT;
            g2d.setColor(LINE_COLOR);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(x, y, childX, childY);
            drawTree(g2d, node.left, childX, childY, xOffset / 2, level + 1);
        }
        
        if (node.right != null) {
            int childX = x + xOffset;
            int childY = y + LEVEL_HEIGHT;
            g2d.setColor(LINE_COLOR);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(x, y, childX, childY);
            drawTree(g2d, node.right, childX, childY, xOffset / 2, level + 1);
        }
        
        // Dibujar el nodo
        Color nodeColor = (shouldHighlight && node.value == highlightedValue) ? 
                          HIGHLIGHT_COLOR : NODE_COLOR;
        
        g2d.setColor(nodeColor);
        g2d.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        
        g2d.setColor(nodeColor.darker());
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        
        // Dibujar el valor
        g2d.setColor(TEXT_COLOR);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
        String value = String.valueOf(node.value);
        FontMetrics fm = g2d.getFontMetrics();
        int textX = x - fm.stringWidth(value) / 2;
        int textY = y + fm.getAscent() / 2 - 2;
        g2d.drawString(value, textX, textY);
    }
}