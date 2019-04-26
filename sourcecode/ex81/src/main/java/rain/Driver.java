package rain;

import org.hibernate.*;
import util.HibernateUtil;


public class Driver {
    
        
    /**
     * Open a Hibernate session, and create our Music Data Access Object
     */
    public Driver() {
        super();
    }

    /**
     * @param args
     */

    public static void main(String[] args) {
        
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.getCurrentSession();

       
    	

        // TODO
    	//
    	// Create a Duration object of length 0 hours 3 minutes 51 seconds
    	

    	// TODO
    	//
    	// Create a Track with title "Seven Nation Army" and composer
    	// J. White and duration defined by the duration object created above

    	
    	// TODO
    	//
    	// Save the Track and Duration objects
    	//
    	// Hint: Remember the save should be inside a transaction
        

    	
    	// TODO
    	//
    	// Retrieve the ID from the track
    	// This will be used to read the track later
    	
    	
    	// TODO
    	//
    	// Display the Track information
    
    	
    	// TODO
    	//
    	// Set the track reference to null to clear any reference to it
    	
        
        
        System.out.println("\nNow about to read from database and show results\n");

        
        // TODO
        //
        // Now read the Track you just persisted from the database and display it
        // to the console
        
        
  
       sessionFactory.close();
        
        
    }
}