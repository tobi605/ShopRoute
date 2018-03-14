package app.gimbus.shoproute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SavedListsActivity extends AppCompatActivity {
    static private List<String> shopAndProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_lists);

        SharedPreferences preferences = getSharedPreferences(String.valueOf(R.string.preferences), Context.MODE_PRIVATE);
        Map<String, ?> entries = preferences.getAll();
        ArrayList<String> dates = new ArrayList<>();
        dates.addAll(entries.keySet());
        ArrayList<Set<String>> strings = new ArrayList<>();
        strings.addAll((Collection<? extends Set<String>>) entries.values());
        ArrayList<Pair<String, Set<String>>> toPass = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++){
            toPass.add(new Pair<>(dates.get(i), strings.get(i)));
        }
        SavedListAdapter adapter = new SavedListAdapter(getApplicationContext(), toPass);
        final ListView listView = findViewById(R.id.saved_lists_list);
        listView.setAdapter(adapter);

        Button select = findViewById(R.id.choose_saved_list);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingListHolder.createListFromStrings(shopAndProducts);
                startActivity(new Intent(SavedListsActivity.this, ShowRouteActivity.class));
            }
        });
    }

    static void setShopAndProducts(List<String> list){ shopAndProducts = list;}
}
