package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class LivroDAO extends GenericDAO<Livro>{
    
    @Override
    public void save(Livro livro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(livro);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Livro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Livro l", Livro.class);
        List<Livro> livros = q.getResultList();
        em.close();
        return livros;
    }

    @Override
    public void delete(Livro livro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        livro = em.getReference(Livro.class, livro.getId());
        tx.begin();
        em.remove(livro);
        tx.commit();
    }
    
    @Override
    public void update(Livro livro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(livro);
        tx.commit();
        em.close();
    }

    @Override
    public Livro get(Long id) {
        EntityManager em = this.getEntityManager();
        Livro livro = em.find(Livro.class, id);
        em.close();
        return livro;
    }
}