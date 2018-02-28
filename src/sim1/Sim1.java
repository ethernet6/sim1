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

        int group_size = 21;

        Student[] group_project = new Student[group_size];
        //Student[] group_project1 = new Student[group_size];
        Random rand = new Random();

        double lazy_s = 0.51;
        double hard_s = 0.75;

        int no_lazy_workers = 0;
        int no_hard_workers = 0;
        for (int v = 0; v < group_size; v++) {

            Student s1 = new Student();
            

            // random numbers 0 to 1 exclu. 2
            int n = rand.nextInt(2);
            int n2 = rand.nextInt(2);

            s1.lazy = n;
             

            if (s1.lazy == 1) {
                s1.effort = lazy_s;
                
                no_lazy_workers++;
            }
            if (s1.lazy == 0) {
                s1.effort = hard_s;
                
                no_hard_workers++;
            }

            group_project[v] = s1;
        }
        System.out.println("Level 0 ");
        System.out.println("LZ: " + no_lazy_workers);
        System.out.println("HD: " + no_hard_workers);
        int sims = 15;
        SimStat[] stats = new SimStat[sims];

        for (int a = 0; a < sims; a++) {
            //System.out.println("Group formed, size: " + group_size);
            //System.out.println("H: 0.85,  L: 0.5");
            //System.out.println("Lazy STU " + no_lazy_workers);
            //System.out.println("HARD STU " + no_hard_workers);
            double group_effort = (no_hard_workers * hard_s) + (no_lazy_workers * lazy_s);
            //System.out.println("Effort: " + group_effort);
            double group_mark = group_effort / group_size;
            //System.out.println("Mark: " + group_mark);
            double alpha = 0.1;
            //System.out.println("Alpha: " + alpha);

            int l2 = 0;
            int h2 = 0;
            l2 = no_lazy_workers;
            h2 = no_hard_workers;

            //System.out.println("Measure: (Lower is better)");
            // collective drag
            double total_m = 0;
            for (int v = 0; v < group_size; v++) {
                
                

                // group effort
                //System.out.println(group_project[v].effort);
                double measure = group_mark - (alpha * group_project[v].effort);
                group_project[v].measure = measure;
                //System.out.println("stat: " + (v + 1) + " UMS: " + measure);
                total_m = measure + total_m;
            }

            //System.out.println("New Effort Stats");
            no_lazy_workers = 0;
            no_hard_workers = 0;

            int changes = 0;
//            for (int w = 0; w < group_size; w++) {
//
//                // check measure
//                int n = rand.nextInt(group_size - 1);
//                int v = rand.nextInt(group_size - 1);
//                
//                if(group_project[v].measure < group_project[n].measure){
//                
//                    group_project[v].effort = group_project[n].effort;
//                }
//                
//                //System.out.println(group_project[v].effort);
//
//                if (group_project[w].effort == lazy_s) {
//                    no_lazy_workers++;
//
//                }
//                if (group_project[w].effort == hard_s) {
//                    no_hard_workers++;
//
//                }
//            }
            //System.out.println("Switched " + changes);
            //System.out.println("");

//            SimStat sim = new SimStat(l2, h2, group_effort, group_mark, total_m, changes);
//            stats[a] = sim;

        } //end of sim

//        System.out.println("L H GE GM DRG SWT");
//        for (int v = 0; v < sims; v++) {
//
//            stats[v].printsim();
//
//        }
//        System.out.println((stats[sims - 1].ge / group_size));

    }

}
