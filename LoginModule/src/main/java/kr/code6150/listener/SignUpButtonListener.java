package kr.code6150.listener;

import kr.code6150.frame.SignUpDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButtonListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        new SignUpDialog().setVisible(true);
    }
}
