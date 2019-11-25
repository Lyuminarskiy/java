package com.company;
import lib.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Task3_3 task = new Task3_3("russia_population.csv");
        task.Update(new Population(2007,999,444,333));
       // task.Update(new Population(2007,6,6,6));
       // task.Delete(new Population(2010,6,6,6));
        task.Update(new Population(2020,1,2,3));

        task.Show();
    }
}