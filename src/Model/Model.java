/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CS355Controller;
import Controller.Controller;
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
    private Color selectColor;
    
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
    	this.modelChanged();
    }
    
    public Shape getShape(int index) {
        return container.get(index);
    }
    
    public void setShape(Shape shape, int index){
        container.set(index, shape);
        this.modelChanged();
    }
    
    public int getShapeCount(){
        return container.size();
    }

    public Color getSelectColor() {
        return selectColor;
    }

    public void setSelectColor(Color selectColor) {
        this.selectColor = selectColor;
        GUIFunctions.changeSelectedColor(selectColor);
        this.modelChanged();
    }
    
    public void check4ShapeClicked(Point3D world){
        int count = Model.inst().getShapeCount();
        //Trans world coords. to 
        for(int i = count - 1; i >= 0; i--){
            this.container.get(i).isPointInShape(world);
        }
        this.modelChanged();
    }
    
    public void modelChanged(){
        this.setChanged();
    	this.notifyObservers();
    }

}
