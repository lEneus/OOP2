package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

public class NetSimulator extends JFrame{


	Project project = new Project();
	JToolBar buttonlabel = new JToolBar();
	Area newArea = new Area(project);
	
	public NetSimulator() {
	
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(buttonlabel,BorderLayout.NORTH);
        add(newArea,BorderLayout.CENTER);
        JButton addComputer = new JButton("addComputer");
        JButton addSwitch = new JButton("addSwitch");
        JButton deleteDevice = new JButton("deleteDevice");
        
        
        
      
		buttonlabel.add(addComputer);
		buttonlabel.add(addSwitch);
        buttonlabel.add(deleteDevice);
        
        
        addComputer.addActionListener(e -> addComputer());
        addSwitch.addActionListener(e -> addSwitch());
        deleteDevice.addActionListener(e -> deleteDevice());

		
		setVisible(true);
	}
	
	
	
	
	public void addSwitch() {
	   
	    JPanel inputPanel = new JPanel(new GridLayout(2, 2));
	    JTextField nameField = new JTextField("Switch");
	    JTextField ipField = new JTextField("192.168.1.1");
	    inputPanel.add(new JLabel("Name:"));
	    inputPanel.add(nameField);
	    inputPanel.add(new JLabel("IP Address:"));
	    inputPanel.add(ipField);

	    int result = JOptionPane.showConfirmDialog(
	        this, 
	        inputPanel, 
	        "Add Switch", 
	        JOptionPane.OK_CANCEL_OPTION
	    );

	    if (result == JOptionPane.OK_OPTION) {
	        String name = nameField.getText().trim();
	        String ip = ipField.getText().trim();

	        // Basic validation
	        if (name.isEmpty() || ip.isEmpty()) {
	            JOptionPane.showMessageDialog(this, 
	                "Name and IP cannot be empty!", 
	                "Error", 
	                JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Create and add the switch
	        Switch newSwitch = new Switch(name, ip);
	        newArea.add(newSwitch);
	        project.addDevice(newSwitch);
	        newArea.repaint();
	    }
	}
	
	
	
	public void addComputer() {
	   
	    JPanel inputPanel = new JPanel(new GridLayout(2, 2));
	    JTextField nameField = new JTextField("Computer");
	    JTextField ipField = new JTextField("192.168.1.1");
	    inputPanel.add(new JLabel("Name:"));
	    inputPanel.add(nameField);
	    inputPanel.add(new JLabel("IP Address:"));
	    inputPanel.add(ipField);

	    int result = JOptionPane.showConfirmDialog(
	        this, inputPanel, "Add Computer", JOptionPane.OK_CANCEL_OPTION);

	    if (result == JOptionPane.OK_OPTION) {
	        String name = nameField.getText().trim();
	        String ip = ipField.getText().trim();

	        
	        if (name.isEmpty() || ip.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Name and IP cannot be empty!", 
	                "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        if (isDeviceNameExists(name) || isDeviceIpExists(ip)) {
	            JOptionPane.showMessageDialog(this, 
	                "Name or IP must be unique!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        Computer computer = new Computer(name, ip); 
	        newArea.add(computer);
	        project.addDevice(computer);
	        newArea.repaint();
	    }
	}
	public void deleteDevice() {
		Device selected = newArea.getSelectedDevice();
		if (selected == null) {
	        JOptionPane.showMessageDialog(this, "No device selected!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		int confirm = JOptionPane.showConfirmDialog(
		        this, 
		        "Delete " + selected.getName() + "?", 
		        "Confirm", 
		        JOptionPane.YES_NO_OPTION
		    );

		if (confirm == JOptionPane.YES_OPTION) {
	        
	        for (Device d : project.devices) {
	            d.getLinks().remove(selected);
	        }
	        // Remove the device
	        project.devices.remove(selected);
	        newArea.remove(selected);
	        newArea.clearSelectedDevice();
	        newArea.repaint();
	    }
	}
	
	

	public static void main(String args[]) {
		NetSimulator a = new NetSimulator();
	}
	private boolean isDeviceNameExists(String name) {
	    for (Device device : project.devices) {
	        if (device.getName().equalsIgnoreCase(name)) {
	            return true; // Name already exists
	        }
	    }
	    return false; // Name is unique
	}
	private boolean isDeviceIpExists(String ip) {
	    for (Device device : project.devices) {
	        if (device instanceof Computer && ((Computer)device).getIp().equals(ip)) {
	            return true;
	        }
	    }
	    return false;
	}
}
