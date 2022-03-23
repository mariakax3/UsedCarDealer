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

public class SellTruck extends JPanel {
    private JTextField brandTextField;
    private JTextField modelTextField;
    private JTextField dateTextField;
    private JTextField mileageTextField;
    private JTextField powerTextField;
    private JTextField capacityTextField;
    private JTextField lengthTextField;
    private JTextField widthTextField;
    private JTextField heightTextField;
    private JTextField priceTextField;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel dateLabel;
    private JLabel mileageLabel;
    private JLabel powerLabel;
    private JLabel capacityLabel;
    private JLabel lengthLabel;
    private JLabel widthLabel;
    private JLabel heightLabel;
    private JLabel priceLabel;
    private JButton addButton;
    private JButton resetButton;

    public SellTruck(Fleet fleet){
        setup();
        brandTextField.addActionListener(e-> modelTextField.grabFocus());
        modelTextField.addActionListener(e -> dateTextField.grabFocus());
        dateTextField.addActionListener(e-> mileageTextField.grabFocus());
        mileageTextField.addActionListener(e -> powerTextField.grabFocus());
        powerTextField.addActionListener(e -> capacityTextField.grabFocus());
        capacityTextField.addActionListener(e -> lengthTextField.grabFocus());
        lengthTextField.addActionListener(e -> widthTextField.grabFocus());
        widthTextField.addActionListener(e -> heightTextField.grabFocus());
        heightTextField.addActionListener(e -> priceTextField.grabFocus());
        priceTextField.addActionListener(e -> addButton.grabFocus());
        addButton.addActionListener(e -> addToFleet(fleet));
        resetButton.addActionListener(e -> resetData());
    }

    private void setup(){
        this.setLayout(new GridLayout(12, 6, 10, 10));

        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Wprowadź dane"));
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
        capacityTextField.setBorder(new LineBorder(Color.BLACK, 1));
        lengthTextField.setBorder(new LineBorder(Color.BLACK, 1));
        widthTextField.setBorder(new LineBorder(Color.BLACK, 1));
        heightTextField.setBorder(new LineBorder(Color.BLACK, 1));
        priceTextField.setBorder(new LineBorder(Color.BLACK, 1));

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
        this.add(capacityLabel);
        this.add(capacityTextField);
        this.add(lengthLabel);
        this.add(lengthTextField);
        this.add(widthLabel);
        this.add(widthTextField);
        this.add(heightLabel);
        this.add(heightTextField);
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
        Integer capacity = null;
        try {
            capacity = Validators.getInt(capacityTextField.getText(), 0, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            capacityTextField.setText("");
        }
        String str = lengthTextField.getText();
        str = str.replace(",", ".");
        Float length = null;
        try {
            length = Validators.getFloat(str, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            lengthTextField.setText("");
        }
        str = widthTextField.getText();
        str = str.replace(",", ".");
        Float width = null;
        try {
            width = Validators.getFloat(str, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            widthTextField.setText("");
        }
        str = heightTextField.getText();
        str = str.replace(",", ".");
        Float height = null;
        try {
            height = Validators.getFloat(str, 0);
        } catch (FormExceptions e) {
            if (!(message.contains(e.toString()))){
                message.add(e.toString());
            }
            heightTextField.setText("");
        }
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
                || capacity == null || length == null || width == null || height == null || price == null) {
            JOptionPane.showMessageDialog(null, "Podaj wszystkie wymagane parametry.");
        }
        else{
            Car car = new Truck(brand, model, mileage, productionDate, enginePower,
                    capacity, length, width, height, price, false);
            fleet.fleetT.add(car);
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
        capacityTextField.setText("");
        lengthTextField.setText("");
        widthTextField.setText("");
        heightTextField.setText("");
        priceTextField.setText("");
    }
}
