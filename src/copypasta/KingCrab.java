package copypasta;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class KingCrab extends CrabCritter {
    public void processActors(ArrayList<Actor> actors) {
        for(Actor a : actors) {
            int dir = getLocation().getDirectionToward(a.getLocation());
            Location adj = a.getLocation().getAdjacentLocation(dir);
            if(getGrid().isValid(adj) && getGrid().get(adj) == null) {
                a.moveTo(adj);
            }
            else {
                a.removeSelfFromGrid();
            }
        }
    }
}
