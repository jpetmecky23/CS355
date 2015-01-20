/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Model;
import Model.shapes.Shape;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author James
 */
public class Factory {
    
    
    
    public void drawShape(Graphics2D g2d, Shape s){
        
        for(int i = 0; i < Model.inst().getShapeCount(); i++){
            s = Model.inst().getShape(i);
            drawShape(g2d, s);
            //start here
            //Write a class that takes a shape as input and then
            //figures out whay type it is and then draws it.
        }  
    
        if(s.getClass() == Shape){
        g2d.setColor(Color.blue);
        g2d.fillRect(5, 5, 50, 500);
        }
    }
}
            
                                //write a function that will iterart though the shapes array and draw them to the screen.
    

