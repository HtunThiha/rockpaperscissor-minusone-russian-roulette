import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int roundNumber = 1;
        boolean continueNextRound = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(String.format("========== Round %d ==========", roundNumber));

            System.out.print("Enter your first shape: ");
            String p_shape1 = scanner.nextLine();
            System.out.print("Enter your second shape: ");
            String p_shape2 = scanner.nextLine();
            System.out.println(String.format("\nYou played: %s %s", p_shape1, p_shape2));

            var botShapes = Bot.selectTwoShapes();
            String b_shape1 = botShapes.get(0);
            String b_shape2 = botShapes.get(1);
            System.out.println(String.format("Bot played: %s %s", b_shape1, b_shape2));

            boolean invalidFinalChoice = false;
            String p_finalShape;

            do {
                System.out.print("\nChoose your final play: ");
                p_finalShape = scanner.nextLine();

                if (p_finalShape.equals(p_shape1) || p_finalShape.equals(p_shape2)) {
                    invalidFinalChoice = false;
                } else {
                    System.out.println("Invalid choice. You must choose one of two shapes you have selected previously.");
                    invalidFinalChoice = true;
                }
            } while (invalidFinalChoice);

            String b_finalShape = Bot.selectOneShape(botShapes);
            System.out.println(String.format("\nBot final shape: %s", b_finalShape));
            String result = RockPaperScissors.compare(p_finalShape, b_finalShape);
            System.out.println(result);

            roundNumber++;
        } while (continueNextRound);

    }
}