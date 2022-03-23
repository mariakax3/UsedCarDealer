package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePanel extends JPanel {
    private JLabel title;

    public HomePanel(){
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),""));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 28));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(new Color(66, 134, 244));

        try{
            BufferedImage carImg = ImageIO.read(new File("img/car4.png"));
            Image resized = carImg.getScaledInstance(324, 350, Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(resized));
            this.add(picLabel);
        }catch(IOException ex){
            System.out.println("Nie udało się załadować pliku.");
        }

        title.setFont(new Font("ROG Fonts", Font.PLAIN, 30));
        this.add(title);
    }
}
