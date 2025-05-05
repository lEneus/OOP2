package gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Switch extends Device {
    ArrayList<Device> devices = new ArrayList<>();
  
    
    public Switch(String name,String ip) {
        super(name,ip);
        ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\newEclipseWorkshop\\testing\\bin\\switch.png");
        JLabel label = new JLabel(icon);
        label.setSize(100, 100);
        add(label);
    }
    
   
   
   }
	
    
    
    
