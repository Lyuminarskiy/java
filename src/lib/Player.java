package lib;

import java.util.Random;

public class Player extends Thread
{
    public Player(ThreadGroup group, String name)
    {
        super(group, name);
    }

    public synchronized void run()
    {
        while (Math.abs(Game.CurrentScore) < Game.WinScore)
        {
            Random random = new Random();
            try
            {
                Player.currentThread().sleep(100 + random.nextInt(200));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized ((Object) Game.CurrentScore)
            {
                if (Math.abs(Game.CurrentScore) < Game.WinScore)
                {
                    int points = random.nextInt(Game.WinScore);
                    if (Player.currentThread().getThreadGroup().getName().equals("Красные"))
                    {
                        Game.CurrentScore += points ;
                    }
                    if (Player.currentThread().getThreadGroup().getName().equals("Синие"))
                    {
                        Game.CurrentScore -= points;
                    }
                    System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                            Player.currentThread().getName(), Player.currentThread().getThreadGroup().getName(),
                            points, Game.CurrentScore, -Game.CurrentScore);
                    if (Math.abs(Game.CurrentScore) >= Game.WinScore)
                    {
                        System.out.printf("\nИгра окончена!\nПобедила команда <%s>", Player.currentThread().getThreadGroup().getName());
                    }
                }
            }
        }
    }
}