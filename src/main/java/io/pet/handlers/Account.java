/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.handlers;

import co.paralleluniverse.fibers.Suspendable;
import io.vertx.ext.web.RoutingContext;

/**
 *
 * @author Anala
 */
public class Account {
    
    public Account(){}
    
    public boolean validateCreate(String p1, String p2, String username){
        return p1.equals(p2) && p1.length() >= 7;
    }
    
    @Suspendable
    public void createUser(RoutingContext ctx){
        var body = ctx.getBodyAsJson();
        var p1 = body.getString("password");
        var p2 = body.getString("password_confirm");
        var username = body.getString("username");
        if(!validateCreate(p1,p2,username))
            ctx.fail(400);
    }
}
