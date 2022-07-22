import java.util.concurrent.*;
public class Car extends Thread{
    Semaphore semaphore;
    Semaphore semCurrent;
    int no;
    String dir;
     public Car(Semaphore semaphore, Semaphore semCurrent, int no, String dir){
         this.semaphore=semaphore;
         if(semCurrent==null){
             this.semCurrent=semaphore;
         }
         else {
            this.semCurrent=semCurrent;
         }
         this.no=no;
         this.dir=dir;
     }

    public String getDir() {
        return dir;
    }

    @Override
    public void run() {
         System.out.println("Car " + no + this.getDir() + " is waiting at the semaphore.");
            if(this.semCurrent == this.semaphore) {
                try {
                    this.semaphore.acquire();
                    System.out.println("GREEN! Car " + no + this.getDir() + " leaves");
                    Thread.sleep(10);
                    this.semaphore.release();
                } catch (InterruptedException exception) {
                    System.out.println(exception);
                }
                this.semCurrent=null;
            }
            else{
                System.out.println("FOR " + no + this.getDir() + " CAR IS RED!");

            }

     }
}
