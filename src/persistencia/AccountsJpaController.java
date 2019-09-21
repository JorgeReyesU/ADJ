/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Accounts;
import modelo.Empleados;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author reyes
 */
public class AccountsJpaController implements Serializable {

    public AccountsJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ADJPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Accounts accounts) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empDni = accounts.getEmpDni();
            if (empDni != null) {
                empDni = em.getReference(empDni.getClass(), empDni.getEmpDni());
                accounts.setEmpDni(empDni);
            }
            em.persist(accounts);
            if (empDni != null) {
                empDni.getAccountsList().add(accounts);
                empDni = em.merge(empDni);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accounts accounts) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accounts persistentAccounts = em.find(Accounts.class, accounts.getAccCod());
            Empleados empDniOld = persistentAccounts.getEmpDni();
            Empleados empDniNew = accounts.getEmpDni();
            if (empDniNew != null) {
                empDniNew = em.getReference(empDniNew.getClass(), empDniNew.getEmpDni());
                accounts.setEmpDni(empDniNew);
            }
            accounts = em.merge(accounts);
            if (empDniOld != null && !empDniOld.equals(empDniNew)) {
                empDniOld.getAccountsList().remove(accounts);
                empDniOld = em.merge(empDniOld);
            }
            if (empDniNew != null && !empDniNew.equals(empDniOld)) {
                empDniNew.getAccountsList().add(accounts);
                empDniNew = em.merge(empDniNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = accounts.getAccCod();
                if (findAccounts(id) == null) {
                    throw new NonexistentEntityException("The accounts with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accounts accounts;
            try {
                accounts = em.getReference(Accounts.class, id);
                accounts.getAccCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accounts with id " + id + " no longer exists.", enfe);
            }
            Empleados empDni = accounts.getEmpDni();
            if (empDni != null) {
                empDni.getAccountsList().remove(accounts);
                empDni = em.merge(empDni);
            }
            em.remove(accounts);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Accounts> findAccountsEntities() {
        return findAccountsEntities(true, -1, -1);
    }

    public List<Accounts> findAccountsEntities(int maxResults, int firstResult) {
        return findAccountsEntities(false, maxResults, firstResult);
    }

    private List<Accounts> findAccountsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accounts.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Accounts findAccounts(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Accounts.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accounts> rt = cq.from(Accounts.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
