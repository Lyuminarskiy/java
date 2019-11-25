package lib;

public class Population {// contain obj
    private int year;
    private int populationCount;
    private int newbornCount;
    private int deathCount;

    public Population(int year, int populationCount, int newbornCount, int deathCount) {
        this.setYear(year);
        this.setPopulationCount(populationCount);
        this.setNewbornCount(newbornCount);
        this.setDeathCount(deathCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Population ppl = (Population) obj;

        return (this.year == ppl.year) ? true : false;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public int getNewbornCount() {
        return newbornCount;
    }

    public void setNewbornCount(int newbornCount) {
        this.newbornCount = newbornCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }
}