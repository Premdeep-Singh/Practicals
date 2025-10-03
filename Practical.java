
/* Question 2: HashMap 
Create a Java program that uses a HashMap to store employee IDs (Integer) as keys and their names (String) as values. 
Write methods to: 
    1. Add an employee to the map. 
    2. Retrieve an employee's name by ID. 
    3. Throw a custom exception if the ID is not found. 
    4. Display all employees in the format "ID: Name". 
*/


/*
Question 4: HashMap and Exception Handling 
Write a Java program that uses a HashMap to store product IDs (String) and their prices (Double). 
Implement a method to apply a discount to a product's price based on a percentage input. 
Handle the following cases: 
    1. Throw a custom exception if the product ID doesn't exist. 
    2. Throw an IllegalArgumentException if the discount percentage is negative or greater than 100. 
    3. Update the price in the HashMap after applying the discount.
*/


import java.util.*;

class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String message) {
        super(message);
    }
}

public class Practical {
    public static void main(String[] args) {
        Map<Integer, String> mp1 = new HashMap<>();
        Map<String, Double> mp2 = new HashMap<>();

        mp2.put("A", 29.99);
        mp2.put("B", 24.99);
        mp2.put("C", 13.99);
        mp2.put("D", 44.99);
        mp2.put("E", 19.99);

        System.out.println("1. Add/Find/Display in Integer-String Map");
        System.out.println("2. Apply Discount in String-Double Map");
        System.out.println("0. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice != 0){
            choice = sc.nextInt();
            if(choice == 1){
                System.out.println("1. Add");
                System.out.println("2. Find");
                System.out.println("3. Display");
                System.out.println("0. Exit");
                choice = sc.nextInt(); 
                switch (choice) {
                    case 1:
                        int key = sc.nextInt(); sc.nextLine();
                        String value = sc.nextLine();
                        mp1.put(key, value);
                        break;
                    case 2:
                        try {
                            int find = sc.nextInt();
                            if (!mp1.containsKey(find)) {
                                throw new KeyNotFoundException(find + " not found in the map.");
                            }
                            System.out.println(mp1.get(find));

                        } catch (KeyNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        for (Map.Entry<Integer, String> entry : mp1.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }    
            else if (choice == 2){
                try {
                    sc.nextLine();
                    String code = sc.nextLine();
                    Double discount = sc.nextDouble();
                    ApplyDiscount(mp2, code, discount);
                } catch (IllegalArgumentException | KeyNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void ApplyDiscount(Map<String, Double> mp2, String code, Double discount) throws IllegalArgumentException, KeyNotFoundException {
        if (!mp2.containsKey(code)) {
            throw new KeyNotFoundException(code + " not found in the map.");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100.");
        }
        
        Double newVal = mp2.get(code) - (mp2.get(code) * (discount / 100));
        mp2.put(code, newVal);
        System.out.println("Discount applied: " + discount);
    }
}


