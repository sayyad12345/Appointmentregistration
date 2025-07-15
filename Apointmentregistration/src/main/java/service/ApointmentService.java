package service;
import entity.ApointmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import app.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class ApointmentService {
	 private final EntityManagerFactory emf;

	    public ApointmentService() {
	        this.emf = HibernateUtil.getEntityManagerFactory();
	    }

	    // Create
	    public void createApointment(String firstName, String lastName, String email, Date aptDate) {
	        EntityTransaction transaction = null;
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            transaction = entityManager.getTransaction();
	            transaction.begin();
	            ApointmentEntity apointment = new ApointmentEntity();
	            apointment.setFirstName(firstName);
	            apointment.setLastName(lastName);
	            apointment.setEmail(email);
	            apointment.setAptDate(aptDate);
	            entityManager.persist(apointment);
	            transaction.commit();
	            System.out.println("Created employee with ID: " + apointment.getApt_id());
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    // Read by ID
	    public ApointmentEntity findApointment(int id) {
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            return entityManager.find(ApointmentEntity.class, id);
	        } finally {
	            entityManager.close();
	        }
	    }

	    // Read all
	    public List<ApointmentEntity> findAllApointments() {
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            TypedQuery<ApointmentEntity> query = entityManager.createQuery("FROM apointmentEntity", ApointmentEntity.class);
	            return query.getResultList();
	        } finally {
	            entityManager.close();
	        }
	    }

	    // Update
	    public void updateApointment(int id, String firstName, String lastName, String address, Date aptDate) {
	        EntityTransaction transaction = null;
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            transaction = entityManager.getTransaction();
	            transaction.begin();
	            ApointmentEntity apointment = entityManager.find(ApointmentEntity.class, id);
	            if (apointment != null) {
	                apointment.setFirstName(firstName);
	                apointment.setLastName(lastName);
	                apointment.setEmail(address);
	                apointment.setAptDate(aptDate);
	                entityManager.merge(apointment);
	                transaction.commit();
	                System.out.println("Updated apointment with ID: " + id);
	            } else {
	                System.out.println("apointment with ID " + id + " not found");
	            }
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    // Delete
	    public void deleteApointment(int id) {
	        EntityTransaction transaction = null;
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            transaction = entityManager.getTransaction();
	            transaction.begin();
	            ApointmentEntity apointment = entityManager.find(ApointmentEntity.class, id);
	            if (apointment != null) {
	                entityManager.remove(apointment);
	                transaction.commit();
	                System.out.println("Deleted apointment ID: " + id);
	            } else {
	                System.out.println("apointment  ID " + id + " not found");
	            }
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    // Shutdown
	    public void shutdown() {
	        HibernateUtil.shutDown();
	    }

		
			
		}

		
		


