import java.lang.reflect.Field;
import java.util.concurrent.Semaphore;

public class Main {

    private static Semaphore semaphoreNS = new Semaphore(2, true);
    private static Semaphore semaphoreWE = new Semaphore(2, true);
   // private static ;

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphoreCurrent = semaphoreWE;

        Car car1 = new Car(semaphoreNS, semaphoreCurrent,0,"N");
        Car car2 = new Car(semaphoreWE, semaphoreCurrent,1,"E");
        Car car3 = new Car(semaphoreWE, semaphoreCurrent,2,"E");
        Car car4 = new Car(semaphoreWE, semaphoreCurrent,3,"W");

        semaphoreCurrent = semaphoreNS;

        Car car5 = new Car(semaphoreNS, semaphoreCurrent, 4,"N");
        Car car6 = new Car(semaphoreNS, semaphoreCurrent, 5,"W");
        Car car7 = new Car(semaphoreNS, semaphoreCurrent, 6,"S");

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();





    }
}
