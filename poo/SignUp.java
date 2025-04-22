package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
    JButton back, signup;
    JTextField name, pass, pass2;

    public SignUp() {
        setTitle("SignUp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        name = new JTextField(15);
        pass = new JTextField(15);
        pass2 = new JTextField(15);

        JPanel p = new JPanel(new GridLayout(3, 2, 5, 5));
        p.add(new JLabel("Name:"));
        p.add(name);
        p.add(new JLabel("Password:"));
        p.add(pass);
        p.add(new JLabel("Password:"));
        p.add(pass2);
        add(p, BorderLayout.CENTER);

        signup = new JButton("SignUp");
        back = new JButton("Back");
        signup.addActionListener(this);
        back.addActionListener(this);

        JPanel l = new JPanel();
        l.add(signup);
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
			DBsignup c=new DBsignup();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
         if (name.getText().isEmpty() || pass.getText().isEmpty() || pass2.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Please fill in all fields!");
             return;
         }
         String username = name.getText();
         String password = pass.getText();
         String confirmPassword = pass2.getText();
         
         if (password.equals(confirmPassword)) {
        	    DBsignup db = null;
				try {
					db = new DBsignup();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	    db.addUser(username, password);
        	    JOptionPane.showMessageDialog(null, "SignUp confirmed :)");
        	    name.setText(null);
        	    pass.setText(null);
        	    pass2.setText(null);
        	} else {
        	    JOptionPane.showMessageDialog(null, "The password is not same the first one?!");
        	    return;
        	}
        
    }
    }
}
