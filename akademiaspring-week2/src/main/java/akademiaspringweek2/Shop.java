package akademiaspringweek2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class Shop {

    @Value("${vat}")
    private double vat;

    @Value("${discount}")
    private double discount;

    private final Random random = new Random();
    private List<Product> products = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        generateProducts();
        printSummaryPrice();
    }

    public void generateProducts() {

        addProduct(new Product("Milk", generateRandomPrice()));
        addProduct(new Product("Bread", generateRandomPrice()));
        addProduct(new Product("Juice", generateRandomPrice()));
        addProduct(new Product("Fish", generateRandomPrice()));
        addProduct(new Product("Ham", generateRandomPrice()));


    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int generateRandomPrice() {

        return random.nextInt(250)+50;

    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    abstract protected void printSummaryPrice();

    public double getBasicSummaryPrice() {

        int sum = 0;

        for (Product product : products) {

            sum += product.getPrice();

        }

        return sum;

    }

    public double getPlusSummaryPrice() {

        int sum = 0;

        for (Product product : products) {

            sum += product.getPrice();

        }

        return (double) sum * (1.0 - vat);

    }

    public double getProSummaryPrice() {

        int sum = 0;

        for (Product product : products) {

            sum += product.getPrice();

        }

        return (double) sum * (1.0 - vat) * (1.0 - discount);

    }

}
