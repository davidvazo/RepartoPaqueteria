package mx.trillas.ControlEnvio.persistence.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mx.trillas.ControlEnvio.persistence.HibernateUtil;
import mx.trillas.ControlEnvio.persistence.dao.DestinatarioDAO;
import mx.trillas.ControlEnvio.persistence.pojos.Destinatario;
public class DestinatarioDAODBImpl implements DestinatarioDAO {

	@Override
	public void altaDestinatario(Destinatario destinatario) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(destinatario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Destinatario getDestinatarioByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Destinatario destinatario = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Destinatario.class);
			criteria.add(Restrictions.and(Restrictions.eq("nombre", nombre)));
			Object destinatarioObj = criteria.uniqueResult();
			if (destinatarioObj != null && destinatarioObj instanceof Destinatario) {
				destinatario = (Destinatario) destinatarioObj;
				HibernateUtil.initializeObject(destinatario.getDepartamento()); 
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return destinatario;
	}
}	
