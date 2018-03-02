package app.gimbus.shoproute;

import java.util.ArrayList;

/**
 * Created by tobi6 on 15.02.2018.
 */

class ShoppingListHolder {
    private ArrayList<Product> shoppingList;
    private boolean isSorted = false;

    private static final ShoppingListHolder ourInstance = new ShoppingListHolder();

    static ShoppingListHolder getInstance() {
        return ourInstance;
    }

    private ShoppingListHolder() {
        this.shoppingList = new ArrayList<>();
    }

    void addItem(Product item){
        shoppingList.add(item);
    }

    void clearList(){ shoppingList.clear(); }

    void sortItems(Shop shop){
        ArrayList<Product> sortedList = new ArrayList<>();
        ArrayList<Shelf> shelfList = new ArrayList<>();
        ArrayList<Shelf> visited = new ArrayList<>();
        sortHelper(shop.getStartingShelf(), sortedList, shelfList, visited);
        this.shoppingList = sortedList;
        this.isSorted = true;
    }

    private void sortHelper(Shelf shelf, ArrayList<Product> sortedList, ArrayList<Shelf> shelves, ArrayList<Shelf> visited){
        Product current = this.shoppingList.get(0);
        while (current!=null){
            if(!sortedList.contains(current)){
                sortedList.add(current);
                if(!shelves.contains(shelf))shelves.add(shelf);
            }
            this.shoppingList.remove(current);
            if(!shoppingList.isEmpty()) current = this.shoppingList.get(0);
            else current=null;
        }
        visited.add(shelf);
        if(!this.shoppingList.isEmpty()){
            for (Shelf s : shelf.getNeighbours()) {
                if(!visited.contains(s)) sortHelper(s, sortedList, shelves, visited);
            }
        }
    }

    boolean isSorted(){ return isSorted;}

    ArrayList<Product> getList(){ return this.shoppingList;}
}
