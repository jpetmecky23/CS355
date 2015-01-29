/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CS355Controller;
import View.View;
import View.ViewRefresher;
import Model.shapes.*;
import Shell.GUIFunctions;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;


/**
 *
 * @author James
 */
 public class Model extends Observable {
    private ArrayList<Shape> container;
    private static Model instance;
    
    public static Model inst()
    {
        if (instance == null)
        {
        	instance = createModel();
        }
        
        return instance;
    }
    
       
    public static Model createModel()
    {
        instance = new Model();
        return instance;
    }

	static boolean isInitialized() 
    {
        return (instance != null);
    } 

    public Model() {
        this.container = new ArrayList();
          
    }
    
    public void addShape(Shape s){
    	container.add(s);
    	this.setChanged();
    	this.notifyObservers();
    }
    
    public Shape getShape(int index) {
        return container.get(index);
    }
    
    public void setShape(Shape shape, int index){
        container.set(index, shape);
        this.setChanged();
    	this.notifyObservers();
    }
    
    public int getShapeCount(){
        return container.size();
    }
 
    public Shape isClickOnShape(Point3D p){
        Shape shape = null;
        //Trans world coords. to 
        
        return shape;
    }
    
    public void testModel(){
        /*
        Shape s = null;
        s = new Circle(new Point3D(285, 325, 60), 50, Color.BLUE);
        addShape(s);
        
        s = new Ellipses(new Point3D(140, 420, 60), 30, 20, Color.CYAN);
        addShape(s);

        s = new Line3D(new Point3D(30, 40, 60), new Point3D(300, 400, 60), Color.YELLOW);
        addShape(s);
        
        //s = new Rectangle(new Point3D(240, 290, 60), 50, 60, Color.PINK);
       // addShape(s);

        //s = new Square(new Point3D(80, 400, 60), 50, Color.ORANGE);
       // addShape(s);
        
        s = new Triangle(new Point3D(383, 425, 60), new Point3D(100, 30, 60), new Point3D(55, 45, 60), Color.RED);
        addShape(s);
                */
                
    }
}
