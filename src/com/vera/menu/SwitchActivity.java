/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.menu;

import com.vera.mvc.Controller.State;
import com.vera.mvc.model.activity.Activity;



/**
 *
 * @author Wera
 */
public class SwitchActivity implements Command{
   State state;
   Activity activity;

    public SwitchActivity(State state, Activity activity) {
        this.state = state;
        this.activity = activity;
    }

    @Override
    public void execute() {
        state.setActivity(activity);
    }
}
