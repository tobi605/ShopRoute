package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by tobi6 on 21.01.2018.
 */

public class CreateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.list_creator);

        ListView productList = findViewById(R.id.list_creator_list);
        Product[] products = ShopHolder.getInstance().getShop().getProducts();
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(),products);
        productList.setAdapter(adapter);
    }
}
