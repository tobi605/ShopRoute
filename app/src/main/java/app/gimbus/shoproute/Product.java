package app.gimbus.shoproute;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tobi6 on 02.02.2018.
 */

@Entity
public class Product {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "product_name")
    private String productName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
