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
public class Matrix {
    private ArrayList<ArrayList<Double>> matrix;

    public Matrix() {
        this.matrix = new ArrayList();
    }
    
    public void multiply(ArrayList<ArrayList<Double>> m){
        ArrayList<ArrayList<Double>> temp = new ArrayList();//Create function which creates matricx of specified size//new ArrayList();
        //do the multiplications
        if(m.size() == this.matrix.get(0).size()){
            for(int i = 0; i < m.size(); i++){//row
                temp.add(new ArrayList<Double>());
                 Double value = 0.0;
                for(int j = 0; j < this.matrix.size(); j++){//col
                    value += this.matrix.get(i).get(j) * m.get(j).get(0);
                    }
                temp.get(i).add(value); 
                }
            this.matrix = temp;
        }
        else{
            System.out.println("Worng Matirx Dims");
        }
    }

    private ArrayList<ArrayList<Double>> create0matrix(int rows, int col){
        ArrayList<ArrayList<Double>> zeroMatrix = new ArrayList();
        for(int i = 0; i < rows; i++){
            ArrayList<Double> temp = new ArrayList();
            for(int j = 0; j < col; j++){
                temp = new ArrayList();
                temp.add(0.0);
                zeroMatrix.add(temp); 
            }
           
        }
        return zeroMatrix;
    }
    public ArrayList<ArrayList<Double>> getMatrix() {
        return matrix;
    }  
    
    public void addRow(int index, ArrayList<Double> row){
        matrix.add(index, row);
    }
}
