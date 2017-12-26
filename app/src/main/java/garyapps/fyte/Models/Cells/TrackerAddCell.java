package garyapps.fyte.Models.Cells;

import android.view.View;
import android.view.animation.Animation;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/25/17.
 */

public class TrackerAddCell extends FyteCell {
    private FyteTableRowAdapter adapter;
    private FyteRowModel model;

    public TrackerAddCell(FyteTableRowAdapter adapter){
        bindViews(adapter.getLayoutInflater().inflate(R.layout.tracker_discipline_cell, null));
    }

    private void bindViews(View v){
        this.view = v;
    }

    public void bindViewModel(FyteRowModel viewModel){
        this.model = viewModel;
    }

    public FyteRowModel getModel(){ return this.model; }

    @Override
    public void onClick(final FyteTableRowAdapter adapter, final View view, final int position) {
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
}
