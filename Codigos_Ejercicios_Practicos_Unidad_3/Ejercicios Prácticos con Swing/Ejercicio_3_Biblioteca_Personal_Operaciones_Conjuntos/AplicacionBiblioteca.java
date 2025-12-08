import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Aplicación de Gestión de Biblioteca Personal usando Conjuntos (Set) de Java
 * Demuestra el uso de HashSet, TreeSet y operaciones de conjuntos
 * 
 * Datos del entorno: Gestión de libros personales
 * - Título del libro
 * - Autor
 * - Género
 * - Año de publicación
 * - ISBN
 * 
 * @author Ejercicio 03 - Estructuras de Datos
 * @version 1.0
 */
public class AplicacionBiblioteca extends JFrame {
    
    // Conjuntos principales para almacenar libros
    private Set<Book> myLibrary;          // Mi biblioteca personal
    private Set<Book> wishlist;           // Lista de deseos
    private Set<Book> friendLibrary;      // Biblioteca de un amigo
    
    // Componentes de la interfaz
    private JTextField titleField, authorField, genreField, yearField, isbnField;
    private JComboBox<String> collectionCombo;
    private JTextArea resultArea;
    private DefaultTableModel tableModel;
    private JTable resultTable;
    private JLabel statsLabel;
    
    /**
     * Constructor principal de la aplicación
     */
    public AplicacionBiblioteca() {
        // Inicializar conjuntos usando HashSet para operaciones rápidas
        myLibrary = new HashSet<>();
        wishlist = new HashSet<>();
        friendLibrary = new HashSet<>();
        
        setTitle("Gestión de Biblioteca Personal - Conjuntos en Java");
        setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initializeComponents();
        setupLayout();
        addListeners();
        loadSampleData();
        updateStats();
    }
    
    /**
     * Inicializa todos los componentes de la interfaz
     */
    private void initializeComponents() {
        // Campos de entrada para datos del libro
        titleField = new JTextField(20);
        authorField = new JTextField(20);
        genreField = new JTextField(15);
        yearField = new JTextField(8);
        isbnField = new JTextField(15);
        
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);
        titleField.setFont(fieldFont);
        authorField.setFont(fieldFont);
        genreField.setFont(fieldFont);
        yearField.setFont(fieldFont);
        isbnField.setFont(fieldFont);
        
