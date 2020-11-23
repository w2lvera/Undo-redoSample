/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Wera
 */
public class Model extends Observable {

    MyShape currentShape = null;
    MyShape sampleShape;
    ArrayList<MyShape> list;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public Model() {
        list = new ArrayList<>();
    }

    public Model(MyShape sampleShape) {
        this.sampleShape = sampleShape;
        list = new ArrayList<>();
    }

    public MyShape inintCurrentShape() {
        currentShape = sampleShape.clone();
        list.add(currentShape);
        return currentShape;
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        if (list != null) {
            for (MyShape s : list) {
                s.draw(g);
            }
        }
    }

    public MyShape findShape(Point2D p1) {
        if (list != null) {
            for (MyShape s : list) {
                if (s.contains(p1)) {
                    currentShape = s;
                    return currentShape;
                };
            }
        }
        return null;
    }

    public void moveShape(Point2D[] p) {
        double deltaX = p[0].getX() - p[1].getX();
        double deltaY = p[0].getY() - p[1].getY();
        if (currentShape != null) {
            RectangularShape s = currentShape.getShape();
            double xMin = s.getMinX() - deltaX;
            double yMin = s.getMinY() - deltaY;
            double xMax = s.getMaxX() - deltaX;
            double yMax = s.getMaxY() - deltaY;
            s.setFrameFromDiagonal(xMin, yMin, xMax, yMax);
            p[0] = p[1];
            setChanged();
            notifyObservers();
        }
    }

    ///////////////////////undo/////////////////////////
    public MyShape ctrlZ_Shape() {
        MyShape s = list.remove(list.size() - 1);
        setChanged();
        notifyObservers();
        return s;
    }

    public void setActiveShape(MyShape activeShape) {
        this.currentShape = activeShape;
        list.add(currentShape);
        setChanged();
        notifyObservers();
    }

    public void reseverMove(MyShape shapeNew, Point2D[] oldP) {
        shapeNew.setFrame(oldP);
        currentShape = shapeNew;
        setChanged();
        notifyObservers();
    }

}
