package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.Models.CalendarData.FyteCalendarData;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;
import garyapps.fyte.R;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by Garrett on 12/15/2017.
 */

public class TrackerViewController extends ViewController {

    private LinearLayout trackerTable;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public TrackerViewController(Activity context){
        super(context);

        trackerTable = this.view.findViewById(R.id.tracker_linear_layout);
        recyclerView = new RecyclerView(context);
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);


        //Do Work
        trackerTable.addView(new garyapps.fyte.Views.Home.TrackerProfileView(context));
        trackerTable.addView(recyclerView);

        createTrackerCells();
    }

    private void createTrackerCells(){
        ArrayList<FyteRowModel> cells = new ArrayList<FyteRowModel>();
        cells.add(new FyteTrackerRowModel("BJJ", "Blue", -1, FyteCellType.Tracker));
        cells.add(new FyteTrackerRowModel("Wrestling", "Experienced", -1, FyteCellType.Tracker));
        cells.add(new FyteTrackerRowModel("Kickboxing", "Beginner", -1, FyteCellType.Tracker));

        FyteTableRowAdapter adapter = new FyteTableRowAdapter(context, cells, recyclerView);

        recyclerView.setAdapter(adapter);
        //recyclerView.setOnItemClickListener(adapter);

        //simulate getting tracker information for now
        FyteCalendarData trackerData = new FyteCalendarData();
        trackerData.fetchData(Shared.appUser.getId());
    }

    @Override
    void inflateView() {
        view = context.getLayoutInflater().inflate(R.layout.tracker_view, null);
    }
}