        // ComboBox para seleccionar colección
        String[] collections = {"Mi Biblioteca", "Lista de Deseos", "Biblioteca de Amigo"};
        collectionCombo = new JComboBox<>(collections);
        collectionCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        
        // Área de texto para resultados de operaciones
        resultArea = new JTextArea(10, 40);
        resultArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(248, 249, 250));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        
        // Tabla para mostrar libros
        String[] columns = {"Título", "Autor", "Género", "Año", "ISBN"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable = new JTable(tableModel);
        resultTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        resultTable.setRowHeight(25);
        resultTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        resultTable.getTableHeader().setBackground(new Color(0, 123, 255));
        resultTable.getTableHeader().setForeground(Color.WHITE);
        
        // Etiqueta de estadísticas
        statsLabel = new JLabel();
        statsLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        statsLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    
    /**
     * Configura el diseño de la interfaz
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel superior: Entrada de datos
        JPanel inputPanel = createInputPanel();
        
        // Panel central: Tabla de resultados
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 2),
            "Vista de Colección",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        JScrollPane tableScroll = new JScrollPane(resultTable);
        centerPanel.add(tableScroll, BorderLayout.CENTER);
        centerPanel.add(statsLabel, BorderLayout.SOUTH);
        
        // Panel derecho: Operaciones con conjuntos
        JPanel rightPanel = createOperationsPanel();
        
        // Panel inferior: Resultados de operaciones
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(40, 167, 69), 2),
            "Resultados de Operaciones",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        bottomPanel.setPreferredSize(new Dimension(0, 200));
        
        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Crea el panel de entrada de datos
     */
    private JPanel createInputPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(248, 249, 250));
        mainPanel.setBorder(BorderFactory.createTitledBorder("Agregar Libro"));
        
        // Panel de campos (primera fila)
        JPanel fieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        fieldsPanel.setBackground(new Color(248, 249, 250));
        
        fieldsPanel.add(new JLabel("Título:"));
        fieldsPanel.add(titleField);
        
        fieldsPanel.add(new JLabel("Autor:"));
        fieldsPanel.add(authorField);
        
        fieldsPanel.add(new JLabel("Género:"));
        fieldsPanel.add(genreField);
        
        fieldsPanel.add(new JLabel("Año:"));
        fieldsPanel.add(yearField);
        
        fieldsPanel.add(new JLabel("ISBN:"));
        fieldsPanel.add(isbnField);
        
        fieldsPanel.add(new JLabel("Colección:"));
        fieldsPanel.add(collectionCombo);
        
        // Panel de botones (segunda fila)
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonsPanel.setBackground(new Color(248, 249, 250));
        
        JButton addBtn = createCrudButton("➕ Agregar", new Color(40, 167, 69));
        JButton removeBtn = createCrudButton("➖ Eliminar", new Color(220, 53, 69));
        JButton clearBtn = createCrudButton("🗑️ Limpiar", new Color(108, 117, 125));
        JButton showBtn = createCrudButton("👁️ Mostrar", new Color(0, 123, 255));
        
        buttonsPanel.add(addBtn);
        buttonsPanel.add(removeBtn);
        buttonsPanel.add(clearBtn);
        buttonsPanel.add(showBtn);
        
        addBtn.addActionListener(e -> addBook());
        removeBtn.addActionListener(e -> removeBook());
        clearBtn.addActionListener(e -> clearCollection());
        showBtn.addActionListener(e -> showCollection());
        
        mainPanel.add(fieldsPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    /**
     * Crea el panel de operaciones con conjuntos
     */
    private JPanel createOperationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(111, 66, 193), 2),
            "Operaciones de Conjuntos",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        panel.setPreferredSize(new Dimension(280, 0));
        panel.setBackground(new Color(248, 249, 250));
        
        // Operación 1: Unión
        JButton unionBtn = createOperationButton("1️⃣ Unión (A ∪ B)", 
            "Libros en Mi Biblioteca O Lista de Deseos");
        unionBtn.addActionListener(e -> performUnion());
        
        // Operación 2: Intersección
        JButton intersectionBtn = createOperationButton("2️⃣ Intersección (A ∩ B)", 
            "Libros que tengo Y están en mi Lista de Deseos");
        intersectionBtn.addActionListener(e -> performIntersection());
        
        // Operación 3: Diferencia
        JButton differenceBtn = createOperationButton("3️⃣ Diferencia (A - B)", 
            "Libros en Mi Biblioteca pero NO en Lista de Deseos");
        differenceBtn.addActionListener(e -> performDifference());
        
        // Operación 4: Diferencia Simétrica
        JButton symDiffBtn = createOperationButton("4️⃣ Dif. Simétrica (A Δ B)", 
            "Libros que están en uno pero NO en ambos");
        symDiffBtn.addActionListener(e -> performSymmetricDifference());
        
        // Operación 5: Subconjunto
        JButton subsetBtn = createOperationButton("5️⃣ Subconjunto (A ⊆ B)", 
            "¿Mi Biblioteca está contenida en la de mi Amigo?");
        subsetBtn.addActionListener(e -> checkSubset());
        
        // Operación 6: Contiene elemento
        JButton containsBtn = createOperationButton("6️⃣ Contiene", 
            "Buscar libro por título en colección actual");
        containsBtn.addActionListener(e -> checkContains());
        
        // Operación 7: Tamaño del conjunto
        JButton sizeBtn = createOperationButton("7️⃣ Tamaño", 
            "Cantidad de libros en cada colección");
        sizeBtn.addActionListener(e -> showSizes());
        
        // Operación 8: Conjunto vacío
        JButton emptyBtn = createOperationButton("8️⃣ Está Vacío", 
            "Verificar si alguna colección está vacía");
        emptyBtn.addActionListener(e -> checkEmpty());
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(unionBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(intersectionBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(differenceBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(symDiffBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(subsetBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(containsBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(sizeBtn);
        panel.add(Box.createVerticalStrut(5));
        panel.add(emptyBtn);
        panel.add(Box.createVerticalGlue());
        
        return panel;
    }
    
    /**
     * Crea un botón estilizado para operaciones CRUD
     */
    private JButton createCrudButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(140, 40));
        
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
     * Crea un botón estilizado estándar
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
     * Crea un botón de operación con tooltip
     */
    private JButton createOperationButton(String text, String tooltip) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setBackground(new Color(111, 66, 193));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(260, 40));
        btn.setToolTipText(tooltip);
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(90, 50, 160));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(111, 66, 193));
            }
        });
        
        return btn;
    }
    
    /**
     * Agrega listeners a los componentes
     */
    private void addListeners() {
        collectionCombo.addActionListener(e -> showCollection());
    }
    
    /**
     * Obtiene el conjunto seleccionado actualmente
     */
    private Set<Book> getSelectedCollection() {
        int index = collectionCombo.getSelectedIndex();
        switch (index) {
            case 0: return myLibrary;
            case 1: return wishlist;
            case 2: return friendLibrary;
            default: return myLibrary;
        }
    }
    
    /**
     * OPERACIÓN BÁSICA: Agregar un libro al conjunto
     * Demuestra: add() - Operación fundamental de conjuntos
     */
    private void addBook() {
        try {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String genre = genreField.getText().trim();
            int year = Integer.parseInt(yearField.getText().trim());
            String isbn = isbnField.getText().trim();
            
            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "El título y autor son obligatorios",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Book book = new Book(title, author, genre, year, isbn);
            Set<Book> collection = getSelectedCollection();
            
            // add() retorna false si el elemento ya existe (propiedad de conjuntos)
            boolean added = collection.add(book);
            
            if (added) {
                resultArea.append("✓ Libro agregado a " + collectionCombo.getSelectedItem() + ":\n");
                resultArea.append("  " + book + "\n\n");
                clearFields();
                showCollection();
                updateStats();
            } else {
                resultArea.append("⚠ El libro ya existe en " + collectionCombo.getSelectedItem() + "\n");
                resultArea.append("  Los conjuntos no permiten duplicados\n\n");
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "El año debe ser un número válido",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * OPERACIÓN BÁSICA: Eliminar un libro del conjunto
     * Demuestra: remove() - Eliminar elemento
     */
    private void removeBook() {
        String title = titleField.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Ingrese el título del libro a eliminar",
                "Título requerido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Set<Book> collection = getSelectedCollection();
        Book toRemove = null;
        
        // Buscar el libro por título
        for (Book book : collection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                toRemove = book;
                break;
            }
        }
        
        if (toRemove != null) {
            collection.remove(toRemove);
            resultArea.append("✓ Libro eliminado de " + collectionCombo.getSelectedItem() + ":\n");
            resultArea.append("  " + toRemove + "\n\n");
            clearFields();
            showCollection();
            updateStats();
        } else {
            resultArea.append("✗ Libro no encontrado en " + collectionCombo.getSelectedItem() + "\n\n");
        }
    }
    
    /**
     * OPERACIÓN BÁSICA: Limpiar el conjunto
     * Demuestra: clear() - Vaciar conjunto
     */
    private void clearCollection() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar todos los libros de " + collectionCombo.getSelectedItem() + "?",
            "Confirmar limpieza",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            Set<Book> collection = getSelectedCollection();
            int size = collection.size();
            collection.clear();
            resultArea.append("🗑️ Se eliminaron " + size + " libros de " + 
                            collectionCombo.getSelectedItem() + "\n\n");
            showCollection();
            updateStats();
        }
    }
    
    /**
     * Muestra el contenido del conjunto seleccionado
     * Demuestra: Iteración sobre conjuntos
     */
    private void showCollection() {
        Set<Book> collection = getSelectedCollection();
        tableModel.setRowCount(0);
        
        // TreeSet para ordenar alfabéticamente por título
        Set<Book> sorted = new TreeSet<>(Comparator.comparing(Book::getTitle));
        sorted.addAll(collection);
        
        for (Book book : sorted) {
            tableModel.addRow(new Object[]{
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getYear(),
                book.getISBN()
            });
        }
        
        updateStats();
    }
    
    /**
     * OPERACIÓN 1: Unión de conjuntos (A ∪ B)
     * Demuestra: addAll() - Combinar dos conjuntos
     */
    private void performUnion() {
        Set<Book> result = new HashSet<>(myLibrary);
        result.addAll(wishlist);
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 1: UNIÓN (Mi Biblioteca ∪ Lista de Deseos)\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Libros que están en Mi Biblioteca O en Lista de Deseos (o en ambos)\n");
        resultArea.append("Total de libros únicos: " + result.size() + "\n\n");
        
        displayBooks(result);
    }
    
    /**
     * OPERACIÓN 2: Intersección de conjuntos (A ∩ B)
     * Demuestra: retainAll() - Elementos comunes
     */
    private void performIntersection() {
        Set<Book> result = new HashSet<>(myLibrary);
        result.retainAll(wishlist);
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 2: INTERSECCIÓN (Mi Biblioteca ∩ Lista de Deseos)\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Libros que YA TENGO pero que también están en mi Lista de Deseos\n");
        resultArea.append("Total de libros en común: " + result.size() + "\n\n");
        
        if (result.isEmpty()) {
            resultArea.append("No hay libros en común entre ambas colecciones\n\n");
        } else {
            displayBooks(result);
        }
    }
    
    /**
     * OPERACIÓN 3: Diferencia de conjuntos (A - B)
     * Demuestra: removeAll() - Elementos en A pero no en B
     */
    private void performDifference() {
        Set<Book> result = new HashSet<>(myLibrary);
        result.removeAll(wishlist);
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 3: DIFERENCIA (Mi Biblioteca - Lista de Deseos)\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Libros que TENGO pero NO están en mi Lista de Deseos\n");
        resultArea.append("Total de libros: " + result.size() + "\n\n");
        
        displayBooks(result);
    }
    
    /**
     * OPERACIÓN 4: Diferencia simétrica (A Δ B)
     * Demuestra: Elementos en A o B pero no en ambos
     */
    private void performSymmetricDifference() {
        Set<Book> union = new HashSet<>(myLibrary);
        union.addAll(wishlist);
        
        Set<Book> intersection = new HashSet<>(myLibrary);
        intersection.retainAll(wishlist);
        
        Set<Book> result = new HashSet<>(union);
        result.removeAll(intersection);
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 4: DIFERENCIA SIMÉTRICA\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Libros que están en UNA colección pero NO en AMBAS\n");
        resultArea.append("Total de libros: " + result.size() + "\n\n");
        
        displayBooks(result);
    }
    
    /**
     * OPERACIÓN 5: Verificar subconjunto (A ⊆ B)
     * Demuestra: containsAll() - Verificar si A está contenido en B
     */
    private void checkSubset() {
        boolean isSubset = friendLibrary.containsAll(myLibrary);
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 5: SUBCONJUNTO (Mi Biblioteca ⊆ Biblioteca de Amigo)\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: ¿Todos mis libros también los tiene mi amigo?\n\n");
        
        if (isSubset) {
            resultArea.append("✓ SÍ: Mi Biblioteca es un subconjunto de la Biblioteca de mi Amigo\n");
            resultArea.append("   Todos mis " + myLibrary.size() + " libros también los tiene mi amigo\n\n");
        } else {
            resultArea.append("✗ NO: Mi Biblioteca NO es un subconjunto de la Biblioteca de mi Amigo\n");
            resultArea.append("   Tengo libros que mi amigo no tiene\n\n");
            
            // Mostrar qué libros tengo que mi amigo no tiene
            Set<Book> difference = new HashSet<>(myLibrary);
            difference.removeAll(friendLibrary);
            resultArea.append("Libros que tengo pero mi amigo no (" + difference.size() + "):\n");
            for (Book book : difference) {
                resultArea.append("  • " + book.getTitle() + "\n");
            }
            resultArea.append("\n");
        }
    }
    
    /**
     * OPERACIÓN 6: Verificar si contiene un elemento
     * Demuestra: contains() - Buscar elemento específico
     */
    private void checkContains() {
        String title = titleField.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Ingrese el título del libro a buscar",
                "Título requerido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Set<Book> collection = getSelectedCollection();
        boolean found = false;
        Book foundBook = null;
        
        for (Book book : collection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                foundBook = book;
                break;
            }
        }
        
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 6: CONTIENE (buscar elemento)\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Buscando: \"" + title + "\" en " + collectionCombo.getSelectedItem() + "\n\n");
        
        if (found) {
            resultArea.append("✓ ENCONTRADO:\n");
            resultArea.append("  " + foundBook + "\n\n");
        } else {
            resultArea.append("✗ NO ENCONTRADO en esta colección\n\n");
        }
    }
    
    /**
     * OPERACIÓN 7: Obtener tamaño de los conjuntos
     * Demuestra: size() - Cantidad de elementos
     */
    private void showSizes() {
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 7: TAMAÑO DE CONJUNTOS\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Cantidad de elementos únicos en cada conjunto\n\n");
        resultArea.append("📚 Mi Biblioteca: " + myLibrary.size() + " libros\n");
        resultArea.append("⭐ Lista de Deseos: " + wishlist.size() + " libros\n");
        resultArea.append("👥 Biblioteca de Amigo: " + friendLibrary.size() + " libros\n");
        resultArea.append("\nTotal de libros únicos en todas las colecciones: " + 
                        getTotalUniqueBooks() + "\n\n");
    }
    
    /**
     * OPERACIÓN 8: Verificar si está vacío
     * Demuestra: isEmpty() - Verificar conjunto vacío
     */
    private void checkEmpty() {
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("OPERACIÓN 8: VERIFICAR CONJUNTOS VACÍOS\n");
        resultArea.append("═══════════════════════════════════════\n");
        resultArea.append("Concepto: Determinar si un conjunto no tiene elementos\n\n");
        
        resultArea.append("📚 Mi Biblioteca: " + 
            (myLibrary.isEmpty() ? "❌ VACÍA" : "✓ Tiene " + myLibrary.size() + " libros") + "\n");
        resultArea.append("⭐ Lista de Deseos: " + 
            (wishlist.isEmpty() ? "❌ VACÍA" : "✓ Tiene " + wishlist.size() + " libros") + "\n");
        resultArea.append("👥 Biblioteca de Amigo: " + 
            (friendLibrary.isEmpty() ? "❌ VACÍA" : "✓ Tiene " + friendLibrary.size() + " libros") + "\n\n");
    }
    
    /**
     * Muestra los libros de un conjunto en el área de resultados
     */
    private void displayBooks(Set<Book> books) {
        if (books.isEmpty()) {
            resultArea.append("(Conjunto vacío)\n\n");
            return;
        }
        
        // Ordenar alfabéticamente para mejor presentación
        Set<Book> sorted = new TreeSet<>(Comparator.comparing(Book::getTitle));
        sorted.addAll(books);
        
        for (Book book : sorted) {
            resultArea.append("  • " + book.getTitle() + " - " + book.getAuthor() + 
                            " (" + book.getYear() + ")\n");
        }
        resultArea.append("\n");
    }
    
    /**
     * Actualiza las estadísticas mostradas
     */
    private void updateStats() {
        statsLabel.setText(String.format(
            "  📊 Estadísticas: Mi Biblioteca: %d | Lista de Deseos: %d | Biblioteca de Amigo: %d | Total Único: %d  ",
            myLibrary.size(), wishlist.size(), friendLibrary.size(), getTotalUniqueBooks()
        ));
    }
    
    /**
     * Calcula el total de libros únicos en todas las colecciones
     */
    private int getTotalUniqueBooks() {
        Set<Book> all = new HashSet<>();
        all.addAll(myLibrary);
        all.addAll(wishlist);
        all.addAll(friendLibrary);
        return all.size();
    }
    
    /**
     * Limpia los campos de entrada
     */
    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
        yearField.setText("");
        isbnField.setText("");
    }
    
    /**
     * Carga datos de ejemplo para demostración
     */
    private void loadSampleData() {
        // Mi Biblioteca
        myLibrary.add(new Book("Cien Años de Soledad", "Gabriel García Márquez", "Novela", 1967, "978-0307474728"));
        myLibrary.add(new Book("1984", "George Orwell", "Distopía", 1949, "978-0451524935"));
        myLibrary.add(new Book("El Principito", "Antoine de Saint-Exupéry", "Fábula", 1943, "978-0156012195"));
        myLibrary.add(new Book("Don Quijote", "Miguel de Cervantes", "Novela", 1605, "978-0060934347"));
        
        // Lista de Deseos
        wishlist.add(new Book("El Código Da Vinci", "Dan Brown", "Thriller", 2003, "978-0307474278"));
        wishlist.add(new Book("Sapiens", "Yuval Noah Harari", "Historia", 2011, "978-0062316097"));
        wishlist.add(new Book("1984", "George Orwell", "Distopía", 1949, "978-0451524935")); // Duplicado intencional
        wishlist.add(new Book("El Alquimista", "Paulo Coelho", "Ficción", 1988, "978-0062315007"));
        
        // Biblioteca de Amigo
        friendLibrary.add(new Book("Harry Potter y la Piedra Filosofal", "J.K. Rowling", "Fantasía", 1997, "978-0439708180"));
        friendLibrary.add(new Book("1984", "George Orwell", "Distopía", 1949, "978-0451524935"));
        friendLibrary.add(new Book("El Principito", "Antoine de Saint-Exupéry", "Fábula", 1943, "978-0156012195"));
        friendLibrary.add(new Book("El Hobbit", "J.R.R. Tolkien", "Fantasía", 1937, "978-0547928227"));
        friendLibrary.add(new Book("Cien Años de Soledad", "Gabriel García Márquez", "Novela", 1967, "978-0307474728"));
        
        resultArea.append("✓ Datos de ejemplo cargados exitosamente\n");
        resultArea.append("  Puedes explorar las operaciones de conjuntos\n\n");
        
        showCollection();
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
            AplicacionBiblioteca app = new AplicacionBiblioteca();
            app.setVisible(true);
        });
    }
}

/**
 * Clase que representa un Libro
 * Implementa equals() y hashCode() para funcionar correctamente en Sets
 */
class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private String isbn;
    
    /**
     * Constructor del libro con todos los datos
     */
    public Book(String title, String author, String genre, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.isbn = isbn;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public String getISBN() { return isbn; }
    
    /**
     * equals() - Dos libros son iguales si tienen el mismo ISBN
     * Esto es fundamental para que Set funcione correctamente
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }
    
    /**
     * hashCode() - Debe ser consistente con equals()
     * Dos objetos iguales deben tener el mismo hashCode
     */
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
    
    @Override
    public String toString() {
        return title + " por " + author + " (" + year + ") - " + genre;
    }
}