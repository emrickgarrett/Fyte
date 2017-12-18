package garyapps.fyte.Models.Cells;

import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteTableRowModel;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class AcknowledgementCell extends FyteInfoCell {

    public AcknowledgementCell(View v, FyteTableRowModel model){
        super(v, model);

        createDefaultAcknowledgement();
    }

    private void createDefaultAcknowledgement(){
        this.cellTitle.setText("Default Acknowledgement");
        this.cellDesc.setText("This will be a simple acknowledgement that the user clicks to remove");
        this.cellImage.setImageResource(android.R.drawable.ic_menu_info_details);
        this.cellActionImage.setImageResource(android.R.drawable.btn_star);
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
}
