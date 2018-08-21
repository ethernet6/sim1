/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim1;
import java.util.*;
import java.lang.Math;
import static java.lang.Math.exp;
import java.util.Random;
/**
 *
 * @author James
 */
public class ExpoTimer {
    public static void main(String[] args) {
        double tock = 0.1;
        
        // expo function
        double min = 0.1;
        double max = 1.0;
        
        double alarm = -1;
        
        double y2 = 1;
        System.out.println("Timer test");
        
        Random r = new Random();
        double tick = min + (max - min) * r.nextDouble();
        y2 = exp(-tick);
        
        int m = 1;
        System.out.println(m*tick + " " + y2);
        
        
        while(y2 > 0.1){
        
            
       // tick = min + (max - min) * r.nextDouble();
        
        //double y = exp(-tock);
        //System.out.println(y);
        m = m + 1;
            //System.out.println("m : " +m);
        y2 = exp(-m*tick);
        System.out.println(m*tick + " " + y2);
        
            if (y2 < 0.1){
                //System.out.println("Timer Done");
                //System.out.println("Y2: " + y2);
                alarm = 1;
            }
        }
    }
    
}
