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

public class store {
    static LinkedList<Customer> checkout = new LinkedList<Customer>();
    static LinkedList<Customer> return_line = new LinkedList<Customer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file :");
        String file = sc.next();
        String st;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                String str[] = st.toString().split(" ");

                checkout.add(new Customer(str[0], Boolean.parseBoolean(str[1])));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {// take from checkout line and processing ...
            for (int i = 0; i < 2; i++) {// processing two of checkout line at same time...
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

            // processing of return_line ....
            System.out.println(return_line.getFirst().getName() + " has returned an item");
            return_line.removeFirst();
            if (checkout.size() < 1) {
                break;
            }

        }
        int j = 0;
        while (j < return_line.size()) {// processing of any remaining returns ...
            System.out.println(return_line.getFirst().getName() + " has returned an item");
            return_line.removeFirst();
        }

    }
}