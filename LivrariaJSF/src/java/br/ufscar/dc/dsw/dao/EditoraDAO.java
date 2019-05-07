package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Editora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class EditoraDAO extends GenericDAO<Editora> {

    @Override
    public void save(Editora editora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(editora);
        tx.commit();
        em.close();
    }

    @Override
    public List<Editora> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Editora e", Editora.class);
        List<Editora> editoras = q.getResultList();
        em.close();
        return editoras;
    }

    @Override
    public void delete(Editora editora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        editora = em.getReference(Editora.class, editora.getId());
        tx.begin();
        em.remove(editora);
        tx.commit();
    }

    @Override
    public void update(Editora editora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(editora);
        tx.commit();
        em.close();
    }

    @Override
    public Editora get(Long id) {
        EntityManager em = this.getEntityManager();
        Editora editora = em.find(Editora.class, id);
        em.close();
        return editora;
    }
}