/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.crud.CrudUsuario;
import br.entity.Senha;
import br.entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author giovanacgois
 */
@ManagedBean
@SessionScoped
public class JsfUsuario implements Serializable {

    private Integer id;
    private String nomecompleto;
    private String email;
    private short pin;
    private String datanascimento;
    private String atrib1, atrib2, atrib3;
    private Senha senha;
    private boolean entrar = false;
    private boolean novo = false;

    /**
     * Creates a new instance of Usuario
     */
    public JsfUsuario() {
    }

    public java.util.Collection<br.entity.Usuario> getAll() {
        return new br.crud.CrudUsuario().getAll();
    }

    public void salvar() {
        br.entity.Usuario usuario;
        usuario = new br.entity.Usuario();
        usuario.setNomecompleto(nomecompleto);
        usuario.setPin(pin);
        usuario.setEmail(email);
        usuario.setDatanascimento(datanascimento);
        usuario.setAtrib1(atrib1);
        usuario.setAtrib2(atrib2);
        usuario.setAtrib3(atrib3);
        new br.crud.CrudUsuario().persist(usuario);
    }

    public void remove(br.entity.Usuario usuario) {
        new br.crud.CrudUsuario().remove(usuario);
    }

    public void update(br.entity.Usuario usuario) {
        this.nomecompleto = usuario.getNomecompleto();
        this.email = usuario.getEmail();
        this.atrib1 = usuario.getAtrib1();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getAtrib1() {
        return atrib1;
    }

    public void setAtrib1(String atrib1) {
        this.atrib1 = atrib1;
    }

    public String getAtrib2() {
        return atrib2;
    }

    public void setAtrib2(String atrib2) {
        this.atrib2 = atrib2;
    }

    public String getAtrib3() {
        return atrib3;
    }

    public void setAtrib3(String atrib3) {
        this.atrib3 = atrib3;
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }

    public boolean isEntrar() {
        return entrar;
    }

    public void setEntrar(boolean entrar) {
        this.entrar = entrar;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public Usuario usuarioExiste() {
        EntityManager em = br.crud.CrudSenha.getEntityManager();
        Usuario user = (Usuario) em.createNamedQuery("Usuario.validar")
                .setParameter("email", this.email)
                .setParameter("pin", this.pin)
                .getSingleResult();
        return user;
    }

    public void login() throws IOException {
        br.entity.Usuario user = new br.entity.Usuario();
        user = this.usuarioExiste();
        
        this.id = user.getId();
        if (this.id != 0) {
            Passaporte ativo = new br.jsf.Passaporte();
            ativo.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("home.xhtml");
            System.out.println("\n\n\n\n---------- id =" + this.id);
        }
    }
}
