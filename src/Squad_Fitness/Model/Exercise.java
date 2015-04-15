package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class Exercise {

    int exerciseID;
    String exerciseName;
    String exerciseDescription;
    String typE;
    String tipS;
    int bodyPart;
    Boolean equipmentNeeded;
    //In seconds,
    int timeRequired;

    public Exercise(int exerciseid, String exercisename, String exercisedescription, String type, String tips,
                    int bodypart, Boolean equipmentneeded) {
        exerciseID = exerciseid;
        exerciseName = exercisename;
        exerciseDescription = exercisedescription;
        typE = type;
        tipS = tips;
        bodyPart = bodypart;
        equipmentNeeded = equipmentneeded;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int newExerciseID) {
        exerciseID = newExerciseID;
    }

}
