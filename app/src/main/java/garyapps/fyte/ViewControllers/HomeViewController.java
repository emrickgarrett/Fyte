package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.R;
import garyapps.fyte.Views.Home.HomeProfileView;
import garyapps.fyte.Models.FyteProfileRowModel;
import garyapps.fyte.Views.Home.TrackerProfileView;

/**
 * Created by Garrett on 12/14/2017.
 */

public class HomeViewController extends ViewController {

    private LinearLayout homeTable;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public HomeViewController(Activity context){
        super(context);
        homeTable = this.view.findViewById(R.id.home_linear_layout);
        recyclerView = new RecyclerView(context);
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);


        //Do Work
        homeTable.addView(new HomeProfileView(context));
        homeTable.addView(recyclerView);

        createInfoCells();
    }


    @Override
    void inflateView(){
        this.view = context.getLayoutInflater().inflate(R.layout.home_view, null);
    }

    private void createInfoCells(){
        ArrayList<FyteRowModel> cells = new ArrayList<FyteRowModel>();
        cells.add(new FyteProfileRowModel("Default Acknowledgement", "", FyteCellType.Acknowledge));
        cells.add(new FyteProfileRowModel("Alert Cell", "", FyteCellType.Alert));

        FyteTableRowAdapter adapter = new FyteTableRowAdapter(context, cells, recyclerView);

        recyclerView.setAdapter(adapter);
        //recyclerView.setOnItemClickListener(adapter);
    }
}