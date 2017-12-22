package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.Models.CalendarData.FyteCalendarData;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;
import garyapps.fyte.R;
import garyapps.fyte.Utilities.Shared;
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
        ArrayList<FyteRowModel> cells = new ArrayList<FyteRowModel>();
        cells.add(new FyteTrackerRowModel("BJJ", "Blue", -1, FyteCellType.Tracker));
        cells.add(new FyteTrackerRowModel("Wrestling", "Experienced", -1, FyteCellType.Tracker));
        cells.add(new FyteTrackerRowModel("Kickboxing", "Beginner", -1, FyteCellType.Tracker));

        FyteTableRowAdapter adapter = new FyteTableRowAdapter(context, cells, listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);

        //simulate getting tracker information for now
        FyteCalendarData trackerData = new FyteCalendarData();
        trackerData.fetchData(Shared.appUser.getId());
    }

    @Override
    void inflateView() {
        view = context.getLayoutInflater().inflate(R.layout.tracker_view, null);
    }
}
