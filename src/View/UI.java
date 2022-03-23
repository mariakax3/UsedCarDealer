package View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class UI extends JFrame {
    private JTabbedPane tabbedPane;

    public UI(Fleet fleet, HomePanel home, BuyPassengerCar buyPC, SellPassengerCar sellPC, BuyTruck buyTruck, SellTruck sellTruck){

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.add("Strona główna", home);
        tabbedPane.add("Kup samochód osobowy", buyPC);
        tabbedPane.add("Sprzedaj samochód osobowy", sellPC);
        tabbedPane.add("Kup ciężarówkę", buyTruck);
        tabbedPane.add("Sprzedaj ciężarówkę", sellTruck);

        ImageIcon icon = new ImageIcon("img/cari.png");
        ImageIcon homeIcon = new ImageIcon("img/home.png");
        ImageIcon buyPCIcon = new ImageIcon("img/buycar.png");
        ImageIcon sellPCIcon = new ImageIcon("img/sellcar.png");
        ImageIcon buyTruckIcon = new ImageIcon("img/buytruck.png");
        ImageIcon sellTruckIcon = new ImageIcon("img/selltruck.png");

        Image resizedImg = homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(resizedImg);
        Image resizedImg1 = buyPCIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        buyPCIcon = new ImageIcon(resizedImg1);
        Image resizedImg2 = sellPCIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        sellPCIcon = new ImageIcon(resizedImg2);
        Image resizedImg3 = buyTruckIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        buyTruckIcon = new ImageIcon(resizedImg3);
        Image resizedImg4 = sellTruckIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        sellTruckIcon = new ImageIcon(resizedImg4);

        tabbedPane.setIconAt(0, homeIcon);
        tabbedPane.setIconAt(1, buyPCIcon);
        tabbedPane.setIconAt(2, sellPCIcon);
        tabbedPane.setIconAt(3, buyTruckIcon);
        tabbedPane.setIconAt(4, sellTruckIcon);

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(tabbedPane.getSelectedIndex() == 1){
                    fleet.showFleet(0, buyPC);
                }
                else if(tabbedPane.getSelectedIndex() == 3){
                    fleet.showFleet(1, buyTruck);
                }
            }
        });

        getContentPane().add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(860, 530));
        setTitle("Komis samochodowy");
        setIconImage(icon.getImage());
        setResizable(false);
        setVisible(true);
    }
}
