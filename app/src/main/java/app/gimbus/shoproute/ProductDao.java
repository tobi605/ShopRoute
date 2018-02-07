package app.gimbus.shoproute;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by tobi6 on 02.02.2018.
 */

@Dao
public interface ProductDao {
    @Query("SELECT * from products")
    List<Product> getAll();

    @Query("SELECT * FROM products WHERE product_name LIKE :name LIMIT 1")
    Product findByName(String name);
}
