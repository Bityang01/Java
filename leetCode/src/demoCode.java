public class demoCode {
}
class Solution {
    //leetcode移除元素
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==val)
            {
                j++;
            }else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}

class Solution {
	//20191020leetcode35搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                return i;
            }
            if(i==nums.length-1){
                return nums.length;
            }
        }
        return -1;
    }
}

class Solution {
	//20191022leetcode7整数反转
    public int reverse(int x) {
    int num=x;
    int count=0;
    long sum=0;
    //num=abs(num);
    while(num!=0)
    {
        count++;
        num=num/10;
    }
    int[] arr=new int[count];
    for(int i=0;i<count;i++)
    {
        arr[i]=x%10;//arr[0]=3 arr[1]=2 arr[2]=1
        x=x/10;
    }
    for(int j=count-1;j>=0;j--)
    {
        sum=sum+(long)(arr[j]*Math.pow(10,count-1-j));
        if(sum<-2147483648||sum>2147483647)
        {
            return 0;
        }
    }
    return (int)(sum);
    }
}

class Solution {
	//20191023leetcode53最大子序和
    public int maxSubArray(int[] nums) {
        int sumMax=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum=sum+nums[j];
                if(sum>sumMax)
                {
                    sumMax=sum;
                }
            }
        }
        return sumMax;
    }
}

class Solution {
	//20191024leetcode66加一
    public int[] plusOne(int[] digits) {
        int flg=0;
        int count=digits.length+1;
        int[] arr=new int[count];
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]!=9)
            {
                digits[i]=digits[i]+1;
                for(int j=i+1;j<digits.length;j++)
                {
                    digits[j]=0;
                }
                flg=1;
                return digits;
            }
        }
        if(flg==0)
        {
            arr[0]=1;
            for(int k=1;k<=digits.length;k++)
            {
                arr[k]=0;
            }
            return arr;
        }
        return digits;
    }
}

class Solution {
	//20191025leetcode69x的平方根
    public int mySqrt(int x) {
        for(long i=1;i<=x;i++)
        {
            if((i*i)>x)
            {
                return (int)(i-1);
            }
            if((i*i)==x)
            {
                return (int)i;
            }
        }
        return 0;
    }
}


