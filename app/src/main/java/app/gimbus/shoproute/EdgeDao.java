package app.gimbus.shoproute;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by tobi6 on 09.02.2018.
 */

@Dao
public interface EdgeDao {

    @Query("SELECT * FROM edges")
    List<Edge> getAllEdges();
}
