package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Area extends JPanel implements MouseListener , MouseMotionListener{

	
	Project currentProject;
	Device device,device2,previousdevice;
	
	public Area(Project currentProject) {
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(Color.white);
		setLayout(null);
		this.currentProject = currentProject;
	}
	
	public void addDevice(Device c){
		
		add(c);
		repaint();
	}
	
	
	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Device getDevice2() {
		return device2;
	}

	public void setDevice2(Device device2) {
		this.device2 = device2;
	}

	public Device getPreviousdevice() {
		return previousdevice;
	}

	public void setPreviousdevice(Device previousdevice) {
		this.previousdevice = previousdevice;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(device != null) {
			device.setLocation(e.getX() - 50,e.getY() - 50);
			repaint();
		}
		
    }

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON3) {
		
			for(int i = 0 ; i < currentProject.devices.size() ; i++) {
				Device d = (Device) currentProject.devices.get(i);
				int deviceX = d.getX();
	            int deviceY = d.getY();
	            if(((e.getX() < deviceX + 100) &&( e.getX() > deviceX)) && ((e.getY() > deviceY) && (e.getY() < deviceY + 100))) {
	            	showDeviceContextMenu(d, e.getX(), e.getY());
	            	
	            	return;
	            }
			}
		
	
		}else{
		
		
		for(int i = 0 ; i < currentProject.devices.size() ; i++) {
			Device d = (Device) currentProject.devices.get(i);
			int deviceX = d.getX();
            int deviceY = d.getY();
            if(((e.getX() < deviceX + 100) &&( e.getX() > deviceX)) && ((e.getY() > deviceY) && (e.getY() < deviceY + 100))) {
            	previousdevice = d;
            	return;
            }
		}
		device = null;
		}
		
	}
	public Device getSelectedDevice() {
		return previousdevice;
	}
	public void clearSelectedDevice() {
		previousdevice = null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(int i = 0 ; i < currentProject.devices.size() ; i++) {
			Device d= (Device) currentProject.devices.get(i);
			int deviceX = d.getX();
            int deviceY = d.getY();
            if(((e.getX() < deviceX + 100) &&( e.getX() > deviceX)) && ((e.getY() > deviceY) && (e.getY() < deviceY + 100))) {
            	device = d;
            	return;
            }
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		device = null;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setColor(Color.BLUE);
	    g2.setStroke(new BasicStroke(2));

	    for (Component comp : getComponents()) {
	        if (comp instanceof Device d1) {
	            for (Device d2 : d1.getLinks()) {
	                int x1 = d1.getX() + d1.getWidth() / 2;
	                int y1 = d1.getY() + d1.getHeight() / 2;
	                int x2 = d2.getX() + d2.getWidth() / 2;
	                int y2 = d2.getY() + d2.getHeight() / 2;

	                if (d2 instanceof Computer && d2.getLinks().size() > 0 | d1 instanceof Computer && d1.getLinks().size()>0) {
	                  
	                    
	                }
	                g2.drawLine(x1, y1, x2, y2);
	            }
	        }
	    }
	}
	
	private void showDeviceContextMenu(Device device, int x, int y) {
	    JPopupMenu popupMenu = new JPopupMenu();
	    
	   
	    JMenuItem infoItem = new JMenuItem("Get Information");
	    infoItem.addActionListener(evt -> showDeviceInfo(device));
	    
	    JMenuItem changeItem = new JMenuItem("Change Information");
	    changeItem.addActionListener(evt -> changeDeviceInfo(device));
	    
	    
	    JMenuItem linkItem = new JMenuItem("Link Device");
	    linkItem.addActionListener(evt -> startLinkingProcess(device));
	    
	    popupMenu.add(infoItem);
	    popupMenu.add(changeItem);
	    popupMenu.add(linkItem);
	    
	    popupMenu.show(this, x, y);
	}

	
	private void showDeviceInfo(Device device) {
	    String message = "Device: " + device.getName() + "\n" +
	                     "Links: " + device.getLinks().size()+ "\n"+
	                     "Ip Address" + device.getIp();
	    JOptionPane.showMessageDialog(this, message, "Device Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void changeDeviceInfo(Device device) {
	    String newName = JOptionPane.showInputDialog(this, "Enter new name:", device.getName());
	    String ip = JOptionPane.showInputDialog(this, "Enter new ip address:", device.getIp());
	    
	    if (isDeviceNameExists(newName) || isDeviceIpExists(ip)) {
            JOptionPane.showMessageDialog(this, 
                "Name or IP must be unique!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
	    if (newName != null && !newName.trim().isEmpty()) {
	        device.setName(newName);
	        device.setText(newName); 
	        device.setIp(ip);
	        repaint();
	    }
	}
	private void startLinkingProcess(Device d) {
		device2 = d;
    	previousdevice.linkTo(d);
    	repaint();
	}
	
	private boolean isDeviceNameExists(String name) {
	    for (Device device : currentProject.devices) {
	        if (device.getName().equalsIgnoreCase(name)) {
	            return true; // Name already exists
	        }
	    }
	    return false; // Name is unique
	}
	private boolean isDeviceIpExists(String ip) {
	    for (Device device : currentProject.devices) {
	        if (device instanceof Computer && ((Computer)device).getIp().equals(ip)) {
	            return true;
	        }
	    }
	    return false;
	}
}
