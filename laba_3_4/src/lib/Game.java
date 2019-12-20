package lib;

import java.util.List;

//Класс нужен только для хранения текущего счёта и вывода информации.
public class Game {
    public Game(){}

    private static int winScore = 20;
    private static int currentScore = 0;
    public static int blueScore = 0;
    public static int redScore = 0;
    public static boolean flag;

    public void Start(List<Challenger> challengers) {
        printTeams(challengers);
        System.out.println("Игра начинается!\nКоманда победит при достижении порога в " + winScore + " единиц\n");
        for (Challenger chalk : challengers) chalk.start();

    }

    public static int getWinScore() {
        return  winScore;
    }

    public static void setWinScore(int i) {
        winScore = i;
    }

    public static int getCurrentScore() {
        return  currentScore;
    }

    static void printAction(Challenger ch, int power) {
        if (power < 0) power *= -1;
        System.out.println(String.format("%s<%s> добавляет %s к своей команде\nТекущий счет: +%s<%s>, %s<%s>\n",
                ch.name,ch.team,power,redScore,"Красные", blueScore, "Синие"));
    }

    public static void setCurrentScore(Challenger ch, int power)
    {
        currentScore += power;
        printAction(ch, power);
    }

    public static boolean checkWin() {
        return Math.abs(currentScore) >= winScore;
    }

    void printTeams(List<Challenger> challengers) {
        StringBuilder reds = new StringBuilder(); reds.append("Команда <Красные>:\n");
        StringBuilder blues = new StringBuilder(); blues.append("Команда <Синие>:\n");
        for(Challenger ch : challengers) {
            if (ch.team.equals("Синие")) {
                blues.append(String.format("%s<%s>\n", ch.name, ch.team));
            } else {
                reds.append(String.format("%s<%s>\n", ch.name, ch.team));
            }
        }
        System.out.println(reds.toString()+ "\n" + blues.toString());
    }

    public static void printWinner() {
        if (!flag) {
            System.out.println(String.format("Игра завершена!\nПобедила команда <%s>",
                    currentScore < 0 ? "Синие" : "Красные"));
        }
        flag = true;
    }
}
