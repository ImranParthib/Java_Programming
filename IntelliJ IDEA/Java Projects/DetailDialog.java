import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailDialog extends JDialog {
    private JTextArea textArea;
    private JButton closeButton;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JScrollPane scrollPane;

    public DetailDialog(Frame owner, String title, String content) {
        super(owner, title, true);
        createComponents(content);
        setupLayout();
        setupListeners();
        finalizeDialog();
    }

    private void createComponents(String content) {
        textArea = new JTextArea(content);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(250, 250, 250));
        textArea.setForeground(new Color(33, 33, 33));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        // Make close button with modern styling
        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setPreferredSize(new Dimension(100, 35));
        closeButton.setBackground(new Color(70, 130, 180));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setOpaque(true);

        // Add hover effect
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(new Color(60, 116, 162));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(new Color(70, 130, 180));
            }
        });

        contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(Color.WHITE);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
    }

    private void setupLayout() {
        // Set border for panels
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        contentPanel.add(scrollPane, BorderLayout.CENTER);
        buttonPanel.add(closeButton);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupListeners() {
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void finalizeDialog() {
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate window size (90% of screen size)
        int width = (int)(screenSize.width * 0.9);
        int height = (int)(screenSize.height * 0.9);

        // Set size and position
        setSize(width, height);
        setLocationRelativeTo(null);

        // Add minimum size
        setMinimumSize(new Dimension(800, 600));

        // Make dialog resizable
        setResizable(true);

        // Ensure content is visible
        validate();
    }
}