package rain;

import java.util.List;

import org.hibernate.SessionFactory;



/**
 *  DAO implementation built using Hibernate
 *
 *  @author 517 Development Team
 */




public class HibernateSpringVideoDao  implements VideoDao {


	private SessionFactory sessionFactory;
	
	
	
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	public List<Category> getVideoCategories() throws DAOException {

		// TODO
		//
		// Execute the HQL "from rain.Category" and return the result
		//
	

		return null;
	    	
	}

	
	
	
	public List<VideoRecording> getVideoRecordings(String theCategory)throws DAOException{
		return getVideoRecordings(theCategory, VideoDao.SORT_BY_TITLE);
	}

	
	public List<VideoRecording> getVideoRecordings(String theCategory,
			int sortBy) throws DAOException {
		// TODO
		//
		// Notice how we execute the Named Query with a name parameter using HQL
		//


    	return sessionFactory.getCurrentSession()
    			.createNamedQuery("VideoRecording.byCategory", VideoRecording.class)
    			.setParameter("theCategory", theCategory)
    			.list();
		
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

		// TODO
		//
		// Notice how we execute the Named Query with a named parameter using HQL
		// and return the result

		return sessionFactory.getCurrentSession()
				.createNamedQuery("VideoRecording.Recording", VideoRecording.class)
				.setParameter("theRecordingId", recordingId)
				.uniqueResult();
	}


}
