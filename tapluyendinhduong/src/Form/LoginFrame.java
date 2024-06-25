// LoginFrame.java
package Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.*;

public class LoginFrame extends JFrame {
    private JTextField edtAccount;
    private JPasswordField edtPassword;
    private JLabel jLabel2, jLabel3;
    private JButton btnLogin, btnRegister; 
    private RegisterFrame registerFrame; 
    public LoginFrame() {
        initComponents();
    }
    private void initComponents() {
        edtAccount = new JTextField();
        edtPassword = new JPasswordField();
        setTitle("Đăng Nhập");
        jLabel2 = new JLabel("Tên tài khoản:");
        jLabel3 = new JLabel("Mật khẩu:");
        btnLogin = new JButton("Đăng nhập");
        btnRegister = new JButton("Đăng ký");
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; 
        centerPanel.add(jLabel2, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        edtAccount.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(edtAccount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(jLabel3, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        edtPassword.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(edtPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(btnLogin, gbc);

        gbc.gridx = 2;
        centerPanel.add(btnRegister, gbc); 

        add(centerPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
       
                showRegisterFrame();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = edtAccount.getText();
                char[] passwordChars = edtPassword.getPassword();
                String password = new String(passwordChars);
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Vui lòng điền đủ tài khoản và mật khẩu");
                    return;
                }
                LoginDAO adminDAO = new LoginDAO();
               //check m
                if (adminDAO.checkLogin(username, password)) {
                    dispose();
                    Main main = new Main();
                    main.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Tài khoản hoặc mật khẩu không chính xác");
                }
            }
        });
    }

   
    private void showRegisterFrame() {
        if (registerFrame == null) {
            registerFrame = new RegisterFrame(this); 
        }
        registerFrame.setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}