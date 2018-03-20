package app.gimbus.shoproute;

/**
 * Created by tobi6 on 13.02.2018.
 */

class ShopHolder {
    private Shop shop;

    private static final ShopHolder ourInstance = new ShopHolder();

    static ShopHolder getInstance() {
        return ourInstance;
    }

    private ShopHolder() {
    }

    void setShop(Shop shop) {
        this.shop = shop;
    }

    Shop getShop() {
        return this.shop;
    }

}