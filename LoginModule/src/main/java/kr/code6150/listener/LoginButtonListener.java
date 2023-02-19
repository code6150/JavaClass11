package kr.code6150.listener;

import kr.code6150.data.User;
import kr.code6150.frame.LoginFrame;
import kr.code6150.manager.DataManager;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// extends -> class - class
//         -> interface - interface

//implements -> class - interface(추상)
public class LoginButtonListener implements ActionListener {

    private LoginFrame frame;

    public LoginButtonListener(LoginFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = frame.getId();
        String pw = frame.getPassword();
        if (id.isEmpty() || pw.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "아이디 혹은 비밀번호를 입력하세요!",
                    "에러!",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 아이디, 비번 잘 입력함.
        User user = DataManager.getInstance().getUser(id, pw);
        if(user == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "아이디 혹은 비밀번호가 틀립니다.",
                    "에러", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    user.getName() + user.getPhone() + "님 환영합니다."
            );
        }
    }

}
