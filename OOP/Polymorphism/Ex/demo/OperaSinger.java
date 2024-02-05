package OOP.Polymorphism.Ex.demo;

import java.sql.SQLOutput;

public class OperaSinger implements Singer{
    @Override
    public void sing() {
        System.out.println("Singing opera");
    }
}