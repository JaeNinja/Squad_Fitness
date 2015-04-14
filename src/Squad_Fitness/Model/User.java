package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
//Changes
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

    public User (User reference) {
        userName = reference.userName;
        password = reference.password;
        UserID = reference.UserID;
        FName = reference.FName;
        LName = reference.LName;
        Age = reference.Age;
        Gender = reference.Gender;
        Weight = reference.Weight;
        EMail = reference.EMail;
    }


}
