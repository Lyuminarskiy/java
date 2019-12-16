package TugOfWar;

import java.util.Random;

public class TeamMember extends Thread {

    String Team;

    public TeamMember(String name, String team){
        super(name);
        Team = team;
    }

    @Override
    public void run() {
        var r = new Random();
        while (Game.flag) {
            Game.pullTheRope(this);
            try {
                Thread.sleep(100 + r.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
