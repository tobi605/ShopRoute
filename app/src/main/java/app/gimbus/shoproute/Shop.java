package app.gimbus.shoproute;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;
import java.util.Vector;

/**
 * Created by tobi6 on 07.02.2018.
 */

class Shop {
    private Vector<ShelfNode> shelves;
    private Vector<Product> products;
    private AppDatabase database;

    Shop(String databaseName, Context context){
        this.database = Room.databaseBuilder(context, AppDatabase.class, "main").build();
        List<Shelf> shelfList = database.shelfDao().getAllShelves();
        int iter = 0;
        for (Shelf s : shelfList
             ) {
            shelves.add(new ShelfNode(s));
        }
        shelfList = null;
        List<Edge> edgeList = database.edgeDao().getAllEdges();
        for (Edge e : edgeList
             ) {
                shelves.get(e.getFromNode()).addNeighbour(shelves.get(e.getToNode()));
                shelves.get(e.getToNode()).addNeighbour(shelves.get(e.getFromNode()));
        }
        edgeList = null;
        List<Product> loadProducts = database.productDao().getAll();
        products.addAll(loadProducts);
        loadProducts = null;
    }

    Product[] getProducts(){
        return (Product[]) products.toArray();
    }
}
