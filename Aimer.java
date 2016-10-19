import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class Aimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aimer extends Actor
{
    /**
     * Act - do whatever the Aimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Plan:
     * Detect things with a limited radius/range
     * Be able to shoot different kinds of arrows/bullets *Additional Functionality*
     */
    
    int range;
    int level;
    myWorld world;
    Tower t;
    int[] tempArray;
    
    public Aimer() {
        
    }
    
    public Aimer(int radius, Tower tee) {
        range = radius;
        GreenfootImage image = getImage();
        image.scale(range, range);
        t = tee;
    }
    
    public int[] enemyCheck() {
        Actor e = getOneIntersectingObject(Enemy.class);
        if (e != null) {
            tempArray = new int[] {e.getX(), e.getY()};
        }
        return tempArray;
    }

    public void act()  // Add your action code here.
    {
        setLocation(t.xLoc, t.yLoc);
    }    
}
