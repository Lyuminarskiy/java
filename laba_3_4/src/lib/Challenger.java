package lib;

public class Challenger {
    public String name;
    public int power;

    public Challenger(String name, int power){
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString(){
        return String.format("%1$s", name);
    }
}
