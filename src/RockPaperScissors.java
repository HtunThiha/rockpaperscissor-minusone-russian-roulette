public class RockPaperScissors {

    public static String compare(String p_finalShape, String b_finalShape) {
        var shapesList = Shape.getShapesList();

        int p_index = shapesList.indexOf(p_finalShape);
        int b_index = shapesList.indexOf(b_finalShape);
        int result = (p_index - b_index + 3) % 3;

        if (result == 0) {
            return "Draw";
        } else if (result == 1) {
            return "Player Wins";
        } else {
            return "Bot Wins";
        }
    }
}
