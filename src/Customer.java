public class Customer {
    private String ID;
    private String name;

    Customer(String name){
        this.ID = RandomUID.generateRandomID();
        this.name = name;
    }
    @Override
    public String toString() {
        return
                "ID='" + ID + '\'' +
                ", name ='" + name + '\'';

    }
    public String getID(){
        return this.ID;
    }
}
