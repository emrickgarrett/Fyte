package garyapps.fyte.Models.Cells.Home;

import android.media.Image;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;

import garyapps.fyte.Adapters.HomeViewTableRowAdapter;
import garyapps.fyte.Models.HomeTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class AcknowledgementCell extends HomeInfoCell {

    public AcknowledgementCell(View v, HomeTableRowModel model){
        super(v);

        createDefaultAcknowledgement();
    }

    private void createDefaultAcknowledgement(){
        this.cellTitle.setText("Default Acknowledgement");
        this.cellDesc.setText("This will be a simple acknowledgement that the user clicks to remove");
        this.cellImage.setImageResource(android.R.drawable.ic_menu_info_details);
        this.cellActionImage.setImageResource(android.R.drawable.btn_star);
    }

    @Override
    public void onClick(final HomeViewTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {
        Animation anim = AnimationUtils.loadAnimation(adapter.getContext(), R.anim.anim_slide_out_right);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                parent.removeViewInLayout(view);
                adapter.removeCell(position);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(anim);
    }
}
