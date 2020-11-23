/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.menu;

import com.vera.mvc.Controller.State;
import com.vera.mvc.model.MyShape;

/**
 *
 * @author Wera
 */
public class SwitchFill implements Command{
    State state;
    MyShape.FillBehavior fb;

    public SwitchFill(State state, MyShape.FillBehavior fb) {
        this.state = state;
        this.fb = fb;
    }
    
    @Override
    public void execute() {
        state.setFb(fb);
    }
    
}
