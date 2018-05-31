package rain;

public class Driver {
    
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
       listDurations(musicDao);

       
       System.out.println("\n\nUpdating duration 1 - setting hours to 12");
       // TODO
       //
       // Modify the first Duration objects hours so that the value is 12 and
       // persist this value
       //
       // Redisplay all Duration objects to re-confirm that the change has been made
       
      
       
       durationOne.setHours(12);
       
       musicDao.updateDuration(durationOne);
       
       listDurations(musicDao);

       
       // TODO
       //
       // Delete the second Duration object and make the change permanent
       //
       // Redisplay all Duration objects to confirm the change has been made
       
       
       
       System.out.println("\n\nDeleting duration 2");
       
       musicDao.deleteDuration(durationTwo);
       
       listDurations(musicDao);
       
       musicDao.close();
    }
    
    
    private static final void listDurations(MusicDao musicDao) {
        System.out.println("List of retrieved Duration objects:");
        musicDao.getDurations().forEach(System.out::println);
    }
}
