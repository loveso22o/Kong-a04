/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution44 {
    private static final Scanner in = new Scanner(System.in);

    private String input() {
        // Ask user what input they are searching for
        System.out.println("What is the product name?");

        // Return answer
        return in.nextLine();
    }

    public Inventory readJSON() throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        // Read JSON by using BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader("data/exercise44_input.json"));

        Inventory inventory = gson.fromJson(reader, Inventory.class);

        reader.close();

        // Return inventory created
        return inventory;
    }

    private boolean output(Product search) {
        // If product is not in stock, print statement
        if (search == null) {
            System.out.println("Sorry, that product was not found in our inventory. ");
            return false;
        }
        // If product is in stock, print information
        else {
            System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d%n", search.getName(), search.getPrice(), search.getQuantity());
            return true;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Solution44 main = new Solution44();

        try
        {
            // Read JSON and store that to an inventory object
            Inventory currentInventory = main.readJSON();

            while(true)
            {
                // Search term user inputs and print result
                String search = main.input();

                Product searchedProduct = currentInventory.search(search);

                if(main.output(searchedProduct))
                {
                    break;
                }
            }
        } catch(IOException ioException)
        {
            ioException.printStackTrace();
        }

    }
}

class Inventory
{
    private List<Product> products = new ArrayList<>();

    private void product(String name, double price, int quantity)
    {
        // Sets information for each product
        this.products.add(new Product(name, price, quantity));
    }

    public Product search(String name)
    {
        // Use a loop to search all products in inventory based on name
        for(Product temp : products)
        {
            if(temp.getName().equals(name))
            {
                return temp;
            }
        }

        return null;
    }


}

class Product
{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity)
    {
        // Sets information for each product
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
