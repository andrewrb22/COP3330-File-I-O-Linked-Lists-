//Andrew Rodriguez
//October 19, 2022
//COP3330 
//Assignment 4: File I/O & Linked Lists
import java.util.*;
import java.io.*;

//Customer class - 
class Customer { 
    String name;
    boolean buying;
//Customer constructure - takes string and boolean
    public Customer(String name, boolean buying) {
        this.name = name;
        this.buying  = buying;
    }
//Methods
    public String getName() {
        return name;
    }

    public boolean getBusiness() {
        return buying ;
    }
}
// Store class
public class store {
    //static LinkedLists that store Customers
    static LinkedList<Customer> checkout = new LinkedList<Customer>();
    static LinkedList<Customer> return_line = new LinkedList<Customer>();

    //Main Method
    /**
     * @param args
     */
    public static void main(String[] args) {
// Ask the user what is the name of the file they would like to load.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file :");
        String file = sc.next();
        String st;
        // Main method reads information from the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                String str[] = st.toString().split(" ");

                checkout.add(new Customer(str[0], Boolean.parseBoolean(str[1])));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            for (int i = 0; i < 2; i++) {
                if (checkout.size() < 1) {
                    break;
                }
                boolean val = checkout.getFirst().getBusiness();
                if (val == true) {
                    System.out.println(checkout.getFirst().getName() + " was forwarded to the return line");
                    return_line.add(checkout.getFirst());
                } else {
                    System.out.println(checkout.getFirst().getName() + " has checked out");
                }
                checkout.removeFirst();

            }

         
            System.out.println(return_line.getFirst().getName() + " has returned an item");
            return_line.removeFirst();
            if (checkout.size() < 1) {
                break;
            }

        }
        int j = 0;
        while (j < return_line.size()) {
            System.out.println(return_line.getFirst().getName() + " has returned an item");
            return_line.removeFirst();
        }

    }
}