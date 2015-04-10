package Squad_Fitness.Model;

import java.sql.ResultSet;

/**
 * Created by Kyle on 3/16/2015.
 */
//Changes
public class User {

    public String userName;
    public String password;
    public int UserID;
    public String FullName;
    public int Age;
    public String Gender;
    public int Weight;
    public String EMail;

    public User(){}

    public User (String username, String strPassword, int userid, String fullname, int age, String gender,
                 int weight, String email)
    {
        userName = username;
        password = strPassword;
        UserID = userid;
        FullName = fullname;
        Age = age;
        Gender = gender;
        Weight = weight;
        EMail = email;

    }

    public User (ResultSet userFromDataBase)
    {
        try
        {
            userFromDataBase.beforeFirst();
            if(userFromDataBase.next()) {
                userName = userFromDataBase.getString("username");;
                password = userFromDataBase.getString("password");;
                UserID = userFromDataBase.getInt("UserID");;
                FullName = userFromDataBase.getString("name");;
                Age = userFromDataBase.getInt("age");;
                Gender = userFromDataBase.getString("sex");;
                Weight = userFromDataBase.getInt("weight");;
                EMail = userFromDataBase.getString("email");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
