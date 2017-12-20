package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/19/17.
 */

public class TrackerUpdateCell extends FyteCell{

    private TextView disciplineTitle;
    private TextView startDate;
    private BarChart weeklySessionTracker;

    private FyteTrackerRowModel model;

    public TrackerUpdateCell(Activity context, FyteRowModel model){
        bindViews(context.getLayoutInflater().inflate(R.layout.tracker_discipline_cell, null), ((FyteTrackerRowModel) model));
    }

    private void bindViews(View v){
        this.view = v;
        this.disciplineTitle = v.findViewById(R.id.tracker_cell_discipline_title);
        this.startDate = v.findViewById(R.id.tracker_cell_start_date);
        this.weeklySessionTracker = v.findViewById(R.id.tracker_cell_discipline_week_session_tracker);
    }

    private void bindViews(View v, FyteTrackerRowModel model) {
        this.bindViews(v);
        this.model = model;

        if(model.discipline != ""){
            disciplineTitle.setText(model.discipline);
        }

        if(model.experienceLevel != ""){
            //do work
        }
    }

    @Override
    public void onClick(final FyteTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {
        if(animating) return;
        Animation anim = slideOutRightAnimation();
        final FyteCell cell = this;
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animating = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                adapter.removeCell(cell);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(anim);
    }

    @Override
    public FyteRowModel getModel(){ return model; }
}
