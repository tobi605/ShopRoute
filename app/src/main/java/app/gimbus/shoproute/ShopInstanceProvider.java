package app.gimbus.shoproute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tobi6 on 14.02.2018.
 */

class ShopInstanceProvider {
    //here will be static methods returning shops
    private static Shop TestShop(){
        Product p1 = new Product("Pomidor");
        Product p2 = new Product("Woda");
        Product p3 = new Product("Czekolada");
        Shelf shelf = new Shelf("Wszystko");
        shelf.addProducts(new Product[]{p1,p2,p3});
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Shelf> shelves = new ArrayList<>();
        products.add(p1); products.add(p2); products.add(p3);
        shelves.add(shelf);
        return new Shop("Biedra", shelves, products);
    }

    static List<Shop> getAllShops(){
        List<Shop> shops = new LinkedList<>();
        shops.add(TestShop());
        return shops;
    }
}
