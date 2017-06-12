/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

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

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("br_ProjetoTopicos_war_1.0-SNAPSHOTPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Senha.findAll").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(br.entity.Senha senha) {
        EntityManager em = emf.createEntityManager();
        try {
            em.remove(senha);
        } finally {
            em.close();
        }
    }
}
