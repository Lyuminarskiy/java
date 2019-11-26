package com.company;
import lib.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Task3_3 task = new Task3_3("russia_population.csv");

        task.Update(new Population(2006,6,6,6));
        task.Update(new Population(2007,6,6,6));
        task.Update(new Population(2008,6,6,6));
        task.Update(new Population(2009,6,6,6));
        task.Update(new Population(2010,6,6,6));
        task.Update(new Population(2011,6,6,6));
        task.Show();
        task.Delete(2007,2008,2009);
        task.Show(2020,2024,2012);
    }
}