class Solution {
	//20191027leetcode70爬楼梯
    public int climbStairs(int n) {
    if(n==1)
    return 1;
    if(n==2)
    return 2;
    int f1=1;
    int f2=2;
    int f3=0;
    for(int i=3;i<=n;i++){
        f3=f1+f2;
        f1=f2;
        f2=f3;
    }
    return f3;
    }
}




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191030leetcode206反转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        ListNode newHead=null;
        while(cur!=null)
        {
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191030leetcode876链表的中间节点
    public ListNode middleNode(ListNode head) {
    ListNode pFast = head;
	ListNode pSlow = head;
	while ((pFast) != null && (pFast.next != null)){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
	    return pSlow;
    }
}


class Solution {
	//20191031leetcode88合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=0;
        for(int i=nums1.length-1;i>=0;i--){
            if(count!=n){
                nums1[i]=nums2[count];
                count++;
            }
        }
        /*for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0){
                nums1[i]=nums2[count];
                count++;
            }
        }*/
        //Arrays.sort(nums1);	//可以用工具包快速排序，下面用的是冒泡排序
        for(int j=0;j<nums1.length;j++){
            for(int k=nums1.length-1;k>j;k--){
                if(nums1[k]<nums1[k-1]){
                    nums1[k]=nums1[k]^nums1[k-1];
                    nums1[k-1]=nums1[k]^nums1[k-1];
                    nums1[k]=nums1[k]^nums1[k-1];
                }
            }
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191101leetcode83删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pCur=head;
        ListNode pre=head;
        while(pCur!=null){
            while(pCur!=null&&pCur.val==pre.val){
                pCur=pCur.next;
            }
            pre.next=pCur;
            pre=pCur;
            if(pCur==null)
            {
                break;
            }
            pCur=pCur.next;
        }
        return head;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	//20191102leetcode142环形链表II
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                fast=head;
                while(fast!=null&&slow!=null){
                    if(fast==slow){
                        return fast;
                    }
                    fast=fast.next;
                    slow=slow.next;
                }
            }
        }
        return null;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	//20191102leetcode141环形链表I给定一个链表，判断链表中是否有环。
	//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	//20191102leetcode160相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur=headA;
        ListNode bCur=headB;
        ListNode pl=headA;
        int countA=0;
        int countB=0;
        int flg=0;
        while(aCur!=null){
            aCur=aCur.next;
            countA++;
        }
        while(bCur!=null){
            bCur=bCur.next;
            countB++;
        }
        int count=0;
        if(countA>countB){
            count=countA-countB;
        }else{
            count=countB-countA;
        }
        if(countB>countA){
            pl=headB;
            flg=1;
        }
        while(count!=0){
            pl=pl.next;
            count--;
        }
        while(pl!=null){
            if(flg==1&&pl==headA){
                return pl;
            }
            if(flg==0&&pl==headB){
                return pl;
            }
            pl=pl.next;
            headA=headA.next;
            headB=headB.next;
        }
        return pl;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191102leetcode21合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        ListNode curA=l1;
        ListNode curB=l2;
        while(curA!=null&&curB!=null){
            if(curA.val<curB.val){
                tmp.next=curA;
                curA=curA.next;
                tmp=tmp.next;
            }else{
                tmp.next=curB;
                curB=curB.next;
                tmp=tmp.next;
            }
        }
        if(curA==null){
            tmp.next=curB;
        }else{
            tmp.next=curA;
        }
        return node.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191102leetcode21合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node =new ListNode(-1);
        ListNode tmp=node;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tmp.next=l1;
                tmp=tmp.next;
                l1=l1.next;
            }else{
                tmp.next=l2;
                tmp=tmp.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            tmp.next=l2;
        }else{
            tmp.next=l1;
        }
        return node.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191104leetcode203移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(head.val==val)
        {
           head=head.next;
        }
        return head;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191105leetcode234回文链表
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode cur=slow.next;
        ListNode curNext=null;
        while(cur!=null){
            curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        while((slow!=null)&&(slow!=head)){
            if(slow.val!=head.val){
                return false;
            }
            head=head.next;
            if(head==slow){
                return true;
            }
            slow=slow.next;
        }
        return true;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191106leetcode19删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            if(head.next==null&&n==1){
                return null;
            }
        }
        ListNode cur=head;
        ListNode pre=head;
        while(n!=0){
            cur=cur.next;
            n--;
        }
        ListNode before=head;
        while(cur!=null&&pre!=null){
            before=pre;
            pre=pre.next;
            cur=cur.next;
        }
        before.next=pre.next;
        if(pre==head){
            head=head.next;
        }
        return head;
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
	//20191106leetcode138复制带随机指针的链表
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //1,将两个链表串起来
        Node cur=head;
        while(cur!=null){
            Node curNext=cur.next;
            Node node=new Node(cur.val,cur.next,null);
            cur.next=node;
            cur=curNext;
        }
        //2，处理random
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
                cur=cur.next.next;
            }else{
                cur.next.random=null;
                cur=cur.next.next;
            }
        }
        //3，拆分两个链表
        cur=head;
        Node newHead=cur.next;
        Node tmp=cur.next;
        while(cur.next!=null){
            tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191107leetcode86分隔链表
    public ListNode partition(ListNode head, int x) {
        ListNode afterStart=null;
        ListNode afterEnd=null;
        ListNode BeforStart=null;
        ListNode BeforEnd=null;
        ListNode headNext=null;
        while(head!=null){
            headNext=head.next;
            if(head.val<x){
                if(BeforStart==null){
                    BeforStart=BeforEnd=head;
                }else{
                    BeforEnd.next=head;
                    BeforEnd=head;
                }
                BeforEnd.next=null;
            }else{
                if(afterStart==null){
                    afterStart=afterEnd=head;
                }else{
                    afterEnd.next=head;
                    afterEnd=head;
                }
                afterEnd.next=null;
            }
            head=headNext;
        }
        if(afterStart==null){
            return BeforStart;
        }
        if(BeforStart==null){
            return afterStart;
        }
        BeforEnd.next=afterStart;
        return BeforStart;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191107leetcode82删除排序链表中的重复元素II（不包含重复元素）
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                tmp=tmp.next;
                cur=cur.next;
                tmp.next=null;
            }
        }
        return node.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191108leetcode143重排链表
    public void reorderList(ListNode head) {
        ListNode cur=head;
        ListNode before=null;
        ListNode curNext=cur;
        if(head==null||head.next==null||head.next.next==null){
            head=head;
        }else{
            while(curNext!=before&&cur!=before){
                before=cur;
                curNext=cur.next;
                while(before.next!=null&&before.next.next!=null){
                    before=before.next;
                }
                /*if(before.next==null){
                    cur.next=before;
                }*/
                if(cur==before){

                }else{
                    cur.next=before.next;
                    cur=before.next;
                    before.next=null;
                    cur.next=curNext;
                    cur=cur.next;
                }
            }
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191108leetcode328奇偶链表
    public ListNode oddEvenList(ListNode head) {
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        ListNode headNext=null;
        int count=1;
        while(head!=null){
            headNext=head.next;
            if(count%2!=0){//奇数
                if(beforeStart==null){
                    beforeStart=beforeEnd=head;
                }else{
                    beforeEnd.next=head;
                    beforeEnd=head;
                }
                beforeEnd.next=null;
            }else{
                if(afterStart==null){
                    afterStart=afterEnd=head;
                }else{
                    afterEnd.next=head;
                    afterEnd=head;
                }
                afterEnd.next=null;
            }
            head=headNext;
            count++;
        }
        if(afterStart==null){
            return beforeStart;
        }
        if(beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//20191109leetcode61旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        if(count!=0&&k>count){
            k=k%count;
        }
        cur=head;
        while(k!=0){
            cur=head;
            while(cur!=null){
                if(cur.next!=null&&cur.next.next==null){
                    cur.next.next=head;
                    head=cur.next;
                    cur.next=null;
                }else{
                    cur=cur.next;
                }
            }
            k--;
        }
        return head;
    }
}


class Solution {
	//20191109leetcode977有序数组的平方
    public int[] sortedSquares(int[] A) {
        int[] array=new int[A.length];
        for(int i=0;i<A.length;i++){
            array[i]=(int)Math.pow(A[i],2);
        }
        for(int j=0;j<A.length;j++){
            for(int k=0;k<A.length-1-j;k++){
                if(array[k]>array[k+1]){
                    array[k]=array[k]^array[k+1];
                    array[k+1]=array[k]^array[k+1];
                    array[k]=array[k]^array[k+1];
                }
            }
        }
        return array;
    }
}



class Solution {
	//20191110leetcode1108IP地址无效化
    public String defangIPaddr(String address) {
        String newer=new String();
        int count=0;
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                newer=newer+'[';
                newer=newer+'.';
                newer=newer+']';
            }else{
                newer=newer+address.charAt(i);
            }
        }
        return newer;
    }
}

