package garyapps.fyte.Models.Cells;

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


    public DisciplineCell(FyteTableRowAdapter adapter, FyteRowModel model) {
        super(adapter, ((FyteProfileRowModel) model));

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
