package garyapps.fyte.Models;

import garyapps.fyte.Enums.FyteCellType;

/**
 * Created by garrettemrick on 12/19/17.
 */

public class FyteTrackerRowModel extends FyteRowModel{

    public String discipline;
    public String experienceLevel;

    public int disciplineId;

    public FyteTrackerRowModel(String discipline, String experienceLevel, int disciplineId, FyteCellType type){
        super(type);
        this.discipline = discipline;
        this.experienceLevel = experienceLevel;
        this.disciplineId = disciplineId;
    }

    public FyteTrackerRowModel(String discipline, String experienceLevel, int disciplineId){
        this(discipline, experienceLevel, disciplineId, FyteCellType.Discipline);
    }

}
