package garyapps.fyte.Models;

import garyapps.fyte.Enums.FyteCellType;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class FyteProfileRowModel extends FyteRowModel{

    public int imageId;
    public String title;
    public String desc;
    public int actionImageId;

    public FyteProfileRowModel(int imageId, String title, String desc, int actionImageId, FyteCellType type){
        super(type);
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.actionImageId = actionImageId;
    }

    public FyteProfileRowModel(int imageId, String title, String desc, int actionImageId){
        this(imageId, title, desc, actionImageId, FyteCellType.Default);
    }

    public FyteProfileRowModel(String title, String desc){
        this(title, desc, FyteCellType.Default);
    }

    public FyteProfileRowModel(String title, String desc, FyteCellType type){
        this(-1, title, desc, -1, type);
    }
}
