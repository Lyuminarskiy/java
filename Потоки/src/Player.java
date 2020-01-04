public class Player extends Thread{
    public String name;
    public String team;

    Player(ThreadGroup team, String name){
        super(team, name);
        this.team = team.getName();
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%s<%s> ", name, team);
    }

    @Override
    public void run(){
        int point = (int) (Math.random() * Data.pointsForVictory * 1.2);
        if(this.getThreadGroup().getName() == Data.blue.getName()) {
            Data.blueScore += point;
            Data.redScore -= point;
        }
        else{
            Data.redScore += point;
            Data.blueScore -= point;
        }

        System.out.format("\n%s добавляет %d очков к своей команде\nТекущий счет: %s <%s>, %s <%s>\n", this, point, Data.redScore, Data.red.getName(),
                                                                                                                Data.blueScore, Data.blue.getName());
    }
}
