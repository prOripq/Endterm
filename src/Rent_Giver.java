public class Rent_Giver extends Person {
    private String items;
    private double price;

    public Rent_Giver(String name, String surname, String items, double price ){
        super(name, surname);
        this.items = items;
        this.price = price;
    }

    public String getItems(){
        return items;
    }

    public double getPrice(){
        return price;
    }

    public String toString() {
        return "Rent Giver: " + getName() + " " + getSurname() + " sells " + getItems() + " for " + getPrice() + " dollars";
    }

}