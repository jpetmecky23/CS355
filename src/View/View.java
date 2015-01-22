/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics2D;
import java.util.Observable;
import java.awt.Color;
import Model.Model;
import Model.shapes.Shape;
import Shell.GUIFunctions;
import View.drawableShapes.DrawableShape;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author James
 */
public class View implements ViewRefresher {
	private static View instance;
	private ArrayList<DrawableShape> shapes;
	  
	 public static View inst()
	    {
	        if (instance == null)
	        {
	            instance = createView();
	        }
	        
	        return instance;
	    }
	    
	       
	    public static View createView()
	    {
	        instance = new View();
	        return instance;
	    }

		static boolean isInitialized() 
	    {
	        return (instance != null);
	    } 

	    public View() {
	        
	    }


            @Override
            public void update(Observable o, Object arg) {
                    // TODO Auto-generated method stub
                   // GUIFunctions.refresh();
            }


            @Override
            public void refreshView(Graphics2D g2d) {
                //g2d.setColor(Color.blue);//testing code
               // g2d.fillRect(5, 5, 50, 500); //testing code
                
                shapes = Factory.inst().prepShapes();//Call factory and get a new drawable shapes array
                
                for(int i = 0; i < shapes.size(); i++){
                    shapes.get(i).draw(g2d);//iterate though them and draw them.
                }              
            }
}
