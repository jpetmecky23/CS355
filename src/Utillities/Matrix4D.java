/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Matrix4D {
    private ArrayList<ArrayList<Integer>> matrix;

    public Matrix4D(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z, ArrayList<Integer> w) {
        this.matrix = new ArrayList();
    }
    
    public void multiply(ArrayList<ArrayList<Integer>> m){
        ArrayList<ArrayList<Integer>> temp = null;
        //do the multiplications
        this.matrix = temp;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }  
}
