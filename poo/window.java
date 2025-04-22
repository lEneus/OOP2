package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class window extends JFrame implements ActionListener {
    JButton sign, log;

    public window() {
        setTitle("First Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        sign = new JButton("SignUp");
        log = new JButton("LogIn");

        JPanel p = new JPanel();
        p.add(sign);
        add(p, BorderLayout.CENTER);

        JPanel l = new JPanel();
        l.add(log);
        add(l, BorderLayout.SOUTH);

        sign.addActionListener(this);
        log.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sign) {
        	dispose();
            SignUp a = new SignUp();
        } else {
        	dispose();
            LogIn b = new LogIn();
        }
    }

}
