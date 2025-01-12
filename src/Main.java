public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        Revolver.setDeathRounds(3);
        System.out.println(Revolver.spinAndFire());
    }
}