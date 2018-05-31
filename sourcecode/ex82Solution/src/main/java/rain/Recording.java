package rain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *  This class represents a Recording.  It describes the recording
 *  title, price, category, imageName and duration.  <p>
 *
 *  Subclasses must implement the method <code>getDuration()</code> to
 *  return the total duration for the recording.
 *
 *  @author 570 Development Team
 */


/*
 * 
 * TODO
 * 
 * Annotate this class as an Entity class
 * 
 * Map the inheritance strategy as Joined
 * 
 */



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Recording extends Product implements Comparable<Recording> {

	private static final long serialVersionUID = 1L;

    //
    //  DATA MEMBERS
    //

	
	/*
	 * 
	 * TODO
	 * 
	 * Annotate this field as the primary key field
	 * Use the key generation strategy Auto
	 * 
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	
    /**
     *  The recording title
     */
    private String title;

    /**
     *  The recording price
     */
    private double price;

    /**
     *  The recording category
     */
    private String category;

    /**
     *  The recording image name
     */
    private String imageName;

    /**
     *  The recording id
     */


    /**
     *  The quantity of stock on hand
     */
    private int stockCount;


    //
    //  CONSTRUCTORS
    //

    /**
     *  Basic default constructor
     */
    public Recording() {
        // default constructor
    }


    /**
     *  Constructs a recording w/ given parameter values
     */
    public Recording(String theTitle, double thePrice,
                     String theCategory, String theImageName) {

        title = theTitle;
        price = thePrice;
        category = theCategory;
        imageName = theImageName;
    }


    /**
     *  Constructs a recording w/ given parameter values
     */
    public Recording(String theTitle, double thePrice,
                     String theCategory, String theImageName,
                     int theStockCount) {

        this(theTitle, thePrice, theCategory, theImageName);

        stockCount = theStockCount;
    }



    //
    //  ABSTRACT METHOD(S)
    //

    /**
     *  Returns the recording duration.  Subclasses must
     *  override this method to return the total duration.
     */
    public abstract Duration getDuration();

    //
    //  GETTER / SETTER METHODS
    //

    /**
     *  Returns the recording title
     */
    public String getTitle() {
        return title;
    }

    /**
     *  Sets the recording title
     */
    public void setTitle(String theTitle) {
        title = theTitle;
    }


    /**
     *  Returns the recording price
     */
    public double getPrice() {
        return price;
    }

    /**
     *  Sets the recording price
     */
    public void setPrice(double thePrice) {
        price = thePrice;
    }


    /**
     *  Returns the recording category
     */
    public String getCategory() {
        return category;
    }

    /**
     *  Sets the recording category
     */
    public void setCategory(String theCategory) {
        category = theCategory;
    }


    /**
     *  Returns the recording image name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     *  Sets the recording image name
     */
    public void setImageName(String theImageName) {
        imageName = theImageName;
    }

    /**
     *  Returns the recording id.
     */
    public int getId() {
        return id;
    }

    /**
     *  Sets the recording id
     */
    public void setId(int theRecordingId) {
        id = theRecordingId;
    }

    /**
     *  Returns the name of the product
     */
    public String getName() {
        return toString();
    }

    /**
     *  Sets the name / title
     */
    public void setName(String theName) {
        setTitle(theName);
    }

    /**
     *  Returns the stock count - quantity on hand
     */
    public int getStockCount() {
        return stockCount;
    }

    /**
     *  Sets the stock count
     */
    public void setStockCount(int theCount) {
        stockCount  = theCount;
    }

    /**
     *  Returns true if the product is in stock
     */
    public boolean isInStock() {
        return stockCount > 0;
    }

    /**
     *  Allow us to sort the recordings by title
     */
    public int compareTo(Recording object) {

        Recording recording = (Recording) object;
        String targetTitle = recording.getTitle();

        return title.compareTo(targetTitle);
    }

}