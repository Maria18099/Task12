package org.example;
//Напишіть програму, яка кожну секунду відображає на екрані дані про час, що минув
//від моменту запуску програми.
//Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.
public class Task1 {
    static int seconds=0;
    public static void task(){
        Thread threadTimerOneSecond = new Thread(
                ()->{
                    while (true){
                        seconds++;
                        System.out.println(seconds);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        threadTimerOneSecond.start();
        Thread threadTimerFiveSeconds = new Thread(
                ()->{
                    while (true){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                            System.out.println("5 seconds passed");
                    }
                }
        );
        threadTimerFiveSeconds.start();
    }
}
