package app.gimbus.shoproute;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tobi6 on 13.02.2018.
 */

class Shelf {
    private ArrayList<Product> products;
    private ArrayList<Shelf> neighbours;
    private String name;

    public Shelf(String name) {
        this.name = name;
    }

    public void addProducts(Product[] products){
        this.products.addAll(Arrays.asList(products));
    }

    public void addNeighbours(Shelf[] shelves){
        this.neighbours.addAll(Arrays.asList(shelves));
    }

    public boolean contains(Product product){
        return products.contains(product);
    }
}