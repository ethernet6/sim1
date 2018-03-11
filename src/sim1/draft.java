/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim1;

import java.util.*;

/**
 *
 * @author James
 */
public class draft {

    public static void main(String[] args) {

        int group_size = 20;

        Random rand = new Random();
        
        double lazy = 0.0;
        double hard = 1.0;
        
        int lazy_workers = 0;
        int hard_workers = 0;
        
        int no_of_groups = 2;
        
        Group[] collection = new Group[no_of_groups];
        
        for (int b = 0; b < no_of_groups; b++) {
        Group g1 = new Group(group_size);
            collection[b] = g1;
            
            for (int a = 0; a < group_size; a++) {
                Student s1 = new Student();
                int n = rand.nextInt(2);
                s1.lazy = n;

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
        for(int v = 0; v<8; v++){
            
        double alpha = 1.0;
        double measure;
        
        // numbers of groups
        for (int q = 0; q < no_of_groups; q++) {

            double group_effort = (collection[q].hw* hard) + (collection[q].sw * lazy);
            //System.out.println("gh "+ group_effort);
            double group_mark = group_effort / group_size;
            collection[q].ge = group_effort;
            collection[q].gm = group_mark*100;
            
            // students in group
            for (int a = 0; a < group_size; a++) {

                measure = collection[q].gm - (alpha * collection[q].s1[a].effort);
                collection[q].s1[a].measure = measure;

            }
        }
        
        // group project over
        
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
            
            
            
            if (lookup[q1][a1] == 0 && collection[q].s1[a].measure > collection[q1].s1[a1].measure) {

                System.out.println("big :" + collection[q].s1[a].measure);
                System.out.println("small: " + collection[q1].s1[a1].measure);
                changes++;
                
                //lookup[q][a] = 1;
            lookup[q1][a1] = 1;
                collection[q1].s1[a1].effort = collection[q].s1[a].effort;
                if(lazy == collection[q].s1[a].effort){
                    
                    
                    //collection[q1].s1[a1].lazy = 1;
                    //collection[q1].s1[a1].ch = 1;
                    
                }
                //changes++;
            }
        
        }
        System.out.println("Changes overall: " + changes);
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
            
            System.out.println("Group No. [" + (w) + "]" );
            System.out.println("SIM-----");
            System.out.println("GE: " + collection[w].ge);
            System.out.println("GM: " + collection[w].gm);
            System.out.println("POST----");
            System.out.println("L: " + collection[w].sw);
            System.out.println("H: " + collection[w].hw);
            //System.out.println("Measure: " + total_m/100);
            //System.out.println("CH: " + changes);
            counter = 0;
            System.out.println("");
            //System.out.println("");
        }
        
        for(int k =0; k< no_of_groups; k++){
        
            for(int h=0; h< group_size;  h++){
                
            collection[k].s1[h].measure = 0.0;
            }
        }
      }// end of master loop
    }

}
