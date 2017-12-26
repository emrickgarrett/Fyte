package garyapps.fyte.Views.Home;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import garyapps.fyte.R;
import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/18/17.
 */

public class HomeProfileView extends RelativeLayout{

    private TextView userName;
    private TextView record;
    private TextView date;
    private TextView weight;

    public HomeProfileView(Activity context) {
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.home_profile_cell, null);

        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindView(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindView(View v){
        this.userName = v.findViewById(R.id.home_profile_full_name);
        this.record = v.findViewById(R.id.home_profile_record);
        this.date = v.findViewById(R.id.home_profile_date);
        this.weight = v.findViewById(R.id.home_profile_weight);
    }

    private void bindValues(){
        this.userName.setText(Shared.appUser.getFullName());
        this.record.setText(""); //TODO after initial release
        this.date.setText(DateHelper.getCurrentDateFormatted());
        this.weight.setText("180 lbs");//TODO create fitness object to hold basic fitness data

    }

}
