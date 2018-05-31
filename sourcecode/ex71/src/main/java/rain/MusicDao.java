package rain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;


public class MusicDao {

	private SessionFactory sessionFactory=null;
    
    public MusicDao() {
        super();
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    
    /**
     * Store object via Hibernate
     */
    public void saveDuration(Duration duration) {

    	// TODO
    	//
    	// Obtain a Transaction from the current hibernate Session
    
    	
    	
    	
    	// TODO
    	//
    	// Save the duration object
    	
    	
    	
    	// TODO
    	//
    	// Commit the save operation
    	
    }

    
    /**
     * Single object selector - returns Duration instance
     * 
     * @param id primary key of Duration
     * @return selected Duration 
     */
    public Duration getDuration(int id){
    	Session session = sessionFactory.getCurrentSession();
    	Transaction transaction = session.beginTransaction();

    	// TODO
    	//
    	// Get the duration object that has the id defined by the method parameter
    	
    	Duration duration = /* Your code here */ ;
    	
        transaction.commit();
        return duration;        
    }
    
    
    /**
     * Returns a list of all the stored Duration objects via an HQL query
     */
    public List<Duration> getDurations() {
    	Session session = sessionFactory.getCurrentSession();
    	Transaction transaction = session.beginTransaction();
    	
    	// TODO 
    	//
    	// Complete the statement that will load all Duration objects from the database
    	
        Query query = session.createQuery(/* Your code here */ );
        
        List result = query.list();
        
        transaction.commit();
     
        return result;        
    }
    

    
    
    // TODO
    //
    // Read through the methods below and make sure you understand what they do
    //
    
    
    /**
     * Updates duration object stored in database
     */
    public void updateDuration(Duration duration){
    	Session session = sessionFactory.getCurrentSession();
    	Transaction transaction = session.beginTransaction();
    	session.update(duration);
    	transaction.commit();
    }

    
    /**
     * Deletes duration object from database
     */
     public void deleteDuration(Duration duration){
     	Session session = sessionFactory.getCurrentSession();
     	Transaction transaction = session.beginTransaction();
    	session.delete(duration);
    	transaction.commit();
    }

     
    public void close(){
    	sessionFactory.close();
    }
}
