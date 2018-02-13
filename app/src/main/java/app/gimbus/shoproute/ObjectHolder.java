package app.gimbus.shoproute;

import android.app.Application;

import java.util.List;

/**
 * Created by tobi6 on 13.02.2018.
 */

public class ObjectHolder extends Application {
    private static List<Shop> shops;

    public static void addShop(Shop shop){ shops.add(shop);}

    public static Shop[] getAllShops(){ return (Shop[]) shops.toArray();}
}
