import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        try {
            int roundNumber = 1;
            boolean continueNextRound = true;
            Scanner scanner = new Scanner(System.in);
            String gameWinner = "";
            int numberOfBullets;

            do {
                numberOfBullets = 1 + (int) Math.floor(roundNumber / 4);
                System.out.println(String.format("========== Round %d ==========", roundNumber));
                System.out.println(String.format("Number of bullets on this round: %s\n", numberOfBullets));

                boolean invalidFirstChoice;
                String p_shape1;
                String p_shape2;
                do {
                    System.out.print("Play your first hand: ");
                    p_shape1 = (scanner.nextLine());
                    System.out.print("Play your second hand: ");
                    p_shape2 = scanner.nextLine();

                    var shapesList = Shape.getShapesList();

                    if (shapesList.contains(p_shape1) && shapesList.contains(p_shape2)) {
                        invalidFirstChoice = false;
                    } else {
                        System.out.println("Invalid plays. You must choose either rock, paper, or scissors.");
                        invalidFirstChoice = true;
                    }
                } while (invalidFirstChoice);

                System.out.println(String.format("\nYou played: %s %s", p_shape1, p_shape2));

                var botShapes = Bot.selectTwoShapes();
                String b_shape1 = botShapes.get(0);
                String b_shape2 = botShapes.get(1);
                System.out.println(String.format("Bot played: %s %s", b_shape1, b_shape2));

                boolean invalidFinalChoice;
                String p_finalShape;
                do {
                    System.out.print("\nChoose your final play: ");
                    p_finalShape = scanner.nextLine();

                    if (p_finalShape.equals(p_shape1) || p_finalShape.equals(p_shape2)) {
                        invalidFinalChoice = false;
                    } else {
                        System.out.println("Invalid play. You must choose one of two shapes you have selected previously.");
                        invalidFinalChoice = true;
                    }
                } while (invalidFinalChoice);

                String b_finalShape = Bot.selectOneShape(botShapes);
                System.out.println(String.format("\nYour final hand: %s", p_finalShape));
                System.out.println(String.format("Bot final hand: %s", b_finalShape));
                Thread.sleep(1200);
                String rockpaperscissors_winner = RockPaperScissors.compare(p_finalShape, b_finalShape);
                Thread.sleep(1000);

                if (rockpaperscissors_winner != "Draw") {

                    String loser = (rockpaperscissors_winner == "player") ? "Bot":"Player";

                    System.out.println(String.format("%s's turn for Russian Roulette!", loser));
                    Thread.sleep(800);

                    Revolver.setDeathRounds(numberOfBullets);
                    for (int i = 3; i >= 0; i--) {
                        int delay = (i != 0) ? 1000:200;
                        System.out.print("\rPulling trigger in " + i + "...");
                        Thread.sleep(delay);
                    }

                    boolean isTriggered = Revolver.spinAndFire();

                    if (isTriggered) {
                        System.out.println(String.format("\nBAM!\n%s has been shot.\n%s Lost!", loser, loser));
                        continueNextRound = false;
                        gameWinner = rockpaperscissors_winner;
                    } else {
                        System.out.println(String.format("\nClick! The chamber was empty. %s passed.\n\n", loser));
                    }
                }
                roundNumber++;
            } while (continueNextRound);

            System.out.println("\nGame Over!");
            System.out.println(String.format("%s wins at round %d!", gameWinner, roundNumber - 1));

        } catch (NoSuchElementException e) {
            if (e.getMessage() == "No line found") {
                System.out.println("\n\n Game terminated.");
            }
        }
    }
}