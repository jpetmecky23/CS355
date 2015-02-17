/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.shapes.*;
import Shell.GUIFunctions;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;



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
        this.changeColorOfSelectedShape(selectColor);
        this.modelChanged();
    }
    
    public void clearSelectedShapes(){
        int count = Model.inst().getShapeCount(); 
        for(int i = count - 1; i >= 0; i--){
           this.container.get(i).setIsSelected(false);//clear selected shapes.
        }
    }
    
    public void check4ShapeClicked(Point3D world){
        int count = Model.inst().getShapeCount();
        clearSelectedShapes();
        for(int i = count - 1; i >= 0; i--){
            boolean yes = this.container.get(i).isPointInShape(world);
            if(yes){
               break;
            }
        }
        this.modelChanged();
    }
    
    public void changeColorOfSelectedShape(Color c){
        int count = Model.inst().getShapeCount(); 
        for(int i = count - 1; i >= 0; i--){
            if(this.container.get(i).isIsSelected()){
                this.container.get(i).setColor(c);
            }
        }
    }
    
    public void modelChanged(){
        this.setChanged();
    	this.notifyObservers();
    }

    public void translateShape(Point3D tanslationVec){
        int count = Model.inst().getShapeCount();
        for(int i = count - 1; i >= 0; i--){
            this.container.get(i).translateShape(tanslationVec);
        } 
        this.modelChanged();
    }
    
    public int getIndexOfSelectedShape(){
        for(int i = 0; i < this.getShapeCount(); i++){
            if(this.getShape(i).isIsSelected()){
                return i;
            }
        }
        return -1;
    }
}
