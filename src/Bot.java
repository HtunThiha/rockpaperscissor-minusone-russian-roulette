import java.util.List;

public class Bot {

    public static List<String> selectTwoShapes() {
        List<String> shapesList = Shape.getShapesList();

        int shape1Index = (int) Math.floor(Math.random() * 3);
        String shape1 = shapesList.get(shape1Index);
        shapesList.remove(shapesList.indexOf(shape1));

        int shape2Index = (int) Math.floor(Math.random() * 2);
        String shape2 = shapesList.get(shape2Index);

        return List.of(shape1, shape2);
    }

    public static String selectOneShape(List<String> shapesList) {
        int indexToSelect = (int) Math.floor(Math.random() * 2);
        return shapesList.get(indexToSelect);
    }
}
