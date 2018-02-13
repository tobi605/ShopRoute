package app.gimbus.shoproute;

import java.util.ArrayList;

/**
 * Created by tobi6 on 13.02.2018.
 */

class Shelf {
    private ArrayList<Product> products;
    private ArrayList<Shelf> neighbours;
    private String name;

    public Shelf(Product[] products, String name) {
        this.name = name;
        for (Product p : products
             ) {
            this.products.add(p);
        }
    }

    public void addNeighbours(Shelf[] shelves){
        for (Shelf s : shelves
             ) {
            neighbours.add(s);
        }
    }

    public boolean contains(Product product){
        return products.contains(product);
    }
}