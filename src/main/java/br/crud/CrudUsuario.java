/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import br.entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giovanacgois
 */
public class CrudUsuario {
    
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

    public java.util.Collection<br.entity.Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        try {
            return em.createNamedQuery("Usuario.findAll").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(br.entity.Usuario usuario) {
        EntityManager em = this.getEntityManager();
        try {
            em.remove(usuario);
        } finally {
            em.close();
        }
    }

    public boolean temCadastro(String email, String pin) {
        EntityManager em = this.getEntityManager();

        em.createNamedQuery("Usuario.buscaPorEmail", Usuario.class)
                .setParameter("email", email)
                .getSingleResult();
        return true;
    }
}
    