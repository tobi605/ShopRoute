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

    Shelf(String name) {
        this.name = name;
        products = new ArrayList<>();
        neighbours = new ArrayList<>();
    }

    void addProducts(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

    void addNeighbours(Shelf... shelves) {
        this.neighbours.addAll(Arrays.asList(shelves));
    }

    ArrayList<Shelf> getNeighbours() {
        return this.neighbours;
    }

    boolean contains(Product product) {
        return products.contains(product);
    }
}