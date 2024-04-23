package products.service;

import products.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    private ArrayList<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();

        this.loadData();
    }

    public ProductService(ArrayList<Product> products) {
        this.products =products;
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\products\\data\\products.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Product product = new Product(line);

                this.products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisare(){
        for(int i=0; i<this.products.size(); i++){
            System.out.println(products.get(i).descriere());
        }
    }
    public Product findProductById(int id){
        for (int i =0; i < products.size();i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findProductById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Product findByName(String name){
        for(int i =0; i < products.size();i++){
            if(products.get(i).getName().equals(name)){
                return products.get(i);
            }
        }
        return null;
    }

    public boolean stergereProdus(Product product){
        for(int i =0; i < products.size();i++){
            if(products.get(i).getId() == product.getId()){
                products.remove(products.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean adaugareProdus(Product product){
        for(int i =0 ; i < products.size(); i++){
            if(products.get(i).getName().equals(product.getName())){
                return false;
            }
        }
        this.products.add(product);
        return true;
    }

}