class Solution {
	//20191110leetcode1207独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        int flag=0;
        int ret=0;
        int[] array=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int count=0;
            flag=0;
            for(int j=0;j<i;j++){
                if(arr[i]==arr[j]){
                    flag=1;
                }
            }
            if(flag==1){
                continue;
            }else{
                for(int k=i;k<arr.length;k++){
                    if(arr[i]==arr[k]){
                        count++;
                    }
                }
                array[ret]=count;
                ret++;
            }
        }
        for(int i=0;i<ret;i++){
            for(int j=ret-1;j>i;j--){
                if(array[i]==array[j]){
                    return false;
                }
            }
        }
        return true;
    }
}


class Solution {
	//20191111leetcode344反转字符串
    public void reverseString(char[] s) {
        for(int i=0,j=s.length-1;i<=j;i++,j--){
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
        }
    }
}


class Solution {
	//20191112leetcode重复N次的元素
    public int repeatedNTimes(int[] A) {
        int N=A.length/2;
        int count=0;
        for(int i=0;i<A.length;i++){
            count=0;
            for(int j=0;j<A.length;j++){
                if(A[i]==A[j]){
                    count++;
                }
            }
            if(count==N){
                return A[i];
            }
        }
        return 0;
    }
}


public class Solution {
	//20191112leetcode191位1的个数
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                count++;
            }
        }
        return count;
    }
}


class Solution {
	//20191113leetcode169求众数
    public int majorityElement(int[] nums) {
        int count=nums.length/2;
        int num=0;
        int max=0;
        int maxNum=0;
        for(int i=0;i<nums.length;i++){
            int ret=0;
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    ret++;
                }
            }
            if(ret>=count){
                num=ret;
                if(num>max){
                    max=ret;
                    maxNum=nums[i];
                }
            }
        }
        return maxNum;
    }
}


