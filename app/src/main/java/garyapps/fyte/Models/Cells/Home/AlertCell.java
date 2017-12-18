package garyapps.fyte.Models.Cells.Home;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Toast;

import garyapps.fyte.Adapters.HomeViewTableRowAdapter;
import garyapps.fyte.Models.HomeTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/18/17.
 */

public class AlertCell extends HomeInfoCell {

    public AlertCell(View v, HomeTableRowModel model) {
        super(v, model);

        createAlert();
    }

    private void createAlert(){
        this.cellTitle.setText("Default Alert");
        this.cellDesc.setText("This will be a simple alert that the user clicks to take an action");
        this.cellImage.setImageResource(android.R.drawable.ic_dialog_alert);
        this.cellActionImage.setImageResource(android.R.drawable.ic_menu_edit);
    }

    @Override
    public void onClick(final HomeViewTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {
        Animation anim = slideOutRightAnimation();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                adapter.removeCell(position);
                takeAction();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(anim);
    }

    protected void takeAction(){
        Toast.makeText(view.getContext(), "Example Action", Toast.LENGTH_SHORT).show();
    }
}
