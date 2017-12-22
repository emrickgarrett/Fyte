package garyapps.fyte.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Models.Cells.AcknowledgementCell;
import garyapps.fyte.Models.Cells.AlertCell;
import garyapps.fyte.Models.Cells.DisciplineCell;
import garyapps.fyte.Models.Cells.FyteCell;
import garyapps.fyte.Models.Cells.FyteInfoCell;
import garyapps.fyte.Models.Cells.TrackerUpdateCell;
import garyapps.fyte.Models.FyteRowModel;

/**
 * Created by garrettemrick on 12/17/17.
 */


public class FyteTableRowAdapter extends ArrayAdapter<FyteRowModel> implements AdapterView.OnItemClickListener {
    private final Activity context;
    private final ArrayList<FyteRowModel> data;
    private final ArrayList<FyteCell> cells = new ArrayList<FyteCell>();
    private final ListView listView;

    public FyteTableRowAdapter(Activity context, ArrayList<FyteRowModel> data, ListView listView) {
        super(context, -1, data);
        this.listView = listView;
        this.context = context;
        this.data = data;
        for(int i = 0; i < data.size(); i++){
            cells.add(createCell(context, data.get(i)));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return cells.get(position).getView();
    }

    private FyteCell createCell(Activity context, FyteRowModel model){
        switch(model.type){
            case Acknowledge:
                return new AcknowledgementCell(this, model);
            case Alert:
                return new AlertCell(this, model);
            case Discipline:
                return new DisciplineCell(this, model);
            case Tracker:
                return new TrackerUpdateCell(this, model);
            case Default:
                return new FyteInfoCell(this, model);

        }
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cells.get(position).onClick(this, parent, view, position, id);
    }

    public void removeCell(FyteCell cell){
        this.remove(cell.getModel());
        this.cells.remove(cell);
        this.notifyDataSetChanged();
    }

    public LayoutInflater getLayoutInflater(){
        return context.getLayoutInflater();
    }

    public void refreshLayout(){
        this.notifyDataSetInvalidated();
        this.listView.invalidateViews();
    }
}