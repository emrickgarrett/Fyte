package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteProfileRowModel;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class FyteInfoCell extends FyteCell{

    protected ImageView cellImage;
    protected TextView cellTitle;
    protected TextView cellDesc;
    protected ImageView cellActionImage;
    protected FyteProfileRowModel model;
    protected FyteTableRowAdapter adapter;

    public FyteInfoCell(FyteTableRowAdapter adapter, FyteRowModel model){
        this.adapter = adapter;
        bindViews(adapter.getLayoutInflater().inflate(R.layout.home_info_cell, null),((FyteProfileRowModel) model));
    }

    private void bindViews(View v){
        this.view = v;
        cellImage = v.findViewById(R.id.home_info_cell_image);
        cellTitle = v.findViewById(R.id.home_info_cell_title);
        cellDesc = v.findViewById(R.id.home_info_cell_desc);
        cellActionImage = v.findViewById(R.id.home_info_cell_action_image);
    }

    private void bindViews(View v, FyteProfileRowModel model) {
        this.bindViews(v);
        this.model = model;

        if (model.imageId != -1) {
            cellImage.setImageDrawable(Drawable.createFromPath(""));
        }
        if (model.title != "") {
            cellTitle.setText(model.title);
        }
        if (model.desc != "") {
            cellDesc.setText(model.desc);
        }
        if(model.actionImageId != -1){
            cellActionImage.setImageDrawable(Drawable.createFromPath(""));
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
    public FyteRowModel getModel(){
        return model;
    }
}
