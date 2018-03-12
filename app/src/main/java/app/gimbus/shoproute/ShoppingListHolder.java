package app.gimbus.shoproute;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.ArraySet;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tobi6 on 15.02.2018.
 */

class ShoppingListHolder {
    private ArrayList<Product> shoppingList;
    private AbstractSet<String> toSaveList;
    private boolean isSorted = false;
    private boolean toBeSaved = false;

    private static final ShoppingListHolder ourInstance = new ShoppingListHolder();

    static ShoppingListHolder getInstance() {
        return ourInstance;
    }

    private ShoppingListHolder() {
        this.shoppingList = new ArrayList<>();
    }

    void addItem(Product item){
        shoppingList.add(item);
        if(!toSaveList.contains(ShopHolder.getInstance().getShop().toString())) toSaveList.add(ShopHolder.getInstance().getShop().toString());
        toSaveList.add(item.toString());
    }

    void clearList(){
        shoppingList.clear();
        toSaveList.clear();
    }

    void sortItems(Shop shop){
        ArrayList<Product> sortedList = new ArrayList<>();
        ArrayList<Shelf> shelfList = new ArrayList<>();
        ArrayList<Shelf> visited = new ArrayList<>();
        sortHelper(shop.getStartingShelf(), sortedList, shelfList, visited);
        this.shoppingList = sortedList;
        this.isSorted = true;
    }

    private void sortHelper(Shelf shelf, ArrayList<Product> sortedList, ArrayList<Shelf> shelves, ArrayList<Shelf> visited){
        for (Product p : this.shoppingList
             ) {
            if(!sortedList.contains(p) && shelf.contains(p)){
                sortedList.add(p);
                if(!shelves.contains(shelf)) shelves.add(shelf);
            }
        }
        for (Product p : sortedList
             ) {
            if(this.shoppingList.contains(p)) this.shoppingList.remove(p);
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

    ArrayList<String> getToSaveList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(toSaveList);
        return arrayList;
    }

    void setToBeSaved(){ this.toBeSaved = true;}

    boolean getToBeSaved() {
        return toBeSaved;
    }


    void saveList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Resources.getSystem().getString(R.string.preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Date date = Calendar.getInstance().getTime();
        editor.putStringSet(date.toString(), this.toSaveList);
        editor.apply();
    }
}
