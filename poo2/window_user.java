package prr;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class window_user extends JFrame implements ActionListener{

    JButton login,back;
    JTextField password,idusb,username;

    public window_user() {
        setTitle("user Page");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        username=new JTextField();
        password = new JTextField();
        idusb = new JTextField();
        login = new JButton("Log In");
        login.setBackground(new Color(30, 144, 255));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        back = new JButton("Back");
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel n = new JLabel("Password:");
        JLabel pa = new JLabel("ID USB Key:");
        JLabel id =new JLabel("Username:");
        p.add(id);
        p.add(username);
        p.add(n);
        p.add(password);
        p.add(pa);
        p.add(idusb);
        p.add(login);
        p.add(back);

        add(p);
        setVisible(true);

        login.addActionListener(this);
        back.addActionListener(this);
    }
    @Override 
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource()==login)
     {
    	 String name=username.getText();
        String  userpassword=password.getText();
          String idkey =idusb.getText();
          if(name.isEmpty()||userpassword.isEmpty()||idkey.isEmpty())
          {
        	  JOptionPane.showMessageDialog(null, "the field is empty");
          }else {
          Login_user us = null;
      	try {
      		us = new Login_user();
      	} catch (ClassNotFoundException e1) {
      		e1.printStackTrace();
      	}
        
        if(us.CheckUser(name,userpassword, idkey)) {
        	dispose();
        	NetSimulator n=new NetSimulator();
        	
        }
          }
     
     }else {
    	 dispose();
    	 window_user_admin w=new window_user_admin();
     }
    	
    }
}

