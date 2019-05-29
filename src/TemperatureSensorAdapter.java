/*
 * Temperature Sensor Adapter
 */

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements Sensor {
    TemperatureSensor ts = new TemperatureSensor();

    @Override
    public double getValue() {
        return ts.senseTemperature();
    }

    @Override
    public String getStatus() {
        return ts.getTempReport().toUpperCase();
    }

    @Override
    public int getStatusBarSize(double val) {
        return ((int)val);
    }

    @Override
    public String getName() {
        return ts.getSensorType().toUpperCase();
    }

    @Override
    public String getUnit() {
        return "°C";
    }
}
