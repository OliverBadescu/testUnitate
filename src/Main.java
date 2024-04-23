import products.model.Product;
import products.service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        Product product = new Product(1,"test", 200, 10);
        Product product2 = new Product(1,"Samsung Galaxy S20",999.99,50);
        productService.adaugareProdus(product);
        productService.stergereProdus(product2);
        productService.afisare();
    }
}