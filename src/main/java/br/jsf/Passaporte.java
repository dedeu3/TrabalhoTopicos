/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author giovanacgois
 */
@Named(value = "passaporte")
@SessionScoped
public class Passaporte implements Serializable {

    private br.entity.Usuario user = new br.entity.Usuario();
    /**
     * Creates a new instance of Passaporte
     */
    public Passaporte() {
        
        
    }

    public br.entity.Usuario getUser() {
        return user;
    }

    public void setUser(br.entity.Usuario id) {
        this.user = id;
    }
    
}
