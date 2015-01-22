/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs355.solution;

import Controller.CS355Controller;
import Controller.Controller;
import Controller.MouseLis;
import Controller.MouseMotionLis;
import Model.Model;
import Model.shapes.Circle;
import Model.shapes.Point3D;
import Shell.GUIFunctions;
import View.View;
import View.ViewRefresher;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author [your name here]
 */
public class CS355 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	// Fill in the parameters below with your controller, view, 
    	//   mouse listener, and mouse motion listener
    	CS355Controller c = new Controller(); 
    	View v = new View();
    	Model.inst().addObserver(v);
        //Model model = Model.createModel();
        
    	MouseLis ml = new MouseLis();
    	MouseMotionLis mml = new MouseMotionLis();
    	
        GUIFunctions.createCS355Frame(c,v, ml, mml);
        GUIFunctions.refresh();
        
        //GUIFunctions.changeSelectedColor(Color.cyan);
        //Model.inst().testModel();
       //GUIFunctions.refresh(); 
        
   
    }
}