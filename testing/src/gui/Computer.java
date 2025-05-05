package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Computer extends Device {
    private Device linkedDevice = null;

    
    
    public Computer(String name,String ip) {
        super(name,ip);
        ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\newEclipseWorkshop\\testing\\bin\\computer.png");
        JLabel label = new JLabel(icon);
        label.setSize(100, 100);
        add(label);
    }
    @Override
    public void linkTo(Device other) {
        if (linkedDevice != null) {
            
            this.links.remove(linkedDevice);
            linkedDevice.getLinks().remove(this);
        }
        
        this.linkedDevice = other;
        super.linkTo(other); 
    }
    
   
  
}