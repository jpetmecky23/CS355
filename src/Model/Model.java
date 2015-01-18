/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CS355Controller;
import Model.shapes.Shape;
import View.ViewRefresher;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;

import javax.swing.text.View;

/**
 *
 * @author James
 */
 public class Model extends Observable {
    private ArrayList<Shape> container;
    private Color shapeColor;
    private static Model instance;
    private String currentShape;
    
    static Model inst()
    {
        if (instance == null)
        {
            throw new IllegalStateException("Tried to get instance of Model without initializing it first!");
        }
        
        return instance;
    }
    
       
    public static void createModel()
    {
        instance = new Model();
    }

	static boolean isInitialized() 
    {
        return (instance != null);
    } 

    public Model() {
        this.container = new ArrayList<Shape>();
        shapeColor = Color.BLUE;
        
    }
    
    public void addShape(Shape s){
    	container.add(s);
    	this.notifyObservers();
    }
    
    public ArrayList<Shape> getContainer() {
        return container;
    }

    public void setContainer(ArrayList<Shape> container) {
        this.container = container;
    }

    public Color getColor() {
        return shapeColor;
    }

    public void setColor(Color color) {
        this.shapeColor = color;
        this.notifyObservers();
    }

	public String getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(String currentShape) {
		this.currentShape = currentShape;
	}
    
    
}
