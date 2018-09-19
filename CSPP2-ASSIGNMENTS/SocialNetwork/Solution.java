import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for social network.
 */
class User {
	private String username;
	private List<String> friends;
	/**
	 * Constructs the object.
	 */
	User() {
		//Empty.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      name  The name
	 */
	User(final String name, final String[] friend) {
		this.username = name;
		friends = new List<String>();
		for (int i = 0; i < friend.length; i++) {
			friends.add(friend[i]);
		}
	}
	/**
	 * Gets the user name.
	 *
	 * @return     The user name.
	 */
	public String getUserName() {
		return this.username;
	}
	/**
	 * Sets the user name.
	 *
	 * @param      name1  The name 1
	 */
	public void setUserName(final String name1) {
		this.username = name1;
	}
	public List<String> getFriends() {
		return this.friends;
	}
	public void setFriends(final List<String> friends1) {
		this.friends = friends1;
	}
}
/**
 * Class for social network.
 */
class SocialNetwork {
	private List<User> users;
	/**
	 * Constructs the object.
	 */
	SocialNetwork() {
		users = new List<User>();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void addConnections(final String user, final String friend) {
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i).getUserName())) {
				users.get(i).getFriends().add(friend);
			}
		}
	}
	public List<String> getConnections(final String user) {
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i).getUserName())) {
				return users.get(i).getFriends();
			}
		}
        System.out.println("Not a user in Network");
		return null;
	}
	public List<String> getCommonConnections(final String userA, final String userB) {
		List<String> common = new List<String>();
		List<String> friendsA = getConnections(userA);
		List<String> friendsB = getConnections(userB);
		if (friendsA != null && friendsB != null) {
			for (int i = 0; i < friendsA.size(); i++) {
				if (friendsB.contains(friendsA.get(i))) {
					common.add(friendsA.get(i));
				}
			}
		}
		return common;
	}
    public String toString() {
        String[] keys = new String[users.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = users.get(i).getUserName();
        }
        Arrays.sort(keys);
        String str = "";
        int i = 0;
        for (i = 0; i < keys.length - 1; i++) {
            str += keys[i] + ":" + getConnections(keys[i]) + ", ";
        }
        str += keys[i] + ":" + getConnections(keys[i]);
        return str;
    }
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Empty.
	}
	/**
	 * {Main method}
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int x = Integer.parseInt(input[1]);
        SocialNetwork sn = new SocialNetwork();
        while (x != 0) {
            String[] options = scan.nextLine().split(" is connected to ");
            String[] friends = options[1].replace(".","").split(", ");
            sn.addUser(new User(options[0], friends));
            x--;
        }
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "addConnections":
					sn.addConnections(tokens[1],tokens[2]);
				break;
				case "getConnections":
                    if (sn.getConnections(tokens[1]) != null) {
                        System.out.println(sn.getConnections(tokens[1]));
                    }
				break;
				case "CommonConnections":
                    System.out.println(sn.getCommonConnections(tokens[1],tokens[2]));
				break;
                case "Network":
                    System.out.println(sn);
                break;
			}
		}
	}
}