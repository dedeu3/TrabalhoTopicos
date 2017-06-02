/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotopicos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author giovanacgois
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.id = :id")
    , @NamedQuery(name = "Usuario.findByPin", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.pin = :pin")
    , @NamedQuery(name = "Usuario.findByNomecompleto", query = "SELECT u FROM Usuario u WHERE u.nomecompleto = :nomecompleto")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByDatanascimento", query = "SELECT u FROM Usuario u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Usuario.findByAtrib1", query = "SELECT u FROM Usuario u WHERE u.atrib1 = :atrib1")
    , @NamedQuery(name = "Usuario.findByAtrib2", query = "SELECT u FROM Usuario u WHERE u.atrib2 = :atrib2")
    , @NamedQuery(name = "Usuario.findByAtrib3", query = "SELECT u FROM Usuario u WHERE u.atrib3 = :atrib3")})
public class Usuario implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Senha senha;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Size(max = 50)
    @Column(name = "nomecompleto")
    private String nomecompleto;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "datanascimento")
    private String datanascimento;
    @Size(max = 20)
    @Column(name = "atrib1")
    private String atrib1;
    @Size(max = 20)
    @Column(name = "atrib2")
    private String atrib2;
    @Size(max = 20)
    @Column(name = "atrib3")
    private String atrib3;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(int id, short pin) {
        this.usuarioPK = new UsuarioPK(id, pin);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.projetotopicos.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }
    
}
