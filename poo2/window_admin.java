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

public class window_admin extends JFrame implements ActionListener {

    JButton login,back;
    JTextField name, password;

    public window_admin() {
        setTitle("Admin Page");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name = new JTextField();
        password = new JTextField();
        login = new JButton("Log In");
        login.setBackground(new Color(30, 144, 255));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        back =new JButton("Back");
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel p = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel n = new JLabel("Name:");
        JLabel pa = new JLabel("Password:");
        p.add(n);
        p.add(name);
        p.add(pa);
        p.add(password);
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
       Login_admin ad = null;
	try {
		ad = new Login_admin();
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
      String adminname=name.getText();
      String adminpassword=password.getText();
      if(adminname.isEmpty() || adminpassword.isEmpty()) {JOptionPane.showMessageDialog(null, "the field is empty");}else {
       if( ad.CheckUser(adminname,adminpassword)) { dispose();
       add_user u=new add_user();}else {name.setText(null);password.setText(null);}
     }
     
     }else {
    	 dispose();
    	 window_user_admin w=new window_user_admin();
     }
    	
    }
}





