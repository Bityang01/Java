/*import java.util.*;
public class DemoTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String str2=scanner.nextLine();
        String str3=str+str2;
        *//*String str="123456789";
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)<'0')||(str.charAt(i)>'9')){
                System.out.println("false");
            }
        }
        System.out.println("true");*//*
    }
}


import java.util.*;
public class DemoTest{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
                if(i==s.length()-1&&count>=3){
                    s=s.substring(0,i-2);
                    count=0;
                    i=0;
                }
                continue;
            }
            if(count>=3){
                //很奇怪不是减count个，而是-3个，估计是题目的问题吧。。。
                s=s.substring(0,i-3)+s.substring(i);
                i=0;
            }
            count=1;
        }
        System.out.println(s);
    }
}*/

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
    }
}

class MySinalList{
    ListNode head=null;

    public void Insert(int val){
        if(this.head==null){
            this.head.val=val;
            return;
        }
        ListNode node=new ListNode(val);
        node.next=this.head;
        this.head=node;
    }

    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode Cur=this.head;
        while(Cur!=null){
            ListNode CurNext=Cur.next;
            Cur.next=pre;
            pre=Cur;
            Cur=Cur.next;
        }
        return pre;
    }


}
public class DemoTest{
    public static void main(String[] args) {

    }
}
/*
import java.util.*;
public class DemoTest{

    public static String reverse(String str){
        char[] arr=str.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            char tmp=arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;
            left++;
            right--;
        }
        return String.copyValueOf(arr);
    }

    public static String func(String str){
        String str1="";
        int count=0;
        for(int i=0;i<str.length();i++){
            if(i==str.length()-1){
                str1=str1+reverse(str.substring(i-count-1));
                break;
            }
            if(str.charAt(i)==' '){
                str1=str1+reverse(str.substring(i-count,i))+' ';
                count=0;
            }else{
                count++;
            }
        }
        return str1.substring(0,str1.length()-1);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(func(str));
    }
}*/
/*public class DemoTest{



    public static int Search(int[] arr,int key){
        int left=0;
        int right=arr.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]<key){
                left=mid++;
            }
            if(arr[mid]>key){
                right=mid--;
            }
            if(arr[mid]==key){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(Search(arr,1));
    }
}*/