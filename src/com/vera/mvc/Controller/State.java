/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.Controller;


import com.vera.mvc.model.Activity;
import com.vera.mvc.model.Model;
import com.vera.mvc.model.MyShape;
import java.awt.Color;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class State {
   //from controller 
   Model model;
   // menu created 
   MyShape shape;
   Color color;
   MyShape.FillBehavior fb;
   RectangularShape rectangularShape;
   Activity activity;

    public void setActivity(Activity.ActivityBehavior activity) {
        this.activity.setAb(activity);
    }

    public Activity getActivity() {
        return activity;
    }

    public State(Model model) {
        this.model = model;
        activity = new Activity(model);
        activity.setAb(Activity.ActivityBehavior.DRAW);
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
        shape.setColor(color);
        model.setSampleShape(shape);
    }

    public void setFb(MyShape.FillBehavior fb) {
        this.fb = fb;
        shape.setFb(fb);
        model.setSampleShape(shape);
    }

    public void setRectangularShape(RectangularShape rectangularShape) {
        this.rectangularShape = rectangularShape;
        shape.setShape(rectangularShape);
        model.setSampleShape(shape);
    }

    public MyShape getShape() {
        return shape;
    }
    
    
}
