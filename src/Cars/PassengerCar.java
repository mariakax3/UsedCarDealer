package Cars;

public class PassengerCar extends Car {
    private String gearboxType;
    private Float engineCapacity;
    private String fuelType;
    private String bodyType;

    public PassengerCar(String brand, String model, Integer mileage, Integer productionDate,
                        Integer enginePower, String gearboxType, Float engineCapacity,
                        String fuelType, String bodyType, Integer price, Boolean reserved){
        super(brand, model, mileage, productionDate, enginePower, price, reserved);
        this.gearboxType = gearboxType;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
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

    public String getGearboxType(){
        return this.gearboxType;
    }

    public Float getEngineCapacity(){
        return this.engineCapacity;
    }

    public String getFuelType(){
        return this.fuelType;
    }

    public String getBodyType(){
        return this.bodyType;
    }

    public boolean getState(){
        return this.reserved;
    }

    public void setReserved(){
        this.reserved = true;
    }

    public Object[] getAsEntity() {
        return new Object[] {"p", this.brand, this.model, this.mileage, this.productionDate, this.enginePower,
                this.gearboxType, this.engineCapacity, this.fuelType, this.bodyType, this.price, this.reserved};
    }
}
