import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int cycle;
    private int gap;
    private int freq;
    public MyWorld()
    {    
        super(1200, 800, 1); 
        setPaintOrder(LoseScreen.class, WinScreen.class, Ground.class, Flappy.class, Pipe.class);//makes ground on top of everything else
        prepare();
        cycle = 0;
        freq=400;
        gap=650;
    }
    public void act(){
        MidLevelSpawn();
    }
    public void MidLevelSpawn(){
        if(cycle % freq == 0){
            freq = freq -10;
            if(freq <10){
                freq= 10;
            }
            int topY = Greenfoot.getRandomNumber(200) - 10;
            int bottomY = topY + gap;
            gap = gap-5;
            BottomPipe bob = new BottomPipe();
            addObject(bob, 1151, bottomY);
            TopPipe mark = new TopPipe();
            addObject(mark, 1151, topY);
            Goal jim = new Goal();
            addObject(jim, 1151, (bottomY+topY)/2);
        }
        cycle++;
    }
    
    private void prepare()
    {
        Flappy flappy = new Flappy();
        addObject(flappy,109,298);
        flappy.setLocation(192,298);
        flappy.setLocation(294,400);
        Ground ground = new Ground();
        addObject(ground,721,745);
        Ground ground2 = new Ground();
        addObject(ground2,1035,745);
        Ground ground3 = new Ground();
        addObject(ground3,449,745);
        Ground ground4 = new Ground();
        addObject(ground4,167,745);
        Clouds clouds = new Clouds();
        addObject(clouds,450,186);
        clouds.setLocation(411,233);
        clouds.setLocation(489,240);
        Clouds clouds2 = new Clouds();
        addObject(clouds2,924,134);
    }
}
