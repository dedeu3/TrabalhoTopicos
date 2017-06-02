/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotopicos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author giovanacgois
 */
@Embeddable
public class SenhaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pin")
    private short pin;

    public SenhaPK() {
    }

    public SenhaPK(int id, short pin) {
        this.id = id;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) pin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SenhaPK)) {
            return false;
        }
        SenhaPK other = (SenhaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.pin != other.pin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.projetotopicos.SenhaPK[ id=" + id + ", pin=" + pin + " ]";
    }
    
}
