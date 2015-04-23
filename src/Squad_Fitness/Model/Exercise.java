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

    public Exercise(int exerciseid,
                    String exercisename,
                    String exercisedescription,
                    String type,
                    String tips,
                    int bodypart,
                    Boolean equipmentneeded) {
        exerciseID = exerciseid;
        exerciseName = exercisename;
        exerciseDescription = exercisedescription;
        typE = type;
        tipS = tips;
        bodyPart = bodypart;
        equipmentNeeded = equipmentneeded;
    }

    public int getExerciseID()
    {
        return exerciseID;
    }

    public void setExerciseID(int newExerciseID)
    {
        exerciseID = newExerciseID;
    }

    public String getExerciseName()
    {
        return exerciseName;
    }

    public void setExerciseName(String ExerciseName)
    {
        exerciseName = ExerciseName;
    }

    public String getExerciseDesription()
    {
        return exerciseName;
    }

    public void setExerciseDescription(String ExerciseDescription)
    {
        exerciseDescription = ExerciseDescription;
    }

    public String getType()
    {
        return typE;
    }

    public void setType(String Type)
    {
        typE = Type;
    }

    public String getTips()
    {
        return tipS;
    }

    public void setTips(String Tips)
    {
        tipS = Tips;
    }

    public int getBodyPart()
    {
        return bodyPart;
    }

    public void setBodyPart(int BodyPart)
    {
        bodyPart = BodyPart;
    }

    public Boolean getEquipmentNeeded()
    {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(boolean EquipmentNeeded)
    {
        equipmentNeeded = EquipmentNeeded;
    }

    public int getTimeRequired()
    {
        return timeRequired;
    }

    public void setTimeRequired(int TimeRequired)
    {
        timeRequired = TimeRequired;
    }
}
