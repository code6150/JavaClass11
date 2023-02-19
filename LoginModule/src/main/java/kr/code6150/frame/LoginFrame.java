package kr.code6150.frame;

import kr.code6150.listener.LoginButtonListener;
import kr.code6150.listener.SignUpButtonListener;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField idField = new JTextField();
    private JTextField pwField = new JPasswordField();
    private JButton loginButton = new JButton("로그인");
    private JButton signButton = new JButton("회원가입");

    private JPanel loginPanel = new JPanel(new GridLayout(2, 2));

    public LoginFrame() {

        super("로그인 창");
        super.setLocationRelativeTo(null);
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        loginPanel.add(idField);
        loginPanel.add(pwField);
        loginPanel.add(loginButton);
        loginPanel.add(signButton);

        loginButton.addActionListener(new LoginButtonListener(this));
        signButton.addActionListener(new SignUpButtonListener());

        add(loginPanel);

    }

    public String getId() {
        return idField.getText();
    }

    public String getPassword() {
        return pwField.getText();
    }

}
