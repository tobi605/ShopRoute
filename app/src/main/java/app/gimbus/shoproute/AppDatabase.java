package app.gimbus.shoproute;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by tobi6 on 02.02.2018.
 */

public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
