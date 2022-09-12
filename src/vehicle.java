public class vehicle {
    private String make, model;
    private int yearOfManufacture;
    private double engineCapacity, price;
    
    public vehicle() {
        this.make = "";
        this.model = "";
        this.engineCapacity = 0;
        this.price = 0;
        this.yearOfManufacture = 0;
    }

    public vehicle(String make, String model, double engineCapacity, int yearOfManufacture, double price) {
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

    public double getengineCapacity() {
        return this.engineCapacity;
    }

    public void setengineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getyearOfManufacture() {
        return this.yearOfManufacture;
    }

    public void setyearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
}
