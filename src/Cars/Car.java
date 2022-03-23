package Cars;

import java.io.Serializable;

public abstract class Car implements Serializable {
    protected String brand;
    protected String model;
    protected Integer mileage;
    protected Integer productionDate;
    protected Integer enginePower;
    protected Integer price;
    protected boolean reserved;

    public Car(String brand, String model, Integer mileage, Integer productionDate,
               Integer enginePower, Integer price, Boolean reserved){
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.productionDate = productionDate;
        this.enginePower = enginePower;
        this.price = price;
        this.reserved = reserved;
    }

    public abstract String getBrand();
    public abstract String getModel();
    public abstract Integer getDate();
    public abstract Integer getMileage();
    public abstract Integer getEnginePower();
    public abstract Integer getPrice();
    public abstract boolean getState();
    public abstract void setReserved();
    public abstract Object[] getAsEntity();
}
