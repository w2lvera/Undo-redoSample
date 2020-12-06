/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model.activity;

import com.vera.mvc.model.Model;
import com.vera.mvc.model.MyShape;
import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public class Move implements Activity{
    Model model;
    Point2D[] p;
    MyShape shapeNew;
    MyShape shapeOld;
    
    public Move(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public Move() {
        p = new Point2D[2];
    }
    
   
    @Override
    public void getPointOne(Point2D p1){
         p[0] = p1;
         shapeNew = model.findShape(p[0]);
         if(shapeNew!=null)shapeOld = shapeNew.clone();

    }
    
    @Override
    public void getPointTwo(Point2D p1){
        p[1] = p1;
        model.moveShape(p);
    }
    
    @Override
    public void execute() {
        Point2D oldP[] = new Point2D[2];
        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());
        oldP[1] = new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());
        shapeOld = shapeNew.clone();
        model.reseverMove(shapeNew, oldP);
    }

    @Override
    public void unexecute() {
        Point2D oldP[] = new Point2D[2];
        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());
        oldP[1] = new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());
        shapeOld = shapeNew.clone();
        model.reseverMove(shapeNew, oldP);
    }

    @Override 
    public Activity clone() {
       Move d = new Move(model);
        d.shapeNew = shapeNew;
        d.shapeOld = shapeOld;
        d.p = p;
        return d;
    }

    @Override
    public void setModel(Model m) {
        model = m;
    }
    
}
