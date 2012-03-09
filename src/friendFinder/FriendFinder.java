package friendFinder;

import common.FriendFinderConstants;
import dataReceiver.ConsoleData;
import dataReceiver.DataFeeder;
import dataReceiver.ManualData;
import exception.FriendFinderException;
import exception.ImproperDataFeed;
import exception.RelationshipDoesnotExist;
import model.FriendsMap;
import model.RelationshipPath;
import model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 * Program : In a social network, given any two names the shortest connection
 * path between those two will be stated,if the connection exists.
 */


public class FriendFinder {
    public static void main(String args[]) {

        try {

            getAllUsers();

            makeFriendConnections();

            String userName = getWhoseLinkToBeFound();

            //The relationship will be tracked between these two users
            String fromUser = null, toUser = null;
            if (userName != null && userName.split(" ").length == 2 &&
                    !userName.split(" ")[0].equalsIgnoreCase(userName.split(" ")[1])) {
                //Assigning the first user as from user
                fromUser = userName.split(" ")[0];
                //To assign the second mentioned user as to user
                toUser = userName.split(" ")[1];
            }else{
                throw new ImproperDataFeed(FriendFinderConstants.IMPROPER_DATA_FEED);
            }

            RelationshipTracer relationshipTracer = new RelationshipTracer();
            //This returns all possible paths between from and to user
            List<RelationshipPath> relationshipPathList = relationshipTracer.findRelationshipPaths(fromUser, toUser);

            RelationshipPath shortestPath = detectShortestPath(relationshipPathList);
            printPath(shortestPath);
        } catch (FriendFinderException fFE) {
            System.out.println(fFE.getMessage());
        }
    }

    //To print any given path
    private static void printPath(RelationshipPath shortestPath) throws RelationshipDoesnotExist {
        if (shortestPath != null) {
            System.out.println("Shortest Path :" + shortestPath.path());
        } else {
            throw new RelationshipDoesnotExist(FriendFinderConstants.Relationship_DOES_NOT_EXIST);
        }
    }

    //From all possible paths this returns the shortest network path between from and to user
    private static RelationshipPath detectShortestPath(List<RelationshipPath> relationshipPaths) {
        RelationshipPath shortestPath = null;
        for (RelationshipPath path : relationshipPaths) {
            System.out.println("one possible path " + path.path());
            if (shortestPath == null) {
                shortestPath = path;
            } else {
                if (path.length() < shortestPath.length()) {
                    shortestPath = path;
                }
            }
        }
        return shortestPath;
    }

   //To know between whom the relationship should be found
    private static String getWhoseLinkToBeFound() throws FriendFinderException {
        DataFeeder dataFeederFromConsole = new ConsoleData();
        String userName = dataFeederFromConsole.getFromAndToUserToFindRelationship();
        return userName;
    }

    //All available users are read through and added in the friendsMap
    private static void getAllUsers() throws FriendFinderException {
        DataFeeder dataFeeder = new ManualData();
        String[] userNames = dataFeeder.getUserNames();
        for (String userName : userNames) {
            User user = new User(userName);
            FriendsMap.setFriendConnectionsMap(user, new HashSet<User>());
        }
    }

    //Friend connections of each user is obtained through this api
    private static void makeFriendConnections() throws FriendFinderException {
        DataFeeder dataFeeder = new ManualData();
        for (User user : FriendsMap.getUsers()) {
            Set<String> userConnectionNames = dataFeeder.getFriends(user);
            if (userConnectionNames != null) {
                for (String friendName : userConnectionNames) {
                    User friend = FriendsMap.getUser(friendName);
                    if (friend != null) {
                        if(!user.getFriends().add(friend)){
                            System.out.println(user+" already friend with "+ friend);
                        }
                        FriendsMap.getFriendConnectionsMap(user).add(user);
                    }else{
                        
                    }
                }
            }
        }
    }


}
