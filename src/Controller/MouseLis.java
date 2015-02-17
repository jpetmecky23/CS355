package Controller;

import Model.Model;
import Model.shapes.Point3D;
import java.awt.event.MouseEvent;

public class MouseLis implements java.awt.event.MouseListener{
    private static MouseLis instance;
    
    public static MouseLis inst()
	    {
	        if (instance == null)
	        {
	            instance = createMouseLis();
	        }
	        
	        return instance;
	    }
	    
	       
	    public static MouseLis createMouseLis()
	    {
	        instance = new MouseLis();
	        return instance;
	    }

		static boolean isInitialized() 
	    {
	        return (instance != null);
	    } 

	    public MouseLis() {
	        
	    }
    
    
    
	@Override
	public void mouseClicked(MouseEvent arg0) {
            Point3D mouseLocation = new Point3D(arg0.getX(), arg0.getY(), 0);
           // Controller.inst().setMouseClick(mouseLocation);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//pass the coordinates to the model class
            Point3D mouseLocation = new Point3D(arg0.getX(), arg0.getY(), 0);
            Controller.inst().setMouseDown(mouseLocation);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
            Point3D mouseLocation = new Point3D(arg0.getX(), arg0.getY(), 0);
            Controller.inst().setMouseUp(mouseLocation);
	}

}
