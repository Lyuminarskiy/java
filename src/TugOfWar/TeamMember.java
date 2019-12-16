package TugOfWar;

public class TeamMember extends Thread {

    String Team;

    public TeamMember(String name, String team){
        super(name);
        Team = team;
    }

    @Override
    public void run() {
        while (Game.flag) {
            Game.pullTheRope(this);
            try {
                Thread.sleep(100 + Game.r.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
