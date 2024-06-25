package Form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.*;

public class RegisterFrame extends JFrame {
    private JTextField edtNewAccount;
    private JPasswordField edtNewPassword, edtConfirmPassword;
    private JLabel jLabel4, jLabel5, jLabel6;
    private JButton btnRegister;
    private LoginFrame loginFrame; 

    public RegisterFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame; 
        initComponents();
    }
    private void initComponents() {
        edtNewAccount = new JTextField();
        edtNewPassword = new JPasswordField();
        edtConfirmPassword = new JPasswordField();
        setTitle("Đăng Ký");
        jLabel4 = new JLabel("Tên tài khoản mới:");
        jLabel5 = new JLabel("Mật khẩu mới:");
        jLabel6 = new JLabel("Xác nhận mật khẩu:");
        btnRegister = new JButton("Đăng ký");

        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(jLabel4, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        edtNewAccount.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(edtNewAccount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        centerPanel.add(jLabel5, gbc);

        gbc.gridx = 1;
        edtNewPassword.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(edtNewPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(jLabel6, gbc);

        gbc.gridx = 1;
        edtConfirmPassword.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(edtConfirmPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centerPanel.add(btnRegister, gbc);

        add(centerPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(false);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = edtNewAccount.getText();
                char[] newPasswordChars = edtNewPassword.getPassword();
                char[] confirmPasswordChars = edtConfirmPassword.getPassword();
                String newPassword = new String(newPasswordChars);
                String confirmPassword = new String(confirmPasswordChars);

                if (newUsername.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Vui lòng điền đủ thông tin đăng ký");
                    return;
                }

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Mật khẩu xác nhận không khớp");
                    return;
                }

                
                LoginDAO registerDAO = new LoginDAO();
                boolean registered = registerDAO.registerUser(newUsername, newPassword);
                if (registered) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Đăng ký thành công");
                    dispose(); 
                    loginFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Đăng ký thất bại");
                }
            }
        });
    }
}