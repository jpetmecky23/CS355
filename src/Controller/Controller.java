/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Shell.GUIFunctions;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import Model.Model;
import Model.shapes.*;


/**
 *
 * @author James
 */
public class Controller implements CS355Controller{
    private static Controller instance;
    private Point3D mousePressed;
    private Point3D mouseReleased;
    private Point3D mousePrevLocation;
    private Point3D mouseCurrentLocation;
    private ControllerState currentState;
    private ModAction modAction;
    private double zoom;
    private Point3D viewOffset;
    private int scrollBarKnobSize;
            
    public static Controller inst()
    {
        if (instance == null)
        {
        	instance = createController();
        }
        
        return instance;
    }
    
       
    public static Controller createController()
    {
        instance = new Controller();
        return instance;
    }

	static boolean isInitialized() 
    {
        return (instance != null);
    } 

    public Controller() {
        this.mousePressed = null;
        this.mouseReleased = null;
        this.mouseCurrentLocation = null;
        this.mousePrevLocation = null;
        this.zoom = 1.0;
        this.viewOffset = new Point3D(0, 0, 0);
        this.scrollBarKnobSize = 512;

    }


    public void colorButtonHit(Color c){
        GUIFunctions.changeSelectedColor(c);
        Model.inst().setSelectColor(c);
    }
    
    public void triangleButtonHit(){
        Controller.inst().setState(ControllerState.Triangle);
        Model.inst().clearSelectedShapes();
    }
    
    public void squareButtonHit(){
        Controller.inst().setState(ControllerState.Square);
        Model.inst().clearSelectedShapes();
    }
    
    public void rectangleButtonHit(){
        Controller.inst().setState(ControllerState.Rectangle);
        Model.inst().clearSelectedShapes();
    }

    public void circleButtonHit(){
        Controller.inst().setState(ControllerState.Circle);
        Model.inst().clearSelectedShapes();
    }
 
    public void ellipseButtonHit(){
        Controller.inst().setState(ControllerState.Ellipses);
        Model.inst().clearSelectedShapes();
    }
    
    public void lineButtonHit(){
        Controller.inst().setState(ControllerState.Line);
        Model.inst().clearSelectedShapes();
    }

    public void selectButtonHit(){
         Controller.inst().setState(ControllerState.ModingShape);
         Model.inst().clearSelectedShapes();
    }
    @Override
    public void zoomInButtonHit(){
        if(Controller.inst().getZoom() < 4){
            Controller.inst().setZoom(Controller.inst().getZoom() * 2);
            Controller.inst().setScrollBarKnobSize(Controller.inst().getScrollBarKnobSize() / 2);
            GUIFunctions.setHScrollBarKnob(Controller.inst().getScrollBarKnobSize() );
            GUIFunctions.setVScrollBarKnob(Controller.inst().getScrollBarKnobSize() );
            this.hScrollbarChanged(60);
            this.vScrollbarChanged(60);
            //GUIFunctions.setVScrollBarPosit(scrollBarKnobSize);
            Model.inst().modelChanged();
        }
    }
    @Override
    public void zoomOutButtonHit(){
        if(Controller.inst().getZoom() > .25){
            Controller.inst().setZoom(Controller.inst().getZoom() / 2);
            Controller.inst().setScrollBarKnobSize(Controller.inst().getScrollBarKnobSize() * 2);
            GUIFunctions.setHScrollBarKnob(Controller.inst().getScrollBarKnobSize() );
            GUIFunctions.setVScrollBarKnob(Controller.inst().getScrollBarKnobSize() );
            Model.inst().modelChanged();
        }
        
    }
    @Override
    public void hScrollbarChanged(int value){ 
        System.out.println("hScroll: ");
        System.out.println(value + "\n");
        Point3D offset = new Point3D(value, Controller.inst().getViewOffset().y, 0);
        Controller.inst().setViewOffset(offset);
        Model.inst().modelChanged();
    }
    @Override
    public void vScrollbarChanged(int value){
        System.out.println("vScroll: ");
        System.out.println(value + "\n");
        Point3D offset = new Point3D(Controller.inst().getViewOffset().x, value, 0);
        Controller.inst().setViewOffset(offset);
        Model.inst().modelChanged();
    }
    @Override
    public void toggle3DModelDisplay(){
        
    }
    @Override
    public void keyPressed(Iterator<Integer> iterator){
        
    }
    @Override
    public void doEdgeDetection(){
        
    }
    @Override
    public void doSharpen(){
        
    }
    @Override
    public void doMedianBlur(){
        
    }
    @Override
    public void doUniformBlur(){
        
    }
    @Override
    public void doChangeContrast(int contrastAmountNum){
        
    }
    @Override
    public void doChangeBrightness(int brightnessAmountNum){
        
    }
    @Override
    public void doLoadImage(BufferedImage openImage){
        
    }
    @Override
    public void toggleBackgroundDisplay(){
        
    }
    
    public ControllerState getState(){
        return this.currentState;
    }
    public void setState(ControllerState state){
        this.currentState = state;
    }

    public ModAction getModAction() {
        return modAction;
    }

    public void setModAction(ModAction modAction) {
        this.modAction = modAction;
    }
    
