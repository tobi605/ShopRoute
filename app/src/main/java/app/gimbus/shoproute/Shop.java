package app.gimbus.shoproute;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobi6 on 07.02.2018.
 */

public class Shop {
    ArrayList<ShelfNode> shelves;
    ArrayList<Product> products;
    AppDatabase database;

    public Shop(String databaseName, Context context){
        this.database = Room.databaseBuilder(context, AppDatabase.class, "main").build();
        List<Shelf> shelfList = database.shelfDao().getAllShelves();
        int iter = 0;
        for (Shelf s : shelfList
             ) {
            shelves.add(new ShelfNode(s));
        }
        List<Edge> edgeList = database.edgeDao().getAllEdges();
        for (Edge e : edgeList
             ) {

        }
    }



}
