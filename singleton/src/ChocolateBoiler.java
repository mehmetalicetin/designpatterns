public class ChocolateBoiler {
    private volatile static ChocolateBoiler instance;

    private ChocolateBoiler(){}

    public static ChocolateBoiler getInstance(){
        if(instance == null){
            synchronized (ChocolateBoiler.class){
                if(instance == null){
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println("Current Thread:"+Thread.currentThread());
        System.out.println("Instance:"+instance);
    }
}
