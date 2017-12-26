package garyapps.fyte.Views.Home;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import garyapps.fyte.R;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class TrackerProfileView extends RelativeLayout {

    private TextView fullNameTv;
    private TextView fightingStylesTv;
    private TextView dayStreakLabelTv;
    private TextView dayStreakNumberTv;
    private TextView sessionNumberTv;
    private TextView sessionLabelTv;

    public TrackerProfileView(Activity context) {
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.tracker_profile_cell, null);

        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindView(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindView(View v){
        fullNameTv = v.findViewById(R.id.tracker_profile_full_name);
        fightingStylesTv = v.findViewById(R.id.tracker_profile_fighting_styles);
        dayStreakLabelTv = v.findViewById(R.id.tracker_profile_currentDayStreakDays);
        dayStreakNumberTv = v.findViewById(R.id.tracker_profile_currentDayStreakNumber);
        sessionNumberTv = v.findViewById(R.id.tracker_profile_totalTrainingSessionsNumber);
        sessionLabelTv = v.findViewById(R.id.tracker_profile_totalTrainingSessionsLabel);
    }

    private void bindValues(){
        fullNameTv.setText(Shared.appUser.getFullName());
        fightingStylesTv.setText(Shared.appUser.getFightingStylesListAsString());
        dayStreakLabelTv.setText("days");
        dayStreakNumberTv.setText(Shared.appUser.getDayStreak() + "");
        sessionNumberTv.setText(Shared.appUser.getSessionCounter() + "");
        sessionLabelTv.setText("sessions");
    }

}
