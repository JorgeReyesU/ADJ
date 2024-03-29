/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Observaciones;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Accounts;
import modelo.Empleados;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author reyes
 */
public class EmpleadosJpaController implements Serializable {

    public EmpleadosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ADJPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleados) throws PreexistingEntityException, Exception {
        if (empleados.getObservacionesList() == null) {
            empleados.setObservacionesList(new ArrayList<Observaciones>());
        }
        if (empleados.getAccountsList() == null) {
            empleados.setAccountsList(new ArrayList<Accounts>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Observaciones> attachedObservacionesList = new ArrayList<Observaciones>();
            for (Observaciones observacionesListObservacionesToAttach : empleados.getObservacionesList()) {
                observacionesListObservacionesToAttach = em.getReference(observacionesListObservacionesToAttach.getClass(), observacionesListObservacionesToAttach.getObsCodigo());
                attachedObservacionesList.add(observacionesListObservacionesToAttach);
            }
            empleados.setObservacionesList(attachedObservacionesList);
            List<Accounts> attachedAccountsList = new ArrayList<Accounts>();
            for (Accounts accountsListAccountsToAttach : empleados.getAccountsList()) {
                accountsListAccountsToAttach = em.getReference(accountsListAccountsToAttach.getClass(), accountsListAccountsToAttach.getAccCod());
                attachedAccountsList.add(accountsListAccountsToAttach);
            }
            empleados.setAccountsList(attachedAccountsList);
            em.persist(empleados);
            for (Observaciones observacionesListObservaciones : empleados.getObservacionesList()) {
                Empleados oldEmpDniOfObservacionesListObservaciones = observacionesListObservaciones.getEmpDni();
                observacionesListObservaciones.setEmpDni(empleados);
                observacionesListObservaciones = em.merge(observacionesListObservaciones);
                if (oldEmpDniOfObservacionesListObservaciones != null) {
                    oldEmpDniOfObservacionesListObservaciones.getObservacionesList().remove(observacionesListObservaciones);
                    oldEmpDniOfObservacionesListObservaciones = em.merge(oldEmpDniOfObservacionesListObservaciones);
                }
            }
            for (Accounts accountsListAccounts : empleados.getAccountsList()) {
                Empleados oldEmpDniOfAccountsListAccounts = accountsListAccounts.getEmpDni();
                accountsListAccounts.setEmpDni(empleados);
                accountsListAccounts = em.merge(accountsListAccounts);
                if (oldEmpDniOfAccountsListAccounts != null) {
                    oldEmpDniOfAccountsListAccounts.getAccountsList().remove(accountsListAccounts);
                    oldEmpDniOfAccountsListAccounts = em.merge(oldEmpDniOfAccountsListAccounts);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleados(empleados.getEmpDni()) != null) {
                throw new PreexistingEntityException("Empleados " + empleados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getEmpDni());
            List<Observaciones> observacionesListOld = persistentEmpleados.getObservacionesList();
            List<Observaciones> observacionesListNew = empleados.getObservacionesList();
            List<Accounts> accountsListOld = persistentEmpleados.getAccountsList();
            List<Accounts> accountsListNew = empleados.getAccountsList();
            List<Observaciones> attachedObservacionesListNew = new ArrayList<Observaciones>();
            for (Observaciones observacionesListNewObservacionesToAttach : observacionesListNew) {
                observacionesListNewObservacionesToAttach = em.getReference(observacionesListNewObservacionesToAttach.getClass(), observacionesListNewObservacionesToAttach.getObsCodigo());
                attachedObservacionesListNew.add(observacionesListNewObservacionesToAttach);
            }
            observacionesListNew = attachedObservacionesListNew;
            empleados.setObservacionesList(observacionesListNew);
            List<Accounts> attachedAccountsListNew = new ArrayList<Accounts>();
            for (Accounts accountsListNewAccountsToAttach : accountsListNew) {
                accountsListNewAccountsToAttach = em.getReference(accountsListNewAccountsToAttach.getClass(), accountsListNewAccountsToAttach.getAccCod());
                attachedAccountsListNew.add(accountsListNewAccountsToAttach);
            }
            accountsListNew = attachedAccountsListNew;
            empleados.setAccountsList(accountsListNew);
            empleados = em.merge(empleados);
            for (Observaciones observacionesListOldObservaciones : observacionesListOld) {
                if (!observacionesListNew.contains(observacionesListOldObservaciones)) {
                    observacionesListOldObservaciones.setEmpDni(null);
                    observacionesListOldObservaciones = em.merge(observacionesListOldObservaciones);
                }
            }
            for (Observaciones observacionesListNewObservaciones : observacionesListNew) {
                if (!observacionesListOld.contains(observacionesListNewObservaciones)) {
                    Empleados oldEmpDniOfObservacionesListNewObservaciones = observacionesListNewObservaciones.getEmpDni();
                    observacionesListNewObservaciones.setEmpDni(empleados);
                    observacionesListNewObservaciones = em.merge(observacionesListNewObservaciones);
                    if (oldEmpDniOfObservacionesListNewObservaciones != null && !oldEmpDniOfObservacionesListNewObservaciones.equals(empleados)) {
                        oldEmpDniOfObservacionesListNewObservaciones.getObservacionesList().remove(observacionesListNewObservaciones);
                        oldEmpDniOfObservacionesListNewObservaciones = em.merge(oldEmpDniOfObservacionesListNewObservaciones);
                    }
                }
            }
            for (Accounts accountsListOldAccounts : accountsListOld) {
                if (!accountsListNew.contains(accountsListOldAccounts)) {
                    accountsListOldAccounts.setEmpDni(null);
                    accountsListOldAccounts = em.merge(accountsListOldAccounts);
                }
            }
            for (Accounts accountsListNewAccounts : accountsListNew) {
                if (!accountsListOld.contains(accountsListNewAccounts)) {
                    Empleados oldEmpDniOfAccountsListNewAccounts = accountsListNewAccounts.getEmpDni();
                    accountsListNewAccounts.setEmpDni(empleados);
                    accountsListNewAccounts = em.merge(accountsListNewAccounts);
                    if (oldEmpDniOfAccountsListNewAccounts != null && !oldEmpDniOfAccountsListNewAccounts.equals(empleados)) {
                        oldEmpDniOfAccountsListNewAccounts.getAccountsList().remove(accountsListNewAccounts);
                        oldEmpDniOfAccountsListNewAccounts = em.merge(oldEmpDniOfAccountsListNewAccounts);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getEmpDni();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getEmpDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            List<Observaciones> observacionesList = empleados.getObservacionesList();
            for (Observaciones observacionesListObservaciones : observacionesList) {
                observacionesListObservaciones.setEmpDni(null);
                observacionesListObservaciones = em.merge(observacionesListObservaciones);
            }
            List<Accounts> accountsList = empleados.getAccountsList();
            for (Accounts accountsListAccounts : accountsList) {
                accountsListAccounts.setEmpDni(null);
                accountsListAccounts = em.merge(accountsListAccounts);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
