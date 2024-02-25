package org.example;


public class Main {
    public static void main(String[] args)  {
        //Task 1
        //Task1.task();

        //Task 2
        Task2 task2 = new Task2(16);

        Thread A = new Thread(task2::fizz);
        Thread B = new Thread(task2::buzz);
        Thread C = new Thread(task2::fizzbuzz);
        Thread D = new Thread(task2::number);

        A.start();
        B.start();
        C.start();
        D.start();

    }
}