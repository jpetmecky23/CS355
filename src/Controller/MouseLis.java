package Controller;

import Model.shapes.Point3D;
import Utillities.Tools;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

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
            mouseLocation = view2World(mouseLocation);
            Controller.inst().setMouseDown(mouseLocation);
            if(Controller.inst().getState() != ControllerState.ModingShape){
                Controller.inst().addShape();
                }
            else if(Controller.inst().getState() == ControllerState.ModingShape){
             ModAction modAction = Controller.inst().getModActionFromShape();
             if(modAction == ModAction.NoAction){
             Controller.inst().selectShape(Controller.inst().getMouseDown());
             }
             
         }

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
            Point3D mouseLocation = new Point3D(arg0.getX(), arg0.getY(), 0);
            mouseLocation = view2World(mouseLocation);
            Controller.inst().setMouseUp(mouseLocation);
	}
        
        public static Point3D view2World(Point3D mouseLocation){
            double scale = Controller.inst().getZoom();
            Point3D offset = Controller.inst().getViewOffset();
            AffineTransform view2World = Tools.view2World(scale, offset);
            return Tools.transform2Point(view2World, mouseLocation);
        }

}
