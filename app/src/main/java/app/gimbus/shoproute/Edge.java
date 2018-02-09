package app.gimbus.shoproute;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tobi6 on 09.02.2018.
 */
@Entity
public class Edge {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "from_node")
    private int fromNode;

    @ColumnInfo(name = "to_node")
    private int toNode;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFromNode() {
        return fromNode;
    }

    public void setFromNode(int fromNode) {
        this.fromNode = fromNode;
    }

    public int getToNode() {
        return toNode;
    }

    public void setToNode(int toNode) {
        this.toNode = toNode;
    }
}
