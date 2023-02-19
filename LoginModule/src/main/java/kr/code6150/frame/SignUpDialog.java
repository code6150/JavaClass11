package kr.code6150.frame;

import kr.code6150.listener.CheckButtonListener;

import javax.swing.*;
import java.awt.*;

public class SignUpDialog extends JDialog {

    private JPanel panel = new JPanel(new GridLayout(11,0));
    private JTextField nameField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField idField = new JTextField();
    private JPasswordField pwField = new JPasswordField();
    private JPasswordField pwCheckField = new JPasswordField();
    private JButton checkButton = new JButton("확인");

    public SignUpDialog() {
        setTitle("회원가입");
        setSize(300,250);

        panel.add(new JLabel("이름"));
        panel.add(nameField);
        panel.add(new JLabel("번호"));
        panel.add(phoneField);
        panel.add(new JLabel("아이디"));
        panel.add(idField);
        panel.add(new JLabel("비번"));
        panel.add(pwField);
        panel.add(new JLabel("비번확인"));
        panel.add(pwCheckField);
        panel.add(checkButton);

        checkButton.addActionListener(new CheckButtonListener(this));

        add(panel);

    }

    public String getName() {
        return nameField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getId() {
        return  idField.getText();
    }

    public String getPassword() {
        String pw = pwField.getText();
        String check = pwCheckField.getText();
        if(pw.equals(check)) return pw;
        else return null;
    }

}
