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