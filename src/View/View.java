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

/**
 *
 * @author James
 */
public class View implements ViewRefresher {
	 private static View instance;
	
	  
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
			//GUIFunctions.refresh();
		}


		@Override
		public void refreshView(Graphics2D g2d) {
			// TODO Auto-generated method stub
	    	//s.getGr
	    	//View.inst().refreshView(square);
                    
                    //write a function that will iterart though the shapes array and draw them to the screen.
                    for(int i = 0; i < Model.inst().getShapeCount(); i++){
                        Shape s = Model.inst().getShape(i);
                        //Write a class that takes a shape as input and then
                        //figures out whay type it is and then draws it.
                    }
                    
                    g2d.setColor(Color.blue);
                    g2d.fillRect(5, 5, 50, 500);
                    
		}
	
        
	
    
}
