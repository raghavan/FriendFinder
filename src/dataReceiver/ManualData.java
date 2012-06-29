package dataReceiver;

import common.FriendFinderConstants;
import exception.FriendFinderException;
import exception.RelationshipDoesnotExist;
import model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class ManualData implements DataFeeder {

    //This contains all hard coded usernames
    String userNames[] = {FriendFinderConstants.NAME_ADAM,FriendFinderConstants.NAME_BOB,FriendFinderConstants.NAME_CHAI,
    FriendFinderConstants.NAME_DIVYA,FriendFinderConstants.NAME_DODO,FriendFinderConstants.NAME_FRUSTU,
    FriendFinderConstants.NAME_GANDU,FriendFinderConstants.NAME_RANI};
  
    String adamsFriends[] = {FriendFinderConstants.NAME_BOB,FriendFinderConstants.NAME_CHAI};
    String bobsFriends[] = {FriendFinderConstants.NAME_FRUSTU,FriendFinderConstants.NAME_GANDU,
            FriendFinderConstants.NAME_ADAM};
    String chaisfrens[] = {FriendFinderConstants.NAME_DODO,FriendFinderConstants.NAME_GANDU,
            FriendFinderConstants.NAME_ADAM};
    String dodosfrens[] = {FriendFinderConstants.NAME_CHAI,FriendFinderConstants.NAME_RANI};
    String divyasfrens[] = {FriendFinderConstants.NAME_FRUSTU,FriendFinderConstants.NAME_GANDU,
            FriendFinderConstants.NAME_RANI};
    String frustussfriends[] = {FriendFinderConstants.NAME_BOB,FriendFinderConstants.NAME_DIVYA};
    String gandusfrens[] = {FriendFinderConstants.NAME_BOB,FriendFinderConstants.NAME_DIVYA,FriendFinderConstants.NAME_CHAI};
    String ranisfrens[] = {FriendFinderConstants.NAME_DODO,FriendFinderConstants.NAME_DIVYA};

    public String[] getUserNames() {
        return userNames;
    }

    // This provides all relationships for a given user
    public Set getFriends(User user) throws FriendFinderException {

        if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_ADAM)) {
            return new HashSet(Arrays.asList(adamsFriends));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_BOB)) {
            return new HashSet(Arrays.asList(bobsFriends));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_CHAI)) {
            return new HashSet(Arrays.asList(chaisfrens));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_DODO)) {
            return new HashSet(Arrays.asList(dodosfrens));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_DIVYA)) {
            return new HashSet(Arrays.asList(divyasfrens));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_FRUSTU)) {
            return new HashSet(Arrays.asList(frustussfriends));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_GANDU)) {
            return new HashSet(Arrays.asList(gandusfrens));
        } else if (user.getUserName().equalsIgnoreCase(FriendFinderConstants.NAME_RANI)) {
            return new HashSet(Arrays.asList(ranisfrens));
        } else {
            return null;
        }
    }

    public String getFromAndToUserToFindRelationship() throws FriendFinderException {
        return null;
    }
}
