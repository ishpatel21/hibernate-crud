package com.example.hibernatecrud.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.hibernatecrud.config.SessionFactoryConfig;

@Service
public class CrudService {

	@Value("${entityPackage}")
	String entityPackage;
	
	public Object saveOrUpdate(String entityName, Object obj) {
        Session session = SessionFactoryConfig.sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
        	Object id = session.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(obj);
    		Object o = null;
    		if(id != null) {
    			o = session.merge(obj);
    		}else {
    			o = session.save(obj);
    		}
    		session.getTransaction().commit();	
            return o;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public Object read(String entityName, long id) {
    	Class<?> clasz = getClass(entityName);
        if(clasz == null) return null;
        Session session = SessionFactoryConfig.sf.openSession();
       
        try {
            Object obj = session.get(clasz, id);
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);	
        } finally {
            session.close();
        }
    }

    public void delete(String entityName, long id) {
    	Class<?> clasz = getClass(entityName);
        if(clasz == null) return;
        
        Session session = SessionFactoryConfig.sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object obj = session.find(clasz, id);
            session.delete(obj);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }
    
    private Class<?> getClass(String entityName){
    	Class<?> clasz = null;
		try {
			clasz = Class.forName(entityPackage + "." + entityName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clasz;
    }
}
