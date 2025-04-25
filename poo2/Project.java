package prr;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable {

    ArrayList<Device> devices = new ArrayList<>();

    void addDevice(Device d) {
        devices.add(d);
    }

    Device getDevice(String name) {
        for (Device device : devices) {
            if (device.getName().equals(name)) {
                return device;
            }
        }
        return null;
    }

    Device getDevice(int x, int y) {
        for (Device device : devices) {
            int xP = device.getX();
            int yP = device.getY();

            if (((x > xP) && (x < xP + 100)) && ((y > yP) && (y < yP + 100))) {
                return device;
            }
        }
        return null;
    }
}
