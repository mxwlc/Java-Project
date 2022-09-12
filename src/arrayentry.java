public class arrayentry {
    vehicle v;
    int id;


    public arrayentry() {
    }

    public arrayentry(vehicle v, int id) {
        this.v = v;
        this.id = id;
    }

    public vehicle getV() {
        return this.v;
    }

    public void setV(vehicle v) {
        this.v = v;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
