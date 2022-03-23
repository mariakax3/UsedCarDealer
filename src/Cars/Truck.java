package Cars;

public class Truck extends Car {
    private Integer capacity;
    private Float length;
    private Float width;
    private Float height;

    public Truck(String brand, String model, Integer mileage, Integer productionDate, Integer enginePower,
                 Integer capacity, Float length, Float width, Float height, Integer price, Boolean reserved){
        super(brand, model, mileage, productionDate, enginePower, price, reserved);
        this.capacity = capacity;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public Integer getDate(){
        return this.productionDate;
    }

    public Integer getMileage(){
        return this.mileage;
    }

    public Integer getEnginePower(){
        return this.enginePower;
    }

    public Integer getPrice(){
        return this.price;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public Float getLength(){
        return this.length;
    }

    public Float getWidth(){
        return this.width;
    }

    public Float getHeight(){
        return this.height;
    }

    public boolean getState(){
        return this.reserved;
    }

    public void setReserved(){
        this.reserved = true;
    }

    public Object[] getAsEntity() {
        return new Object[] {"t", this.brand, this.model, this.mileage, this.productionDate, this.enginePower,
                                this.capacity, this.length, this.width, this.height, this.price, this.reserved};
    }
}