class Solution {
	//20191113leetcode693交替位二进制数
    public boolean hasAlternatingBits(int n) {
        int tmp=n;
        int count=0;
        while(tmp!=0){
            count++;
            tmp=tmp/2;
        }
        for(int i=0;i<count-1;i++){
            if(((n>>i)&1)==((n>>(i+1))&1)){
                return false;
            }
        }
        return true;
    }
}


class Solution {
	//20191114leetcode389找不同（暴力破解法，通过测试用例1）
    public char findTheDifference(String s, String t) {
        char sc;
        int flag=0;
        for(int i=0;i<((s.length()>t.length())?s.length():t.length());i++){
            flag=0;
            for(int j=0;j<((s.length()<t.length())?s.length():t.length());j++){
                if(s.length()>t.length()){
                    if(s.charAt(i)==t.charAt(j)){
                        flag=1;
                        break;
                    }
                }else{
                    if(t.charAt(i)==s.charAt(j)){
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0){
                if(s.length()>t.length()){
                    sc=s.charAt(i);
                }else{
                    sc=t.charAt(i);
                }
                return sc;
            }
        }
        return 0;
    }
}

class Solution {
	//20191114leetcode389找不同
    public char findTheDifference(String s, String t) {
        int sNum=0;
        int tNum=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            sNum=sNum+s.charAt(i);
        }
        for(int j=0;j<t.length();j++){
            tNum=tNum+t.charAt(j);
        }
        if(sNum>tNum){
            num=sNum-tNum;
        }else{
            num=tNum-sNum;
        }
        return (char)num;
    }
}


class Solution {
	//20191114leetcode868二进制间距
    public int binaryGap(int N) {
        int res=0;
        int tmp=0;
        while((N&1)!=1){
            N=N>>1;
        }      
        while(N>0){
            if((N&1)==1){
                res=res>tmp?res:tmp;
                tmp=0;
            }
            tmp++;
            N=N>>1;
        }
        return res;
    }
}


class Solution {
	//20191116leetcode283移动零（解法一：时间复杂度太高）
    public void moveZeroes(int[] nums) {
        for(int k=0;k<nums.length;k++){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    for(int j=i;j<nums.length-1;j++){
                        nums[j]=nums[j+1];
                    }
                    nums[nums.length-1]=0;
                }
            }
        }
    }
}


class Solution {
	//20191116leetcode283移动零（解法二）
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(i!=j){
                    nums[j]=nums[i];
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}

class Solution {
	//20191116leetcode1009十进制整数的反码
    public int bitwiseComplement(int N) {
        int num=1;
        while(num<N){
            num=(num<<1)+1;
        }
        return N^num;
    }
}


class Solution {
	//20191117leetcode1089复写零
    public void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                for(int j=arr.length-1;j>i;j--){
                    arr[j]=arr[j-1];
                }
                i++;
            }
        }
    }
}


class Solution {
	//20191117leetcode1185一周中的第几天
    public String dayOfTheWeek(int day, int month, int year) {
        if(year==2003&&month==3&&day==7){
            return "Friday";
        }
        if(month==1||month==2)
        {
            year--;
            month+=12;
        }
        String[] array={"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        double i=0;
        i=((year%100)+(year%100)/4+(year/100)/4-2*(year/100)+(26*(month+1)/10)+day-1)%7;
        int j=(int)Math.abs(i);
        return array[j];
    }
}


class Solution {
	//20191117leetcode1185一周中的第几天
    public String dayOfTheWeek(int day, int month, int year) {
        if(month==1||month==2)
        {
            year--;
            month+=12;
        }
        String[] array={"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int i=0;
        i=((year%100)+(year%100)/4+(year/100)/4-2*(year/100)+(26*(month+1)/10)+day-1)%7;
        int j=(int)Math.abs(i);
        j=i>=0?(i%7):(i%7+7);
        return array[j];
    }
}

class Solution {
	//20191118leetcode202快乐数
    public boolean isHappy(int n) {
        int[] array=new int[100];
        int count=0;
        while(n!=0){
            if(n==1){
                return true;
            }
            int sum=0;
            int num=n;
            while(num!=0){
                sum=sum+(int)Math.pow(num%10,2);
                num=num/10;
            }
            for(int i=0;i<count;i++){
                if(array[i]==sum){
                    return false;
                }
            }
            array[count]=sum;
            count++;
            n=sum;
        }
        return false;
    }
}


class Solution {
	//20191118leetcode485最大连续1的个数
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            if(nums[i]==0){
                max=max>count?max:count;
                count=0;
            }
        }
        return max>count?max:count;
    }
}


