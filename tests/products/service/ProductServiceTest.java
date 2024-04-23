package products.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.model.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {


    private ProductService productService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void GivenAvailableIdCheckProductExists(){


        //preconditie

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1, "Produs test", 200, 10);
        Product product1 = new Product(2, "Laptop Dell XPS 13", 1500, 20);
        Product product2 = new Product(3, "Smartphone Samsung Galaxy S21", 1000, 15);
        Product product3 = new Product(4, "Televizor LG OLED55C1", 2500, 8);
        Product product4 = new Product(5, "Tablet Apple iPad Air", 800, 25);
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        productService=new ProductService(products);


        //actiune


        Product product5=productService.findProductById(5);
        Product product6=productService.findProductById(1);
        Product product7=productService.findProductById(9);


        //rezultat
        assertEquals("Tablet Apple iPad Air",product5.getName());
        assertEquals(5, product5.getId());
        assertEquals(800, product5.getPrice());
        assertEquals(25, product5.getStock());

        assertEquals("Produs test",product6.getName());
        assertEquals(1, product6.getId());
        assertEquals(200, product6.getPrice());
        assertEquals(10, product6.getStock());

        assertNull(product7);
    }

    @Test

    public void GiveAvailableNameCheckProductExists(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1, "Produs test", 200, 10);
        Product product1 = new Product(2, "Laptop Dell XPS 13", 1500, 20);
        Product product2 = new Product(3, "Smartphone Samsung Galaxy S21", 1000, 15);
        Product product3 = new Product(4, "Televizor LG OLED55C1", 2500, 8);
        Product product4 = new Product(5, "Tablet Apple iPad Air", 800, 25);
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        productService=new ProductService(products);

        Product product5=productService.findByName("Tablet Apple iPad Air");
        Product product6=productService.findByName("Produs test");

        assertEquals("Tablet Apple iPad Air",product5.getName());
        assertEquals(5, product5.getId());
        assertEquals(800, product5.getPrice());
        assertEquals(25, product5.getStock());

        assertEquals("Produs test",product6.getName());
        assertEquals(1, product6.getId());
        assertEquals(200, product6.getPrice());
        assertEquals(10, product6.getStock());
    }


    @Test
    public void GivenAvailableProductCheckIfProductGetsAdded(){

        ArrayList<Product> products = new ArrayList<>();
        Product product0 = new Product(1, "Produs test", 200, 10);
        Product product = new Product(9, "Produs testtt", 200, 10);
        Product product1 = new Product(2, "Laptop Dell XPS 13", 1500, 20);
        Product product2 = new Product(3, "Smartphone Samsung Galaxy S21", 1000, 15);
        Product product3 = new Product(4, "Televizor LG OLED55C1", 2500, 8);
        Product product4 = new Product(5, "Tablet Apple iPad Air", 800, 25);
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        productService=new ProductService(products);

        productService.adaugareProdus(product0);

        assertEquals("Produs test",product0.getName());
        assertEquals(1, product0.getId());


    }


    @Test

    public void GivenAvailableProductCheckIfProductGetsRemoved(){
        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1, "Produs test", 200, 10);
        Product product1 = new Product(2, "Laptop Dell XPS 13", 1500, 20);
        Product product2 = new Product(3, "Smartphone Samsung Galaxy S21", 1000, 15);
        Product product3 = new Product(4, "Televizor LG OLED55C1", 2500, 8);
        Product product4 = new Product(5, "Tablet Apple iPad Air", 800, 25);
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        productService=new ProductService(products);


        productService.stergereProdus(product);


        assertEquals(null,productService.findProductById(1));


    }

}