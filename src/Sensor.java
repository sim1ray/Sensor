/*
 * Common interface for all sensors
 */

public interface Sensor {

    double getValue();                  //returns sensor reading
    String getStatus();                 //returns safety status
    int getStatusBarSize(double val);   //returns width of status bar to be displayed
    String getName();                   //returns name of sensor
    String getUnit();                   //returns unit
}
