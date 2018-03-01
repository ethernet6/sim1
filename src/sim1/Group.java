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
public class Group {
    
    int hw;
    int sw;
    double ge;
    double gm;
    int max;
    Student[] s1;
    Group(int cap){
        max = cap;
        s1 = new Student[max];
    }
    
    
    
}