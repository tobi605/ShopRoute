package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by tobi6 on 19.02.2018.
 */

public class ShowRouteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.route_show);

        TextView currentItemName = findViewById(R.id.current_item_name);
        TextView currentItemPlace  = findViewById(R.id.current_item_place);
        ListView otherItems = findViewById(R.id.other_items);
        Button postponeButton = findViewById(R.id.postpone_item);
        Button gotItButton = findViewById(R.id.got_item);
    }
}