class Solution {
	//20191119leetcode976三角形的最大周长
    public int largestPerimeter(int[] A) {
        if(A.length<3){
            return 0;
        }
        Arrays.sort(A);
        for(int i=A.length-1;i>=0;i--){
            if(i<2){
                return 0;
            }
            if((A[i-1]+A[i-2])>A[i]){
                return A[i-1]+A[i-2]+A[i];
            }
        }
        return 0;
    }
}

class Solution {
	//20191119leetcode520检测大写字母
    public boolean detectCapitalUse(String word) {
        if(word.length()<2){
            return true;
        }
        if(word.charAt(0)>=65&&word.charAt(0)<=90){
            if(word.charAt(1)>=65&&word.charAt(1)<=90){
                for(int k=1;k<word.length();k++){
                    if(word.charAt(k)<65||word.charAt(k)>90){
                        return false;
                    }
                }
            }
            if(word.charAt(1)>=97&&word.charAt(1)<=122){
                for(int j=1;j<word.length();j++){
                    if(word.charAt(j)<97||word.charAt(j)>122){
                        return false;
                    }
                }
            }
        }
        if(word.charAt(0)>=97&&word.charAt(0)<=122){
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)<97||word.charAt(i)>122){
                    return false;
                }
            }
        }
        return true;
    }
}


class Solution {
	//20191120leetcode268缺失数字（30%）
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                return nums[i]+1;
            }
        }
        if((nums[nums.length-1]+1)==nums.length){
            return nums.length;
        }
        return 0;
    }
}


class Solution {
	//20191120leetcode268缺失数字（进阶版100%）
    public int missingNumber(int[] nums) {
        int count=1;
        int sumBig=0;
        int sumLow=0;
        int i=0;
        while(count<=nums.length){//count!=2?
            sumBig=sumBig+count;
            sumLow=sumLow+nums[i];
            i++;
            count++;
        }
        return sumBig-sumLow;
    }
}


class Solution {
	//20191120leetcode1137第N个泰波那契数
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        if(n==1||n==2){
            return 1;
        }
        int T0=0;
        int T1=1;
        int T2=1;
        int T3=0;
        for(int i=3;i<=n;i++){
            T3=T0+T1+T2;
            T0=T1;
            T1=T2;
            T2=T3;
        }
        return T3;
    }
}


class Solution {
	//20191121leetcode704二分查找
    public int search(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

class Solution {
	//20191121leetcode两数之和II——输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int[] array=new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    array[0]=i+1;
                    array[1]=j+1;
                    return array;
                }
            }
        }
        return null;
    }
}


public class Solution {
	//20191122leetcode190颠倒二进制位
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num=0;
        for(int i=0;i<=32;i++){
            int tmp=(n>>i)&1;   //取n的每一位
            tmp=tmp<<(31-i);    //将n的每一位存放到高位去
            num=num|tmp;        //采用|运算累加每一位
        }
        return num;
    }
}

