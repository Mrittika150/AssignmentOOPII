import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputReader {

    private final Scanner scanner = new Scanner(System.in);

    public Customer readCustomer(CustomerFactory factory) {
        System.out.printf("\n\n\n%60s ++++++++++++++ Welcome to the Customer Registration Portal ++++++++++++++", "");

        System.out.print("\nEnter your name :\t");
        String name = scanner.nextLine();

        System.out.print("Enter your email address :\t");
        String email = scanner.nextLine();

        while (User.isUniqueData(email)) {
            System.out.println("ERROR!!! User with the same email already exists. Try a different one:");
            System.out.print("Enter your email address :\t");
            email = scanner.nextLine();
        }

        System.out.print("Enter your Password :\t");
        String password = scanner.nextLine();

        System.out.print("Enter your Phone number :\t");
        String phone = scanner.nextLine();

        System.out.print("Enter your address :\t");
        String address = scanner.nextLine();

        System.out.print("Enter your age :\t");
        int age = scanner.nextInt();
        scanner.nextLine();

        return factory.createCustomer(name, email, password, phone, address, age);
    }

    public List<String> readCustomerInfoUpdate() {
        List<String> details = new ArrayList<>();

        System.out.print("\nEnter the new name of the Passenger:\t");
        details.add(scanner.nextLine());

        System.out.print("Enter the new email address:\t");
        details.add(scanner.nextLine());

        System.out.print("Enter the new Phone number:\t");
        details.add(scanner.nextLine());

        System.out.print("Enter the new address:\t");
        details.add(scanner.nextLine());

        System.out.print("Enter the new age:\t");
        details.add(String.valueOf(scanner.nextInt()));
        scanner.nextLine();

        return details;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public char readChar(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().charAt(0);
    }
}
