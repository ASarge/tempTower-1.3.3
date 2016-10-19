import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waypoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waypoint extends Actor
{
    /**
     * followPath - takes the parameters passed into the class and sets them to coordinates
     */
    
    public int x;
    public int y;
    int size = 60;
  
    public Waypoint(int x, int y) {
        GreenfootImage i = getImage();
        i.scale(size, size);
        this.x = x;
        this.y = y;
    }
}
