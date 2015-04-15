package Squad_Fitness.Model;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

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
    private Boolean rememberMe;
    public static User currentUser;

    public User(){}

    public User (String strUsername, String strPassword, int intUserID, String strName, int intAge, String strSex,
                 int intWeight, String strEmail, Boolean rememberme)
    {
        username = strUsername;
        password = strPassword;
        userID = intUserID;
        name = strName;
        age = intAge;
        sex = strSex;
        weight = intWeight;
        email = strEmail;
        rememberMe = rememberme;

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
        rememberMe = reference.rememberMe;
    }



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

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public  Boolean getRememberMeFromPreferences()
    {
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
        return  preferences.getBoolean("rememberMe", false);
    }

    public void clearRememberMeFromPreferences()
    {
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
        preferences.putBoolean("rememberMe", false);
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String strUsername) {
        username = strUsername;
    }

    public void setPassword(String strPassword) {
        password = strPassword;
    }

    public void setUserID(int intUserID) {
        userID = intUserID;
    }

    public void setName(String strName) {
        name = strName;
    }

    public void setAge(int intAge) {
        age = intAge;
    }

    public void setSex(String strSex) {
        sex = strSex;
    }

    public void setWeight(int intWeight) {
        weight = intWeight;
    }

    public void setEmail(String strEmail) {
        email = strEmail;
    }

    public void setRemmemberMe(Boolean rememberMe) {
        rememberMe = rememberMe;
    }

    public static void clearUser() {
        currentUser = new User();
    }

    public void putUserInPreferences(User currentUser)
    {
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());

        preferences.put("Username", currentUser.username);
        preferences.put("Password", currentUser.password);
        preferences.putInt("UserID", currentUser.userID);
        preferences.put("Name", currentUser.name);
        preferences.putInt("Age", currentUser.age);
        preferences.put("Sex", currentUser.sex);
        preferences.putInt("Weight", currentUser.weight);
        preferences.put("Email", currentUser.email);
        preferences.putBoolean("rememberMe", currentUser.rememberMe);
    }

    public User getUserFromPreferences(User currentUser)
    {
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
        currentUser.username = preferences.get("Username", "");
        currentUser.password = preferences.get("Password", "");
        currentUser.userID =  preferences.getInt("UserID", 0);
        currentUser.name = preferences.get("Name", "");
        currentUser.age = preferences.getInt("Age", 0);
        currentUser.sex =  preferences.get("Sex", "");
        currentUser.weight = preferences.getInt("Weight", 0);
        currentUser.email = preferences.get("Email", "");
        currentUser.rememberMe = preferences.getBoolean("rememberMe", false);

        return currentUser;
    }

    public void clearUserPreferences(User currentUser) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
        preferences.clear();
    }
}
