import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDialog extends JDialog {
    private JTable table;
    private TableRowSorter<TableModel> sorter;
    private JTextField searchField;
    private JButton searchButton;
    private JButton closeButton;
    private JPanel searchPanel;
    private JPanel buttonPanel;

    public ListDialog(Frame owner, String title, String[] columnNames, Object[][] data) {
        super(owner, title, true);
        createComponents(columnNames, data);
        setupLayout();
        setupListeners();
        finalizeDialog();
    }

    private void createComponents(String[] columnNames, Object[][] data) {
        // Create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Style table
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(10, 5));
        table.setShowGrid(false);
        table.setSelectionBackground(new Color(230, 230, 250));

        // Style header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);

        // Create search components
        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);

        // Create close button
        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(70, 130, 180));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);

        // Create panels
        searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        // Setup search panel
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Setup button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(closeButton);

        // Add components to dialog
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupListeners() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = searchField.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void finalizeDialog() {
        setSize(800, 500);
        setLocationRelativeTo(getOwner());
    }
}