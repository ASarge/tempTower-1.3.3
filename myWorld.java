import greenfoot.*;
import java.util.*;

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*
 * To do list
 * add in .txt file reader
 * add in tower menu jfc
 */

public class myWorld extends World
{
    public int screenWidth = getWidth()/50;
    public int screenHeight = getHeight()/50;
    ArrayList <Waypoint> path;
    MouseInfo mouse;
    int level;
    int f; //size of tile; entire screen is 12x12
    float timer;
    boolean keyPress;
    boolean mouseSearch;
    boolean pause;
    Waypoint p;
    int maxEnemies = 5;
    public static int enemies = 0;
    TowerHolder h;
    
    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public myWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        f = 50;
        path = new ArrayList <Waypoint>();
        createPath();
        mouse = Greenfoot.getMouseInfo();
        pause = false;
        h = new TowerHolder();
      }
   
    public void enemyWave() {
        addObject(new Enemy(path), path.get(0).x, path.get(0).y);
    }
    
    public void createPath() { //convert to file grabber after complete
        path.add(new Waypoint(0, f)); //0
        path.add(new Waypoint(f, f)); //1
        path.add(new Waypoint(f*2, f)); //2
        path.add(new Waypoint(f*3, f)); //3
        path.add(new Waypoint(f*3, f*2)); //4
        path.add(new Waypoint(f*3, f*3)); //5
        path.add(new Waypoint(f*3, f*4)); //6
        path.add(new Waypoint(f*3, f*5)); //7
        path.add(new Waypoint(f*4, f*5)); //8
        path.add(new Waypoint(f*5, f*5)); //9
        path.add(new Waypoint(f*6, f*5)); //10
        path.add(new Waypoint(f*7, f*5)); //11
        path.add(new Waypoint(f*7, f*6)); //12
        path.add(new Waypoint(f*7, f*7)); //13
        path.add(new Waypoint(f*7, f*8)); //14
        path.add(new Waypoint(f*7, f*9)); //15
        path.add(new Waypoint(f*7, f*10)); //16
        path.add(new Waypoint(f*7, f*11)); //17
        path.add(new Waypoint(f*8, f*11)); //18
        path.add(new Waypoint(f*9, f*11)); //19
        path.add(new Waypoint(f*10, f*11)); //20
        path.add(new Waypoint(f*11, f*11)); //21
        path.add(new Waypoint(f*12, f*11)); //22
        path.add(new Waypoint(f*13, f*11)); //end of path
        for(Waypoint w: path) {
            addObject(w, w.x, w.y);
        }
    }
    
    public void act() {
        mouse = Greenfoot.getMouseInfo();
        timer++;
        addObject(h, f*14, 0);
        
        if (Greenfoot.isKeyDown("space")) {
            addObject(new Tower(), mouse.getX(), mouse.getY());
        }
        if (enemies < maxEnemies && timer >= 100) {
            enemyWave();
            enemies ++;
            timer = 0;
        }
    }
    
}
