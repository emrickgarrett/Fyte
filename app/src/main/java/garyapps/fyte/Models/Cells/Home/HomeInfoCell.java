package garyapps.fyte.Models.Cells.Home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import garyapps.fyte.Models.HomeTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class HomeInfoCell extends RecyclerView.ViewHolder{

    protected ImageView cellImage;
    protected TextView cellTitle;
    protected TextView cellDesc;
    protected ImageView cellActionImage;
    protected View view;

    public HomeInfoCell(View v){
        super(v);
        bindViews(v);
    }
    public HomeInfoCell(View v, HomeTableRowModel model){
        super(v);
        bindViews(v, model);
    }

    public View getView(){ return view; }

    private void bindViews(View v){
        this.view = v;
        cellImage = v.findViewById(R.id.home_info_cell_image);
        cellTitle = v.findViewById(R.id.home_info_cell_title);
        cellDesc = v.findViewById(R.id.home_info_cell_desc);
        cellActionImage = v.findViewById(R.id.home_info_cell_action_image);
    }

    private void bindViews(View v, HomeTableRowModel model) {
        this.bindViews(v);

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

    public void onClick(AdapterView<?> parent, View view, int position, long id) {
        parent.removeViewInLayout(view);
    }
}
