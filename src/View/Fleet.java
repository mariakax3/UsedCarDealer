package View;

import Cars.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Fleet {
    public Vector<Car> fleetPC;
    public Vector<Car> fleetT;
    private final FleetRepository repository;

    public Fleet(FleetRepository fleetRepository) {
        fleetPC = new Vector<>();
        fleetT = new Vector<>();
        this.repository = fleetRepository;
        readData();
    }

    public void showFleet(Integer t, JPanel panel){
        if(t == 0){
            printFleet(fleetPC, panel, 0, t);
        }
        else if(t == 1){
            printFleet(fleetT, panel, 0, t);
        }
    }

    public void saveData() {
        ArrayList<Object[]> entities = new ArrayList<>();
        for(int i = 0; i < fleetPC.size(); i++){
            entities.add(fleetPC.elementAt(i).getAsEntity());
        }
        for(int i = 0; i < fleetT.size(); i++){
            entities.add(fleetT.elementAt(i).getAsEntity());
        }
        try {
            repository.saveToFile(entities);
        } catch (CannotSaveToFileException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void readData(){
        ArrayList<Object[]> entities = repository.readFromFile();
        for(Object[] c : entities) {
            if ("p".compareTo(c[0].toString()) == 0){
                Car car = new PassengerCar(c[1].toString(), c[2].toString(), Integer.parseInt(c[3].toString()),
                        Integer.parseInt(c[4].toString()), Integer.parseInt(c[5].toString()), c[6].toString(),
                        Float.parseFloat(c[7].toString()), c[8].toString(), c[9].toString(),
                        Integer.parseInt(c[10].toString()), Boolean.valueOf(c[11].toString()));
                fleetPC.add(car);
            }
            else if ("t".compareTo(c[0].toString()) == 0){
                Car car = new Truck(c[1].toString(), c[2].toString(), Integer.parseInt(c[3].toString()),
                        Integer.parseInt(c[4].toString()), Integer.parseInt(c[5].toString()), Integer.parseInt(c[6].toString()),
                        Float.parseFloat(c[7].toString()), Float.parseFloat(c[8].toString()), Float.parseFloat(c[9].toString()),
                        Integer.parseInt(c[10].toString()), Boolean.valueOf(c[11].toString()));
                fleetT.add(car);
            }
        }
    }

    private void printFleet(Vector cars, JPanel panel, int i, int type){
        if(cars.size() == 0) {
            panel.removeAll();
            String x = "";
            if(type == 0){
                x = "samochodów";
            }
            else if(type == 1){
                x = "ciężarówek";
            }
            JLabel info = new JLabel("Baza " + x + " aktualnie jest pusta.");
            info.setFont(new Font("Tahoma", Font.PLAIN, 18));
            info.setForeground(new Color(168, 50, 64));
            panel.add(info);
            return;
        }

        JButton showMore = new JButton("Przeglądaj dalej");
        JButton getBack = new JButton("Wstecz");

        panel.removeAll();
        showData(panel, i, type);
        i++;
        if(i < cars.size()) {
            showData(panel, i, type);
            i++;
            if(i < cars.size()) {
                showData(panel, i, type);
                i++;
                if(i < cars.size()){
                    final int x = i;
                    showMore.addActionListener(e -> {
                        panel.setVisible(false);
                        printFleet(cars, panel, x, type);
                    });
                    panel.add(showMore);
                }
            }
        }
        if(i - 1 >= 3) {
            if((i % 3) == 0){
                final int y = i - 6;
                getBack.addActionListener(f -> {
                    panel.setVisible(false);
                    printFleet(cars, panel, y, type);
                });
            }
            else {
                final int y = i - 3 - (i % 3);
                getBack.addActionListener(f -> {
                    panel.setVisible(false);
                    printFleet(cars, panel, y, type);
                });
            }
            panel.add(getBack);
        }
    }

    private void showData(JPanel panel, int i, int t){
        if(t == 0){
            showDataPC(panel, i);
        }
        else if(t == 1){
            showDataT(panel, i);
        }
    }

    private void showDataT(JPanel panel, int i){
        String sep = "     ";
        JSeparator v = new JSeparator(SwingConstants.VERTICAL);
        v.setPreferredSize(new Dimension(800,30));

        JLabel mileage = loadImg("img/mileage.png");
        JLabel capacity = loadImg("img/cap.png");
        JLabel engine = loadImg("img/eng.png");
        JLabel meas = loadImg("img/meas.png");

        JLabel name = new JLabel(fleetT.elementAt(i).getBrand() + " " +
                fleetT.elementAt(i).getModel() + ", " + fleetT.elementAt(i).getDate() + sep);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        name.setForeground(new Color(201, 122, 18));

        JLabel price = new JLabel("Cena: " + fleetT.elementAt(i).getPrice() + " PLN" + sep);
        price.setFont(new Font("Tahoma", Font.PLAIN, 18));
        price.setForeground(new Color(168, 50, 64));

        panel.add(name);
        panel.add(mileage);
        panel.add(new JLabel(fleetT.elementAt(i).getMileage().toString() + " km" + sep));
        panel.add(engine);
        panel.add(new JLabel(fleetT.elementAt(i).getEnginePower() + " KM" + sep));
        panel.add(capacity);
        panel.add(new JLabel(((Truck) fleetT.elementAt(i)).getCapacity() + " kg" + sep));
        panel.add(meas);
        panel.add(new JLabel(((Truck) fleetT.elementAt(i)).getLength() + "m x "
                + ((Truck) fleetT.elementAt(i)).getWidth() + "m x "
                + ((Truck) fleetT.elementAt(i)).getHeight() + "m" + sep));
        panel.add(price);

        JLabel info = new JLabel("*REZERWACJA*");
        info.setFont(new Font("Tahoma", Font.PLAIN, 16));
        info.setForeground(new Color(168, 50, 64));

        if(!fleetT.elementAt(i).getState()){
            JButton reserve = new JButton("Rezerwuj");
            reserve.addActionListener(e -> {
                if(reserve == (JButton) e.getSource()){
                    fleetT.elementAt(i).setReserved();
                    reserve.setEnabled(false);
                    reserve.setText("*REZERWACJA*");
                    reserve.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    panel.revalidate();
                    saveData();
                }
            });
            panel.add(reserve);
        }
        else{
            panel.add(info);
        }
        panel.add(v);
    }

    private void showDataPC(JPanel panel, int i){
        String sep = "     ";
        JSeparator v = new JSeparator(SwingConstants.VERTICAL);
        v.setPreferredSize(new Dimension(800,30));

        JLabel mileage = loadImg("img/mileage.png");
        JLabel aut = loadImg("img/aut.png");
        JLabel man = loadImg("img/man.png");
        JLabel fuel = loadImg("img/fuel.png");
        JLabel engine = loadImg("img/eng.png");
        JLabel body = loadImg("img/body.png");

        JLabel name = new JLabel(fleetPC.elementAt(i).getBrand() + " " +
                fleetPC.elementAt(i).getModel() + ", " + fleetPC.elementAt(i).getDate() + sep);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        name.setForeground(new Color(201, 122, 18));

        JLabel price = new JLabel("Cena: " + fleetPC.elementAt(i).getPrice() + " PLN" + sep);
        price.setFont(new Font("Tahoma", Font.PLAIN, 18));
        price.setForeground(new Color(168, 50, 64));

        panel.add(name);
        panel.add(mileage);
        panel.add(new JLabel(fleetPC.elementAt(i).getMileage().toString() + " km" + sep));

        if(((PassengerCar) fleetPC.elementAt(i)).getGearboxType() == "Manualna") {
            panel.add(man);
        }
        else{
            panel.add(aut);
        }

        panel.add(new JLabel(((PassengerCar) fleetPC.elementAt(i)).getGearboxType() + sep));
        panel.add(fuel);
        panel.add(new JLabel(((PassengerCar) fleetPC.elementAt(i)).getFuelType() + sep));
        panel.add(engine);
        panel.add(new JLabel(((PassengerCar) fleetPC.elementAt(i)).getEngineCapacity()
                + " dm³ / " + fleetPC.elementAt(i).getEnginePower() + " KM" + sep));
        panel.add(body);
        panel.add(new JLabel(((PassengerCar) fleetPC.elementAt(i)).getBodyType()));
        panel.add(price);

        JLabel info = new JLabel("*REZERWACJA*");
        info.setFont(new Font("Tahoma", Font.PLAIN, 16));
        info.setForeground(new Color(168, 50, 64));

        if(!fleetPC.elementAt(i).getState()){
            JButton reserve = new JButton("Rezerwuj");
            reserve.addActionListener(e -> {
                if(reserve == (JButton) e.getSource()){
                    fleetPC.elementAt(i).setReserved();
                    reserve.setEnabled(false);
                    reserve.setText("*REZERWACJA*");
                    reserve.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    panel.revalidate();
                    saveData();
                }
            });
            panel.add(reserve);
        }
        else{
            panel.add(info);
        }
        panel.add(v);
    }

    private JLabel loadImg(String path){
        try{
            BufferedImage icon = ImageIO.read(new File(path));
            Image resized = icon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(resized));
            return picLabel;
        }catch(IOException ex) {
            System.out.println("Nie udało się załadować pliku.");
            JLabel message = new JLabel("");
            return message;
        }
    }
}
