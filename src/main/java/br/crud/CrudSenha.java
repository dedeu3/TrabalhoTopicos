/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import br.cripto.Criptografador;
import br.cripto.pwGenerator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giovanacgois
 */
public class CrudSenha {    

    private static EntityManager em;
    private static final String PU = "br_ProjetoTopicos_war_1.0-SNAPSHOTPU";

    public static EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

    public void persist(Object object) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public java.util.Collection<br.entity.Senha> getAll() {
        EntityManager em = this.getEntityManager();
        try {
            return em.createNamedQuery("Senha.findAll").getResultList();
        } catch (Exception e) {
            return null;
        } 
    }

    public void remove(br.entity.Senha senha) {
        EntityManager em = this.getEntityManager();
        try {
            em.remove(senha);
        } finally {
            em.close();
        }
    }

}
