/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim1;

import static java.lang.Math.exp;
import java.util.*;

/**
 *
 * @author James
 */
public class draft2 {

    public static void main(String[] args) {

        int group_size = 100;

        Random rand = new Random();
        // strategy paramters
        double lazy = 0.0;
        double hard = 1.0;
        
        int lazy_workers = 0;
        int hard_workers = 0;
        
        int no_of_groups = 5;
        
        Group[] collection = new Group[no_of_groups];
        
        // expo timer
        
        double tock = 0.1;
        
        // expo function
        double min = 0.1;
        double max = 1.0;
        
        double alarm = -1;
        
        double y2 = 1;
        
        
        // end of new
        
        
        for (int b = 0; b < no_of_groups; b++) {
        Group g1 = new Group(group_size);
            collection[b] = g1;
            
            for (int a = 0; a < group_size; a++) {
                Student s1 = new Student();
                //int n = rand.nextInt(2);
                Random r = new Random();
                s1.r = r;
                
                if(a < -5){
                    int n=1;
                    s1.lazy = n;}
                
                if(a > -1){
                    int n=0;
                    s1.lazy = n;}
                //s1.lazy = n;    
                if (s1.lazy == 1) {
                    s1.effort = lazy;
                   
                    lazy_workers++;
                }
                if (s1.lazy == 0) {
                    s1.effort = hard;
                    
                    hard_workers++;
                }
                
                g1.s1[a] = s1;
            }
            g1.hw = hard_workers;
            g1.sw = lazy_workers;
            System.out.println("Group No. [" + (b) + "]" );
            System.out.println("L: " + collection[b].sw);
            System.out.println("H: " + collection[b].hw);
            lazy_workers = 0;
            hard_workers = 0;
        }
        
        // groups init
        //students init
        System.out.println("");
        System.out.println("");
        
        //master loop
        // number of courses polk
        for(int v = 0; v<600; v++){
            //System.out.println("COURSE: No. [" + (v+1) + "]");
        double alpha = 0.5;
        double measure;
        
        // numbers of groups
        for (int q = 0; q < no_of_groups; q++) {

            double group_effort = (collection[q].hw* hard) + (collection[q].sw * lazy);
            //System.out.println("gh "+ group_effort);
            double group_mark = group_effort / group_size;
            collection[q].ge = group_effort;
            collection[q].gm = group_mark;
            
            // students in group
            for (int a = 0; a < group_size; a++) {

                measure = collection[q].gm - (alpha * collection[q].s1[a].effort);
                collection[q].s1[a].measure = measure;
                //System.out.println(measure);

            }
        }
        
        // group project over
        
        
        
        
        //double tick = min + (max - min) * r.nextDouble();
        
        double[][] timer_p = new double[no_of_groups][group_size];
        for(int k =0; k< no_of_groups; k++){
        
            for(int h=0; h< group_size;  h++){
                double tick = min + (max - min) * collection[k].s1[h].r.nextDouble();
            timer_p[k][h] = tick;
            
            y2 = exp(-v*tick);
            
            if(y2< 0.1){
                //System.out.println("KEN");
                int q = rand.nextInt(no_of_groups);
            int a = rand.nextInt(group_size);
                    if(collection[q].s1[a].effort == lazy){
                    collection[k].s1[h].effort = lazy;
                    }
                    
                    if(collection[q].s1[a].effort == hard){
                        collection[k].s1[h].effort = lazy;
                    }
                }
            }
        }
        
        //y2 = exp(-tick);
        // start project lookup
        
        int[][] lookup = new int[no_of_groups][group_size];
        //int[] lookup2 = new int[group_size];
        
        for(int k =0; k< no_of_groups; k++){
        
            for(int h=0; h< group_size;  h++){
            lookup[k][h] = 0;
            
            }
        }
        
        int changes = 0;
        
        for (int y = 0; y < (no_of_groups * group_size); y++) {
        //for (int y = 0; y < 3 ; y++) {
            int q = rand.nextInt(no_of_groups);
            int a = rand.nextInt(group_size);

            int q1 = rand.nextInt(no_of_groups);
            int a1 = rand.nextInt(group_size);
            
            
            // compare measure 
            if (collection[q].s1[a].measure > collection[q1].s1[a1].measure) {

                //System.out.println("big :" + collection[q].s1[a].measure);
                //System.out.println("small: " + collection[q1].s1[a1].measure);
                changes++;
                
                //lookup[q][a] = 1;
            lookup[q1][a1] = 1;
                //OLD //collection[q1].s1[a1].effort = collection[q].s1[a].effort;
                if(lazy == collection[q].s1[a].effort){
                    
                    
                    //collection[q1].s1[a1].lazy = 1;
                    //collection[q1].s1[a1].ch = 1;
                    
                }
                //changes++;
            }
        
        }
        //System.out.println("Changes overall: " + changes);
        //changes = 0;
        // end of re-check
        int counter = 0;
        
        for (int w = 0; w < no_of_groups;  w++) {

            for (int h = 0; h < group_size; h++) {
            
                //System.out.println("g"+h + " "+ collection[w].s1[h].measure);
                
                if(lazy == collection[w].s1[h].effort){
                    counter++;
                    if(collection[w].s1[h].ch == 1){
                        //changes++;
                    }
                }
            }
            collection[w].sw = counter;
            collection[w].hw = group_size - counter;
            
//            System.out.println("Group No. [" + (w) + "]" );
//            System.out.println("SIM-----");
//            System.out.println("Group Effor: " + collection[w].ge);
//            System.out.println("Group Mark: " + collection[w].gm);
//            System.out.println("POST----");
//            System.out.println("L: " + collection[w].sw);
//            System.out.println("H: " + collection[w].hw);
            
            //new lines
            //System.out.println("Group No. [" + (w) + "]" );
            //System.out.println("SIM-----");
            
            //collection[q].s1[a].measure
            
            double hardco = 0.0;
            double lazyco = 0.0;
            
            for (int k = 0; k < no_of_groups; k++) {

                for (int h = 0; h < group_size; h++) {

                    if(collection[k].s1[h].lazy ==0){
                        hardco = hardco + collection[k].s1[h].measure;
                        
                    }
                    
                    if(collection[k].s1[h].lazy ==1){
                        lazyco = lazyco + collection[k].s1[h].measure;
                        //System.out.println(collection[k].s1[h].measure);
                    }
                }
            }
            //park
                //System.out.println(collection[w].ge);
            //System.out.println(collection[w].ge + ","+ collection[w].gm+","+collection[w].sw+","+collection[w].hw+','+lazyco+','+hardco);
            System.out.print(lazyco+" ");
            System.out.println(hardco);
            System.out.println("");
            
//            System.out.println("Group Mark: " + collection[w].gm);
//            System.out.println("POST----");
//            System.out.println("L: " + collection[w].sw);
//            System.out.println("H: " + collection[w].hw);
            //System.out.println("Measure: " + total_m/100);
            //System.out.println("CH: " + changes);
            lazyco = 0.0;
            hardco = 0.0;
            
            counter = 0;
                //System.out.println("");
            //System.out.println("");
        }
        
        
        for(int k =0; k< no_of_groups; k++){
        
            for(int h=0; h< group_size;  h++){
                
            //collection[k].s1[h].measure = 0.0;
            }
        }
      }// end of master loop
    }

}
