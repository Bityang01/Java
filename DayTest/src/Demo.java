import java.util.Scanner;
public class Demo {

    /*   public static int fac(int number){
           if(number==1)
               return 1;
           return number+fac(number-1);
       }*/
/* public static void fac(int number) {
     if(number>10) {
         fac(number/10);
     }
     System.out.println(number%10);
 }*/
/*public static int fac(int number){
    int sum;
    if(number<10)
        return number;
    return number%10+fac(number/10);
}*/
/*
public static int fac(int number){
    if(number==1)
        return 1;
    if(number==2)
        return 1;
    return fac(number-1)+fac(number-2);
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(fac(number));
    }
}
*/
public static int function(int n){
    if(n==1)
        return 1;
    if(n==2)
        return 2;
    return function(n-1)+function(n-2);
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(function(number));
    }
}