package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

import Cars.*;

public class SellPassengerCar extends JPanel {
    private JTextField brandTextField;
    private JTextField modelTextField;
    private JTextField dateTextField;
    private JTextField mileageTextField;
    private JTextField powerTextField;
    private JTextField capTextField;
    private JTextField priceTextField;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel dateLabel;
    private JLabel mileageLabel;
    private JLabel powerLabel;
    private JLabel engineCapLabel;
    private JLabel gearboxTypeLabel;
    private JLabel fuelTypeLabel;
    private JLabel bodyTypeLabel;
    private JLabel priceLabel;
    private JComboBox gearboxTypeBox;
    private JComboBox fuelTypeBox;
    private JComboBox bodyTypeBox;
    private JButton addButton;
    private JButton resetButton;



    public SellPassengerCar(Fleet fleet){
        setup();
        brandTextField.addActionListener(e-> modelTextField.grabFocus());
        modelTextField.addActionListener(e -> dateTextField.grabFocus());
        dateTextField.addActionListener(e-> mileageTextField.grabFocus());
        mileageTextField.addActionListener(e -> powerTextField.grabFocus());
        powerTextField.addActionListener(e -> capTextField.grabFocus());
        capTextField.addActionListener(e -> gearboxTypeBox.grabFocus());
        gearboxTypeBox.addActionListener(e -> fuelTypeBox.grabFocus());
        fuelTypeBox.addActionListener(e -> bodyTypeBox.grabFocus());
        bodyTypeBox.addActionListener(e -> priceTextField.grabFocus());
        priceTextField.addActionListener(e -> addButton.grabFocus());
        addButton.addActionListener(e -> addToFleet(fleet));
        resetButton.addActionListener(e -> resetData());
    }

    private void setup(){
        this.setLayout(new GridLayout(12, 6, 10, 10));

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Wprowadź dane"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 28));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(new Color(66, 134, 244));

        Border border = this.getBorder();
        Border margin = new EmptyBorder(16, 20, 16, 20);
        this.setBorder(new CompoundBorder(border, margin));

        brandTextField.setBorder(new LineBorder(Color.BLACK, 1));
        modelTextField.setBorder(new LineBorder(Color.BLACK, 1));
        dateTextField.setBorder(new LineBorder(Color.BLACK, 1));
        mileageTextField.setBorder(new LineBorder(Color.BLACK, 1));
        powerTextField.setBorder(new LineBorder(Color.BLACK, 1));
        capTextField.setBorder(new LineBorder(Color.BLACK, 1));
        gearboxTypeBox.setBorder(new LineBorder(Color.BLACK, 1));
        fuelTypeBox.setBorder(new LineBorder(Color.BLACK, 1));
        bodyTypeBox.setBorder(new LineBorder(Color.BLACK, 1));
        priceTextField.setBorder(new LineBorder(Color.BLACK, 1));

        gearboxTypeBox.addItem("");
        gearboxTypeBox.addItem("Automatyczna");
        gearboxTypeBox.addItem("Manualna");
        fuelTypeBox.addItem("");
        fuelTypeBox.addItem("Benzyna");
        fuelTypeBox.addItem("Benzyna+LPG");
        fuelTypeBox.addItem("Benzyna+CNG");
        fuelTypeBox.addItem("Diesel");
        fuelTypeBox.addItem("Hybryda");
        fuelTypeBox.addItem("Elektryczny");
        fuelTypeBox.addItem("Wodór");
        bodyTypeBox.addItem("");
        bodyTypeBox.addItem("SUV");
        bodyTypeBox.addItem("Kombi");
        bodyTypeBox.addItem("Sedan");
        bodyTypeBox.addItem("Hatchback");
        bodyTypeBox.addItem("Kabriolet");
        bodyTypeBox.addItem("Coupé");
        bodyTypeBox.addItem("Pickup");

        ImageIcon addI = new ImageIcon("img/ok.png");
        Image resizedImg = addI.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        addI = new ImageIcon(resizedImg);
        addButton.setIcon(addI);
        ImageIcon clearI = new ImageIcon("img/clear.png");
        Image resizedImg1 = clearI.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        clearI = new ImageIcon(resizedImg1);
        resetButton.setIcon(clearI);

        this.add(brandLabel);
        this.add(brandTextField);
        this.add(modelLabel);
        this.add(modelTextField);
        this.add(dateLabel);
        this.add(dateTextField);
        this.add(mileageLabel);
        this.add(mileageTextField);
        this.add(powerLabel);
        this.add(powerTextField);
        this.add(engineCapLabel);
        this.add(capTextField);
        this.add(gearboxTypeLabel);
        this.add(gearboxTypeBox);
        this.add(fuelTypeLabel);
        this.add(fuelTypeBox);
        this.add(bodyTypeLabel);
        this.add(bodyTypeBox);
        this.add(priceLabel);
        this.add(priceTextField);
        this.add(addButton);
        this.add(resetButton);
    }

    private void addToFleet(Fleet fleet){
        ArrayList<String> message = new ArrayList<>();
        String brand = null;
        try {
            brand = Validators.getString(brandTextField.getText());
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            brandTextField.setText("");
        }
        String model = modelTextField.getText();
        Integer mileage = null;
        try {
            mileage = Validators.getInt(mileageTextField.getText(), 0, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            mileageTextField.setText("");
        }
        Integer productionDate = null;
        try {
            productionDate = Validators.getInt(dateTextField.getText(), 1800, Calendar.getInstance().get(Calendar.YEAR));
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            dateTextField.setText("");
        }
        Integer enginePower = null;
        try {
            enginePower = Validators.getInt(powerTextField.getText(), 0, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            powerTextField.setText("");
        }
        String gearboxType = (String) gearboxTypeBox.getSelectedItem();
        String engineCapStr = capTextField.getText();
        engineCapStr = engineCapStr.replace(",",".");
        Float engineCapacity = null;
        try {
            engineCapacity = Validators.getFloat(engineCapStr, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            capTextField.setText("");
        }
        String fuelType = (String) fuelTypeBox.getSelectedItem();
        String bodyType = (String) bodyTypeBox.getSelectedItem();
        Integer price = null;
        try {
            price = Validators.getInt(priceTextField.getText(), 0, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            priceTextField.setText("");
        }

        if(!message.isEmpty()){
            JOptionPane.showMessageDialog(null, String.join("\n", message));
        }

        if (brand == null || model == null || mileage == null || productionDate == null || enginePower == null
            || gearboxType == "" || engineCapacity == null || fuelType == "" || bodyType == "" || price == null) {
            JOptionPane.showMessageDialog(null, "Podaj wszystkie wymagane parametry.");
        }
        else{
            Car car = new PassengerCar(brand, model, mileage, productionDate, enginePower,
                    gearboxType, engineCapacity, fuelType, bodyType, price, false);
            fleet.fleetPC.add(car);
            JOptionPane.showMessageDialog(null, "Samochód został pomyślnie dodany do bazy.");
            fleet.saveData();
            resetData();
        }
    }

    private void resetData(){
        brandTextField.setText("");
        modelTextField.setText("");
        dateTextField.setText("");
        mileageTextField.setText("");
        powerTextField.setText("");
        capTextField.setText("");
        gearboxTypeBox.setSelectedIndex(0);
        fuelTypeBox.setSelectedIndex(0);
        bodyTypeBox.setSelectedIndex(0);
        priceTextField.setText("");
    }
}
