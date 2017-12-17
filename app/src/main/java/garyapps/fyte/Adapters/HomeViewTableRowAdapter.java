package garyapps.fyte.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import garyapps.fyte.Models.Cells.Home.AcknowledgementCell;
import garyapps.fyte.Models.Cells.Home.HomeInfoCell;
import garyapps.fyte.Models.HomeTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */


public class HomeViewTableRowAdapter extends ArrayAdapter<HomeTableRowModel> implements AdapterView.OnItemClickListener {
    private final Context context;
    private final ArrayList<HomeTableRowModel> data;
    private final ArrayList<HomeInfoCell> cells = new ArrayList<HomeInfoCell>();

    public HomeViewTableRowAdapter(Activity context, ArrayList<HomeTableRowModel> data) {
        super(context, -1, data);
        this.context = context;
        this.data = data;
        for(int i = 0; i < data.size(); i++){
            cells.add(createCell(context.getLayoutInflater().inflate(R.layout.home_info_cell, null), data.get(i)));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return cells.get(position).getView();
    }

    private HomeInfoCell createCell(View rowView, HomeTableRowModel model){
        switch(model.type){
            case Acknowledge:
                return new AcknowledgementCell(rowView, model);

        }
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cells.get(position).onClick(this, parent, view, position, id);
    }

    public void removeCell(int index){
        cells.remove(index);
        data.remove(index);
        this.notifyDataSetChanged();
    }
}