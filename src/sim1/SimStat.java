/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim1;

/**
 *
 * @author James
 */
public class SimStat {
    
    
    int lazy;
    int hard;
    double ge;
    double gm;
    double drag;
    int worker_switch;
    
    SimStat(int l, int h, double g_effort, double g_mark, double g_drag, int switch_pace ){
        
        lazy = l;
        hard = h;
        ge = g_effort;
        gm = g_mark;
        drag = g_drag;
        worker_switch = switch_pace;
    
    }
    
    void printsim(){
        System.out.println(lazy + "   " + hard + "   " + ge + "   " + gm + "   " + drag + "   " + worker_switch);
    }
}
