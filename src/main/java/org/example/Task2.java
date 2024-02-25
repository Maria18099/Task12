package org.example;

import java.util.ArrayList;
import java.util.List;

//Напишіть програму, що виводить в консоль рядок, що складається з чисел від 1 до n,
// але з заміною деяких значень:
//якщо число ділиться на 3 - вивести fizz
//якщо число ділиться на 5 - вивести buzz
//якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz,
//Наприклад, для n = 15, очікується такий результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz,
// 13, 14, fizzbuzz.
//
//Програма повинна бути багатопотоковою, і працювати з 4 потоками:
//Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3, і якщо так - додати в чергу на виведення для
//потоку D рядок fizz.
//Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5, і якщо так - додати в чергу на виведення
//для потоку D рядок buzz.
//Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно,
//і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
//Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.
public class Task2 {
    List<String> strNumber = new ArrayList<>();
    int number = 1;
    private int n;
    public Task2(int n){
        this.n = n;
    }

    public synchronized void number(){
        while (number<=n){
            if (number%3 ==0 || number%5==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(strNumber.remove(0));
            }
            else {
                strNumber.add(String.valueOf(number));
                System.out.println(strNumber.remove(0));
                number++;
                notifyAll();
            }

        }
    }
    public synchronized void fizz(){
        while (number<=n){
            if (number%3==0 && number%5!=0){
                strNumber.add("fizz");
                number++;
                notifyAll();
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public synchronized void buzz(){
        while (number<=n){
            if(number%5==0 && number%3!=0){
                strNumber.add("buzz");
                number++;
                notifyAll();
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    public synchronized void fizzbuzz(){
        while (number<=n){
            if (number%15==0){
                strNumber.add("fizzbuzz");
                number++;
                notifyAll();
            }
            else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}

