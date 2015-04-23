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

    public boolean getNeck()
    {
        return neck;
    }

    public void setNeck(boolean Neck)
    {
        neck = Neck;
    }

    public boolean getShoulders()
    {
        return shoulders;
    }

    public void setShoulders(boolean Shoulders)
    {
        shoulders = Shoulders;
    }

    public boolean getBiceps()
    {
        return biceps;
    }

    public void setBiceps(boolean Biceps)
    {
        biceps = Biceps;
    }

    public boolean getTriceps()
    {
        return triceps;
    }

    public void setTriceps(boolean Triceps)
    {
        triceps = Triceps;
    }

    public boolean getForearms()
    {
        return forearms;
    }

    public void setForearms(boolean Forearms)
    {
        forearms = Forearms;
    }

    public boolean getAbs()
    {
        return abs;
    }

    public void setAbs(boolean Abs)
    {
        abs = Abs;
    }

    public boolean getObliques()
    {
        return obliques;
    }

    public void setObliques(boolean Obliques)
    {
        obliques = Obliques;
    }

    public boolean getBack()
    {
        return back;
    }

    public void setBack(boolean Back)
    {
        back = Back;
    }

    public boolean getGlutes()
    {
        return glutes;
    }

    public void setGlutes(boolean Glutes)
    {
        glutes = Glutes;
    }

    public boolean getQuads()
    {
        return quad;
    }

    public void setQuad(boolean Quad)
    {
        quad = Quad;
    }

    public boolean getCalves()
    {
        return calves;
    }

    public void setCalves(boolean Calves)
    {
        calves = Calves;
    }

    public boolean getHamstrings()
    {
        return hamstrings;
    }

    public void setHamstrings(boolean Hamstrings)
    {
        hamstrings = Hamstrings;
    }

    public boolean getBulk()
    {
        return bulk;
    }

    public void setBulk(boolean Bulk)
    {
        bulk = Bulk;
    }

    public boolean getCooldown()
    {
        return cooldown;
    }

    public void setCooldown(boolean Cooldown)
    {
        cooldown = Cooldown;
    }

    public boolean getStretch()
    {
        return stretch;
    }

    public void setStretch(boolean Stretch)
    {
        stretch = Stretch;
    }

    public boolean getEquipment()
    {
        return equipment;
    }

    public void setEquipment(boolean Equipment)
    {
        equipment = Equipment;
    }
}
