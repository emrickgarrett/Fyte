package garyapps.fyte.Models.FightStyles;

import java.util.List;

import garyapps.fyte.Models.FightMove;

/**
 * Created by Garrett on 12/14/2017.
 */

public final class FightStyle {

    private String name;
    private List<FightMove> moves;

    public FightStyle(String name, List<FightMove> moves){
        this.name = name;
        this.moves = moves;
    }

    public List<FightMove> getMoves(){
        return moves;
    }

    public void setMoves(){
        this.moves = moves;
    }

    public String getName() { return this.name; }

    @Override
    public boolean equals(Object other){
        if(other == null) return false;
        if(other == this) return true;

        if(other instanceof FightStyle){
            FightStyle temp = (FightStyle) other;
            if(temp.getName() != this.getName()) return false;
            //compare lists as well
        }

        return true;
    }
}