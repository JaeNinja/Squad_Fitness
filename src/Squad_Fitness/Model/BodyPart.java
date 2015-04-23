package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class BodyPart {

    private boolean neck,
            shoulders,
            biceps,
            triceps,
            forearms,
            abs,
            obliques,
            back,
            glutes,
            quad,
            calves,
            hamstrings;

    private boolean bulk,
            cooldown,
            stretch,
            equipment;
    public static BodyPart currentBodyParts = new BodyPart();
    public static int currentExercise;

    public BodyPart() {}

    public BodyPart(boolean Neck,
                    boolean Shoulders,
                    boolean Biceps,
                    boolean Triceps,
                    boolean Forearms,
                    boolean Abs,
                    boolean Obliques,
                    boolean Back,
                    boolean Glutes,
                    boolean Quad,
                    boolean Calves,
                    boolean Hamstrings,
                    boolean Bulk,
                    boolean Cooldown,
                    boolean Stretch,
                    boolean Equipment)
    {
        neck = Neck;
        shoulders = Shoulders;
        biceps = Biceps;
        triceps = Triceps;
        forearms = Forearms;
        abs = Abs;
        obliques = Obliques;
        back = Back;
        glutes = Glutes;
        quad = Quad;
        calves = Calves;
        hamstrings = Hamstrings;
        bulk = Bulk;
        cooldown = Cooldown;
        stretch = Stretch;
        equipment = Equipment;
    }

    public static void setCurrentBodyParts(BodyPart body)
    {
        currentBodyParts = body;
    }

    public static void setCurrentExercise(int id)
    {
        currentExercise = id;
    }

    public static int getCurrentExercise()
    {
        return currentExercise;
    }

}
