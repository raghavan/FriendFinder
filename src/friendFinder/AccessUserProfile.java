package friendFinder;

import common.FriendFinderConstants;
import exception.FriendFinderException;
import exception.UserDoesNotExist;
import model.FriendsMap;
import model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */

//This serves to access the details present in the user profile
public class AccessUserProfile {


    //This helps to create user from a given name
    public User createUser(String name){
        User user = new User(name);
        return user;
    }

    //This helps to make users from a given list of names
    public Set<User> createUser(Set<String> userConnectionsNames) {
        Set<User> userConnections = new HashSet<User>();
        for(String userConnectionName : userConnectionsNames){
            userConnections.add(new User(userConnectionName));
        }
        return userConnections;
    }

    //To find a user based on his name
    public User getUser(String name) throws FriendFinderException{
        Set<User> users = FriendsMap.getUsers();
        if(users == null){
            throw new UserDoesNotExist(FriendFinderConstants.USER_DOES_NOT_EXIST);
        }
        for(User  user : users){
            if(user.getUserName().equalsIgnoreCase(name)){
                return user;
            }
        }
        throw new UserDoesNotExist(FriendFinderConstants.USER_DOES_NOT_EXIST);
    }
  
}
