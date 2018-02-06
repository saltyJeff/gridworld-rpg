package copypasta;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
    private int steps;
    private int sideLength;
    private int lines = 0;
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        setDirection(Location.EAST);
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else if(steps >= sideLength)
        {
            lines++;
            if(lines >= 3) {
                return;
            }
            if(lines == 1) {
                setDirection(Location.SOUTHWEST);
            }
            else if(lines == 2) {
                setDirection(Location.EAST);
            }
            steps = 0;
        }
        else {
            System.out.println("fell thru");
        }
    }
}
