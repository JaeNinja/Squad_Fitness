package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class PersonalRecord {

    //Idk what the purpose of this class is.
    int personalRecordID;
    String prType;
    int prInt;
    int exercisE;
    String userName;

    public PersonalRecord(int personalrecordid, String prtype, int print, int exercise, String username){
        personalRecordID = personalrecordid;
        prType = prtype;
        prInt = print;
        exercisE = exercise;
        userName = username;
    }

    public int getPersonalRecordID() {
        return personalRecordID;
    }

    public void setPersonalRecordID(int newPersonalRecordID) {
        personalRecordID = newPersonalRecordID;
    }
}
