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
public class Sim1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int size = 5;
        
        Random rand = new Random();
        
        double lazy_s = 0.5;
        double hard_s = 0.7;
        
        int no_lazy_workers = 0;
        int no_hard_workers = 0;
        int nog = 2;
        Group[] gp1 = new Group[nog];
        for (int b = 0; b < nog; b++) {

            Group g1 = new Group(size);
            gp1[b] = g1;

            for (int a = 0; a < size; a++) {
                Student s1 = new Student();
                

                int n = rand.nextInt(2);
                //int n2 = rand.nextInt(2);

                s1.lazy = n;

                if (s1.lazy == 1) {
                    s1.effort = lazy_s;
                   
                    no_lazy_workers++;
                }
                if (s1.lazy == 0) {
                    s1.effort = hard_s;
                    
                    no_hard_workers++;
                }
                
                g1.s1[a] = s1;
            }
g1.hw = no_hard_workers;
 g1.sw = no_lazy_workers;
 
 System.out.println("Group No. [" + (b) + "]" );
            System.out.println("L: " + gp1[b].sw);
            System.out.println("H: " + gp1[b].hw);
            no_lazy_workers = 0;
        no_hard_workers = 0;
        }
        
        System.out.println("Level 0 ");
        System.out.println("LZ: " + no_lazy_workers);
        System.out.println("HD: " + no_hard_workers);
        System.out.println("00 " + nog);
        int sims = 12;
        SimStat[] stats = new SimStat[sims];
        
        double alpha = 1.0;
        double measure;
        
        // numbers of groups
        for (int q = 0; q < nog; q++) {

            double group_effort = (gp1[q].hw* hard_s) + (gp1[q].sw * lazy_s);
            //System.out.println("gh "+ group_effort);
            double group_mark = group_effort / size;
            gp1[q].ge = group_effort;
            gp1[q].gm = group_mark;
            
            // students in group
            for (int a = 0; a < size; a++) {

                measure = group_mark - (alpha * gp1[q].s1[a].effort);
                gp1[q].s1[a].measure = measure;

            }
        }
        int changes = 0;
        for (int y = 0; y < (nog * size); y++) {
            int q = rand.nextInt(nog);
            int a = rand.nextInt(size);

            int q1 = rand.nextInt(nog);
            int a1 = rand.nextInt(size);
            //System.out.println("acc " + q + "," + a);
            if (gp1[q].s1[a].measure > gp1[q1].s1[a1].measure) {

                gp1[q].s1[a].effort = gp1[q1].s1[a1].effort;
                
                if(lazy_s == gp1[q1].s1[a1].effort){
                    gp1[q].s1[a].lazy = 1;
                    gp1[q].s1[a].ch = 1;
                }
                //changes++;
            }
        }
         double total_m = 0;
         int laz = 0;
         int har = 0;
        for (int w = 0; w < nog;  w++) {

            for (int h = 0; h < size; h++) {

                total_m = gp1[w].s1[h].measure + total_m;
                System.out.println("g"+h + " "+ gp1[w].s1[h].measure);
                if(lazy_s == gp1[w].s1[h].effort){
                    laz++;
                }
                if(1 == gp1[w].s1[h].ch){
                    changes++;
                }
            }
            gp1[w].sw = laz;
            gp1[w].hw = size - laz;
            System.out.println("Group No. [" + (w) + "]" );
            System.out.println("L: " + gp1[w].sw);
            System.out.println("H: " + gp1[w].hw);
            System.out.println("GE: " + gp1[w].ge);
            System.out.println("GM: " + gp1[w].gm);
            System.out.println("ME: " + total_m);
            System.out.println("CH: " + changes);
            total_m = 0;
            laz = 0;
            changes = 0;
        }
        

    } // end of main

}
