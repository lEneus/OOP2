package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Device extends JLabel {
    private  String name;
    public java.util.List<Device> links = new java.util.ArrayList<>();
    private String ip;
    
    public Device(String name,String ip) {
        this.name = name;
        this.ip = ip;
        setSize(100, 100);
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setHorizontalAlignment(SwingConstants.CENTER);
        setText(name);
    }

    public void linkTo(Device other) {
        if (!links.contains(other)) {
            links.add(other);
        }
    }

    public java.util.List<Device> getLinks() {
        return links;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
    	this.ip= ip;
    }
}
