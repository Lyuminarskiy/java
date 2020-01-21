import lib.Game;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.CreateTeam();
        newGame.PrintMembersTeam();
        newGame.StartGame();
    }
}
