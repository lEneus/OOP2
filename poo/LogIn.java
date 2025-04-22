package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {
    JButton back, login;
    JTextField name, pass;

    public LogIn() {
        setTitle("LogIn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        name = new JTextField(15);
        pass = new JTextField(15);

        JPanel p = new JPanel(new GridLayout(3, 2, 5, 5));
        p.add(new JLabel("Name:"));
        p.add(name);
        p.add(new JLabel("Password:"));
        p.add(pass);
      
        add(p, BorderLayout.CENTER);

        login = new JButton("LogIn");
        back = new JButton("Back");
        login.addActionListener(this);
        back.addActionListener(this);

        JPanel l = new JPanel();
        l.add(login);
        l.add(back);
        add(l, BorderLayout.SOUTH);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
        	dispose();
           window a = new window();
        } else {
        	try {
				DBlogin b=new DBlogin();
				b.CheckUser(name.getText(),pass.getText());
				dispose();
				NetSimulator s=new NetSimulator();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
    }
}
