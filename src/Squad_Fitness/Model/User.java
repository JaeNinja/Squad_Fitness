package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class User {

    String userName;
    String password;
    int UserID;
    String FName;
    String LName;
    int Age;
    String Gender;
    int Weight;
    String EMail;

    public User(){}

    public User (String username, String strPassword, int userid, String fname, String lname, int age, String gender,
                 int weight, String email)
    {
        userName = username;
        password = strPassword;
        UserID = userid;
        FName = fname;
        LName = lname;
        Age = age;
        Gender = gender;
        Weight = weight;
        EMail = email;

    }


}