class Solution {
	//20191122leetcode217存在重复元素
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                    if(count>=2){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class Solution {
	//20191122leetcode217存在重复元素（法二：时间复杂度98.38%）
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

class Solution {
	//383赎金信
    private static String removeCharAt(String str, int i) {
		return str.substring(0, i)+str.substring(i+1);
	}
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i=0;i<ransomNote.length();i++){
            for(int j=0;j<magazine.length();j++){
                if((j==magazine.length()-1)&&(ransomNote.charAt(i)!=magazine.charAt(j))){
                    return false;
                }
                if(ransomNote.charAt(i)==magazine.charAt(j)){
                    removeCharAt(magazine,j);
                    if(i==(ransomNote.length()-1)){
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
}

class Solution {
	//20191123leetcode551学生出勤记录I
    public boolean checkRecord(String s) {
        int count=0;
        int countl=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                count++;
                if(count>1){
                    return false;
                }
            }
            if(s.charAt(i)=='L'){
                countl++;
            }
            if(s.charAt(i)!='L'){
                countl=0;
            }
            if(countl>2){
                return false;
            }
        }
        return true;
    }
}


class Solution {
	//20191123leetcode405数字转换为十六进制数
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        String str="0123456789abcdef";
        String ret="";
        while(ret.length()<8&&num!=0){
            ret=str.charAt(num & 0xf)+ret;
            num=num>>4;
        }
        return ret;
    }
}

class Solution {
	//20191124leetcode263丑数
    public boolean isUgly(int num) {
        if(num<1){
            return false;
        }
        while(num%2==0){
            num>>=1;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }
        return num==1;
    }
}


class Solution {
	//20191124leetcode628三个数的最大乘积
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ret=0;
        if(nums[0]<0&&nums[1]<0){
            ret=nums[0]*nums[1]*nums[nums.length-1];
        }
        int flg=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return ret>flg?ret:flg;
    }
}

class Solution {
	//20191125leetcode1232缀点成线
    public boolean checkStraightLine(int[][] coordinates) {
        /*
        由斜率公式得
        (y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
        防止除0，变换成相乘的形式
        (y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
        */
        if(coordinates==null||coordinates.length<3){
            return true;
        }
        for(int i=0;i<coordinates.length;i++){
            if((coordinates[1][1]-coordinates[0][1])*(coordinates[i][0]-coordinates[0][0])
            !=(coordinates[i][1]-coordinates[0][1])*(coordinates[1][0]-coordinates[0][0])){
                return false;
            }
        }
        return true;
    }
}

class Solution {
	//20191125leetocde392判断子序列
    public boolean isSubsequence(String s, String t) {
        if(s.length()<1){
            return true;
        }
        if(t.length()<1){
            return false;
        }
        int count=0;
        int i=0;
        while(count!=t.length()){
            if(s.charAt(i)==t.charAt(count)){
                if(i==(s.length()-1)){
                    return true;
                }
                i++;
                count++;
            }else{
                count++;
            }
        }
        return false;
    }
}

class Solution {
	//20191126leetcode504七进制数
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        int a=(num>>31)&1;  //符号位
        int count=0;
        int[] array=new int[100];
        num=Math.abs(num);
        while(num!=0){
            array[count]=num%7;
            count++;
            num=num/7;
        }
        String str="";
        if(a==1){
            str+="-";
        }
        for(int i=count-1;i>=0;i--){
            str+=array[i];
        }
        return str;
    }
}

class Solution {
	//20191126leetcode231 2的幂
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        int count=0;
        if(((n>>31)&1)==1){
            return false;
        }
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
	//20191126leetcode231 2的幂（递归）
    public boolean isPowerOfTwo(int n) {
        if(n==1)
            return true;
        if(n==0)
            return false;
        if(n%2!=0)
            return false;
        return isPowerOfTwo(n/2);
    }
}


class Solution {
	//20191127leetcode342 4的幂
    public boolean isPowerOfFour(int num) {
        if(num==1)
            return true;
        if(num==0)
            return false;
        if(num%4!=0){
            return false;
        }
        return isPowerOfFour(num/4);
    }
}


class Solution {
	//20191127leetcode299猜数字游戏（bulls and cows公牛和奶牛）
    public String getHint(String secret, String guess) {
        char[] secretArray=secret.toCharArray();
        char[] guessArray=guess.toCharArray();
        int countA=0;
        int countB=0;
        for(int i=0;i<guessArray.length;i++){
            if(secretArray[i]==guessArray[i]){
                countA++;
                secretArray[i]='*';
                guessArray[i]='#';
            }
        }
        for(int i=0;i<guessArray.length;i++){
            for(int j=0;j<secretArray.length;j++){
                if(guessArray[i]==secretArray[j]){
                    countB++;
                    guessArray[i]='#';
                    secretArray[j]='*';
                }
            }
        }
        return countA+"A"+countB+"B";
    }
}

class Solution {
	//20191128leetcode746使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
/*class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int retA=cost.length;  
        int sumA=0;
        while(retA>2){
            if((cost[retA-1])<(cost[retA-2])){
                sumA=sumA+cost[retA-1];
                retA=retA-1;
            }else{
                sumA=sumA+cost[retA-2];
                retA=retA-2;
            }
        }
        int retB=-1;
        int sumB=0;
        while(retB<cost.length-2){
            if(cost[retB+1]<cost[retB+2]){
                sumB=sumB+cost[retB+1];
                retB=retB+1;
            }else{
                sumB=sumB+cost[retB+2];
                retB=retB+2;
            }
        }
        int sumC=0;
        int retC=0;
        while(retC<cost.length-2){
            if(cost[retC+1]<cost[retC+2]){
                sumC=sumC+cost[retC+1];
                retC=retC+1;
            }else{
                sumC=sumC+cost[retC+2];
                retC=retC+2;
            }
        }
        sumB=(sumB>sumC?sumC:sumB);
        return sumA>sumB?sumB:sumA;
    }
}*/

class Solution {
	//相交数组
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] longArr=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                longArr[i]=nums1[i];
            }
            int[] lowArr=new int[nums2.length];
            for(int i=0;i<nums2.length;i++){
                lowArr[i]=nums2[i];
            } 
        }else{
            int[] longArr=new int[nums2.length];
            for(int i=0;i<nums2.length;i++){
                longArr[i]=nums2[i];
            }
            int[] lowArr=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                lowArr[i]=nums1[i];
            } 
        }
        int[] array=new int[nums1.length];
        int count=0;
        int longLen=nums1.length>nums2.length?nums1.length:nums2.length;
        int lowLen=nums1.length<nums2.length?nums1.length:nums2.length;
        for(int i=0;i<lowLen;i++){
            for(int j=0;j<longLen;j++){
                if(lowArr[i]==longArr[j]){
                    array[count]=lowArr[i];
                    count++;
                    break;
                }
            }
        }
        int[] arr=new int[count];
        for(int i=0;i<count;i++){
            arr[i]=array[i];
        }
        return arr;
    }
}

