package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Raghavan
 */
public class RelationshipPath {

/*Finds the relationship path from one to another
     and also helps to check if the desired from and to relationship is present
*/     

    private RelationshipPath prevPath = null;
    private Set<User> userset = new HashSet<User>();
    private boolean validPath = false;

         public RelationshipPath() {
			this.prevPath = prevPath;
		}

		public RelationshipPath(RelationshipPath prevPath) {
			this.prevPath = prevPath;
		}


		public int length() {
			if (prevPath != null) {
				return prevPath.length() + userset.size();
			} else {
				return userset.size();
			}
		}

		public String path() {
			StringBuffer sb = new StringBuffer();
			if (prevPath != null) {
				sb.append(prevPath.path());

			}

			for (User user : userset) {
				sb.append(user.getUserName() + "-->");
			}
			return sb.toString();

		}

		public boolean contains(User user) {
			if (prevPath != null) {
				if (prevPath.contains(user) == true) {
					return true;
				}
			}
			return userset.contains(user);
		}

    public RelationshipPath getPrevPath() {
        return prevPath;
    }

    public void setPrevPath(RelationshipPath prevPath) {
        this.prevPath = prevPath;
    }

    public Set<User> getUserset() {
        return userset;
    }

    public void setUserset(Set<User> userset) {
        this.userset = userset;
    }

    public boolean isValidPath() {
        return validPath;
    }

    public void setValidPath(boolean validPath) {
        this.validPath = validPath;
    }
}
