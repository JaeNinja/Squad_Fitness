package Squad_Fitness.Model;

/**
 * Created by Kyle on 3/16/2015.
 */
public class healthyFood {

    String foodName;
    String servingSize;
    int calorieS;
    int caloriesFromFat;
    int totalFat;
    int saturatedFat;
    int cholesteroL;
    int sodiuM;
    int carbohydratE;
    int fibeR;
    int sugaR;
    int proteiN;

    public healthyFood(String foodname, String servingsize, int calories, int caloriesfromfat, int totalfat,
        int saturatedfat, int cholesterol, int sodium, int carbohydrate, int fiber, int sugar, int protein) {
            foodName = foodname;
            servingSize = servingsize;
            calorieS = calories;
            caloriesFromFat = caloriesfromfat;
            totalFat = totalfat;
            saturatedFat = saturatedfat;
            cholesteroL = cholesterol;
            sodiuM = sodium;
            carbohydratE = carbohydrate;
            fibeR = fiber;
            sugaR = sugar;
            proteiN = protein;
    }
}
