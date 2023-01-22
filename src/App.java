import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner in=new Scanner(System.in);

    static ArrayList<Float> number=new ArrayList<>();

    public static ArrayList<Float> input(int n)
{
    Float input;
    int b=n-1;
    for (int i=0;i<n;i++){

        if (i==n-1){
            System.out.print("masukkan c   : ");
            input=in.nextFloat();
            number.add(input);
        }
        else{
            System.out.print("masukkan x^"+b--+" : ");
            input=in.nextFloat();
            number.add(input);
        }
    }
    System.out.println("-----------------------------------");
    System.out.print("f(x) = ");
   
    int a=n-1;
    for (float i : number)
    {
        if (i==number.get(number.size()-1)){
        System.out.print(" + "+i+" = 0 ");
    }
        else if (i>0 && i!=number.get(number.size()-1)&& i!=number.get(0) ){
            System.out.print(" + "+i+"x^"+a--);
        }
        else if (i>0 && i==number.get(0))
        {
            System.out.print(+i+"x^"+a--);
        }
        else if (i<0 && i!=number.get(number.size()-1))
        {
            System.out.print(i+"x^"+a--);
        }
        else if (i<0 && i==number.get(number.size()-1)){
            System.out.print(+i+" = 0 ");
        }
        
    }System.out.println("\n");
    System.out.println("-----------------------------------");
    System.out.println("\n");

    return number;
}
    public static float f(float x)
    {
        float hasil_pangkat=0;
        float hasil=0;
        float fx=0;
        float decrement=number.size()-1;
        for (float i : number){

            if (i==number.get(number.size()-1))
            {
                fx+=i;
            }
                else{
                hasil_pangkat=(float) Math.pow(x,decrement--);
                hasil=i*hasil_pangkat;
                fx+=hasil;
        }
        }
        return fx;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int jumlah_akar;
        float x0,x1,x2,fx0,fx1,fx2;
        float error,err=0;
        int iterasi;
        int i=0;
        System.out.println("""
        Nama    : Ferry Irawan
        Npm     : 06.2021.1.07378
        metode  : Secant
                """);
        System.out.print("Masukkan pangkat tertinggi : ");
        jumlah_akar=in.nextInt();

        input(jumlah_akar);

        System.out.print("Masukkan nilai x0 : ");
        x0=in.nextFloat();

        System.out.print("Masukkan nilai x1 : ");
        x1=in.nextFloat();

        System.out.print("Masukkan Toleransi Error : ");
        error=in.nextFloat();
        
        System.out.print("Masukkan Jumlah Iterasi : ");
        iterasi=in.nextInt();
        System.out.println("\n");
        System.out.println(" _____________________________________________________________________________________________________________________");
        System.out.println("|         |                 |                 |                 |                 |                 |                 |");
        System.out.printf("|%s | %9s       | %9s       | %10s      | %10s      | %9s       | %10s      | %10s       | \n"
        ," iterasi","x0","x1","f(x0)","f(x1)","x2","f(x2)","error");
        System.out.println("|_________|_________________|_________________|_________________|_________________|_________________|_________________|");

        do{
        
        x2=(x1)-((f(x1)*(x1-x0))/(f(x1)-f(x0)));
        err=Math.abs((x2-x1)/x2);
        System.out.printf("|%5d    | %15f | %15f | %15f | %15f | %15f | %15f | %f \n",i,x0,x1,f(x0),f(x1),x2,f(x2),err);
        i++;
       

        x0=x1;
        x1=x2;

        }while(err>error && i<=iterasi);

        System.out.println("|_________|_________________|_________________|_________________|_________________|_________________|_________________|");
        System.out.println(x0);

    }
}
