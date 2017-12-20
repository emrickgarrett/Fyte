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
import garyapps.fyte.Models.Cells.FyteCell;
import garyapps.fyte.Models.Cells.FyteInfoCell;
import garyapps.fyte.Models.Cells.TrackerUpdateCell;
import garyapps.fyte.Models.FyteProfileRowModel;
import garyapps.fyte.Models.FyteRowModel;

import static garyapps.fyte.Enums.FyteCellType.Acknowledge;
import static garyapps.fyte.Enums.FyteCellType.Alert;
import static garyapps.fyte.Enums.FyteCellType.Default;
import static garyapps.fyte.Enums.FyteCellType.Discipline;

/**
 * Created by garrettemrick on 12/17/17.
 */


public class FyteTableRowAdapter extends ArrayAdapter<FyteRowModel> implements AdapterView.OnItemClickListener {
    private final Context context;
    private final ArrayList<FyteRowModel> data;
    private final ArrayList<FyteCell> cells = new ArrayList<FyteCell>();

    public FyteTableRowAdapter(Activity context, ArrayList<FyteRowModel> data) {
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

    private FyteCell createCell(Activity context, FyteRowModel model){
        switch(model.type){
            case Acknowledge:
                return new AcknowledgementCell(context, model);
            case Alert:
                return new AlertCell(context, model);
            case Discipline:
                return new DisciplineCell(context, model);
            case Tracker:
                return new TrackerUpdateCell(context, model);
            case Default:
                return new FyteInfoCell(context, model);

        }
        return null;
    }

    //TODO, currently there is a bug where if you click another cell before one disappears, you get crash
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