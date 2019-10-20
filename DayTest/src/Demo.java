import java.util.Arrays;
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

/*//青蛙跳台阶  非递归方法  递归方式同斐波那契数
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
}*/

/*public static int[] Fun(int[] arr){
    for(int i=0;i<arr.length;i++)
    {
        arr[i]=arr[i]*2;
    }
    return arr;
}*/

/*public static int[] Fun(int[] arr){
    int[] tmp=new int[arr.length];
    for(int i=0;i<tmp.length;i++)
    {
        tmp[i]=arr[i]*2;
    }
    return tmp;
}*/

/*public static String toString(int[] array){
    String str="";
    for(int i=0;i<array.length;i++)
    {

    }
}*/

//数组最大值
/*public static int Max(int[] array){
    int tmp=0;
    for(int i=0;i<array.length;i++)
    {
        if(array[i]>tmp)
        {
            tmp=array[i];
        }
    }
    return tmp;
}

//数组最小值
    public static int Min(int[] array){
        int tmp=array[0];
        for(int i=0;i<array.length;i++)
        {
            if(array[i]<tmp)
            {
                tmp=array[i];
            }
        }
        return tmp;
    }


    //数组平均值
    public static double arv(int[] array){
    double sum=0;
        for (int i = 0; i <array.length ; i++) {
            sum=sum+array[i];
        }
        return sum/array.length;
    }

//逆置
    public static int[] reverse(int[] array){
        for(int left=0,right = array.length-1;left<right;left++,right--)
        {
                array[left]=array[left]^array[right];
                array[right]=array[left]^array[right];
                array[left]=array[left]^array[right];
        }
        return array;
    }

    //数组奇数位于偶数前
public static int[] Fun(int[] array){
    for(int i=0;i<array.length;i++)
    {
        if(array[i]%2==0) {
            for (int j = array.length-1; j >i; j--) {
                if (array[j]%2!=0)
                {
                    array[i]=array[i]^array[j];
                    array[j]=array[i]^array[j];
                    array[i]=array[i]^array[j];
                }
            }
        }
    }
    return array;
}*/


/*public static double binarySearch(int[] array,int key,int left,int right){
    double mid=right/2;
    if(mid==key)
        return mid;
    if(key<mid)
    {
        int right=mid;
    }
}*/

/*public static void func(int x){
     x=10;
}*/


/*public static void func(int[] array){
    array[0]=33;
}*/

//实现数组以字符串形式输出
/*public static String func(int[] array){
    String str="[";
    for(int i=0;i<array.length;i++)
    {
        str+=array[i]+" ";
    }
    str=str+"]";
    return str;
}*/


//手动实现字符串拷贝函数Arrays.copyOf
/*public static int[] arrayCopy(int[] array){
    int[] copy=new int[array.length];
    for (int i = 0; i < array.length ;i++) {
        copy[i]=array[i];
    }
    return copy;
}*/

//数组奇数位于偶数前
/*public static int[] func(int[] array){
    int left=0;
    int right=array.length-1;
    while(left<right){
        while(left<right&&array[left]%2!=0){
            left++;
        }
        while(left<right&&array[right]%2==0){
            right--;
        }
        if(left<right) {
            array[left] = array[left] ^ array[right];
            array[right] = array[left] ^ array[right];
            array[left] = array[left] ^ array[right];
        }
    }
    return array;
}*/

//冒泡排序
/*public static void bubbleSort(int[] array){
    for (int i = 0; i <array.length ; i++) {
        for (int j = i; j <array.length-1 ; j++) {
            if(array[j]>array[j+1]){
                array[j]=array[j]^array[j+1];
                array[j+1]=array[j]^array[j+1];
                array[j]=array[j]^array[j+1];
            }
        }
    }
}*/

//二分查找
/*public static int binarySearch(int[] array,int key){
    int left=0;
    int right=array.length-1;
    while(left<=right){
        int mid=(left+right)/2;
        if(array[mid]<key){
            left=mid+1;
        }
        if(array[mid]>key){
            right=mid-1;
        }
        if(array[mid]==key){
            return mid;
        }
    }
    return -1;
}*/

//二分查找递归实现
/*public static int binarySearch(int[] array,int key,int left,int right){
    if(left>right) {
        return -1;
    }
    int mid=(left+right)/2;
    if(array[mid]<key){
        left=mid+1;
        return binarySearch(array,key,left,right);
    }
    if(array[mid]>key){
        right=mid-1;
        return binarySearch(array,key,left,right);
    }
    if(array[mid]==key){
        return mid;
    }
    return -1;
}*/



    public static void main(String[] args) {
//        int[][] array=new int[3][];
        int[] arr={1,2,3,4,6,3};
        int[] arr1=Arrays.copyOf(arr,4);
        System.out.println(Arrays.toString(arr1));
        int[][] array={{1,2},{2,4},{3,6,8}};
        System.out.println(Arrays.deepToString(array));
        int[] array1=Arrays.copyOf(array[2],2);
        System.out.println(Arrays.toString(array1));
/*        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.printf(array[i][j]+" ");
            }
            System.out.println();
        }*/
//        System.out.println(Arrays.toString(array[0]));

//        int[] arr={1,2,4,7,13,25,14,19};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] array=new int[10];
//        System.out.println(Arrays.toString(array));
//        Arrays.fill(array,2,7,9);
//        System.out.println(Arrays.toString(array));
//        int[] arr={1,2,3,4,5,6,7,8,9,15};
//        System.out.println(binarySearch(arr,15,0,9));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arrayCopy(arr)));
/*       int[] arr={20,2,3,3,4};
       System.out.println(arr);
       System.out.println(arr[0]);
       func(arr);
       System.out.println(arr[0]);*/

//        int[] arr={0};
//        Arrays.s ort(arr);

//        Scanner in = new Scanner(System.in);
//        int number = in.nextInt();
//        System.out.println(frogJump(number));
//         int[] arr1={1,2,3,4,5,6};
//         int[] arr=Fun(arr1);
//         for(int i=0;i<arr.length;i++)
//         {
//             System.out.print(arr[i]+" ");
//         }
//        int[] arr={1,2,3,4,5,6,8,4};
//        System.out.println(Max(arr));
//        System.out.println(Min(arr));
//        System.out.println(arv(arr));
        /*int[] ret=Fun(arr);
        for(int i=0;i<ret.length;i++)
        {
            System.out.println(ret[i]);
        }*/
    }
}














