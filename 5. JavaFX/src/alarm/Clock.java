package alarm;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Clock {
    
    private Canvas canvas;
    private GraphicsContext gc;
    
    private AudioInputStream audioStream;
    private Clip audioClip;
    
    private double centerX;
    private double centerY;
    private double r;
    private int hour,minute,second;
    
    private Calendar calendar;
    private Timer timer;
    private TimeZone timeZone;
    
    
    
    Clock(Canvas canvas){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        timer = new Timer();
        timeZone = TimeZone.getDefault();
        timer.schedule(new NewTask(),0,1000);
    }
    
    class NewTask extends TimerTask{
    
        public void run(){
            calendar = (Calendar)Calendar.getInstance(timeZone);
            drawClock();
        }
        
    }
    
    public void setAlarm(int h, int m){
        
        Thread t = new Thread(){
            public void run(){
                while(true){
                    Calendar c = new GregorianCalendar();
                    int hours = c.get(Calendar.HOUR_OF_DAY);
                    int minutes = c.get(Calendar.MINUTE);
                    if(h==hours&&m==minutes){
                        playSound();
                        return;
                    }
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }
    
 
    public void playSound(){
        try{
        audioStream = AudioSystem.getAudioInputStream(new File("alarmSound.wav"));
        audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        audioClip.setFramePosition(0);
        audioClip.start();
        
    }
    
    public void drawClock() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        centerX = canvas.getWidth()/2;
        centerY = centerX;
        r = canvas.getWidth()/2;
        
        drawFrame();
        
        for(int i=12;i>0;i--)
            drawNumber(Math.PI/-6*i,i);
        
        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        
        drawHand(hour,minute,second);
            
    }
    
    public void drawFrame(){
        
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        double dX = canvas.getWidth();
        double dY = dX;
        gc.fillOval(0,0,dX,dY);
        gc.strokeOval(0,0,dX,dY);
        
        gc.setFill(Color.BLACK);
        gc.fillOval((dX/2)-5,(dY/2)-5,10,10);
        
    }
    
    public void drawNumber(double angle, int n){
        
        gc.setFont(new Font("Arial", r*0.1));
        
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        int dx = (int)((centerX-20)*-s);
        int dy = (int)((centerY-20)*-c);
        gc.fillText(Integer.toString(n),dx+centerX-5,dy+centerY+5);
        
    }
    
    public void drawHand(double hour, double minute, double second){
        
        double rsecond = (second*6)*(Math.PI)/180;
        double rminute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
        double rhours = ((hour + (minute / 60)) * 30) * (Math.PI) / 180;
       		
        gc.setLineWidth(3);
	gc.strokeLine(centerX, centerY, centerX + (int) (r*0.50 * Math.cos(rhours - (Math.PI / 2))), centerY + (int) (r*0.50 * Math.sin(rhours - (Math.PI / 2))));
        gc.setLineWidth(2);
	gc.strokeLine(centerX, centerY, centerX + (int) (r*0.66 * Math.cos(rminute - (Math.PI / 2))), centerY + (int) (r*0.66 * Math.sin(rminute - (Math.PI / 2))));
        gc.setLineWidth(1);
        gc.setStroke(Color.RED);
        gc.strokeLine(centerX, centerY, centerX + (int) (r*0.70 * Math.cos(rsecond - (Math.PI / 2))), centerY + (int) (r*0.70 * Math.sin(rsecond - (Math.PI / 2))));
        gc.setStroke(Color.BLACK);
    }
    
}
