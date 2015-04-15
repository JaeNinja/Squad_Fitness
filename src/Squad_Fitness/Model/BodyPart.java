package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class BodyPart {

    int bodyPartID;
    String Name;
    String Neck;
    String Obliques;
    String Shoulders;
    String Back;
    String Biceps;
    String Triceps;
    String Forearms;
    String Chest;
    String Abs;
    String Quads;
    String Hamstrings;
    String Calves;

    public BodyPart(int bodypartid, String name, String neck, String obliques, String shoulders, String back, String biceps, String triceps, String forearms,
                    String chest, String abs, String quads, String hamstrings, String calves) {
        bodyPartID = bodypartid;
        Name = name;
        Neck = neck;
        Obliques = obliques;
        Shoulders = shoulders;
        Back = back;
        Biceps = biceps;
        Triceps = triceps;
        Forearms = forearms;
        Chest = chest;
        Abs = abs;
        Quads = quads;
        Hamstrings = hamstrings;
        Calves = calves;
    }

    public int getBodyPartID() {
        return bodyPartID;
    }

    public void setBodyPartID(int newBodyPartID) {
        bodyPartID = newBodyPartID;
    }
}
