package garyapps.fyte.Views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import garyapps.fyte.R;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class HomeProfileView extends TableRow {

    private TextView fullNameTv;
    private TextView fightingStylesTv;
    private TextView dayStreakLabelTv;
    private TextView dayStreakNumberTv;
    private TextView sessionNumberTv;
    private TextView sessionLabelTv;

    public HomeProfileView(Activity context) {
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.home_profile_table_row, null);

        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindView(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindView(View v){
        fullNameTv = v.findViewById(R.id.home_profile_full_name);
        fightingStylesTv = v.findViewById(R.id.home_profile_fighting_styles);
        dayStreakLabelTv = v.findViewById(R.id.home_profile_currentDayStreakDays);
        dayStreakNumberTv = v.findViewById(R.id.home_profile_currentDayStreakNumber);
        sessionNumberTv = v.findViewById(R.id.home_profile_totalTrainingSessionsNumber);
        sessionLabelTv = v.findViewById(R.id.home_profile_totalTrainingSessionsLabel);
    }

    private void bindValues(){
        fullNameTv.setText(Shared.appUser.getFullName());
        fightingStylesTv.setText(Shared.appUser.getFightingStylesListAsString());
        dayStreakLabelTv.setText("days");
        dayStreakNumberTv.setText("10");
        sessionNumberTv.setText("216");
        sessionLabelTv.setText("sessions");
    }

}
