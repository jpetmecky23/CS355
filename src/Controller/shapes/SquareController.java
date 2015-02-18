/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Model.shapes.Point3D;
import Model.shapes.Shape;

/**
 *
 * @author James
 */
public class SquareController {
    
    public static int checkCorners(Shape s, Point3D mouseClicked){
        if(checkRotation(s, mouseClicked)){
            return 0;
        }
        
        else if(checkTopLeft(s, mouseClicked)){
            return 1;
        }
        
        else if(checkTopRight(s, mouseClicked)){
            return 2;
        }
        
        else if(checkBottomRight(s, mouseClicked)){
            return 3;
        }
        
        else if(checkBottomLeft(s, mouseClicked)){
            return 4;
        }
        else{
        return -1;
        }
    } 
    
    public static boolean checkRotation(Shape s, Point3D mouseClicked){
        
        return false;
    }
    
    public static boolean checkTopLeft(Shape s, Point3D mouseClicked){
        
        return false;
    }
        
    public static boolean checkTopRight(Shape s, Point3D mouseClicked){
        
        return false;
    }
            
    public static boolean checkBottomRight(Shape s, Point3D mouseClicked){
        
        return false;
    }
            
    public static boolean checkBottomLeft(Shape s, Point3D mouseClicked){
        
        return false;
    }
}
