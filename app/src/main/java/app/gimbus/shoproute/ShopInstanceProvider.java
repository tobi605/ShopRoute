package app.gimbus.shoproute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tobi6 on 14.02.2018.
 */

class ShopInstanceProvider {
    //here will be static methods returning shops
    static Shop TestShop(){
        ArrayList<Shelf> shelves = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        return new Shop("Biedra", shelves, products);
    }

    static List<String> getAllShopNames(){
        List<String> names = new LinkedList<>();
        names.add(TestShop().toString());
        return names;
    }
}
