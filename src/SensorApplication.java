/*
 * GUI application that displays status bars and readings for temperature, pressure, and radiation sensors
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {

	public SensorApplication() {
	    //Initialize sensors
        Sensor temp = new TemperatureSensorAdapter();
        Sensor pressure = new PressureSensorAdapter();
        Sensor radiation = new RadiationSensorAdapter();
        Sensor[] sensorList = {pressure, radiation, temp};

        // Display readings and status bars for each sensor
        display(sensorList);
	}

	public static void main(String[] args) {
	    SensorApplication app = new SensorApplication();
	}

	// Displays readings for each sensor in separate panels
	public void display(Sensor[] list) {
        setTitle("Sensor Tracker");
        setLayout(new GridLayout(3,1));

        // Loop through list of sensors
        for (Sensor s : list) {
            JPanel pnl = new JPanel();
            pnl.setBorder(new TitledBorder(s.getName()));
            pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
            add(pnl);

            // Get readings for the sensor
            double val = s.getValue();
            String status = s.getStatus();
            int width = s.getStatusBarSize(val);
            Color color;

            // Set status colors
            if (status.equals("OK")) {
                color = Color.GREEN;
            } else if (status.equals("DANGER")) {
                color = Color.RED;
            } else {
                color = Color.YELLOW;
            }

            // Add status bar of appropriate length
            JLabel statusColor = new JLabel();
            statusColor.setOpaque(true);
            statusColor.setBackground(color);
            statusColor.setPreferredSize(new Dimension(width, 70));
            pnl.add(statusColor);

            // Add status message
            JLabel message = new JLabel("\n\n" + status + " --> " + val + " " + s.getUnit());
            Font font = new Font("Courier", Font.BOLD,16);
            message.setFont(font);
            pnl.add(message);
        }

        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

}
