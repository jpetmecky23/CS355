package Controller;

import Model.shapes.Point3D;
import java.awt.event.MouseEvent;

public class MouseMotionLis implements java.awt.event.MouseMotionListener{
 private static MouseMotionLis instance;
    
    public static MouseMotionLis inst()
	    {
	        if (instance == null)
	        {
	            instance = createMouseMotionLis();
	        }
	        
	        return instance;
	    }
	    
	       
	    public static MouseMotionLis createMouseMotionLis()
	    {
	        instance = new MouseMotionLis();
	        return instance;
	    }

		static boolean isInitialized() 
	    {
	        return (instance != null);
	    } 

	    public MouseMotionLis() {
	        
	    }
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
            Point3D mouseLocation = new Point3D(arg0.getX(), arg0.getY(), 0);
            Controller.inst().setMouseCurrentLocation(mouseLocation);
            Controller.inst().updateShape();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//Pass the mouse location
	}

}
