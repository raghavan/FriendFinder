package model;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class FriendsMap {

    //A map between user and all his connections
    private static Map<User, Set<User>> friendConnectionsMap = new HashMap<User, Set<User>>();

    public static Set<User> getUsers() {
        return friendConnectionsMap.keySet();
    }

    public static Set<User> getFriendConnectionsMap(User user) {
        return friendConnectionsMap.get(user);
    }

    public static void setFriendConnectionsMap(User user,Set<User> friendsToBeAdded){
        if(friendConnectionsMap.get(user) != null){
            updateUserConnection(user, friendsToBeAdded);
        }else{
            addNewUserConnection(user, friendsToBeAdded);
        }

    }

     private static void addNewUserConnection(User user, Set<User> friendsToBeAdded) {
        friendConnectionsMap.put(user,friendsToBeAdded);
    }

    private static void updateUserConnection(User user, Set<User> friendsToBeAdded) {
        Set<User> userConnections = friendConnectionsMap.get(user);
        userConnections.addAll(friendsToBeAdded);
    }

    public static User getUser(String userName){
        for(User user : friendConnectionsMap.keySet()){
           if(user.getUserName().equalsIgnoreCase(userName)){
               return user;
           }
        }
        return null;
    }


}
