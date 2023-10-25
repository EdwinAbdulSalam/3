import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    private double gravity;
    private int counter;
    private int tipcounter;
    private int score;
    private int speed;
    public Flappy(){
        tipcounter=0;
        gravity=0;
        counter=0;
        getImage().scale(50,50);
        score = 0;
    }
    public void act()
    {
       getWorld().showText("Score "+score, 100, 500);
        jump();
       end();//prevosts's avoid obstacles
       gravity();
       counter++;
       tip();
       scoreandspeed(); //prevosts lookForPoints
        move(speed);
        endGame();
    }
    public void gravity(){
        gravity = gravity +.5;
       setLocation(getX(), (int) (getY()+gravity));
        }
    public void tip(){
        if(counter %2 ==0){
           turn(1);
           tipcounter++;
       }
    }
    public void jump(){
        if(Greenfoot.isKeyDown("Space")){
            turn((5+tipcounter)*-1);
            tipcounter=-5;
            gravity = -5;
        }
    }
    public void end(){
        if(isTouching(Pipe.class) || (isTouching(Ground.class))){
            LoseScreen tom = new LoseScreen();
            getWorld().addObject(tom, 600, 400);
            Greenfoot.stop();
        }
    }
    public void scoreandspeed(){
        if(isTouching(Goal.class)){
            removeTouching(Goal.class);
            speed= speed+(1/4);
            score++;
        }
    }
    public void endGame(){
        if(score==10){
            WinScreen ann = new WinScreen();
            getWorld().addObject(ann, 600, 400);
            Greenfoot.stop();
        }
    }
}
