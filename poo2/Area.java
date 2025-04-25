package prr;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Area extends JPanel implements MouseListener, MouseMotionListener {

    Project p;
    private Device selectedDevice = null;

    Area() {
        addMouseMotionListener(this);
        addMouseListener(this);
        setBackground(Color.black);
        setLayout(null);
    }

    void addDevice(Device d) {
        add(d);
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        selectedDevice = p.getDevice(e.getX(), e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        if (selectedDevice != null) {
            selectedDevice.setLocation(e.getX() - 50, e.getY() - 50);
        }
    }

    public void mouseMoved(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}
