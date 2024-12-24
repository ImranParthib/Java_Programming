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

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(70, 130, 180));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);

        contentPanel = new JPanel(new BorderLayout(10, 10));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    }

    private void setupLayout() {
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
        setSize(450, 400);
        setLocationRelativeTo(getOwner());
    }
}