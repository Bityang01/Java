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
/*public static int function(int n){
    if(n==1)
        return 1;
    if(n==2)
        return 2;
    return function(n-1)+function(n-2);
}*/
/*//求阶乘
public static int fac(int n){
    if(n==1){
        return 1;
    }
    return n*fac(n-1);
}*/

/*//求1+2+3+……+n
public static int sum(int n){
    if(n==1){
        return 1;
    }
    return n+sum(n-1);
}*/

/*//按顺序打印一个数字的每一位
public static void func(int num){
    if(num>9){
        func(num/10);
    }
    System.out.println(num%10);
}*/

//按顺序打印每一位用此种方法不可实现
/*public static void func(int num){
    if(num<10){
        System.out.println();
    }
    func(num/10);
}*/

/*//返回组成数字之和
public static int sumNum(int n){//n=123
    if(n<10){
        return n;
    }
    return n%10+sumNum(n/10);
    //3+sumNum(12)
    //3+2+sumNum(1)
    //3+2+1
}*/

/*//斐波那契数  非递归方式
public static int fib(int n){
    if(n==1||n==2){
        return 1;
    }
    int f1=1;
    int f2=1;
    int f3=0;
    for(int i=3;i<=n;i++)
    {
        f3=f1+f2;
        f1=f2;
        f2=f3;
    }
    return f3;
}*/

//青蛙跳台阶  非递归方法  递归方式同斐波那契数
public static int frogJump(int num){
    if(num==1)
        return 1;
    if(num==2)
        return 2;
    int f1=1;
    int f2=2;
    int f3=0;
    for(int i=3; i<=num;i++)
    {
        f3=f1+f2;
        f1=f2;
        f2=f3;
    }
    return f3;
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(frogJump(number));
        // func(number);
    }
}














