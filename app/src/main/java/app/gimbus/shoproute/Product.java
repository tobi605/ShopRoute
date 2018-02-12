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

    @ColumnInfo(name = "NAME")
    private String name;

    public int getUid() {return uid; }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){return this.name;}
}
