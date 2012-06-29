package model;

import common.FriendFinderConstants;
import exception.FriendFinderException;
import exception.UserDoesNotExist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class User {

    //A user profile to maintain all user details and check if this user traversed through 

    private String userName;
    private Set<User> friends = new HashSet<User>();


    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return userName;
    }
}
