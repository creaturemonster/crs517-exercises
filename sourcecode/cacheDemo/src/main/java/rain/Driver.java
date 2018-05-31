package rain;

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

      
       MusicDao musicDao = new MusicDao();

       // TODO
       //
       // Create a Duration object with values 10 hours, 20 minutes 30 seconds 
       // and save this object
       
       
       Duration durationOne = new Duration(10,20,30);
       
       System.out.println("Saving duration 1");
       
       musicDao.saveDuration(durationOne);

       

       // TODO
       //
       // Create a second Duration with values of 11 hours, 21 minutes 31 seconds 
       // and save this object
       
       Duration durationTwo = new Duration(11,21,31);

       System.out.println("Saving duration 2");
       
       musicDao.saveDuration(durationTwo);
 

       // TODO
       //
       // List the Duration objects
       
       
       
       durationOne = musicDao.getDuration(1);
       durationOne = musicDao.getDuration(1);
       
 
       musicDao.close();
       
    }


}