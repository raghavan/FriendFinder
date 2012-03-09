package exception;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class UserDoesNotExist extends FriendFinderException{
    public UserDoesNotExist(String message) {
        super(message);
    }
}
