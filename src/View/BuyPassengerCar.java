package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BuyPassengerCar extends JPanel {
    private JPanel panel;

    public BuyPassengerCar(){

        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Samochody osobowe"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 28));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(new Color(66, 134, 244));

        Border border = this.getBorder();
        Border margin = new EmptyBorder(20, 10, 20, 10);
        this.setBorder(new CompoundBorder(border, margin));
    }
}
