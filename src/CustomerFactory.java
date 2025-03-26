public class CustomerFactory {

    private final RandomGenerator random = new RandomGenerator();

    public Customer createCustomer(String name, String email, String password, String phone, String address, int age) {
        random.randomIDGen();
        String userID = random.getRandomNumber();
        return new Customer(userID, name, email, password, phone, address, age);
    }
}
