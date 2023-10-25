import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goal extends Actor
{
    /**
     * Act - do whatever the Goal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Goal(){
        getImage().scale(50,300);
        getImage().setTransparency(0);
    }
    public void act(){
        move(-1);
    }
}
