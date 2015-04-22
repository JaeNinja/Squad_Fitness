package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class Goal {

    int goalID;
    String goalType;
    int goalInt;
    int exercise;
    Boolean accomplished;

    public Goal(int goaldid,
                String goaltype,
                int goalint,
                int Exercise,
                boolean Accomplished) {
        goalID = goaldid;
        goalType = goaltype;
        goalInt = goalint;
        exercise = Exercise;
        accomplished = Accomplished;
    }

    public int getGoalID() {
        return goalID;
    }

    public String getGoalType() {
        return goalType;
    }

    public int goalInt() {
        return goalInt;
    }

    public int getExercise() {
        return exercise;
    }

    public Boolean getAccomplished() {
        return accomplished;
    }

    public void setGoalID(int newGoalID) {
        goalID= newGoalID;
    }

    public void setGoalType(String newGoalType) {
        goalType = newGoalType;
    }

    public void setGoalInt(int newGoalInt) {
        goalInt = newGoalInt;
    }

    public void setExercise(int exerciseName) {
        exercise = exerciseName;
    }

    public void getAccomplished(Boolean isAccomplished) {
        accomplished = isAccomplished;
    }

}
