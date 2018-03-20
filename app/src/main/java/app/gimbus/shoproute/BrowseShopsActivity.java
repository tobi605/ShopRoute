package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by tobi6 on 21.01.2018.
 */

public class BrowseShopsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedinstance) {
        super.onCreate(savedinstance);
        setContentView(R.layout.shop_browse);
        ListView shopBrowseList = findViewById(R.id.shop_browse_list);
        Shop shop = ShopHolder.getInstance().getShop();
        ArrayAdapter<Shop> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.shop_browse_item, ShopInstanceProvider.getAllShops());
        shopBrowseList.setAdapter(adapter);
    }
}
