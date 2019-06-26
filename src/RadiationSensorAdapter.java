/*
 * Radiation Sensor Adapter
 */

import sensor.RadiationSensor;

public class RadiationSensorAdapter implements Sensor {
    private RadiationSensor rs;

    public RadiationSensorAdapter(RadiationSensor rs) {
        this.rs = rs;
    }

    @Override
    public double getValue() {
        return rs.getRadiationValue();
    }

    @Override
    public String getStatus() {
        return rs.getStatusInfo().toUpperCase();
    }

    @Override
    public int getStatusBarSize(double val) {
        return ((int)val)*200/3;
    }

    @Override
    public String getName() {
        return rs.getName().toUpperCase();
    }

    @Override
    public String getUnit() {
        return "rad";
    }
}
