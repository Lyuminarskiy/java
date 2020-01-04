import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Data {
    public static int pointsForVictory = 100;
    public static int blueScore = 0;
    public static int redScore = 0;
    static boolean checkWin = false;
    static ThreadGroup red=new ThreadGroup("Красные");
    static ThreadGroup blue=new ThreadGroup("Синие");

    public static void Play(ArrayList<Player> team) throws InterruptedException {
        System.out.format("Состав команды <%s>\n", Data.red.getName());
        for (var i : team) {
            if(i.getThreadGroup().getName() == Data.red.getName())
            System.out.println(i);
        }
        System.out.format("\nСостав команды <%s>\n", Data.blue.getName());
        for (var i : team) {
            if(i.getThreadGroup().getName() == Data.blue.getName())
                System.out.println(i);
        }
        System.out.println("\nИгра начинается!\nКоманда победит при достижении порога в 100 единиц");

        for (var i : team) {
            i.start();
            sleep(100);
            if(blueScore >= pointsForVictory || redScore >= pointsForVictory){
                System.out.format("\nИгра завершена!\nПобедила команда <%s>, первой достигнув %d очков\n", i.team, pointsForVictory);
                break;
            }
        }
    }
}
