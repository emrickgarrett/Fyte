package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.Models.FyteTableRowModel;
import garyapps.fyte.R;
import garyapps.fyte.Views.Home.TrackerProfileView;

/**
 * Created by Garrett on 12/15/2017.
 */

public class TrackerViewController extends ViewController {

    private LinearLayout trackerTable;
    private ListView listView;

    public TrackerViewController(Activity context){
        super(context);

        trackerTable = this.view.findViewById(R.id.tracker_linear_layout);
        listView = new ListView(context);

        //Do Work
        trackerTable.addView(new TrackerProfileView(context));
        trackerTable.addView(listView);

        createTrackerCells();
    }

    private void createTrackerCells(){
        ArrayList<FyteTableRowModel> cells = new ArrayList<FyteTableRowModel>();
        cells.add(new FyteTableRowModel("BJJ", "", FyteCellType.Discipline));
        cells.add(new FyteTableRowModel("Wrestling", "", FyteCellType.Discipline));

        FyteTableRowAdapter adapter = new FyteTableRowAdapter(context, cells);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }

    @Override
    void inflateView() {
        view = context.getLayoutInflater().inflate(R.layout.tracker_view, null);
    }
}
