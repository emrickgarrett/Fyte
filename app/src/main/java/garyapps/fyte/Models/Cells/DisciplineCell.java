package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Toast;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteProfileRowModel;
import garyapps.fyte.Models.FyteRowModel;

/**
 * Created by garrettemrick on 12/18/17.
 */

public class DisciplineCell extends FyteInfoCell {


    public DisciplineCell(Activity context, FyteRowModel model) {
        super(context, ((FyteProfileRowModel) model));

        createCell();
    }

    private void createCell(){
        this.cellTitle.setText("Default Discipline");
        this.cellDesc.setText("This will display information about the users discipline.");
        this.cellImage.setImageResource(android.R.drawable.ic_dialog_alert);
        this.cellActionImage.setImageResource(android.R.drawable.ic_menu_edit);
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
                takeAction();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(anim);
    }

    private void takeAction(){
        Toast.makeText(view.getContext(), "Example Discipline", Toast.LENGTH_SHORT).show();
    }
}
