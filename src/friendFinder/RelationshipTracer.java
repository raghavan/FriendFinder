package friendFinder;

import common.FriendFinderConstants;
import exception.ImproperDataFeed;
import model.FriendsMap;
import model.RelationshipPath;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */

public class RelationshipTracer {

    public List<RelationshipPath> findRelationshipPaths(String fromUser, String toUser) throws ImproperDataFeed {
        List<RelationshipPath> relationshipPaths = new ArrayList<RelationshipPath>();
        RelationshipPath rpath = new RelationshipPath();
        RelationshipTracer relationshipTracer = new RelationshipTracer();
        if (fromUser != null && toUser != null &&
                FriendsMap.getUser(fromUser) != null && FriendsMap.getUser(toUser) != null) {
            relationshipTracer.findShortestNetwork(FriendsMap.getUser(fromUser), FriendsMap.getUser(toUser), rpath, relationshipPaths);
        } else if (fromUser == null || toUser == null) {
            throw new ImproperDataFeed(FriendFinderConstants.IMPROPER_DATA_FEED);
        } else if (FriendsMap.getUser(fromUser) == null || FriendsMap.getUser(toUser) == null) {
            throw new ImproperDataFeed(FriendFinderConstants.NO_FRIENDS_EXIST);
        }
        return relationshipPaths;
    }


//A recursive approach to traverse through the friend networks and note down the valid paths

    private void findShortestNetwork(User source, User dest,
                                     RelationshipPath path, List<RelationshipPath> availablePaths) {
        path.getUserset().add(source);
        System.out.print("cur :" + source + " -->");
        if (source.getFriends().contains(dest)) {
            path.getUserset().add(dest);
            path.setValidPath(true);
            availablePaths.add(path);
            System.out.println("dest :" + dest);

        } else {
            for (User user : source.getFriends()) {
                if (path.contains(user)) {
                    continue;
                }
                //recursion is applied here
                findShortestNetwork(user, dest, new RelationshipPath(path), availablePaths);
            }
        }

    }
}
