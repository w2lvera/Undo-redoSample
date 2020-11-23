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
public interface Activity {
    void getPointOne(Point2D p1);
    void getPointTwo(Point2D p1);
    void setModel(Model m);
    void execute();
    void unexecute();
    Activity clone();
}
