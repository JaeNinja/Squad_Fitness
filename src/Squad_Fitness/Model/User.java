package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
//Changes
public class User {

    private String username;
    private String password;
    private int userID;
    private String name;
    private int age;
    private String sex;
    private int weight;
    private String email;

    public User(){}

    public User (String strUsername, String strPassword, int intUserID, String strName, int intAge, String strSex,
                 int intWeight, String strEmail)
    {
        username = strUsername;
        password = strPassword;
        userID = intUserID;
        name = strName;
        age = intAge;
        sex = strSex;
        weight = intWeight;
        email = strEmail;

    }

    public User (User reference) {
        username = reference.username;
        password = reference.password;
        userID = reference.userID;
        name = reference.name;
        age = reference.age;
        sex = reference.sex;
        weight = reference.weight;
        email = reference.email;
    }

    public static User currentUser;
    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User user) {
        currentUser = user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }

    public String getEmail() {
        return email;
    }
}
