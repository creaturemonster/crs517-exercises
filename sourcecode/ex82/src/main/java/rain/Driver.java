package rain;

import org.hibernate.*;
import util.HibernateUtil;


public class Driver {
    public static void main(String[] args) {

    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        MusicRecording musicRecording = new MusicRecording("Elephant", 10.99, "Lo-fi/Garage",
                "", 100, "EMI", "The White Stripes", null);


        // TODO
        //
        // Save the MusicRecording
        session.save(musicRecording);



        // TODO
        //
        // Complete the transaction
        // 
        transaction.commit();
        
    	// TODO
    	//
    	// Retrieve the ID from the MusicRecording
    	// This will be used to read the MusicRecording later
        int id=musicRecording.getId();
        
        
        //
        // Display the MusicRecording to the console
        System.out.println(musicRecording);


        // TODO
        //
        // Set the MusicRecording reference to null
        //
        musicRecording=null;

        // TODO
        // Read the MusicRecording from the database and display it
        // to the console
        System.out.println(musicRecording);



        HibernateUtil.getSessionFactory().close();
    }

}