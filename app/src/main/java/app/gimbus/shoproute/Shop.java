package app.gimbus.shoproute;

import java.util.List;
import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private String name;
    private Vector<Shelf> shelves;
    private Vector<Product> products;

    Shop(String name, List<Shelf> shelves, List<Product> products){
        this.name = name;
        this.shelves.addAll(shelves);
        this.products.addAll(products);
    }

    Product[] getProducts(){
        return (Product[]) products.toArray();
    }

    public String toString(){ return this.name;}
}