package app.gimbus.shoproute;

import java.util.List;

/**
 * Created by tobi6 on 13.02.2018.
 */

public class ShopsHolder {
    private List<Shop> shops;

    private static final ShopsHolder ourInstance = new ShopsHolder();

    static ShopsHolder getInstance() {
        return ourInstance;
    }

    private ShopsHolder() {}

    public void addShop(Shop shop){ if(!this.shops.contains(shop)) this.shops.add(shop);}

    public void addShop(Shop[] shops){
        for (Shop s : shops
             ) {
            if(!this.shops.contains(s)) this.shops.add(s);
        }
    }

    Shop[] getAllShops(){ return (Shop[]) shops.toArray();}
}