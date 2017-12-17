package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import garyapps.fyte.R;
import garyapps.fyte.Views.HomeProfileView;

/**
 * Created by Garrett on 12/14/2017.
 */

public class HomeViewController extends ViewController {

    private LinearLayout homeTable;

    public HomeViewController(Activity context){
        super(context);
        homeTable = this.view.findViewById(R.id.home_table);

        //Do Work
        homeTable.addView(new HomeProfileView(context));
    }


    @Override
    void inflateView(){
        this.view = context.getLayoutInflater().inflate(R.layout.home_view, null);
    }


}
