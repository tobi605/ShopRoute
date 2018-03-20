package app.gimbus.shoproute;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavedListsActivity extends AppCompatActivity {
    static private List<String> shopAndProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_lists);

        String[] filenames = fileList();
        ArrayList<ArrayList<String>> toPass = new ArrayList<>();
        for (String s : filenames) {
            ArrayList<String> toAdd = new ArrayList<>();
            toAdd.add(s);
            try {
                FileInputStream input = openFileInput(s);
                toAdd.addAll(Arrays.asList(readFromFile(input)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            toPass.add(toAdd);
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

    private String[] readFromFile(FileInputStream stream){
        String line;
        String[] results = new String[0];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            line = reader.readLine();
            results = line.split("\\s+");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
