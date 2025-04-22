package GUI;

import javax.swing.JPanel;

public class Device extends JPanel {
    int w = 100;
    int h = 100;
    String IP = "0.0.0.0";
    String name;

    Device(String name) {
        this.name = name;
        setLayout(null);
        setSize(w, h);
    }

    public String getName() {
        return name;
    }
}