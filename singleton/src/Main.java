public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
           chocolateBoiler.print();
        });
        Thread thread2 = new Thread(()->{
            ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
            chocolateBoiler.print();
        });
        Thread thread3 = new Thread(()->{
            ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
            chocolateBoiler.print();
        });
        Thread thread4 = new Thread(()->{
            ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
            chocolateBoiler.print();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}