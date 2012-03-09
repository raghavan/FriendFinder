package dataReceiver;

import common.FriendFinderConstants;
import exception.FriendFinderException;
import exception.ImproperDataFeed;
import friendFinder.FriendFinder;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class ConsoleData implements DataFeeder {

    //This suffices to get data through console to load user names
    public String[] getUserNames() throws FriendFinderException{
        List<String> userNames = new ArrayList<String>();
        System.out.print("Enter all user names: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userName = null;
        do {
            try {
                System.out.println("If you would like to continue pre 'y' else press 'n' ");
                userName = br.readLine();
            } catch (IOException ioe) {
                throw new ImproperDataFeed(FriendFinderConstants.IMPROPER_DATA_FEED);
            }
            userNames.add(userName);
        } while (userName.equalsIgnoreCase("y"));
        return (String[]) userNames.toArray();
    }

    public Set getFriends(User user) {
        return null;  //Can be implemented such a way to get data from console
    }

    public String getFromAndToUserToFindRelationship() throws FriendFinderException {
        try {
            System.out.println("Get relationship between(give space and type names): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String userName = br.readLine();
            return userName;
        } catch (IOException ioe) {
            throw new ImproperDataFeed(FriendFinderConstants.IMPROPER_DATA_FEED);
        }
    }
}
