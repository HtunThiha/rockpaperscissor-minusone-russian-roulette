import java.util.ArrayList;
import java.util.List;

public class Shape {

    public static List<String> getShapesList() {
        var shapesList = new ArrayList<>(List.of("rock", "paper", "scissors"));
        return shapesList;
    }
}
