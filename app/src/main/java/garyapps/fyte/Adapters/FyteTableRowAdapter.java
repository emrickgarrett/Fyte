package garyapps.fyte.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.OnClick;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.Models.Cells.AcknowledgementCell;
import garyapps.fyte.Models.Cells.AlertCell;
import garyapps.fyte.Models.Cells.DisciplineCell;
import garyapps.fyte.Models.Cells.FyteCell;
import garyapps.fyte.Models.Cells.FyteInfoCell;
import garyapps.fyte.Models.Cells.TrackerUpdateCell;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;

/**
 * Created by garrettemrick on 12/17/17.
 */


public class FyteTableRowAdapter extends RecyclerView.Adapter<FyteTableRowAdapter.ViewHolder> implements View.OnClickListener {
    private final Activity context;
    private final ArrayList<FyteRowModel> data;
    private final ArrayList<FyteCell> cells = new ArrayList<FyteCell>();
    private final RecyclerView recyclerView;

    public FyteTableRowAdapter(Activity context, ArrayList<FyteRowModel> data, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.data = data;
    }

    private FyteCell createCell(Activity context, int value){
        if(value == FyteCellType.Acknowledge.getValue()) {
            return new AcknowledgementCell(this);
        }else if(value == FyteCellType.Alert.getValue()) {
            return new AlertCell(this);
        }else if(value == FyteCellType.Discipline.getValue()) {
            return new DisciplineCell(this);
        }else if(value == FyteCellType.Tracker.getValue()) {
            return new TrackerUpdateCell(this);
        }else {
            return new FyteInfoCell(this);
        }
    }

    @Override
    public void onClick(View v) {
        int itemPosition = this.recyclerView.getChildLayoutPosition(v);
        cells.get(itemPosition).onClick(this, v, itemPosition);
    }

    @Override
    public int getItemViewType(int position){
        return data.get(position).type.getValue();
    }

    @Override
    public FyteTableRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        FyteCell cell = createCell(context, viewType);
        cells.add(cell);

        ViewHolder vh = new ViewHolder(cell);
        vh.cell.getView().setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(FyteTableRowAdapter.ViewHolder holder, int position) {
        holder.getCell().bindViewModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void removeCell(FyteCell cell){
        this.data.remove(cell.getModel());
        this.cells.remove(cell);
        this.notifyDataSetChanged();
    }

    public LayoutInflater getLayoutInflater(){
        return context.getLayoutInflater();
    }

    public void refreshLayout(){
        //TODO
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private FyteCell cell;
        public ViewHolder(FyteCell cell) {
            super(cell.getView());
            this.cell = cell;
        }

        public FyteCell getCell(){
            return cell;
        }
    }


}