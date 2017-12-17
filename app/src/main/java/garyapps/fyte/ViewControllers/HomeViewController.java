package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Adapters.HomeViewTableRowAdapter;
import garyapps.fyte.Enums.HomeCellType;
import garyapps.fyte.Models.Cells.Home.AcknowledgementCell;
import garyapps.fyte.Models.Cells.Home.HomeInfoCell;
import garyapps.fyte.R;
import garyapps.fyte.Views.Home.HomeProfileView;
import garyapps.fyte.Models.HomeTableRowModel;

/**
 * Created by Garrett on 12/14/2017.
 */

public class HomeViewController extends ViewController {

    private LinearLayout homeTable;
    private ListView listView;

    public HomeViewController(Activity context){
        super(context);
        homeTable = this.view.findViewById(R.id.home_linear_layout);
        listView = new ListView(context);

        //Do Work
        homeTable.addView(new HomeProfileView(context));
        homeTable.addView(listView);

        createInfoCells();
    }


    @Override
    void inflateView(){
        this.view = context.getLayoutInflater().inflate(R.layout.home_view, null);
    }

    private void createInfoCells(){
        ArrayList<HomeTableRowModel> cells = new ArrayList<HomeTableRowModel>();
        cells.add(new HomeTableRowModel("Default Acknowledgement", "Default Desc", HomeCellType.Acknowledge));

        HomeViewTableRowAdapter adapter = new HomeViewTableRowAdapter(context, cells);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }
}