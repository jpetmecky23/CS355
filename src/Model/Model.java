/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.shapes.*;
import Shell.GUIFunctions;
import java.awt.Color;
import java.awt.image.BufferedImage;
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
    private double xOffset;
    private double yOffset;
    private double zOffset;
    private double rotationOffset;
    private HouseModel house;
    int[][] image;
    int width;
    int heigth;
    private boolean printPic;
    
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
        xOffset = 0;
        yOffset = 2;
        zOffset = -25;
        house = null;
        image = null;
        printPic = false;
        
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public boolean isPrintPic() {
        return printPic;
    }

    public void setPrintPic(boolean printPic) {
        this.printPic = printPic;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }
    
    
    public double getxOffset() {
        return xOffset;
    }
    public double getyOffset() {
        return yOffset;
    }

    public double getzOffset() {
        return zOffset;
    }

    public double getRotationOffset() {
        return rotationOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
        this.modelChanged();
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
        this.modelChanged();
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
        this.modelChanged();
    }

    public void setRotationOffset(double rotationOffset) {
        this.rotationOffset = rotationOffset;
        this.modelChanged();
    }
    
    public void incrementXOffset(double value) {
        this.xOffset += value;
        System.out.println("X: " + xOffset);
    
    }
    public void decrementXOffset(double value) {
            this.xOffset -= value;
            System.out.println("X: " + xOffset);
    }
    
    public void incrementYOffset(double value) {
        this.yOffset += value;
        System.out.println("Y: " + yOffset);
    }
    public void decrementYOffset(double value) {
            this.yOffset -= value;
            System.out.println("Y: " + yOffset);
    }
    
    public void incrementZOffset(double value) {
        this.zOffset += value;
        System.out.println("Z: " + zOffset);
    }
    public void decrementZOffset(double value) {
            this.zOffset -= value;
            System.out.println("Z: " + zOffset);
    }

    public HouseModel getHouse() {
        return house;
    }

    public void setHouse(HouseModel house) {
        this.house = house;
        this.modelChanged();
    }

    
    
    public void incrementRotateOffset() {
       // if(this.rotationOffset == 359){
       //    this.rotationOffset = 0; 
        //}
       // else{
            this.rotationOffset++;
        //}
        System.out.println("Rotation: " + rotationOffset);
        this.modelChanged();
    }
    public void decrementRotateOffset() {
      /*  if(this.rotationOffset == 0){
            this.rotationOffset = 359;
        }
        else{ */   
            this.rotationOffset--;
       // }
        System.out.println("Rotation: " + rotationOffset);
        this.modelChanged();
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
        this.modelChanged();
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
    
    public int getIndexOfSelectedShape(){
        for(int i = 0; i < this.getShapeCount(); i++){
            if(this.getShape(i).isIsSelected()){
                return i;
            }
        }
        return -1;
    }
}
