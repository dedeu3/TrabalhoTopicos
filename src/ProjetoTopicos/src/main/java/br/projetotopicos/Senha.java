/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotopicos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "senha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senha.findAll", query = "SELECT s FROM Senha s")
    , @NamedQuery(name = "Senha.findById", query = "SELECT s FROM Senha s WHERE s.senhaPK.id = :id")
    , @NamedQuery(name = "Senha.findByPin", query = "SELECT s FROM Senha s WHERE s.senhaPK.pin = :pin")
    , @NamedQuery(name = "Senha.findByDescricao", query = "SELECT s FROM Senha s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Senha.findBySenha", query = "SELECT s FROM Senha s WHERE s.senha = :senha")})
public class Senha implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SenhaPK senhaPK;
    @Size(max = 20)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 20)
    @Column(name = "senha")
    private String senha;
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "pin", referencedColumnName = "pin", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario;

    public Senha() {
    }

    public Senha(SenhaPK senhaPK) {
        this.senhaPK = senhaPK;
    }

    public Senha(int id, short pin) {
        this.senhaPK = new SenhaPK(id, pin);
    }

    public SenhaPK getSenhaPK() {
        return senhaPK;
    }

    public void setSenhaPK(SenhaPK senhaPK) {
        this.senhaPK = senhaPK;
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
        hash += (senhaPK != null ? senhaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Senha)) {
            return false;
        }
        Senha other = (Senha) object;
        if ((this.senhaPK == null && other.senhaPK != null) || (this.senhaPK != null && !this.senhaPK.equals(other.senhaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.projetotopicos.Senha[ senhaPK=" + senhaPK + " ]";
    }
    
}
