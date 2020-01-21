import lib.Game;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.AddTeam("red","Иван", "Марина", "Анна");
        newGame.AddTeam("blue","Михаил", "Сергей", "Ольга");
        newGame.PrintTeams();
        newGame.StartGame();
    }
}
