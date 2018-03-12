package app.gimbus.shoproute;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by tobi6 on 12.03.2018.
 */

class SavedListAdapter extends ArrayAdapter {

    SavedListAdapter(Context context, List<String> list){
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        //todo
        return null;
    }
}
