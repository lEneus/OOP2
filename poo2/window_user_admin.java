package prr;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class window_user_admin extends JFrame implements ActionListener {

	JFrame w;
	JButton admin ,user;
	public window_user_admin() {
		setTitle("Home Page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		 admin=new JButton("Admin");
		 admin.setBackground(new Color(149, 197, 255));
		 admin.setForeground(Color.WHITE);
		 admin.setFont(new Font("Arial", Font.BOLD, 14));
		 user=new JButton("User");
		 user.setBackground(new Color(149, 197, 255));
		 user.setForeground(Color.WHITE);
		 user.setFont(new Font("Arial", Font.BOLD, 14));
	    JPanel p=new JPanel(new GridLayout(2,1));
	    p.add(user);
	    p.add(admin);
	    add(p);
		user.addActionListener(this);
		admin.addActionListener(this);
	}
	@Override 
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == admin) {
	    	dispose();
	    	window_admin w=new window_admin();
	    } else if(e.getSource() == user) {
	    	dispose();
	    	window_user w=new window_user();
	    }
	}

}

