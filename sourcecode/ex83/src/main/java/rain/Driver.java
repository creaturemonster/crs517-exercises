package rain;

import org.hibernate.*;
import util.HibernateUtil;
import java.util.List;
import java.util.ArrayList;


public class Driver {

    public static void main(String[] args) {

    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



     	// TODO
    	//
    	// Create a MusicRecording object.
    	// Hint. Use the createRecording method below


    	// TODO Save the MusicRecording
    	//
    	// Hint. Do not forget the transaction



    	// TODO Retrieve the MusicRecording id - it will be used in retrieving the recording

        System.out.println("\nPersisted MusicRecording :\n");


        // TODO
        //
        // Display the MusicRecording to the console



        // TODO
        //
        // Set the MusicRecording reference to null


        // TODO
        //
        // Read in the MusicRecording from the database

        System.out.println("\nRead MusicRecording from database. Value is :\n");


        // TODO
        //
        // Display the MusicRecording to the console





        HibernateUtil.getSessionFactory().close();


    }

    /**
     * Add some persistent MusicRecording objects
     */
    private static MusicRecording createRecording() {

        List<Track> tracks;

        tracks = new ArrayList<Track>();
        tracks.add(new Track("Seven Nation Army", "J. White", new Duration(0, 3, 51)));
        tracks.add(new Track("Black Math", "J. White", new Duration(0, 3, 3)));
        tracks.add(new Track("There's No Home For You Here", "J. White", new Duration(0, 3, 43)));
        tracks.add(new Track("I Just Don't Know What To Do With Myself", "B. Bacharach and H. David", new Duration(0, 2, 46)));
        tracks.add(new Track("In The Cold, Cold Night", "J. White", new Duration(0, 2, 58)));
        tracks.add(new Track("I Want To Be The Boy To Warm Your Mother's Heart", "J. White", new Duration(0, 3, 20)));
        tracks.add(new Track("You've Got Her In Your Pocket", "J. White", new Duration(0, 3, 39)));
        tracks.add(new Track("Ball And Biscuit", "J. White", new Duration(0, 7, 19)));
        tracks.add(new Track("The Hardest Button To Button", "J. White", new Duration(0, 3, 32)));
        tracks.add(new Track("Little Acorns", "J. White", new Duration(0, 4, 9)));
        tracks.add(new Track("Hypnotize", "J. White", new Duration(0, 1, 48)));
        tracks.add(new Track("The Air Near My Fingers", "J. White", new Duration(0, 3, 40)));
        tracks.add(new Track("Girl, You Have No Faith In Medicine", "J. White", new Duration(0, 3, 17)));
        tracks.add(new Track("Well It's True That We Love One Another", "J. White", new Duration(0, 2, 42)));

        MusicRecording musicRecording = new MusicRecording("Elephant", 10.99, "Lo-fi/Garage",
                "", 100, "EMI", "The White Stripes", tracks);


        return musicRecording;

    }


}