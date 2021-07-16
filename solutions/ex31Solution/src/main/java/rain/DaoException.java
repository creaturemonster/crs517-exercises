package rain;

/**
 *  Exception for the rainforest data access objects (DAO)
 *
 *  @author 517 Development Team
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 *  Constructs an exception with null as the error message.
	 */
	public DaoException() {
	}

	/**
	 *  Constructs an exception with the specified detail message.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Constructs a new throwable with the specified detail message and cause.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new throwable with the specified cause and a detail message. <br>
	 * The detailed message is: (cause==null ? null : cause.toString()). <br>
	 * Which typically contains the class and detail message of cause.
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

}