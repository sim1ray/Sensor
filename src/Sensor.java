/*
 * Common interface for all sensors
 */

import java.awt.*;

public abstract class Sensor {

    abstract double getValue();                  //returns sensor reading
    abstract String getStatus();                 //returns safety status
    abstract int getStatusBarSize(double val);   //returns width of status bar to be displayed
    abstract String getName();                   //returns name of sensor
    abstract String getUnit();                   //returns unit

    Color getStatusColor() {                     //return status color
        String status = this.getStatus();
        if (status.equals("OK")) {
            return Color.GREEN;
        } else if (status.equals("DANGER")) {
            return Color.RED;
        } else {
            return Color.YELLOW;
        }
    }
}
