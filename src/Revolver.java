import java.util.ArrayList;
import java.util.List;

public class Revolver {

    private static List<Integer> deathRounds = new ArrayList<>();

    public static void setDeathRounds(int numOfBullets) {
        deathRounds = new ArrayList<>();
        List<Integer> bulletRounds = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        for (int i = 0; i < numOfBullets; i++) {
            int selectedRoundIndex = (int) Math.floor(Math.random() * bulletRounds.size());
            int liveRound = bulletRounds.get(selectedRoundIndex);
            deathRounds.add(liveRound);
            bulletRounds.remove(selectedRoundIndex);
        }
    }

    public static boolean spinAndFire() {
        int triggeredRound = 1 + (int) Math.floor(Math.random() * 6);
        if (deathRounds.contains(triggeredRound)) {
            return true;
        } else {
            return false;
        }
    }
}