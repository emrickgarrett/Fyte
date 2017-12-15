package garyapps.fyte.Models;

/**
 * Created by Garrett on 12/14/2017.
 */

public class FightMove {

    String name;
    Integer progress;
    String video;

    public FightMove(String name, Integer progress, String video){
        this.name = name;
        this.progress = progress;
        this.video = video;
    }

    public FightMove(String name, int progress, String video){
        this(name, new Integer(progress), video);
    }

    public FightMove(String name, Integer progress){
        this(name, progress, "");
    }

    public FightMove(String name, int progress){
        this(name, new Integer(progress));
    }

    public FightMove(String name){
        this(name, new Integer(0));
    }
}
