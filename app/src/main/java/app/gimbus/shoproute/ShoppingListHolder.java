package app.gimbus.shoproute;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by tobi6 on 15.02.2018.
 */

class ShoppingListHolder {
    private ArrayList<Product> shoppingList;
    private ArrayList<String> toSaveList;
    private String toSaveShop;
    private boolean isSorted = false;
    private boolean toBeSaved = false;
    private boolean comesFromSave = false;

    private static final ShoppingListHolder ourInstance = new ShoppingListHolder();

    static ShoppingListHolder getInstance() {
        return ourInstance;
    }

    private ShoppingListHolder() {
        this.shoppingList = new ArrayList<>();
        this.toSaveList = new ArrayList<>();
    }

    void addItem(Product item){
        shoppingList.add(item);
        toSaveList.add(item.toString());
    }

    void clearList(){
        shoppingList.clear();
        toSaveList.clear();
        ShoppingListHolder.getInstance().isSorted=false;
        ShoppingListHolder.getInstance().toBeSaved=false;
        ShoppingListHolder.getInstance().comesFromSave=false;
        toSaveShop = null;
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
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ConcurrentSkipListSet<String> strings = new ConcurrentSkipListSet<>();
        strings.add(this.toSaveShop);
        strings.addAll(this.toSaveList);
        Date date = Calendar.getInstance().getTime();
        editor.putStringSet(date.toString(), strings);
        editor.commit();
    }

    static void createListFromStrings(List<String> list) {
        ShoppingListHolder.getInstance().comesFromSave=true;
        Shop shop = ShopInstanceProvider.getShopWithName(list.get(0));
        ShopHolder.getInstance().setShop(shop);
        for (int i = 1; i < list.size(); i++){
            Product product = shop.getItemWithName(list.get(i));
            if(product!=null) ShoppingListHolder.getInstance().addItem(product);
        }
    }

    boolean getComesFromSave(){ return this.comesFromSave;}

    void setToSaveShop(String name){ this.toSaveShop = name;}


}
