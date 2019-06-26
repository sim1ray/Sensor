/*
 * Pressure Sensor Adapter
 */

import sensor.PressureSensor;

public class PressureSensorAdapter extends Sensor {
    private PressureSensor ps;

    public PressureSensorAdapter(PressureSensor ps) {
        this.ps = ps;
    }

    @Override
    public double getValue() {
        return ps.readValue();
    }

    @Override
    public String getStatus() {
        return ps.getReport().toUpperCase();
    }

    @Override
    public int getStatusBarSize(double val) {
        return ((int)val)*200/5;
    }

    @Override
    public String getName() {
        return ps.getSensorName().toUpperCase();
    }

    @Override
    public String getUnit() {
        return "bar";
    }

}
