package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/19/17.
 */

public class TrackerUpdateCell extends FyteCell{

    private FyteTrackerRowModel model;

    public TrackerUpdateCell(Activity context, FyteRowModel model){
        bindViews(context.getLayoutInflater().inflate(R.layout.home_info_cell, null), ((FyteTrackerRowModel) model));
    }

    private void bindViews(View v){
        this.view = v;
    }

    private void bindViews(View v, FyteTrackerRowModel model) {
        this.bindViews(v);
        this.model = model;
    }

    @Override
    public void onClick(final FyteTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {
        Animation anim = slideOutRightAnimation();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                adapter.removeCell(position);

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
