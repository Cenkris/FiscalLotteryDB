package Application.View;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class DashboardPage extends JFrame {
    private JPanel insertPanel;

    public DashboardPage() {
        initInsertPanel();
        initDefaultValues();
    }

    private void initInsertPanel() {
        //panel
        insertPanel = new JPanel(new FlowLayout());

        //Lables
        JLabel dateLabel = new JLabel();
        dateLabel.setText("Date: ");

        //Date
        initDatePicker();

        //add components
        add(dateLabel);
        add(insertPanel);
    }

    private void initDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        insertPanel.add(datePicker);
    }

    private void initDefaultValues() {
        setTitle("DashBoard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
//        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
