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
import Model.shapes.Point3D;
import Model.shapes.Rectangle;
import Shell.GUIFunctions;
import View.drawableShapes.DrawableShape;
import java.util.ArrayList;

/**
 *
 * @author James
 */
public class View implements ViewRefresher {
	private static View instance;
	private ArrayList<DrawableShape> shapes;
        boolean pass;//used for testing
	  
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
	        this.shapes = new ArrayList();
                this.pass = true;//used for testing
	    }


            @Override
            public void update(Observable o, Object arg) {
                    // TODO Auto-generated method stub
                    GUIFunctions.refresh();
            }


            @Override
            public void refreshView(Graphics2D g2d) {
                //print picture background
                Factory.inst().printPic(g2d);
                
                shapes = Factory.inst().prepShapes();//Call factory and get a new drawable shapes array
                for(int i = 0; i < shapes.size(); i++){
                    shapes.get(i).drawShape(g2d);//iterate though them and draw them.
                } 
                
                for(int i = 0; i < shapes.size(); i++){
                    shapes.get(i).drawHandles(g2d);//iterate though them and draw them.
                }
                
                Factory.inst().drawHouse(Model.inst().getHouse(), g2d);
            }
            
            public void testView(){
                Rectangle r = null;
                if(Model.inst().getShapeCount() == 0){
                    r = new Rectangle(new Point3D(200, 150, 0), new Point3D(250, 200, 0), Color.GREEN);
                    Model.inst().addShape(r);
                }
                else{
                r = (Rectangle)Model.inst().getShape(0);
                //r.setAngle(r.getAngle() + Math.PI / 4);I changed set angle to take a Point3D
                Model.inst().setShape(r, 0);
                }

            }
}
