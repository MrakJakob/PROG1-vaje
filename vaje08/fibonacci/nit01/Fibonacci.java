
public class Fibonacci {
    // dopolnite ...
    private int a;
    private int b;

    public Fibonacci(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int naslednji(){
        int naslednje = this.a + this.b;
        this.a = this.b;
        this.b = naslednje;
        
        return naslednje;
    }

}
