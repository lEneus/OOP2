package prr;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;



public class add_user extends JFrame implements ActionListener {

    JButton adduser,back;
    JTextField name, usbkey, password;

    public add_user() {
        setTitle("Create Users");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        name = new JTextField();
        password = new JTextField();
        usbkey = new JTextField();

        adduser = new JButton("Add New User");
        adduser.setBackground(new Color(30, 144, 255));
        adduser.setForeground(Color.WHITE);
        adduser.setFont(new Font("Arial", Font.BOLD, 14));
        adduser.addActionListener(this);
        back =new JButton("Back");
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.addActionListener(this);
        JLabel n = new JLabel("Name:");
        JLabel pa = new JLabel("Password:");
        JLabel u = new JLabel("USB Key ID:");

        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));
        p.add(n);
        p.add(name);
        p.add(pa);
        p.add(password);
        p.add(u);
        p.add(usbkey);
        p.add(adduser);
        p.add(back);
        add(p);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adduser) {
        	creat_user cr=null;
        	 try {
     			cr=new creat_user();
     		} catch (SQLException e1) {
     			e1.printStackTrace();
     		}
              if (name.getText().isEmpty() || password.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                  return;
              }
              String username = name.getText();
              String passwordd = password.getText();
              String idkey=usbkey.getText();
              if(username.isEmpty()||passwordd.isEmpty()||idkey.isEmpty()) {
            	  JOptionPane.showMessageDialog(null, "fill all the fields");
            	  return;
              }else {
              cr.addUser(username, passwordd,idkey);
              JOptionPane.showMessageDialog(null, "create confirmed :)");}
      	    name.setText(null);
      	    password.setText(null);
      	    usbkey.setText(null);
        }else {dispose(); window_admin w=new window_admin();}
    }}
