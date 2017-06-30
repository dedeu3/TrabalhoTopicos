/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.cripto.Criptografador;
import br.cripto.pwGenerator;
import br.crud.CrudSenha;
import br.entity.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 * @author giovanacgois
 */
@ManagedBean
@SessionScoped
public class JsfSenha {
     private Integer id;
     private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
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

    public void salvar(int id) throws Exception {
        br.entity.Senha pwd;
        pwd = new br.entity.Senha();
        pwd.setId(id);
        pwd.setDescricao(descricao);
        br.entity.Usuario user = new br.entity.Usuario();
        user = this.recuperaUsuario(id);     
        System.out.println("-----atributos do usuário: " + user.getAtrib1() + user.getAtrib2() + user.getAtrib3()); 
        pwGenerator pwGen = new  pwGenerator(user.getAtrib1(), user.getAtrib2(), user.getAtrib3(), user.getPin());
        //Criptografador aes = new Criptografador("lv39eptlvuhaqqsr");;;;;
        String s = pwGen.generateNew();
        /*String senhaCriptografada = aes.encrypt(senha);
        String senhaDescriptografada = aes.decrypt(senhaCriptografada);*/
        pwd.setSenha(s);
        new br.crud.CrudUsuario().persist(pwd);
    }

    public void remove(br.entity.Senha senha) {
        new br.crud.CrudSenha().remove(senha);
    }

    public void update(br.entity.Senha senha) {
        this.descricao = senha.getDescricao();
    }
    
public Usuario recuperaUsuario(int id)
{
      EntityManager em = new br.crud.CrudUsuario().getEntityManager();
        br.entity.Usuario user = new br.entity.Usuario();
        user = (Usuario) em.createNamedQuery("Usuario.findById")
                .setParameter("id", id)
                .getSingleResult();
        return user;
}


}


