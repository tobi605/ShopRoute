package app.gimbus.shoproute;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tobi6 on 14.02.2018.
 */

class ShopInstanceProvider {
    //here will be static methods returning shops
    @NonNull
    private static Shop TestShop(){
        Product p1 = new Product("Pomidor");
        Product p2 = new Product("Woda");
        Product p3 = new Product("Czekolada");
        Shelf shelf = new Shelf("Wszystko");
        shelf.addProducts(p1,p2,p3);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Shelf> shelves = new ArrayList<>();
        products.add(p1); products.add(p2); products.add(p3);
        shelves.add(shelf);
        return new Shop("Biedra", shelves, products);
    }

    @NonNull
    private static Shop TestShop2(){
        String name = "Stonka";
        Product[] products = new Product[]{new Product("Pomidor"),
                new Product("Kapusta"),
                new Product("Jablko"),
                new Product("Arbuz"),
                new Product("Chleb"),
                new Product("Rogalik"),
                new Product("Szynka"),
                new Product("Salami"),
                new Product("Mleko"),
                new Product("Ser"),
                new Product("Czekolada"),
                new Product("Zelki"),
                new Product("Piwo"),
                new Product("Whisky")};
        Shelf[] shelves = new Shelf[]{new Shelf("Warzywa"),
                new Shelf("Owoce"),
                new Shelf("Pieczywo"),
                new Shelf("Wedliny"),
                new Shelf("Nabial"),
                new Shelf("Slodycze"),
                new Shelf("Alkohol")};
        shelves[0].addProducts(products[0], products[1]);
        shelves[1].addProducts(products[2], products[3]);
        shelves[2].addProducts(products[4], products[5]);
        shelves[3].addProducts(products[6], products[7]);
        shelves[4].addProducts(products[8], products[9]);
        shelves[5].addProducts(products[10], products[11]);
        shelves[6].addProducts(products[12], products[13]);
        shelves[0].addNeighbours(shelves[1], shelves[4]);
        shelves[1].addNeighbours(shelves[0], shelves[4], shelves[5], shelves[2]);
        shelves[2].addNeighbours(shelves[1], shelves[4], shelves[5], shelves[6], shelves[3]);
        shelves[3].addNeighbours(shelves[2], shelves[5], shelves[6]);
        shelves[4].addNeighbours(shelves[0], shelves[1], shelves[2], shelves[5]);
        shelves[5].addNeighbours(shelves[4], shelves[1], shelves[2], shelves[3], shelves[6]);
        shelves[6].addNeighbours(shelves[5], shelves[2], shelves[3]);
        ArrayList<Product> productArrayList = new ArrayList<>();
        Collections.addAll(productArrayList, products);
        ArrayList<Shelf> shelfArrayList = new ArrayList<>();
        Collections.addAll(shelfArrayList, shelves);
        return new Shop(name, shelfArrayList,productArrayList);
    }

    static List<Shop> getAllShops(){
        List<Shop> shops = new LinkedList<>();
        shops.add(TestShop());
        shops.add(TestShop2());
        return shops;
    }
}
