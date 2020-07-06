package Application.View;

import Application.Controller.CodeController;
import Application.Model.Code;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class DashboardPage extends JFrame {
    private JPanel topPanel, searchPanel;
    private JDatePickerImpl datePicker, searchDatePicker;
    JTextField amountTextField;
    private final Dimension DEFAULT_DIMENSION = new Dimension(100, 25);
    private final CodeController codeController = new CodeController();

    public DashboardPage() {
        initDatePicker();
        initInsertPanel();
        initDefaultValues();
    }

    private void initInsertPanel() {
        //panel
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        //Fields

        amountTextField = new JTextField();
        amountTextField.setPreferredSize(DEFAULT_DIMENSION);


        //Button
        JButton addButton = new JButton("Add");
        addButton.setPreferredSize(DEFAULT_DIMENSION);
        addButton.addActionListener(event -> insertCode());

        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(DEFAULT_DIMENSION);
        searchButton.addActionListener(event -> searchCode());

        //Labels
        JLabel dateLabel = new JLabel();
        dateLabel.setText("Date: ");

        JLabel amountLabel = new JLabel();
        amountLabel.setText("Amount: ");


        //add components
        topPanel.add(dateLabel);
        topPanel.add(datePicker);
        topPanel.add(amountLabel);
        topPanel.add(amountTextField);
        topPanel.add(addButton);
        topPanel.add(searchButton);
        add(topPanel);
    }

    private void searchCode() {

    }

    private void insertCode() {
        if (allFieldsAreValid()) {
            int amount = Integer.parseInt(amountTextField.getText());
            java.sql.Date insertDate = null;
            try {
                java.util.Date utilDate = new SimpleDateFormat("MMM dd, yyyy").parse(datePicker.getJFormattedTextField().getText());
                insertDate = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String id = amountTextField.getText() + ", " + datePicker.getJFormattedTextField().getText();

            Code code = new Code(id, insertDate, amount);
            codeController.insertCode(code);
            JOptionPane.showMessageDialog(null, "Code added to DB!");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all insert fields");
        }

    }

    private boolean allFieldsAreValid() {
        return !amountTextField.getText().equals("") && !datePicker.getJFormattedTextField().getText().equals("");
    }

    private void initDatePicker() {
        UtilDateModel model = new UtilDateModel();
        UtilDateModel searchModel = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");


        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePanelImpl searchDatePanel = new JDatePanelImpl(searchModel, properties);

        searchDatePicker = new JDatePickerImpl(searchDatePanel, new DateComponentFormatter());
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
    }

    private void initDefaultValues() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setTitle("FiscalLotteryDB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
