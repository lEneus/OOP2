package GUI;

import javax.swing.JLabel;

public class Computer extends Device {

    Computer() {
        super("Computer");
        JLabel label = new JLabel("Computer", JLabel.CENTER);
        label.setSize(100, 100);
        add(label);
    }
}
