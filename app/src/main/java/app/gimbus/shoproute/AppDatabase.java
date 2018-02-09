package app.gimbus.shoproute;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by tobi6 on 02.02.2018.
 */
@Database(entities = {Product.class, Shelf.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
    public abstract ShelfDao shelfDao();
    public abstract EdgeDao edgeDao();
}
