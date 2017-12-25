package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import garyapps.fyte.R;
import garyapps.fyte.Views.Home.FitnessProfileView;

/**
 * Created by Garrett on 12/15/2017.
 */

public class FitnessViewController extends ViewController {

    private LinearLayout fitnessTable;

    public FitnessViewController(Activity context){
        super(context);
        this.fitnessTable = this.view.findViewById(R.id.fitness_linear_layout);

        this.fitnessTable.addView(new FitnessProfileView(context));
    }

    @Override
    void inflateView() {
        view = context.getLayoutInflater().inflate(R.layout.fitness_view, null);
    }
}
