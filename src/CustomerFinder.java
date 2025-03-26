
import java.util.List;

public class CustomerFinder {

    public Customer findById(String id, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getUserID().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public boolean emailExists(String email, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
