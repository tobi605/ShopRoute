package app.gimbus.shoproute;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by diamentowygimbus on 19.02.18.
 */

public class ChooseShopActivity extends AppCompatActivity {
    private static Shop selected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_shop);

        ListView shopsList = findViewById(R.id.shop_choice_list);
        List<Shop> shops = ShopInstanceProvider.getAllShops();
        ArrayAdapter<Shop> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.shop_browse_item , (Shop[]) shops.toArray());
        shopsList.setAdapter(adapter);
        shopsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 ChooseShopActivity.setSelected((Shop) adapterView.getItemAtPosition(i));
                 view.setSelected(true);
            }
        });

        Button button = findViewById(R.id.choose_shop_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseShopActivity.this, CreateListActivity.class);
                startActivity(intent);
            }
        });
    }

    static void setSelected(Shop shop){ selected = shop;}
    static Shop getSelected(){ return selected;}
}
