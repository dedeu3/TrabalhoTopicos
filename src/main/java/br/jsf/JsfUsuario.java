/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.entity.Senha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author giovanacgois
 */
@ManagedBean
@RequestScoped
public class JsfUsuario {
    private Integer id;
    private String nomecompleto;
    private String email;
    private short pin;
    private String datanascimento;
    private String atrib1, atrib2, atrib3;
    private Senha senha;

    /**
     * Creates a new instance of Usuario
     */
    public JsfUsuario() {
    }

     public java.util.Collection<br.entity.Usuario> getAll() {
        return new br.crud.CrudUsuario().getAll();
    }

    public void salvar() {
        br.entity.Usuario usuario = new br.entity.Usuario();
        usuario.setNomecompleto(nomecompleto);
        usuario.setPin(pin);
        usuario.setEmail(email);
        usuario.setDatanascimento(datanascimento);
        usuario.setAtrib1(atrib1);
        usuario.setAtrib2(atrib2);
        usuario.setAtrib3(atrib3);
        new br.crud.CrudSenha().persist(senha);
    }

    public void remove(br.entity.Usuario usuario) {
        new br.crud.CrudUsuario().remove(usuario);
    }

    public void update(br.entity.Usuario usuario) {
        this.nomecompleto=usuario.getNomecompleto();
        this.email=usuario.getEmail();
        this.atrib1=usuario.getAtrib1();
    }
}
   
