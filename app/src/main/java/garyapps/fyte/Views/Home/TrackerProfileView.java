package garyapps.fyte.Views.Home;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/18/17.
 */

public class TrackerProfileView extends RelativeLayout{

    public TrackerProfileView(Activity context) {
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.home_profile_cell, null);

        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindView(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindView(View v){
    }

    private void bindValues(){
    }

}
