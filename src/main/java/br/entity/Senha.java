/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entity;

import br.cripto.Criptografador;
import br.cripto.pwGenerator;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "senha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senha.findAll", query = "SELECT s FROM Senha s")
    , @NamedQuery(name = "Senha.findById", query = "SELECT s FROM Senha s WHERE s.id = :id")
    , @NamedQuery(name = "Senha.findByDescricao", query = "SELECT s FROM Senha s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Senha.findBySenha", query = "SELECT s FROM Senha s WHERE s.senha = :senha")})
public class Senha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Senha(Integer id, String descricao, String senha, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.senha = senha;
      //  this.usuario = usuario;
    }
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Senha() {
    }

    public Senha(Integer id) {
        this.id = id;
    }

    public Senha(Integer id, String descricao, String senha) {
        this.id = id;
        this.descricao = descricao;
        this.senha = senha;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Senha)) {
            return false;
        }
        Senha other = (Senha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.projetotopicos.Senha[ id=" + id + " ]";
    }
    
   
}
