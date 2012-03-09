package exception;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class FriendFinderException extends Exception{
    //Deriving a newer exception to make Friend Finder application specific exceptions
    public FriendFinderException(String message) {
        super(message);
    }
}
