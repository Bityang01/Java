import java.util.Arrays;
import java.util.List;


//public class Demo {

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
/*public class Person {
    public String name;

    public void func() {
        System.out.println("Person.func()");
    }
}
    public static void main(String[] args) {
    new Person().func();*/
        /*int[][] array={{1,2},{2,4},{3,6,8}};
        System.out.println(Arrays.toString(array));*/
        /*int[] arr={2,3,6,13,56,68,14,16};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));*/
//        int[][] array=new int[3][];
        /*int[] arr=new int[10];
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,2,7,9);
        System.out.println(Arrays.toString(arr));*/
        /*int[] arr1=Arrays.copyOf(arr,4);
        System.out.println(Arrays.toString(arr1));
        int[][] array={{1,2},{2,4},{3,6,8}};
        System.out.println(Arrays.deepToString(array));
        int[] array1=Arrays.copyOf(array[2],2);
        System.out.println(Arrays.toString(array1));*/
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
//    }
//}

//编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
//除四种运算
/*
class Calculator{
    public double num1;
    public double num2;
    public double add(double num1,double num2){
        return num1+num2;
    }
    public double Minus(double num1,double num2){
        return num1-num2;
    }

    public double Multiply(double num1,double num2){
        return num1*num2;
    }
    public double Divide(double num1,double num2){
        return num1/num2;
    }
}

public class Demo {
    public static void main(String[] args) {
        Calculator number=new Calculator();
        System.out.println(number.add(10,20));
        System.out.println(number.Minus(20,15));
        number.num1=10;
        number.num2=15;
        System.out.println(number.Multiply(number.num1,number.num2));
        System.out.println(number.Divide(20,4));
    }
}
*/


//设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
/*class Person{
    public Person(){
        System.out.println("没有参数的构造函数！");
    }
    public Person(String str){
        System.out.println("有一个参数的构造函数！参数是："+str);
    }
    public Person(int num,String str){
        System.out.println("有两个参数的构造函数！参数是："+num+"和"+str);
    }
    public Person(int ...personAge){
        for (int age:personAge) {
            System.out.println("年龄是"+age);
        }
    }
}
public class Demo{
    public static void main(String[] args) {
        Person per=new Person();
        Person per1=new Person("博哥");
        Person per2=new Person(18,"博哥");
        Person per3=new Person(10,20,300,405,69);

    }
}*/


//实现交换两个变量的值。要求：需要交换实参的值。
/*public class Demo{
    public static void swap(int[] array){
        array[0]=array[0]^array[1];
        array[1]=array[0]^array[1];
        array[0]=array[0]^array[1];
    }
    public static void main(String[] args) {
        int[] arr={10,20};
        System.out.println("交换之前的数arr[0] "+arr[0]+"和arr[1] "+arr[1]);
        swap(arr);
        System.out.println("交换之后的数arr[0] "+arr[0]+"和arr[1] "+arr[1]);
    }
}*/




//顺序表

/*
class MyArrayList{
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
    public void add(int pos, int data) {//插入
        if(pos<0||pos>this.usedSize)
        {
            return ;
        }
        if(this.usedSize==this.elem.length){//扩容
            this.Capacity(elem);
        }else{
            for (int i = this.usedSize-1; i >=pos ; i--) {
                elem[i+1]=elem[i];
            }
            this.elem[pos]=data;
            this.usedSize++;
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++
        }

    }

    public boolean contains(int toFind){//查找
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind) { // 查找某个元素对应的位置
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(pos==i){
                return this.elem[i];
            }
        }
        return -1;
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(pos==i){
                this.elem[i]=value;
            }
        }
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i]==toRemove){
                for (int j = i; j <this.usedSize ; j++) {
                    this.elem[j]=this.elem[j+1];
                }
                this.elem[this.usedSize-1]=0;
                this.usedSize--;
                break;
            }
        }
    }

    //删除第一次出现的关键字key
    public void remove1(int toRemove) {
        if(this.usedSize==0){
            System.out.println("顺序表儿没有数据！");
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i]==toRemove){
                for (int j = i; j <this.usedSize-1 ; j++) {
                    this.elem[j]=this.elem[j+1];
                }
                this.elem[this.usedSize-1]=0;
                this.usedSize--;
                break;
            }
        }
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }




    public void Capacity(int[] array){
        this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
    }


    public void Show(){
        for (int i=0;i<this.usedSize;i++) {
            System.out.println(this.elem[i]);
        }
    }


}

public class Demo{

    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,13);
        myArrayList.add(1,43);
        myArrayList.add(2,3);
        myArrayList.add(3,23);
        myArrayList.Show();
        myArrayList.remove(23);
        myArrayList.Show();
        System.out.println("++++++++++++++++++++");
        System.out.println(myArrayList.size());
        myArrayList.clear();
        myArrayList.Show();
    }
}*/


class ListNode{
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}

class MySignalList{
    public ListNode head;
    public MySignalList(){
        this.head=null;
    }

    //头插法
    public void addFirst(int data){
        ListNode pGet=new ListNode(data);
        if(this.head==null){
            this.head=pGet;
        }else{
            pGet.next=this.head;
            this.head=pGet;
        }
    }

    //尾插法
    public void addTail(int data){
        ListNode pCur=this.head;
        ListNode pGet=new ListNode(data);
        if(this.head==null){
            this.head=pGet;
        }else{
            while(pCur.next!=null){
                pCur=pCur.next;
            }
            pCur.next=pGet;
        }
    }

    //看链表中是否包含key
    public boolean contains(int key){
        ListNode pCur=this.head;
        while(pCur.data!=key){
            if(pCur.next==null){
                return false;
            }
            pCur=pCur.next;
        }
        return true;
    }

    //得到长度
    public int getLength(){
        ListNode pCur=this.head;
        int count=0;
        while(pCur.next!=null){
            count++;
            pCur=pCur.next;
        }
        return count;
    }



    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        int count=index-1;
        while(cur.next!=null&&count!=0){
            cur=cur.next;
            count--;
        }
        return cur;
        //cur -> index-1

    }
    public void addIndex(int index,int data){
        if(index<0||index>getLength()){
            System.out.println("不合法的下标!");
            return ;
        }else{
            if(index==0){
                addFirst(data);
            }else{
                ListNode pCur=searchIndex(index);
                ListNode pGet=new ListNode(data);
                pGet.next=pCur.next;
                pCur.next=pGet;
            }
        }
    }
    public void disPlay(){
        ListNode Cur=this.head;
        while(Cur.next!=null){
            System.out.println(Cur.data);
            Cur=Cur.next;
        }
    }
}



public class Demo{
    public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addFirst(13);
        mySignalList.addFirst(23);
        mySignalList.addFirst(33);
        mySignalList.addFirst(43);
        mySignalList.addFirst(53);
        mySignalList.disPlay();
        System.out.println("++++++++++++++++++++");
        mySignalList.addIndex(2,14);
        mySignalList.disPlay();
    }
}





