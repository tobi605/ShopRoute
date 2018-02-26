package app.gimbus.shoproute;

import java.util.ArrayList;

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
        ArrayList<Product> sortedList = new ArrayList<>();
        sortHelper(shop.getStartingShelf(), sortedList);
        this.shoppingList = sortedList;
    }

    private void sortHelper(Shelf shelf, ArrayList<Product> sortedList){
        Product current = this.shoppingList.get(0);
        while (shelf.contains(current)){
            if(!sortedList.contains(current)) sortedList.add(current);
            this.shoppingList.remove(current);
            current = this.shoppingList.get(0);
        }
        if(!this.shoppingList.isEmpty()){
            for (Shelf s : shelf.getNeighbours()) {
                sortHelper(s, sortedList);
            }
        }
    }
}
