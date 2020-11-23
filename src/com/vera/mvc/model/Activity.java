/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public class Activity {
    Model model;
    Point2D[] p;
    MyShape myShape;
    ActivityBehavior ab;

    public Activity(Model model) {
        this.model = model;
        p = new Point2D[2];
        ab = ActivityBehavior.DRAW;
    }

    public void setAb(Activity.ActivityBehavior activity) {
        ab = activity;
    }
    public void getPointOne(Point2D p1){
        ab.getPointOne(p1, p, model);
    }
    public void getPointTwo(Point2D p1){
        ab.getPointTwo(p1, p, model);
    }
    //////////////////////////////////////////////////
    public enum ActivityBehavior {
        DRAW {
            @Override
            public void getPointOne(Point2D p1, Point2D[] p, Model model) {
                p[0] = p1;
                myShape =model.inintCurrentShape();
            }

            @Override
            public void getPointTwo(Point2D p1, Point2D[] p, Model model) {
                p[1] = p1;
                model.changeShape(p);
            }

            @Override
            public void execute(Model model,MyShape s) {
                model.setActiveShape(s);
            }

            @Override
            public void unexecute(Model model,MyShape s) {
                model.ctrlZ_Shape();
            }

            @Override
            public Activity clone() {
                
            }

        },
        MOVE {
            @Override
            public void getPointOne(Point2D p1, Point2D[] p, Model model) {
                p[0] = p1;
                model.findShape(p1);
            }

            @Override
            public void getPointTwo(Point2D p1, Point2D[] p, Model model) {
                p[1] = p1;
                model.moveShape(p);
            }

            @Override
            public void execute(Model model,MyShape s) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void unexecute(Model model,MyShape s) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Activity clone() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        public abstract void getPointOne(Point2D p1, Point2D[] p, Model model);

        public abstract void getPointTwo(Point2D p1, Point2D[] p, Model model);
        public abstract void execute(Model model,MyShape s);
        public abstract void unexecute(Model model,MyShape s);

        public abstract Activity clone();


    }
}
