package app.gimbus.shoproute;

import android.content.Context;

import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private Vector<Shelf> shelves;
    private Vector<Product> products;

    Shop(String databaseName, Context context){}

    Product[] getProducts(){
        return (Product[]) products.toArray();
    }
}
