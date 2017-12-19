package garyapps.fyte.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import garyapps.fyte.Models.Cells.AcknowledgementCell;
import garyapps.fyte.Models.Cells.AlertCell;
import garyapps.fyte.Models.Cells.DisciplineCell;
import garyapps.fyte.Models.Cells.FyteInfoCell;
import garyapps.fyte.Models.FyteTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */


public class FyteTableRowAdapter extends ArrayAdapter<FyteTableRowModel> implements AdapterView.OnItemClickListener {
    private final Context context;
    private final ArrayList<FyteTableRowModel> data;
    private final ArrayList<FyteInfoCell> cells = new ArrayList<FyteInfoCell>();

    public FyteTableRowAdapter(Activity context, ArrayList<FyteTableRowModel> data) {
        super(context, -1, data);
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

    private FyteInfoCell createCell(Activity context, FyteTableRowModel model){
        switch(model.type){
            case Acknowledge:
                return new AcknowledgementCell(context, model);
            case Alert:
                return new AlertCell(context, model);
            case Discipline:
                return new DisciplineCell(context, model);
            case Default:
                return new FyteInfoCell(context, model);

        }
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cells.get(position).onClick(this, parent, view, position, id);
    }

    public void removeCell(int index){
        this.remove(cells.get(index).getModel());
        this.cells.remove(index);
        this.notifyDataSetChanged();
    }
}