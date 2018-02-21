package app.gimbus.shoproute;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by tobi6 on 15.02.2018.
 */

class ShoppingListHolder {
    private ArrayList<Product> shoppingList;

    private static final ShoppingListHolder ourInstance = new ShoppingListHolder();

    static ShoppingListHolder getInstance() {
        return ourInstance;
    }

    private ShoppingListHolder() {
    }

    void addItem(Product item){
        shoppingList.add(item);
    }

    void clearList(){ shoppingList.clear(); }

    void sortItems(Shop shop){


    }
}
