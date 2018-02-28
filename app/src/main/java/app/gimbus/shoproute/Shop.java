package app.gimbus.shoproute;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private String name;
    private LinkedList<Shelf> shelves;
    private Shelf startingShelf;
    private LinkedList<Product> products;

    Shop(String name, List<Shelf> shelves, List<Product> products){
        this.name = name;
        this.products = new LinkedList<>();
        this.shelves = new LinkedList<>();
        this.products.addAll(products);
        this.shelves.addAll(shelves);
        this.startingShelf = shelves.get(0);
    }

    LinkedList<Product> getProducts(){
        return this.products;
    }

    Shelf getStartingShelf(){ return this.startingShelf; }

    public String toString(){ return this.name;}
}