    public Point3D getMouseDown() {
        return mousePressed;
    }
    public void setMouseDown(Point3D mouseDown) {
        this.mousePressed = mouseDown;
        this.mouseReleased = null;
        this.mousePrevLocation = mouseDown;
        this.mouseCurrentLocation = mouseDown;
    }
    public Point3D getMouseUp() {
        return mouseReleased;
    }
    public void setMouseUp(Point3D mouseUp) {
        this.mouseReleased = mouseUp;
        this.modAction = ModAction.NoAction;
    }  
    public Point3D getMousePrevLocation() {
        return mousePrevLocation;
    }
    public void setMousePrevLocation(Point3D mousePrevLocation) {
        this.mousePrevLocation = mousePrevLocation;
    }
    public Point3D getMouseCurrentLocation() {
        return mouseCurrentLocation;
    }
    public void setMouseCurrentLocation(Point3D mouseCurrentLocation) {
        this.setMousePrevLocation(this.mouseCurrentLocation);
        this.mouseCurrentLocation = mouseCurrentLocation;
    }     

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
    
    public Point3D getViewOffset() {
        return viewOffset;
    }

    public void setViewOffset(Point3D viewOffset) {
        this.viewOffset = viewOffset;
    }

    public int getScrollBarKnobSize() {
        return scrollBarKnobSize;
    }

    public void setScrollBarKnobSize(int scrollBarKnobSize) {
        this.scrollBarKnobSize = scrollBarKnobSize;
    }
    
    
    public void addShape(){
         
           if(Controller.inst().getState() == ControllerState.Circle){
               Circle c = new Circle(this.mousePressed, this.mousePressed, Model.inst().getSelectColor());
               Model.inst().addShape(c);
           }
           
           else if(Controller.inst().getState() == ControllerState.Ellipses){
               Ellipses c = new Ellipses(this.mousePressed, this.mousePressed, Model.inst().getSelectColor());
               Model.inst().addShape(c);
           }
           
           else if(Controller.inst().getState() == ControllerState.Line){
              //ds = processLine((Line3D) s);
               Line3D l = new Line3D(this.mousePressed, this.mousePressed, Model.inst().getSelectColor());
               Model.inst().addShape(l);
           } 
           
           else if(Controller.inst().getState() == ControllerState.Rectangle){
               Rectangle s = new Rectangle(this.mousePressed, this.mousePressed, Model.inst().getSelectColor());
               Model.inst().addShape(s);
           }
           
           else if(Controller.inst().getState() == ControllerState.Square){
               Square s = new Square(this.mousePressed, this.mousePressed, Model.inst().getSelectColor());
               Model.inst().addShape(s);
           }
           
           else if(Controller.inst().getState() == ControllerState.Triangle){
               int index = Model.inst().getShapeCount() - 1;//last shape in array
               boolean updateShape = false;
               boolean isTriangle =  false;
                       
               if(index >= 0){
                isTriangle = (Model.inst().getShape(index)instanceof Triangle);//Check to see if the last shape in the arrat is a triangle
                if(isTriangle){
                    updateShape = ((Triangle)Model.inst().getShape(index)).isThreeNull(); //If it is a triangle is the third point null                   
                }
               }
               
               if(isTriangle && updateShape){//If the shape is a triangle and if the this point is null the update the shape with  mousePressed
                this.updateTri();
               }

               else{
                Triangle t = new Triangle(this.mousePressed, Model.inst().getSelectColor());
                Model.inst().addShape(t);
               }
           }  
           
    }
    
    public void updateShape(){

            if(Controller.inst().getState() == ControllerState.Circle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Circle circle = new Circle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(circle, index);
           }
           
           else if(Controller.inst().getState() == ControllerState.Ellipses){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Ellipses e = new Ellipses(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(e, index);
           }
           
           else if(Controller.inst().getState() == ControllerState.Line){
              //ds = processLine((Line3D) s);
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Line3D l = new Line3D(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(l, index);
           } 
           
           else if(Controller.inst().getState() == ControllerState.Rectangle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Rectangle r = new Rectangle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(r, index);
           }
           
           else if(Controller.inst().getState() == ControllerState.Square){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Square s = new Square(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(s, index); 
           }
    }
    
     public void updateTri(){
        int index = Model.inst().getShapeCount() - 1;//last shape in array
        Triangle tri = (Triangle)Model.inst().getShape(index);
        if(tri.isTwoNull()){
            tri.setTwo(this.mousePressed);
         }
         else if(tri.isThreeNull()){
             tri.setThree(this.mousePressed);
         }
        Model.inst().setShape(tri, index);
     }
     
     public void selectShape(Point3D mouseLocation){
         Model.inst().check4ShapeClicked(mouseLocation);      
     }
     
     public ModAction getModActionFromShape(){
       int index = Model.inst().getIndexOfSelectedShape();
       if(index > -1){
       Shape shape = Model.inst().getShape(index);
       ModAction newModAction = shape.getModAction(this.getMouseDown());
      this.setModAction(newModAction);
        return newModAction;
        }
       return ModAction.NoAction;
     }
     
     public boolean modifyShape(){
       int index = Model.inst().getIndexOfSelectedShape();
       if(index > -1){
       Shape shape = Model.inst().getShape(index);
       boolean wasModified = shape.modifyShape(mousePrevLocation, mouseCurrentLocation, this.getModAction());
       Model.inst().setShape(shape, index);
       return wasModified;
        }
       return false;
     }
  }



