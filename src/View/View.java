/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Model.Model;
import Model.shapes.Shape;

/**
 *
 * @author James
 */
public class View implements ViewRefresher {
	 private static View instance;
	
	  
	 static View inst()
	    {
	        if (instance == null)
	        {
	            throw new IllegalStateException("Tried to get instance of View without initializing it first!");
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
			
		}


		@Override
		public void refreshView(Graphics2D g2d) {
			// TODO Auto-generated method stub
			
		}
	
		
	
    
}
