package app.gimbus.shoproute;

import java.util.List;
import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private Vector<Shelf> shelves;
    private Vector<Product> products;

    Shop(List<Shelf> shelves, List<Product> products){
        this.shelves.addAll(shelves);
        this.products.addAll(products);
    }

    Product[] getProducts(){
        return (Product[]) products.toArray();
    }


}
