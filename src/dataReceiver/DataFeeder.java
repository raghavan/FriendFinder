package dataReceiver;

import exception.FriendFinderException;
import model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */


public interface DataFeeder {
//This interface can server to load data from any medium like console/manaul(hard coded)/database/files

    //To get the all users
    public String[] getUserNames()  throws FriendFinderException;

    //To get the relationship of a user
    public Set getFriends(User user) throws FriendFinderException ;

    //To get the input from user to find the relation between whom
    public String getFromAndToUserToFindRelationship() throws FriendFinderException;
}

