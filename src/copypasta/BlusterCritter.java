package copypasta;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class BlusterCritter extends Critter {
    private int courage;
    public BlusterCritter(int c) {
        super();
        courage = c;
    }
    public void processActors(ArrayList<Actor> actors) {
        int inRange = 0;
        for(int i = -2; i <= 2; i++) {
            for(int j = -2; j <= 2; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                Location toLook = new Location(getLocation().getRow() + i, getLocation().getCol() + j);
                if(getGrid().isValid(toLook) && getGrid().get(toLook) instanceof Critter) {
                    inRange++;
                }
            }
        }
        if(inRange >= courage) {
            setColor(getColor().darker());
        }
        else {
            setColor(getColor().brighter());
        }
    }
}
