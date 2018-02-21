package app.gimbus.shoproute;

import java.util.List;
import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private String name;
    private Vector<Shelf> shelves;
    private Shelf startingShelf;
    private Vector<Product> products;

    Shop(String name, List<Shelf> shelves, List<Product> products){
        this.name = name;
        this.shelves.addAll(shelves);
        this.startingShelf = shelves.get(0);
        this.products.addAll(products);
    }

    Product[] getProducts(){
        return (Product[]) products.toArray();
    }

    Shelf getStartingShelf(){ return this.startingShelf; }

    int countDistance(Product product){
        int distance = 0;
        if(!startingShelf.contains(product)){
            boolean found = false;
            //TODO
        }
        return distance;
    }

    public String toString(){ return this.name;}
}