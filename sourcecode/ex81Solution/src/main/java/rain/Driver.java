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

        Transaction transaction = session.beginTransaction();

        // TODO
    	//
    	// Create a Duration object of length 0 hours 3 minutes 51 seconds
    	
        
        Duration duration = new Duration(0, 3, 51);

    	// TODO
    	//
    	// Create a Track with title "Seven Nation Army" and composer
    	// J. White and duration defined by the duration object created above
        
        
        Track track = new Track("Seven Nation Army", "J. White", duration);        

        
        
    	// TODO
    	//
    	// Save the Track and Duration objects
    	//
    	// Hint: Remember the save should be inside a transaction
        
        session.save(track);
        
        transaction.commit();

        
    	// TODO
    	//
    	// Retrieve the ID from the track
    	// This will be used to read the track later
       
        
        int id = track.getId();   // Retrieve Track id

        
        
    	// TODO
    	//
    	// Display the Track information
    
        
        System.out.println(track);
        
    	// TODO
    	//
    	// Set the track reference to null to clear any reference to it

        track = null;
        
        
        System.out.println("\nNow about to read from database and show results\n");
        
        // TODO
        //
        // Now read the Track you just persisted from the database and display it
        // to the console
        
        
        
        session = sessionFactory.getCurrentSession();

        transaction = session.beginTransaction();
        
        track = (Track)session.get(Track.class, id);
        
        transaction.commit();
        
        System.out.println(track);


        sessionFactory.close();
  
        
        
    }
}