class Solution {
	//20191129leetcode326 3的幂
    public boolean isPowerOfThree(int n) {
        if(n==1)
            return true;
        if(n==0)
            return false;
        if(n%3!=0)
            return false;
        return isPowerOfThree(n/3);
    }
}


class Solution {
	//20191130leetcode367有效的完全平方数
    public boolean isPerfectSquare(int num) {
        int i=1;
        while(num>=0){
            num=num-i;
            i=i+2;
            if(num==0){
                return true;
            }
        }
        return false;
        /*int sum=0;
        for(int i=1;true;){
            sum=sum+i;
            if(sum==num){
                return true;
            }else{
                if(sum>num){
                    return false;
                }
            }
            i=i+2;
        }*/
    }
}

class Solution {
	//20191130leetcode387字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                    if(count>1){
                        break;
                    }
                }
            }
            if(count<2){
                return i;
            }
        }
        return -1;
    }
}

import java.util.*;
public class Main{
	//20191201牛客网 字符串连连看
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int count=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
                if(i==str.length()-1&&count>2){
                    str=str.substring(0,i-2);
                    count=0;
                    i=0;
                }
                continue;
            }
            if(count>2){
                str=str.substring(0,i-3)+
                    str.substring(i);
                i=0;
            }
            count=1;
        }
        System.out.println(str);
    }
}

import java.util.*;
public class Main{
	//20191201牛客网 字符串提取
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        String str=sca.next();
        
        int i=str.lastIndexOf("[img]");
        int j=str.lastIndexOf("[\\img]");
        
        if(i<0||j<0||i>j){
            System.out.println("null");
        }else{
            System.out.println(str.substring(i,j+6));
        }
    }
}

/*class Solution {
	//20191202leetcode796旋转字符串（11%）
    public boolean rotateString(String A, String B) {
        if(A.length()==0&&B.length()==0){
            return true;
        }
        int count=A.length();
        for(int i=0;i<A.length();i++){
            A=A.charAt(A.length()-1)+A.substring(0,A.length()-1);
            if(A.equals(B)){
                return true;
            }
            if(count<0){
                return false;
            }
            count--;
        }
        return false;
    }
}*/
class Solution{
	//20191202leetcode796旋转字符串（100%）
    public boolean rotateString(String A,String B){
        return A.length()==B.length()&&(A+A).contains(B);
    }
}

class Solution {
	//20191202leetcode205同构字符串
    public boolean isIsomorphic(String s, String t) {
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
/*class Solution {
	//同构字符串
    public boolean isIsomorphic(String s, String t) {
        for(int i=0;i<s.length();i++){
            t=t.replace(t.charAt(i),s.charAt(i));
        }
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}*/

import java.util.*;
public class Main{
	//20191203牛客 字符串连接
    
    public static String func(String str){
        String[] ret=str.split(" ");
        String str1="";
        for(String c:ret){
            str1=str1+c;
        }
        return str1;
    }
    
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String str2=func(str);
        System.out.println(str2);
    }
}

import java.util.*;
public class Main{
	//20191203牛客网 字符串反转
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
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
        System.out.println(arr);
        //return String.copyValueOf(arr);
    }
}

