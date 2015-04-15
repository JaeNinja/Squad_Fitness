package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class Goal {

    int goalID;
    String goalType;
    int goalInt;
    int exercisE;
    Boolean accomplisheD;

    public Goal(int goaldid, String goaltype, int goalint, int exercise, boolean accomplished) {
        goalID = goaldid;
        goalType = goaltype;
        goalInt = goalint;
        exercisE = exercise;
        accomplisheD = accomplished;
    }

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int newGoalID) {
        goalID= newGoalID;
    }
}
