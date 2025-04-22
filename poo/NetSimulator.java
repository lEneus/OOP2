package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

public class NetSimulator extends JFrame implements ActionListener {

    Area area = new Area();
    ArrayList<Device> liste = new ArrayList<>();
    Project pjct = new Project();
    JToolBar tool = new JToolBar();
    JButton addC, addS, delete;

    public NetSimulator() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(area, BorderLayout.CENTER);
        add(tool, BorderLayout.NORTH);
        addC = new JButton("Add Computer");
        addS = new JButton("Add Switch");
        delete = new JButton("Delete device");

        tool.add(addC);
        tool.add(addS);
        tool.add(delete);

        addC.addActionListener(this);
        addS.addActionListener(this);
        delete.addActionListener(this);

        area.p = pjct;
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addC)) {
            Computer c = new Computer();
            pjct.addDevice(c);
            area.addDevice(c);
        } else if (e.getSource().equals(addS)) {
            Switch s = new Switch();
            pjct.addDevice(s);
            area.addDevice(s);
       }
    }

}