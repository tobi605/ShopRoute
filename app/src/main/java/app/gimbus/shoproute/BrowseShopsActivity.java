package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by tobi6 on 21.01.2018.
 */

public class BrowseShopsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.shop_browse);
        ListView shopBrowseList = findViewById(R.id.shop_browse_list);
        //TODO from file to array of shops
        Shop[] tempArray = {new Shop("Aldi"), new Shop("Lidl")};
        ArrayAdapter<Shop> shopArrayAdapter = new ArrayAdapter<>(this, R.layout.shop_browse_item, tempArray);
        shopBrowseList.setAdapter(shopArrayAdapter);
    }
}
