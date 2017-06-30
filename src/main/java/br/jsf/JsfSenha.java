/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.entity.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author giovanacgois
 */
@ManagedBean
@RequestScoped
public class JsfSenha {
     private Integer id;
     private String descricao;
     private String senha;
     private Usuario usuario;

    /**
     * Creates a new instance of Senha
     */
    public JsfSenha() {
    }
    
    public java.util.Collection<br.entity.Senha> getAll() {
        return new br.crud.CrudSenha().getAll();
    }

    public void salvar() {
        br.entity.Senha senha = new br.entity.Senha();
        senha.setUsuario(usuario);
        senha.setDescricao(descricao);
        senha.setSenha(String.valueOf(senha));
        new br.crud.CrudSenha().persist(senha);
    }

    public void remove(br.entity.Senha senha) {
        new br.crud.CrudSenha().remove(senha);
    }

    public void update(br.entity.Senha senha) {
        this.descricao = senha.getDescricao();
    }
}
