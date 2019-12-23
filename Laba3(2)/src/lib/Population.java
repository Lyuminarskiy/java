package lib;

public class Population implements Comparable< Population > {// contain obj
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
    public String toString(){
        return String.format("%s,%s,%s,%s", this.getYear(), this.getPopulationCount(),
                this.getNewbornCount(), this.getDeathCount());
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

        return this.year == ppl.year;
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

    @Override
    public int compareTo(Population ppl) {
        return Integer.compare(this.getYear(), ppl.getYear());
    }
}