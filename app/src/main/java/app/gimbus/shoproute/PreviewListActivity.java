package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by tobi6 on 26.02.2018.
 */

public class PreviewListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_preview);

        ListView listView = findViewById(R.id.previewList);
        ArrayList<Product> shoppingList = ShoppingListHolder.getInstance().getList();
        ArrayAdapter<Product> adapter = new ArrayAdapter(getApplicationContext(), R.layout.shop_browse_item, shoppingList);
        listView.setAdapter(adapter);
    }
}
