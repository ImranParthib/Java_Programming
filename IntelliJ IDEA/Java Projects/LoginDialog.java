import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.border.*;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private boolean succeeded;
    private Color primaryColor = new Color(64, 123, 255);
    private Color hoverColor = new Color(57, 107, 228);
    private Timer fadeTimer;
    private float opacity = 0.0f;

    public LoginDialog(JFrame parent) {
        super(parent, "Login", true);
        setUndecorated(true);

        // Create main panel with shadow border and gradient background
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(240, 244, 255);
                Color color2 = new Color(255, 255, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setBorder(new CompoundBorder(
                new ShadowBorder(),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Header Panel with gradient background
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Welcome Back");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Close button
        JLabel closeButton = new JLabel("×");
        closeButton.setFont(new Font("Arial", Font.BOLD, 24));
        closeButton.setForeground(new Color(128, 128, 128));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) {
                closeButton.setForeground(new Color(128, 128, 128));
            }
        });
        headerPanel.add(closeButton, BorderLayout.EAST);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Username field
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        usernameLabel.setForeground(new Color(51, 51, 51));
        usernameField = createStyledTextField();

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(51, 51, 51));
        passwordField = createStyledPasswordField();

        // Layout components
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(usernameField, gbc);
        gbc.gridy = 2;
        formPanel.add(passwordLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(passwordField, gbc);

        // Login Button with custom styling
        JButton loginButton = new JButton("Sign In") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed()) {
                    g2.setColor(hoverColor.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(hoverColor);
                } else {
                    g2.setColor(primaryColor);
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        styleButton(loginButton);
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 10, 10, 10);
        formPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                showErrorAnimation("Please fill in all fields");
                return;
            }

            if (authenticate(username, password)) {
                succeeded = true;
                showSuccessAnimation();
            } else {
                showErrorAnimation("Invalid username or password");
                usernameField.setText("");
                passwordField.setText("");
                succeeded = false;
            }
        });

        // Register link
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        linkPanel.setOpaque(false);
        JLabel registerLink = new JLabel("Don't have an account? Register here");
        registerLink.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        registerLink.setForeground(primaryColor);
        registerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                RegisterDialog registerDialog = new RegisterDialog((JFrame) parent);
                registerDialog.setVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                registerLink.setForeground(hoverColor);
            }
            public void mouseExited(MouseEvent e) {
                registerLink.setForeground(primaryColor);
            }
        });
        linkPanel.add(registerLink);
        gbc.gridy = 5;
        formPanel.add(linkPanel, gbc);

        // Add all panels to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Set up the dialog
        getContentPane().add(mainPanel);
        setPreferredSize(new Dimension(400, 450));
        pack();
        setLocationRelativeTo(parent);

        // Add window border
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        // Make sure dialog is visible
        setOpacity(1.0f);
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField(20);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        field.setBackground(Color.WHITE);
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField(20);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        field.setBackground(Color.WHITE);
        return field;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(button.getPreferredSize().width, 40));
    }

    // Rest of the methods remain the same...

    private void showErrorAnimation(String message) {
        JOptionPane optionPane = new JOptionPane(
                message,
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{},
                null
        );

        JDialog dialog = optionPane.createDialog(this, "Error");
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showSuccessAnimation() {
        Timer timer = new Timer(1500, e -> dispose());
        timer.setRepeats(false);
        timer.start();

        JOptionPane.showMessageDialog(
                this,
                "Login successful!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private boolean authenticate(String username, String password) {
        Map<String, String> users = RegisterDialog.getUsers();
        return users.containsKey(username) && users.get(username).equals(password);
    }

    private class ShadowBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(0, 0, 0, 50));
            g2.setStroke(new BasicStroke(4));
            g2.drawRoundRect(x + 2, y + 2, width - 4, height - 4, 10, 10);
            g2.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(4, 4, 4, 4);
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}