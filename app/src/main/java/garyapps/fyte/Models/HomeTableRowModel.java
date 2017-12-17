package garyapps.fyte.Models;

import garyapps.fyte.Enums.HomeCellType;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class HomeTableRowModel {

    public int imageId;
    public String title;
    public String desc;
    public int actionImageId;
    public HomeCellType type;

    public HomeTableRowModel(int imageId, String title, String desc, int actionImageId, HomeCellType type){
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.actionImageId = actionImageId;
        this.type = type;
    }

    public HomeTableRowModel(int imageId, String title, String desc, int actionImageId){
        this(imageId, title, desc, actionImageId, HomeCellType.Default);
    }

    public HomeTableRowModel(String title, String desc){
        this(title, desc, HomeCellType.Default);
    }

    public HomeTableRowModel(String title, String desc, HomeCellType type){
        this(-1, title, desc, -1, type);
    }
}
