import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Rent_Giver");
            System.out.println("2. Add Customer");
            System.out.println("3. Buy Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addRentGiver(scanner, people);
                    break;
                case 2:
                    addCustomer(scanner, people);
                    break;
                case 3:
                    buyItem(scanner, people);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close(); // Closing the scanner
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void addRentGiver(Scanner scanner, List<Person> people) {
        System.out.println("\nEnter details of Rent_Giver (name, surname, items, price):");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Items: ");
        String items = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Rent_Giver rentGiver = new Rent_Giver(name, surname, items, price);
        people.add(rentGiver);
    }

    public static void addCustomer(Scanner scanner, List<Person> people) {
        System.out.println("\nEnter details of Customer (name, surname, items, budget):");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Items interested in: ");
        String items = scanner.nextLine();

        System.out.print("Budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Customer customer = new Customer(name, surname, items, budget);
        people.add(customer);
    }

    public static void buyItem(Scanner scanner, List<Person> people) {
        System.out.println("\nEnter details of Purchase (customer name, customer surname, rent giver name, rent giver surname):");
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Customer Surname: ");
        String customerSurname = scanner.nextLine();
        System.out.print("Rent Giver Name: ");
        String rentGiverName = scanner.nextLine();
        System.out.print("Rent Giver Surname: ");
        String rentGiverSurname = scanner.nextLine();

        // Find the customer and rent giver
        Customer customer = null;
        Rent_Giver rentGiver = null;
        for (Person person : people) {
            if (person instanceof Customer && person.getName().equalsIgnoreCase(customerName) && person.getSurname().equalsIgnoreCase(customerSurname)) {
                customer = (Customer) person;
            }
            if (person instanceof Rent_Giver && person.getName().equalsIgnoreCase(rentGiverName) && person.getSurname().equalsIgnoreCase(rentGiverSurname)) {
                rentGiver = (Rent_Giver) person;
            }
        }

        if (customer != null && rentGiver != null) {
            System.out.println("\nConfirm purchase of " + rentGiver.getItems() + " from " + rentGiver.getName() + " " + rentGiver.getSurname() + " for $" + rentGiver.getPrice() + " by " + customer.getName() + " " + customer.getSurname() + "? (yes/no)");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                if (customer.buyItem(rentGiver)) {
                    System.out.println("Purchase successful!");
                } else {
                    System.out.println("Purchase failed. Insufficient budget.");
                }
            } else {
                System.out.println("Purchase canceled.");
            }
        } else {
            System.out.println("Customer or Rent Giver not found.");
        }
    }

    public static void printData(Iterable<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}