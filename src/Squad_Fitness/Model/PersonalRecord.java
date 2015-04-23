package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class PersonalRecord {

    int personalRecordID;
    String prType;
    int prInt;
    int Exercise;
    String userName;

    public PersonalRecord(int personalrecordid, String prtype, int print, int exercise, String username){
        personalRecordID = personalrecordid;
        prType = prtype;
        prInt = print;
        Exercise = exercise;
        userName = username;
    }

    public int getPersonalRecordID()
    {
        return personalRecordID;
    }

    public void setPersonalRecordID(int newPersonalRecordID)
    {
        personalRecordID = newPersonalRecordID;
    }

    public String getPrType()
    {
        return prType;
    }

    public void setPrType(String PRType)
    {
        prType = PRType;
    }

    public int getExercise()
    {
        return Exercise;
    }

    public void setExercise(int exercise)
    {
        Exercise = exercise;
    }

    public String getUsername()
    {
        return userName;
    }

    public void setUsername(String username)
    {
        userName = username;
    }

    public int getPrInt()
    {
        return prInt;
    }

    public void setPrInt(int PRInt)
    {
        prInt = PRInt;
    }
}