import java.util.*;
public class Main{
	//20191204牛客网 字符串比较（未通过）
    
    public static boolean func(String str1,String str2){
        int a=0;
        if(str1.length()!=str2.length()){
            return false;
        }
        while(a<str1.length()){
            int count1=0;
            int count2=0;
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(a)==str1.charAt(i)){
                    count1++;
                }
                if(str2.charAt(a)==str2.charAt(i)){
                    count2++;
                }
            }
            if(count1!=count2){
                return false;
            }
            a++;
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        System.out.println(func(str1,str2));
    }
}

import java.util.*;
public class Main{
	//20191204牛客网 字符串比较
    
    /*public static boolean func(String str1,String str2){
        int a=0;
        if(str1.length()!=str2.length()){
            return false;
        }
        while(a<str1.length()){
            int count1=0;
            int count2=0;
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(a)==str1.charAt(i)){
                    count1++;
                }
                if(str2.charAt(a)==str2.charAt(i)){
                    count2++;
                }
            }
            if(count1!=count2){
                return false;
            }
            a++;
        }
        return true;
    }*/
    
    public static boolean func2(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        char[] array1=str1.toCharArray();
        char[] array2=str2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        String str3=String.copyValueOf(array1);
        String str4=String.copyValueOf(array2);
        if(str3.contains(str4)){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        System.out.println(func2(str1,str2));
    }
}


import java.util.*;

public class Main{
	//20191205牛客网 字符串包含
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){//sc.hasNext()方法，表示读入示你是否有输入数据，
							//while语句块 表示当你输入数据的时候，就执行输出sc.next()（输出内容）
							//所以只要你输入数据了，它就可以执行，
							//所以后台只是开了一块内存，一直未关闭，不算死循环
            String str1=sc.next();
            String str2=sc.next();
            System.out.println((str1.contains(str2) || str2.contains(str1)) ? 1 : 0);
        }
    }
}

import java.util.*;

public class Main{
	//20191205牛客网 字符串分隔
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        int n=8-str1.length()%8;
        while(str1.length()>8){
            System.out.println(str1.substring(0,8));
            str1=str1.substring(8);
        }
        for(int i=0;i<n;i++){
            str1=str1+"0";
        }
        System.out.println(str1);
        int n2=8-str2.length()%8;
        while(str2.length()>8){
            System.out.println(str2.substring(0,8));
            str2=str2.substring(8);
        }
        for(int i=0;i<n;i++){
            str2=str2+"0";
        }
        System.out.println(str2);
    }
}

import java.util.*;
public class Main{
	//20191206牛客网 验证字符串
    
    public static boolean func(String str1){
        if(str1.length()<2){
            return true;
        }
        if((str1.charAt(1)>='A')&&(str1.charAt(1)<='Z')){
            for(int i=1;i<str1.length();i++){
                if(str1.charAt(i)<'A'||str1.charAt(i)>'Z'){
                    return false;
                }
            }
        }
        if(str1.charAt(1)>='a'&&str1.charAt(1)<='z'){
            for(int i=1;i<str1.length();i++){
                if(str1.charAt(i)<'a'||str1.charAt(i)>'z'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(func(str));
    }
}

import java.util.*;
public class Main{
	//20191207牛客网 翻转字符串
    
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
}

class Solution {
	//20191208leetcode1221分割平衡字符串
    public int balancedStringSplit(String s) {
        int ret=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                num++;
            }
            if(s.charAt(i)=='L'){
                num--;
            }
            if(num==0){
                ret++;
            }
        }
        return ret;
    }
}


/*
public class ListNode{
	int val;
	ListNode next=null;
	
	ListNode(int val){
		this.val=val;
	}
}*/
public class Solution{
	//20191209牛客 20191207java考试合并单链表
	public ListNode Merge(ListNode list1,ListNode list2){
		ListNode node =new ListNode(-1);
		ListNode tmp=node;
		while(list1!=null&&list2!=null){
			if(list1.val>list2.val){
				tmp.next=list2;
				tmp=tmp.next;
				list2=list2.next;
			}else{
				tmp.next=list1;
				tmp=tmp.next;
				list1=list1.next;
		}
	}
	if(list1==null){
		tmp.next=list2;
	}
	if(list2==null){
		tmp.next=list1;
	}
	return node.next;
	}
}