import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Player> Team = new ArrayList<>();
        Team.add(new Player(Data.red, "Слава"));
        Team.add(new Player(Data.blue, "Максим"));
        Team.add(new Player(Data.red, "Егор"));
        Team.add(new Player(Data.blue, "Данил"));
        Team.add(new Player(Data.red, "Даша"));
        Team.add(new Player(Data.blue, "Маша"));
        Team.add(new Player(Data.red, "Ксюша"));
        Team.add(new Player(Data.blue, "Таня"));
        Data.Play(Team);
    }
} 