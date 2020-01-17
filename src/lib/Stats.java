package lib;

public class Stats implements Comparable<Stats>
{
    private int year;
    private int pplNum;
    private int born;
    private int dead;

    public Stats(int year, int pplNum, int born, int dead)
    {
            this.setYear(year);
            this.setPplNum(pplNum);
            this.setBorn(born);
            this.setDead(dead);
    }

    @Override
    public String toString()
    {
            return String.format("%s,%s,%s,%s", this.getYear(), this.getPplNum(),
            this.getBorn(), this.getDead());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }

        Stats ppl = (Stats) obj;

        return this.year == ppl.year;
    }
    @Override
    public int compareTo(Stats ppl)
    {
        return Integer.compare(this.getYear(), ppl.getYear());
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getPplNum()
    {
        return pplNum;
    }

    public void setPplNum(int pplNum)
    {
        this.pplNum = pplNum;
    }

    public int getBorn()
    {
        return born;
    }

    public void setBorn(int born)
    {
        this.born = born;
    }

    public int getDead()
    {
            return dead;
    }

    public void setDead(int dead)
    {
        this.dead = dead;
    }
}
