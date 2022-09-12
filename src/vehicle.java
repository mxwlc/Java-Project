public class vehicle {
    private String make, model;
    private int yearOfManufacture;
    private float engineCapacity, price;
    
    public vehicle() {
        this.make = "";
        this.model = "";
        this.engineCapacity = 0;
        this.price = 0;
        this.yearOfManufacture = 0;
    }

    public vehicle(String make, String model, float engineCapacity, int yearOfManufacture, float price) {
        this.make = make;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getengineCapacity() {
        return this.engineCapacity;
    }

    public void setengineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getyearOfManufacture() {
        return this.yearOfManufacture;
    }

    public void setyearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
   
}
