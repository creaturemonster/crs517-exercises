package rain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;


/**
 *  DAO implementation built using Hibernate
 *
 *  @author 517 Development Team
 */


public class HibernateVideoDao implements VideoDao {





	public List<Category> getVideoCategories() throws DAOException {
	        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();

	    	Transaction transaction = hibernateSession.beginTransaction();
	        
	    	Query<Category> query = 
		    	hibernateSession.createQuery("from rain.Category", Category.class);

	    	List<Category> categories = query.list();
	    	
	    	transaction.commit();
	    	
   	
	        return categories;        
		
	}

	
	
	
	public List<VideoRecording> getVideoRecordings(String theCategory)throws DAOException{
		return getVideoRecordings(theCategory, VideoDao.SORT_BY_TITLE);
	}

	
	public List<VideoRecording> getVideoRecordings(String theCategory,
			int sortBy) throws DAOException {

        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();

    	Transaction transaction = hibernateSession.beginTransaction();

    	//  TODO
    	//
    	// Complete the steps below:

    	// Declare a Query object and initialize it to retrieve all
    	// VideoRecording objects for a specified category
    	//
    	// HINT:  Use the named query: "VideoRecording.byCategory"
    	
    	
    	Query<VideoRecording> query = 
    		hibernateSession.createNamedQuery("VideoRecording.byCategory", VideoRecording.class);
    	
    	// TODO
    	//
    	// On the query, set the named parameter, "theCategory"

    	query.setParameter("theCategory", theCategory);
    	
       	// TODO
    	//
    	// Execute the named query
    	//
 
    	
		List<VideoRecording> videos = query.list();
    	
    	transaction.commit();
    	
    	// TODO
    	//
    	// Modify the statement below to return the List of VideoRecordings your
    	// query returned
    	
        return videos;        
	}

	
	
	public VideoRecording getVideoRecording(String theRecordingId)
			throws DAOException {
		int recordingId =0;
		try{
			recordingId = Integer.parseInt(theRecordingId);
		}catch(NumberFormatException e){
			
		}
		return this.getVideoRecording(recordingId);
	}

	public VideoRecording getVideoRecording(int recordingId)
			throws DAOException {

        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();

    	Transaction transaction = hibernateSession.beginTransaction();
        
    	// TODO
    	//
    	// Note how your named query is used below
    	//
    	// In particular, take note of how we return the single object
    	//

    	Query<VideoRecording> query = 
    		hibernateSession.createNamedQuery("VideoRecording.Recording", VideoRecording.class);
    	
    	query.setParameter("theRecordingId", recordingId);
    	
    	VideoRecording recording = query.uniqueResult();
    	
    	transaction.commit();
    	
    	
        return recording;        
		

	}


}
