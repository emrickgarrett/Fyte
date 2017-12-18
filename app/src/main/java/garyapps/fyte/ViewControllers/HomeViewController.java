package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Enums.FyteCellType;
import garyapps.fyte.R;
import garyapps.fyte.Views.Home.HomeProfileView;
import garyapps.fyte.Models.FyteTableRowModel;

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
        ArrayList<FyteTableRowModel> cells = new ArrayList<FyteTableRowModel>();
        cells.add(new FyteTableRowModel("Default Acknowledgement", "", FyteCellType.Acknowledge));
        cells.add(new FyteTableRowModel("Alert Cell", "", FyteCellType.Alert));

        FyteTableRowAdapter adapter = new FyteTableRowAdapter(context, cells);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }
}