package copypasta;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {
    public ArrayList<Actor> getActors () {
        ArrayList<Actor> toReturn = new ArrayList<Actor>();
        Location p1 = getLocation().getAdjacentLocation(getDirection());
        Location p2 = getLocation().getAdjacentLocation((getDirection()+180)%360);
        if(getGrid().isValid(p1)) {
            toReturn.add(getGrid().get(p1));
        }
        if(getGrid().isValid(p2)) {
            toReturn.add(getGrid().get(p2));
        }
        return toReturn;
    }
}
