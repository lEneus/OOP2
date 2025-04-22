package GUI;


import java.util.ArrayList;

import javax.swing.JLabel;

public class Switch extends Device {
    ArrayList<Device> devices = new ArrayList<>();

    Switch() {
        super("Switch");
        JLabel label = new JLabel("Switch", JLabel.CENTER);
        label.setSize(100, 100);
        add(label);
    }
}
