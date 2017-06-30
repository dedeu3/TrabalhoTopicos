/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entity;

import br.crud.CrudUsuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNomecompleto", query = "SELECT u FROM Usuario u WHERE u.nomecompleto = :nomecompleto")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByPin", query = "SELECT u FROM Usuario u WHERE u.pin = :pin")
    , @NamedQuery(name = "Usuario.findByDatanascimento", query = "SELECT u FROM Usuario u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Usuario.findByAtrib1", query = "SELECT u FROM Usuario u WHERE u.atrib1 = :atrib1")
    , @NamedQuery(name = "Usuario.findByAtrib2", query = "SELECT u FROM Usuario u WHERE u.atrib2 = :atrib2")
    , @NamedQuery(name = "Usuario.validar", query = "SELECT u FROM Usuario u WHERE u.email = :email and u.pin = :pin")
    , @NamedQuery(name = "Usuario.findByAtrib3", query = "SELECT u FROM Usuario u WHERE u.atrib3 = :atrib3")})
public class Usuario implements Serializable {

    public Usuario(Integer id, String nomecompleto, String email, short pin, String datanascimento, String atrib1, String atrib2, String atrib3, Senha senha) {
        this.id = id;
        this.nomecompleto = nomecompleto;
        this.email = email;
        this.pin = pin;
        this.datanascimento = datanascimento;
        this.atrib1 = atrib1;
        this.atrib2 = atrib2;
        this.atrib3 = atrib3;
        this.senha = senha;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomecompleto")
    private String nomecompleto;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pin")
    private short pin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "datanascimento")
    private String datanascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "atrib1")
    private String atrib1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "atrib2")
    private String atrib2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "atrib3")
    private String atrib3;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Senha senha;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nomecompleto, String email, short pin, String datanascimento, String atrib1, String atrib2, String atrib3) {
        this.id = id;
        this.nomecompleto = nomecompleto;
        this.email = email;
        this.pin = pin;
        this.datanascimento = datanascimento;
        this.atrib1 = atrib1;
        this.atrib2 = atrib2;
        this.atrib3 = atrib3;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.projetotopicos.Usuario[ id=" + id + " ]";
    }
    
    
}