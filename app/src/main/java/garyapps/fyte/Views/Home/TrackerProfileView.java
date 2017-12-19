package garyapps.fyte.Views.Home;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import garyapps.fyte.R;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/18/17.
 */

public class TrackerProfileView extends RelativeLayout{

    private TextView sessionCounter;
    private TextView sessionLabel;
    private TextView streakCounter;
    private TextView streakLabel;
    private TextView userName;

    public TrackerProfileView(Activity context) {
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.tracker_profile_cell, null);

        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindView(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindView(View v){
        this.userName = v.findViewById(R.id.tracker_profile_full_name);
        this.sessionCounter = v.findViewById(R.id.tracker_profile_totalTrainingSessionsNumber);
        this.sessionLabel = v.findViewById(R.id.tracker_profile_totalTrainingSessionsLabel);
        this.streakCounter = v.findViewById(R.id.tracker_profile_currentDayStreakNumber);
        this.streakLabel = v.findViewById(R.id.tracker_profile_currentDayStreakDays);
    }

    private void bindValues(){
        this.userName.setText(Shared.appUser.getFullName());
        this.sessionCounter.setText(Shared.appUser.getSessionCounter() + "");
        this.sessionLabel.setText("Sessions");
        this.streakCounter.setText(Shared.appUser.getDayStreak() + "");
        this.streakLabel.setText("days");

    }

}
