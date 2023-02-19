package kr.code6150.listener;

import kr.code6150.data.User;
import kr.code6150.frame.SignUpDialog;
import kr.code6150.manager.DataManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButtonListener implements ActionListener {

    private SignUpDialog dialog;

    public CheckButtonListener(SignUpDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(dialog.getName().isEmpty() || dialog.getId().isEmpty() || dialog.getPhone().isEmpty()) {
            JOptionPane.showMessageDialog(null, "내용을 다 채워주십시오.", "tlqkf", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String pw = dialog.getPassword();
        if (pw == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "비밀번호가 다릅니다.",
                    "에러!", JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //회원정보를 잘 입력한 경우
        if(DataManager.getInstance().registerUser(
                new User(dialog.getName(), dialog.getPhone(), dialog.getId(), pw)
        )) {
            JOptionPane.showMessageDialog(
                    null,
                    "회원가입 성공!", "성공!", JOptionPane.INFORMATION_MESSAGE
            );
            dialog.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "중복된 정보가 있습니다.",
                    "에러!",JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
