

public class Customer extends Person {
    private String items;
    private double budget;

    public Customer(String name, String surname, String items, double budget) {
        super(name, surname);
        this.items = items;
        this.budget = budget;
    }

    public String getItems() {
        return items;
    }

    public double getBudget() {
        return budget;
    }

    public boolean buyItem(Rent_Giver rentGiver) {
        if (rentGiver.getPrice() <= budget) {
            budget -= rentGiver.getPrice();
            System.out.println("Purchase successful!");
            System.out.println("Remaining budget: $" + budget);
            return true;
        }
        System.out.println("Purchase failed. Insufficient budget.");
        return false;
    }

}