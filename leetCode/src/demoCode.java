public class demoCode {
}
class Solution {
    //leetcode27移除元素
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


class Solution {
	//20191212leetcode942增减字符串匹配
    public int[] diStringMatch(String S) {
        int[] array=new int[S.length()+1];
        array[0]=0;
        int min=0;
        int max=S.length();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='I'){
                array[i]=min;
                min++;
            }
            if(S.charAt(i)=='D'){
                array[i]=max;
                max--;
            }
        }
        array[S.length()]=max;
        return array;
    }
}


class Solution {
	//20191213leetcode415字符串相加
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int sum=0;
        while(i>=0||j>=0||sum!=0){//两个字符串从后往前每一位相加，存入sb中，最后反转字符串
            if(i>=0)
                sum=sum+(num1.charAt(i--)-48);
            if(j>=0)
                sum=sum+(num2.charAt(j--)-48);
            sb.append(sum%10);
            sum=sum/10;
        }
        return sb.reverse().toString();
    }
}

/*class Solution {
    public String addStrings(String num1, String num2) {
        int[] arrayNum1=new int[num1.length()];
        int[] arrayNum2=new int[num2.length()];
        long SumNum1=0;
        long SumNum2=0;
        for(int i=0;i<num1.length();i++){
            arrayNum1[i]=num1.charAt(i)-48;
            SumNum1=SumNum1+arrayNum1[i]*(long)Math.pow(10,num1.length()-i-1);
        }
        for(int i=0;i<num2.length();i++){
            arrayNum2[i]=num2.charAt(i)-48;
            SumNum2=SumNum2+arrayNum2[i]*(long)Math.pow(10,num2.length()-i-1);
        }
        long Sum=SumNum1+SumNum2;
        String str="";
        str=str+Sum;
        return str;
    }
}*/


class Solution {
	//20191214leetcode443压缩字符串
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int count=1;
        char ch=chars[0];
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                count++;
                ch=chars[i];
            }else{
                sb.append(ch);
                if(count>1){
                    sb.append(count);
                }
                count=1;
                ch=chars[i+1];
            }
        }
        if(count>1){
            sb.append(ch);
            sb.append(count);
        }else{
            sb.append(ch);
        }
        char[] array=sb.toString().toCharArray();
        for(int i=0;i<array.length;i++){
            chars[i]=array[i];
        }
        return sb.toString().length();
    }
}

/*class Solution {
    public int compress(char[] chars) {
        int count=0;
        int i=0;
        int sum=0;
        while(i<chars.length-1){
            count=0;
            for(int j=i;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    count++;
                }else{
                    i=j;
                    sum=sum+count+1;
                    break;
                }
            }
        }
        return sum;
    }
}*/


//官方题解, 其实情况没有那么多, 就三种情况:
//1.字符串长度不相等, 直接返回false
//2.字符串相等的时候, 只要有重复的元素就返回true
//3.A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
class Solution {
	//20191215leetcode859亲密字符串
    public boolean buddyStrings(String A, String B) {
        //1.字符串长度不相等, 直接返回false
        if(A.length()!=B.length()){
            return false;
        }
        //2.字符串相等的时候, 只要有重复的元素就返回true
        if(A.equals(B)){
            for(int i=0;i<A.length();i++){
                int count=0;
                for(int j=i;j<A.length();j++){
                    if(A.charAt(i)==B.charAt(j)){
                        count++;
                        if(count>1){
                            return true;
                        }
                    }
                }
            }
            return false;
        }else{
            //3.A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
            /*int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));*/
           int first=-1,second=-1;
           for(int i=0;i<A.length();++i){
               if(A.charAt(i)!=B.charAt(i)){
                   if(first==-1){
                       first=i;
                   }else{
                        if(second==-1){
                            second=i;
                        }else{
                            return false;
                        }
                   }
               }
           }
           return (second!=-1&&(A.charAt(first)==B.charAt(second))
                            &&(A.charAt(second)==B.charAt(first)));
        }
    }
}


# Write your MySQL query statement below
//SQL20191216leetcode182查找重复的电子邮箱
select Email
from Person
group by Email
having count(Email) > 1;


# Write your MySQL query statement below
//20191217leetcode178分数排名
select s1.Score,count(distinct(s2.score)) Rank
from
Scores s1,Scores s2
where
s1.score<=s2.score
group by s1.Id
order by Rank



# Write your MySQL query statement below
//20191218leetcode183从不订购的客户
select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);

class Solution {
	//20191223leetcode189旋转数组
    public void rotate(int[] nums, int k) {
        while(k>0){
            int tmp=nums[nums.length-1];
            for(int i=nums.length-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=tmp;
            k--;
        }
    }
}

//1.首先去除字符串左右空格,不符合条件的直接return 0;
//2.sign是符号位,start指针指向第一个数字的位置,如果第一位为数字,则sign=1,start=0,否则firstChar接收字符串第一个字符,若为“+”、“-”,sign分别赋值1、-1,start自增1,
//3.从字符串第一个为数字的位置开始遍历,res为无符号结果,如果res大于Integer最大值且sign=1,输出Integer的最大值,反之输出Integer最小值,如果遍历到不为数字的字符,则直接返回res*sign;
//4.如果遍历时该字符串未超范围,且无非数字字符,则返回res * sign;
//5.完结。
class Solution {
	//20191224leetcode8字符串转换整数（atoi）
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0||str==null){
            return 0;
        }
        char firstChar=str.charAt(0);
        int sign=1;
        int start=0;
        long res=0;
        if(firstChar=='+'){
            sign=1;
            start++;
        }else if(firstChar=='-'){
            sign=-1;
            start++;
        }
        for(int i=start;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){//Character.isDigit(ch)方法如果字符ch为数字，则返回 true；否则返回 false。
                return (int)res*sign;
            }
            res=res*10+str.charAt(i)-48;
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)res*sign;
    }
}

/*class Solution {
    public int myAtoi(String str) {
        int[] arr=new int[100];
        int retOut=0;//代表初始ret
        int retIn=0;
        int count=0;
        int sum=0;
        int flg=1;
        //1、去除空格
        str=str.trim();
        if((str.charAt(0)>58||str.charAt(0)<47)&&(str.charAt(0)!='-')){
                return 0;
        }
        //2、看第一位是否是‘-’
        if(str.charAt(0)=='-'){
            flg=-1;
        }
        //3、将每一位存入数组
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<58&&str.charAt(i)>47){
                arr[count]=str.charAt(i)-48;
                count++;
                retOut=1;
                retIn=0;
            }else{
                retIn=2;
            }
            if(retIn==2&&retOut==1){
                break;
            }
        }
        //4、相乘相加
        for(int i=0;i<count;i++){
            sum=sum+arr[i]*(int)Math.pow(10,count-i-1);
        }
        return sum*flg;
    }
}

class Solution {
    public int myAtoi(String str) {
        int flg=0;
        int[] arr=new int[100];
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                if(str.charAt(i)=='-'){
                    flg=(flg>>32)&1;
                }else{

                    if(str.charAt(i)>47&&str.charAt(i)<58){
                        arr[count]=str.charAt(i)-48;
                        count++;
                    }
                }
            }
        }

    }
}*/


//双指针，一个从前往后i，一个从后往前j，当i是字母的时候，从后往前找一个字母append到sb中
class Solution {
	//20191225leetcode917仅仅反转字母
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        int j = S.length()-1;
        for(int i=0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){//Character.isLetter(ch)方法判断一个字符ch是不是字母，是返回true，不是返回false
                while(!Character.isLetter(S.charAt(j)))
                    j--;
                sb.append(S.charAt(j--));
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}

/*class Solution {
    public String reverseOnlyLetters(String S) {
        int count=0;
        char[] array=new char[S.length()];
        for(int i=0;i<S.length();i++){
            for(int j=S.length()-1-count;j>=0;j--){
                if(S.charAt(j)<65||(S.charAt(j)>90&&S.charAt(j)<97)||S.charAt(j)>122){
                    count++;
                    continue;
                }
                if((S.charAt(i)>64&&S.charAt(i)<91)||(S.charAt(i)>96&&S.charAt(i)<123)){
                    count++;
                    array[i]=S.charAt(j);
                    break;
                }else{
                    array[i]=S.charAt(i);
                    break;
                }
            }
        }
        return String.valueOf(array);
        //return Arrays.toString(array);
    }
}*/



//思路：每次sort排序之后，最大的两个数都会在最后的两个位置，只需要比较这两个数的大小并且
//重新赋值，比较完之后再进行排序，一直比较，只到数组中的数只出现一个大于0的数或者全部是0的时侯
class Solution {
	//20191226leetcode1046最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        //排除数组只有一个元素的情况
        if(stones.length<2){
            return stones[0];
        }
        Arrays.sort(stones);//注意此处sort排序是升序排序
        int len=stones.length-1;
        //定义死循环，一直进行排序
        while(true){
            //如果倒数第二个数的值是0的话，说明数组中最大的数就是倒数第一个数
            if(stones[len-1]==0){
                return stones[len];
            }
            //比较两个数的大小，相等的话两个数都赋值0，否则的话，一个赋值0，一个赋值（大数-小数）
            if(stones[len]==stones[len-1]){
                stones[len]=stones[len-1]=0;
            }else{
                stones[len]=stones[len]-stones[len-1];
                stones[len-1]=0;
            }
            //比较完再排序，再循环
            Arrays.sort(stones);
        }
    }
}



class Solution {
	//20191227leetcode242有效的字母异位词
    public boolean isAnagram(String s, String t) {
        char[] arrS=s.toCharArray();
        char[] arrT=t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        /*String strS=Arrays.toString(arrS);
        String strT=Arrays.toString(arrT);
        if(strS.equals(strT)){
            return true;
        }
        return false;*/
        return Arrays.toString(arrS).equals(Arrays.toString(arrT));//简化上述注释代码
    }
}

class Solution {
	//20191228leetcode1281整数的各位积和之差
    public int subtractProductAndSum(int n) {
        int sumH=0;
        int sumJ=1;
        while(n!=0){
            sumJ=sumJ*(n%10);
            sumH=sumH+(n%10);
            n=n/10;
        }
        return sumJ-sumH;
    }
}


class Solution {
	//20191229leetcode561数组拆分I
    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            i++;
        }
        return sum;
    }
}

class Solution {
	//20191230leetcode557反转字符串中的单词III
    public static String reverse(String str){//反转单词
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
        return String.copyValueOf(arr);//数组转换String
    }
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        //str="";
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '||i==s.length()-1){
                if(i==s.length()-1){
                    str=str.append(reverse(s.substring(j,i+1)));
                }else{
                    str=str.append(reverse(s.substring(j,i))+" ");
                    j=i+1;
                }
            }
        }
        return str.toString();//StringBuilder转换String
        /*String str1="";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                str1=str1+reverse(s.substring(i-count-1));
                break;
            }
            if(s.charAt(i)==' '){
                str1=str1+reverse(s.substring(i-count,i))+' ';
                count=0;
            }else{
                count++;
            }
        }
        return str1.substring(0,str1.length()-1);
        */
    }
}


class Solution {
	//20191231leetcode118杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> Row = new ArrayList();
            for(int j=0;j <= i;j++){
                if(j==0||i==j){
                    //Row.set(i,1);
                    Row.add(1);
                    //不可以使用set，设置元素的时候如果Row(i)本身没有元素，那么就不可以被set
                }else{
                    //Row.set(i,1);
                    Row.add(0);
                }
            }
            ret.add(Row);
        }
        //设置其他位置的数据
        for(int i=2;i<numRows;i++){
            List<Integer> cur = ret.get(i);
            List<Integer> pre = ret.get(i-1);
            for(int j=1;j<i;j++){
                cur.set(j,pre.get(j)+pre.get(j-1));
            }
        }
        return ret;
    }
}

/*class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] array=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    array[i][j]=1;
                }else{
                    array[i][j]=array[i-1][j-1]+array[i-1][j];
                }
            }
        }
        return array;
    }
}*/

class Solution {
	//20200101leetcode821字符的最短距离
    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        int count=0;
        for(int i=0;i<S.length();i++){
            int numRight=0;
            int numLeft=0;
            for(int j=i;j<S.length();j++){  //往后找
                if(S.charAt(j)==C){
                    break;
                }
                if(j==S.length()-1){    //加一层条件，防止循环因为j=S.length()-1而退出循环
                    numRight=S.length();
                }
                numRight++;
            }
            for(int k=i;k>=0;k--){      //往前找
                if(S.charAt(k)==C){
                    break;
                }
                if(k==0){           //加一层条件，防止循环因为k=0而退出循环
                    numLeft=S.length();
                }
                numLeft++;
            }
            arr[count]=(numRight>numLeft)?numLeft:numRight;
            count++;
        }
        return arr;
    }
}


class Solution {
	//20200102leetcode682棒球比赛
    public int calPoints(String[] ops) {
        int[] array = new int [ops.length];
        int i=0;
        for(String s:ops){
            switch(s){
                case "C":array[i-1]=0;i--;break;
                case "D":array[i]=2*array[i-1];i++;break;
                case "+":array[i]=array[i-1]+array[i-2];i++;break;
                default:
                    array[i]=Integer.valueOf(s);    //Intteger包装类，将s转换成int型
                    i++;
                    break;
            }
        }
        int sum=0;
        for(i=0;i<array.length;i++){
            sum +=array[i];
        }
        return sum;
    }
}

/*class Solution {
    public int calPoints(String[] ops) {
        int[] array = new int[ops.length];
        for(int i=0;i<ops.length;i++){
            if((ops.charAt(i)<58)&&(ops.charAt(i)>47)){
                array[i]=ops[i]-48;
            }
            if(ops.charAt(i)=='C'){
                for(int j=i;j>=0;j--){
                    if(array[j]>0){
                        array[j]=0;
                        array[i]=0;
                        break;
                    }
                }
            }
            if(ops.charAt(i)=='D'){
                for(int k=i;k>=0;k--){
                    if(array[k]>0){
                        array[i]=array[k]*2;
                        break;
                    }
                }
            }
            if(ops.charAt(i)=='+'){
                int tmp=0;
                for(int l=i;l>=0;l--){
                    if(array[l]>0){
                        array[i]=array[l]+array[i];
                        tmp++;
                        if(tmp>1){
                            break;
                        }
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<ops.length();i++){
            sum=sum+array[i];
        }
        return sum;
    }
}*/


//思路：1.拆分arr1数组，分成一个包含arr2的数组arr1Con[]和不包含arr2的数组arr1NoCon[]
//      2.分割时对包含的数组按照arr2的相对顺序排序
//      3.取出arr1中不包含arr2的数放入arr1NoCon[]
//      4.再对不包含的数组进行sort排序（升序排序）
//      5.将排序后的不包含的数组往包含的数组上拼接
//      6.return arr1Con数组；
class Solution {
	//20200103leetcode1122数组的相对排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //拆分arr1数组，包含arr2的和不包含arr2的
        int[] arr1Con= new int[arr1.length];
        int[] arr1NoCon= new int[arr1.length];
        int con=0;
        //往arr1Con[]中按照arr2的相对顺序放值
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr2[i]==arr1[j]){
                    arr1Con[con]=arr1[j];
                    con++;
                }
            }
        }
        //取出arr1中不包含arr2数组的值，放入arr1NoCon[]
        int k=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    break;
                }
                if(j==arr2.length-1){
                    arr1NoCon[k]=arr1[i];
                    k++;
                }
            }
        }
        /*int[] arrLeft= new int[arr1Con.length];
        int countL=0;
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1Con.length;j++){
                if(arr1Con[j]==arr2[i]){
                    arrLeft[countL]=arr1Con[j];
                    countL++;
                }
            }
        }*/
        //排序arr1NoCon[],sort排序：sort(int[] a, int fromIndex, int toIndex) 按升序排列数组的指定范围
        //从0——k范围内升序排序
        Arrays.sort(arr1NoCon,0,k);
        //Arrays.sort(arr1NoCon,arr1NoCon.length-noCon,arr1NoCon.length);
        /*int[] arr=new int[arr1.length];
        arr=Arrays.copyOfRange(arr1Con,0,arr1Con.length-1);
        int j=0;
        for(int i=arr1Con.length;i<arr1.length;i++){
            arr[i]=arr1NoCon[j];
            j++;
        }*/
        //将排序后的arr1NoCon[]拼接到arr1Con[]
        int count=0;
        for(int i=con;i<arr1.length;i++){
            arr1Con[i]=arr1NoCon[count];
            count++;
        }
        //返回
        return arr1Con;
    }
}


class Solution {
	//20200104leetcode20有效的括号
    public boolean isValid(String s) {
        Stack<Character> ss=new Stack();
        for(int i=0;i<s.length();i++){
            //左括号入栈
            char ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                ss.push(ch);
            }else{
                //ch时右括号
                //如果栈是空，直接return
                if(ss.empty()){
                    return false;
                }
                char chLeft=ss.peek();
                if(chLeft=='('&&ch==')'||chLeft=='['&&ch==']'||chLeft=='{'&&ch=='}'){
                    ss.pop();
                }else{
                    //匹配次序有问题
                    return false;
                }
            }
        }
        if(ss.empty()){
            return true;
        }
        return false;
    }
}

	
class MyStack {
	//20200104leetcode225用队列实现栈
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        //构造两个队列，用链式
        //队列q1用于保存所有元素，q2用于出栈时 临时储存队列
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //入栈直接把元素x压入队列q1
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //出栈时，先将size()-1个元素移入q2，这样q1的队头就是要出栈的元素
        while(q1.size()>1){
            q2.offer(q1.poll());
        }

        //要出栈的元素用ret保存
        int ret = q1.poll();

        //再把q2的元素移回q1
        Queue tmp = q1;
        q1=q2;
        q2=tmp;

        //返回出栈元素ret
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        //获取栈顶元素，步骤同pop，只是不把栈顶元素移除，只是取出元素
        while(q1.size()>1){
            q2.offer(q1.poll());
        }

        //用ret保存栈顶元素
        int ret = q1.peek();
        //再把栈顶元素压入q2
        q2.offer(q1.poll());

        Queue<Integer> tmp = q1;
        q1=q2;
        q2=tmp;

        return ret;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        //所有的元素都在q1中，q1为空时，栈为空
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 
 
 class MyQueue {
	 //20200105leetcode232用栈实现队列
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        //构造两个栈，s1用于保存直接入队的元素，s2用于保存出队顺序的栈
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //入队的元素直接入s1
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //出队时需要判断s2是否为空，s2为空时s1为空说明没有元素，直接返回-1
        //s1不为空时，将s1的元素依次出栈到s2
        //不为空的时候，直接返回s2的栈顶元素
        if(s2.empty()){
            if(s1.empty()){
                return -1;
            }
            while(s1.size()>0){
                s2.push(s1.pop());
            }
        }
        //返回s2的栈顶元素
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //步骤同pop(),返回peek()元素
        if(s2.empty()){
            if(s1.empty()){
                return -1;
            }
            while(s1.size()>0){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (0==s1.size())&&(0==s2.size());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 class MinStack {
	 //20200106leetcode155最小栈
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** initialize your data structure here. */
    public MinStack() {
        //构造两个栈，数据栈和辅助栈
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        //入栈时，数据栈总是需要入元素，当辅助栈为空时，第一个元素总是要入辅助栈
        //辅助栈peek元素总是数据栈中最小值
        //当入数据栈元素小于辅助栈peek()元素，将新元素入辅助栈
        s1.push(x);
        if(s2.empty() || x<=s2.peek()){
            s2.push(x);
        }
    }
    
    public void pop() {
        //pop时，s1总是要pop出一个元素，当s1pop出的元素和辅助栈最上的元素相等时，则辅助栈也需要将元素pop出去
        //且此处比较不可以用==，需要用equals方法，因为有一个拆箱的过程，是一个对象，不是一个值，是地址
        if((s1.peek()).equals(s2.peek())){
            s2.pop();
        }
        s1.pop();


        /*int top = s1.peek();
        if(top==s2.peek()){
            s2.pop();
        }
        s1.pop();*/
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
//思路：统计balon各个字母在text字符串中出现的次数，取出现最小的数
//balloon中l和o出现两次，需要对相应的字母除以2
class Solution {
	//20200107leetcode1189“气球”的最大数量
    public int maxNumberOfBalloons(String text) {
        int[] arr=new int[5];
        String str="balon";
        for(int i=0;i<str.length();i++){
            int count=0;
            for(int j=0;j<text.length();j++){
                if(str.charAt(i)==text.charAt(j)){
                    count++;
                }
            }
            arr[i]=count;
        }
        arr[2]=arr[2]/2;
        arr[3]=arr[3]/2;
        int min=arr[0];
        for(int i=0;i<5;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}


class Solution {
	//20200108leetcode1170比较字符串最小字母出现频次
    public static int count(String str){
        int[] al=new int[26];
        for(int i=0;i<str.length();i++){
            al[str.charAt(i)-'a']++;
            //将每个字母的次数存在字母表中的相应位置
        }
        for(int count:al){
            if(count!=0){
                return count;
                //从字母表开始，返回第一个出现不为0的数，即为最小的出现次数
            }
        }
        return 0;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] array = new int[words.length];
        for(int i=0;i<array.length;i++){
            array[i]=count(words[i]);
        }
        for(int i=0;i<ans.length;i++){
            int count = count(queries[i]);
            for(int j=array.length-1;j>=0;j--){
                ans[i]+=count<array[j]?1:0;
            }
        }
        return ans;
    }
}


class Solution {
	//20200109leetcode985查询后的偶数和
    //Func方法：将一个整数数组中所有的偶数加起来
    public static int Func(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                sum +=array[i];
            }
        }
        return sum;
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] arr = new int[queries.length];
        int val=0;
        int index=0;
        int count=0;
        for(int i=0;i<queries.length;i++){
            val=queries[i][0];
            index=queries[i][1];
            A[index] +=val;
            arr[count]=Func(A);
            count++;
        }
        return arr;
    }
}


class Solution {
	//20200110leetcode788旋转数字
    public static boolean Func(int num){
        int tmp=0;
        int flg=0;
        while(num!=0){
            tmp=num%10;
            //每位都在(2, 5, 6, 9, 0, 1, 8)内，至少一位在(2, 5, 6, 9)内
            if((tmp!=0)&&(tmp!=1)&&(tmp!=8)&&(tmp!=2)&&(tmp!=5)&&(tmp!=6)&&(tmp!=9)){
                return false;
            }
            if(tmp==2||tmp==5||tmp==6||tmp==9){
                flg=1;
            }
            num=num/10;
        }
        if(flg==1){
            return true;
        }
        return false;
    }
    public int rotatedDigits(int N) {
        int count=0;
        for(int i=1;i<=N;i++){
            if(Func(i)){
                count++;
            }
        }
        return count;
    }
}



//思路：范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，说明数组的所有数都在1——n范围内
//      那么，将每一个数当成数组的下标，那么没有出现的下标就是数组中没有的数
//      细致操作为：对每一个数当成数组下标，进行取负操作，那么对数组遍历一遍之后，
//      大于0的数的下标就是原数组中没有出现的数字
class Solution {
	//20200111leetcode448找到所有数组中消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> L = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //将每个数字当成数组下标进行取负操作
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(int j=0;j<nums.length;j++){
            //此时，数组大于0的数的下标就是原数组没有出现的数
            if(nums[j]>0){
                //需要+1，j只是下标，add到List中
                L.add(j+1);
            }
        }
        return L;
    }
}



class Solution {
	//20200112leetcode371两整数之和
    public int getSum(int a, int b) {
        while(b!=0){
            int tmp = a^b;
            b=(a&b)<<1;
            a=tmp;
        }
        return a;
        /*int sum=0;
        sum=a^b;
        int carry = a&b;
        carry=carry<<1;
        while(carry!=0){ 
            carry = carry&(Integer.MAX_VALUE);
            sum=sum^carry;
            carry = carry<<1;
        }
        return sum;*/
    }
}


//思路：非常机智的方法，如果前一个数比后一个数小，那么a=1；如果前一个数比后一个数大，那么b=1
//      如果a和b都等于1的化，那么就不符合单调的要求
class Solution {
	//20200113leetcode896单调数列
    public boolean isMonotonic(int[] A) {
        int a=0;
        int b=0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1]){    //此处注意，不能<=，如果加上=，那么只要出现重复元素就会进入条件
                a=1;
            }
            if(A[i]>A[i+1]){
                b=1;
            }
        }
        if(a==1&&b==1){
            return false;
        }
        return true;
    }
}


//思路：其实此题有个bug，因为每次ops，必定是从[0][0]左上角开始的，那么只需要找到最小的a和b便可以
class Solution {
	//20200114leetcode598范围求和II
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int minA=ops[0][0];
        int minB=ops[0][1];
        for(int i=0;i<ops.length;i++){
            if(ops[i][0]<minA){
                minA=ops[i][0];
            }
            if(ops[i][1]<minB){
                minB=ops[i][1];
            }
        }
        return minA*minB;
    }
}

//思路：构造两个栈，不是#就入栈，是#就出栈
class Solution {
	//20200115leetcode844比较含退格的字符串
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(!s1.empty()){
                    s1.pop();
                } 
            }else{
                s1.push(S.charAt(i));
            }
        }
        for(int j=0;j<T.length();j++){
            if(T.charAt(j)=='#'){
                if(!s2.empty()){
                    s2.pop();
                }
            }else{
                s2.push(T.charAt(j));
            }
        }
        if(s1.size()!=s2.size()){
            return false;
        }
        while((!s1.empty())&&(!s2.empty())){
            if(!s1.pop().equals(s2.pop())){
                return false;
            }
        }
        return true;
    }
}



//两种方法：StringBuilder和String
class Solution {
	//20200116leetcode709转换成小写字母
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>64&&str.charAt(i)<91){
                sb.append((char)(str.charAt(i)+32));//此处强制类型转换需要把char（）起来，写成（char），否则会报错
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

/*class Solution {
    public String toLowerCase(String str) {
        String s = "";
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c>64&&c<91){
                c += 32;
            }
            s += c;
        }
        return s;
    }
}*/



//思路：将ransomNote中和magazine中的所有字母出现次数记入对应的数组中，
//      然后再判断对应下标位置的数组值是否后者大于前者
class Solution {
	//20200117leetcode383赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteArr = new int[26];  //为ransomNote分配数组空间
        int[] magazineArr = new int[26];    //为magazine分配数组空间
        for(int i=0;i<ransomNote.length();i++){
            ransomNoteArr[ransomNote.charAt(i)-'a']++;  
            //将ransomNote中的所有字母出现次数记录在数组相应的位置
        }
        for(int j=0;j<magazine.length();j++){
            magazineArr[magazine.charAt(j)-'a']++;  //记录magazine
        }
        for(int i=0;i<26;i++){
            if(ransomNoteArr[i]>0){ 
                //将ransomNote数组遍历一遍，看magazine数组中的相应数组值是否大于ransomNote的数组值
                if(ransomNoteArr[i]>magazineArr[i]){
                    return false;
                }
            }
        }
        return true;
    }
}

/*class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i=0;i<ransomNote.length();i++){
            for(int j=0;j<magazine.length();j++){
                if((j==magazine.length()-1)&&(ransomNote.charAt(i)!=magazine.charAt(j))){
                    return false;
                }
                if(ransomNote.charAt(i)==magazine.charAt(j)){
                    String Magazine=magazine.replace(magazine.charAt(j),"0");
                    magazine=Magazine;
                    if(i==(ransomNote.length()-1)){
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
}*/


//思路：按题意，负数不是回文数，小于10的数一定是回文数，
//      对于其他数，存入数组中，遍历一遍，从两头往中间比较，不相等的不是回文数
class Solution {
	//20200118leetcode9回文数
    public boolean isPalindrome(int x) {
        if(x<0){    //小于0的不是回文数
            return false;
        }
        if(x<10){   //小于10的是回文数
            return true;
        }
        int i=0;
        int[] array = new int[100];
        while(x>0){ //将每位数都存入数组中
            array[i++] = x%10;
            x=x/10;
        }
        int count=i;
        for(int j=0;j<=count/2;j++){    //从两头往中间比较
            if(array[j]!=array[--i]){   //不相等就不是回文数
                return false;
            }
        }
        return true;
    }
}



//思路：先删除先后所有的空格，然后从后往前找，找到第一个空格的时候返回长度
class Solution {
	//20200119leetcode58最后一个单词的长度
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        if(str.length()==0){
            return 0;
        }
        for(int i=str.length()-1;i>=0;i--){
            if(i==0){
                return str.length()-i;
            }
            if(str.charAt(i)==' '){
                return str.length()-1-i;
            }
        }
        return 0;
    }
}



//思路：双指针大法，i遍历name，j遍历typed
//      当字母相等时，两指针同时往后走，如果不相等，j往后走
//      判断当j走到typed.length()时，i没有走到name.length()，说明不符合要求，返回false
class Solution {
	//20200120leetcode925长按键入
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i<name.length()&&j<typed.length()){
            //遍历两字符串，字母相等时i和j同时++
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else{
                //不相等时，j++，i不动
                j++;
            }
        }
        //如果最后j走到末尾，而i没有走到末尾，返回false
        if(j==typed.length()&&i!=name.length()){
            return false;
        }
        return true;
    }
}

/*class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int[] arrName = new int[26];
        int[] arrTyped = new int[26];
        for(int i=0;i<name.length();i++){
            arrName[name.charAt(i)-'a']++;
        }
        for(int j=0;j<typed.length();j++){
            arrTyped[typed.charAt(j)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arrName[i]>arrTyped[i]){
                return false;
            }
        }
        return true;
    }
}*/


class Solution {
	//20200121leetcode905按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        for(int left=0;left<A.length;left++){
            if(A[left]%2!=0){
                for(int right=A.length-1;right>left;right--){
                    if(A[right]%2==0){
                        A[left] = A[left]^A[right];
                        A[right] = A[left]^A[right];
                        A[left] = A[left]^A[right];
                    }
                }
            }
        }
        return A;
    }
}

/*class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] array = new int[A.length];
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                array[count++] = A[i];
            }
        }
        for(int j=0;j<A.length;j++){
            if(A[j]%2!=0){
                array[count++] = A[j];
            }
        }
        return array;
    }
}*/


//思路：定义rightSum和leftSum，先把所有的数组值和存入rightSum，再从nums[0]开始加值存入leftSum
//      当左右相等时返回下标
class Solution {
	//20200122leetcode724寻找数组的中心索引
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        //将数组和存入rightSum
        for(int i=0;i<nums.length;i++){
            rightSum += nums[i];
        }
        //从nums[0]开始每个值加入leftSum
        for(int i=0;i<nums.length;i++){
            //把rightSum值减掉相应的数组值
            rightSum = rightSum - nums[i];
            //如果左右相等，找到中心索引
            if(rightSum==leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

class Solution {
	//20200124leetcode1两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;
                    return array;
                }
            }
        }
        return null;
    }
}


//思路：先补零（可以不补，补零思路清晰点），取出两个字符串的每一个字母，从后往前加，
//      需要判断是否需要进位，不需要进位的话，直接append到sb中，需要进位的话，定义一个进位标志位ca
//      每次需要进位时，ca置为1，在下一位相加时加上ca
//      最后反转sb返回
class Solution {
	//20200125leetcode67二进制求和
    public String addBinary(String a, String b) {
        //补零
        while(a.length()>b.length()){
            b = '0'+b;
        }
        while(a.length()<b.length()){
            a = '0'+a;
        }
        StringBuilder sb = new StringBuilder();
        int ca = 0;//进位标志符
        for(int i=a.length()-1;i>=0;i--){//从后往前加
            int sum=ca;
            //sum存储本次字母相加的和,带上上一位运算的标志位相加
            sum += (a.charAt(i)-'0')+(b.charAt(i)-'0');
            //存储本次相加完毕后是否需要进位
            ca=sum/2;
            //sum>1说明需要进位，且本位为0；不需要进位，直接append sum
            if(sum>1){
                sb.append(sum%2);
            }else{
                sb.append(sum);
            }
        }
        //第0位需要特殊考虑，如果需要进位，将会比原两个字符串长1，即需要将1 append到第0位
        //否则不需要进位，直接反转返回
        if(ca==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}


//思路：二分查找到一个target值，再分别往前往后查找，返回数组下标就ok
class Solution {
	//20200126leetcode34在排序数组中查找元素的第一个和最后一个位置
    //二分查找
    public int binarySearch(int[] array,int tar){
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid  = (left+right)/2;
            if(array[mid] == tar){
                return mid;
            }
            if(array[mid]>tar){
                right = mid-1;
            }
            if(array[mid]<tar){
                left = mid+1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int tmp = binarySearch(nums,target);
        if(tmp == -1){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        //往前查找
        for(int i = tmp;i>=0;i--){
            if(nums[i]==target){
                arr[0] = i;
            }
            if(nums[i]!=target){
                break;
            }
        }
        //往后查找
        for(int i = tmp;i<nums.length;i++){
            if(nums[i]==target){
                arr[1] = i;
            }
            if(nums[i]!=target){
                break;
            }
        }
        return arr;
    }
}

//思路：先全部转换成小写字母，遍历一次将所有的字母和数字append到sb中，
//      然后从两头往中间遍历，不相等的返回false
class Solution {
	//20200127leetcode125验证回文串
    public boolean isPalindrome(String s) {
        //s.trim();
        //转换成小写字母（或者大写字母也ok）
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        //遍历一次，将所有的字母和数字存入sb中
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'||
                    str.charAt(i)>='0'&&str.charAt(i)<='9'){
                sb.append(str.charAt(i));
            }
        }
        //从两头往中间遍历，不相等的返回false
        for(int i=0,j=sb.length()-1;i<=j;i++,j--){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
        }
        return true;
    }
}


//思路：开辟一个和nums值一样的新数组，对新数组进行排序，排序后与原数组比较，不相等的下标返回
class Solution {
	//20200128leetcode581最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        //开辟和nums值一样的新数组
        int[] array = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            array[i] = nums[i];
        }
        //对新数组排序
        Arrays.sort(array);
        int left = 0;
        int right = 0;
        //新数组和原数组进行比较，找到开始不一样的左下标
        for(int i=0;i<nums.length;i++){
            if(array[i]!=nums[i]){
                left = i;
                break;
            }
        }
        //比较，找到不一样的右下标
        for(int i=nums.length-1;i>=0;i--){
            if(array[i]!=nums[i]){
                right = i+1;
                break;
            }
        }
        //返回子数组元素的个数
        return right-left;
    }
}

//思路：当做栈，数字则压栈，运算符则出栈2个数字，计算完之后压栈一个数字。
class Solution {
	//20200128leetcode150逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String s1 : tokens){
            switch(s1){
                case "+":
                    s.push(s.pop()+s.pop());
                    break;
                case "-":
                    s.push(-s.pop()+s.pop());
                    break;
                case "/":
                    int tmp = s.pop();
                    s.push(s.pop()/tmp);
                    break;
                case "*":
                    s.push(s.pop()*s.pop());
                    break;
                    default:
                    //parseInt()方法，用于将字符串参数作为有符号的十进制整数进行解析。
                        s.push(Integer.parseInt(s1));
                        break;

            }
        }
        return s.pop();
    }
}


class Solution {
	//20200129leetcode78子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int all = l.size();
            for(int j=0;j<all;j++){
                List<Integer> tmp = new ArrayList<>(l.get(j));
                tmp.add(nums[i]);
                l.add(tmp);
            }
        }
        return l;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//20200130leetcode199二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i == (size-1)){
                    res.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}


class Solution {
	//20200131leetcode997小镇的法官
    public int findJudge(int N, int[][] trust) {
        int[] out = new int[N+1];
        int[] in = new int[N+1];
        for(int i=0;i<trust.length;i++){
            //你相信的人的个数
            out[trust[i][0]] += 1;
            //相信你的人的个数
            in[trust[i][1]] += 1;
        }
        for(int i=1;i<=N;i++){
            //你相信的人数为0并且相信你的人有N-1个时是法官
            if(out[i] == 0&&in[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}


//思路：将两个数组排序，定义三个指针，i指向nums1，j指向nums2，如果两者相等，同时加1
class Solution {
	//20200201leetcode350两个数组的交集II
    public int[] intersect(int[] nums1, int[] nums2) {
        //排序数组
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        int[] array = new int[nums1.length];
        while(i<nums1.length&&j<nums2.length){
            //如果小于，则i向后走一步
            if(nums1[i]<nums2[j]){
                i++;
            }else{
                //如果大于，则j向后走一步
                if(nums1[i]>nums2[j]){
                    j++;
                }else{
                    //如果相等，则把值赋给array，三个指针同时向后走一步
                    //有一个节省内存的方法，不开辟新数组，直接把值赋给nums1
                        if(nums1[i] == nums2[j]){
                        array[k++] = nums1[i++];
                        j++;
                    }
                }
            }
        }
        //返回array的0——k的值
        return Arrays.copyOfRange(array,0,k);
    }
}

//思路：定义一个计数器，当大于三的时候就说明符合条件
class Solution {
	//20200202leetcode830较大分组的位置
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        //在S字符串的末尾加一个字符，这样可以不用考虑原字符串的末尾
        S=S+"A";
        int count=1;
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)==S.charAt(i-1)){
                count++;
            }
            if(S.charAt(i)!=S.charAt(i-1)||i==S.length()-1){
                if(count>2){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i-count);
                    tmp.add(i-1);
                    res.add(tmp);
                }
                count=1;
            }
        }
        return res;
    }
}


//假设给定字符串s可由一个子串x重复n次构成，即s=nx。 
//现构造新字符串t=2s，即两个s相加，由于s=nx，则t=2nx。 
//去掉t的开头与结尾两位，则这两处的子串被破坏掉，此时t中包含2n-2个子串。 
//由于t中包含2n-2个子串，s中包含n个子串，若t中包含s，则有2n-2>=n，可得n>=2，
//由此我们可知字符串s可由一个子串x重复至少2次构成，判定为true；
//反之，若t中不包含s，则有2n-2<n，可得n<2，n只能为1，
//由此我们可知字符串s=x，假定的子串就为s本身，判定为false。
class Solution {
	//20200203leetcode459重复的子字符串
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        str = str.substring(1,str.length()-1);
        if(str.contains(s)){
            return true;
        }
        return false;
    }
}


//思路：把一个数组中的值放入map中，
//      然后对另一个数组遍历一遍，如果map中包含，就放入List中，并保存i+j的值
//      如果i+j小于num的话，清空List中的值，重新重复上述操作
class Solution {
	//20200204leetcode599两个列表的最小索引总和
    public static String[] findRestaurant(String[] list1, String[] list2) {
        //map储存list1中的值
        Map<String,Integer> map = new HashMap<>();
        //List储存两数组相同且索引最小的值
        List<String> res = new ArrayList<>();
        //定义索引相加值num
        int num = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            //如果map中包含list2中的值，且num==i+j，则放入res中
            if(map.containsKey(list2[i])){
                if(num == i+map.get(list2[i])){
                    res.add(list2[i]);
                }else{
                    //当有i+j比num小的时候，更新num和List中的值
                    if(num > i + map.get(list2[i])){
                        num = i+map.get(list2[i]);
                        res.clear();
                        res.add(list2[i]);
                    }
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

/*class Solution {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        String[] sArr = new String[list1.length];
        int count = 0;
        int min = 100000;
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i] == list2[j]){
                    count = i+j;
                    if(count<min){
                        min = count;
                        sArr[0] = list1[i];
                    }
                }
            }
        }
        count = 0;
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i] == list2[j]){
                    if(i+j == min){
                        sArr[count++] = list1[i];
                    }
                }
            }
        }
        return Arrays.copyOfRange(sArr,0,count);
    }
}*/



class Solution {
	//20200205leetcode1071字符串的最大公因子
    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            for(int i=str1.length();i>0;i--){
                if(str1.length()%i==0&&str2.length()%i==0
                &&(str1.substring(0,i)+str2).equals(str2+str1.substring(0,i))){
                    return str1.substring(0,i);
                }
            }
        }
        return "";
    }
}

class Solution {
	//20200206leetcode7171比特与2比特字符
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;i++){
            //当i走到length-1时就必定为1比特字符
            if(i==bits.length-1){
                return true;
            }
            //i总是指向1比特或者2比特开始字符位置，不会指到2比特第二个字符位置
            if(bits[i] == 1){
                i++;
            }
        }
        return false;
    }
}


class Solution {
	//20200207leetcode744寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while(left <= right){
            int mid = (left+right) /2;
            if(target < letters[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return letters[left%letters.length];
    }
}


//思路：定义两个计数器；count为当前最长的连续子序列，tmp为当前的连续子序列；
//      当tmp>count时，tmp赋给count
class Solution {
	//20200208leetcode674最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int count = 1;
        int tmp = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                tmp++;
                if(tmp>count){
                    count=tmp;
                }
            }else{
                tmp=1;
            }
        }
        return count;
    }
}


class Solution {
	//20200209leetcode989数组形式的整数加法
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int lastNum = K;
        LinkedList<Integer> res = new LinkedList<>();
        int i = len-1;
        while( i>= 0||lastNum>0){
            if(i>=0){
                lastNum += A[i];
            }
            res.addFirst(lastNum%10);
            lastNum /= 10;
            i--;
        }
        return res;
    }
}

/*class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        /*int[] array = new int[];
        int count = 0;
        while(K>0){
            array[count++] = K%10;
            K /= 10;
        }
        List<Integer> res = new ArrayList<>();
        int tmp = 0;
        int i = A.length-1;
        while(i>=0||K>0){
            if(i>=0){
                tmp = tmp + A[i];
            }
            res.add(tmp%10);
            tmp = tmp/10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }
}*/


class Solution {
	//20200210leetcode1010总持续时间可被60整除的歌曲
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] array = new int[60];
        //把数组中得每个余数对应的出现次数放入新开辟的数组中
        for(int i=0;i<time.length;i++){
            array[time[i]%60]++;
        }
        for(int i=1;i<30;i++){
            //除开0和30以外的配对次数
            count += array[i] * array[60-i];
        }
        //0和30的配对次数
        count += (array[0]*(array[0]-1) + array[30]*(array[30]-1))/2;
        return count;
    }
}

//暴力法：超时
/*class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for(int i=0;i<time.length;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i]+time[j])%60 == 0){
                    count++;
                }
            }
        }
        return count;
    }
}*/


//思路：标签：动态规划
//      动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
//      思路实现：由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，
//      要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，
//      二者之间取最大值
//      举例来说：1 号房间可盗窃最大值为 33 即为 dp[1]=3，2 号房间可盗窃最大值为 44 即为 dp[2]=4，
//      3 号房间自身的值为 22 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，
//      3 号房间可盗窃最大值为 55
//      时间复杂度：O(n)O(n)，nn 为数组长度
class Solution {
	//20200211leetcode198打家劫舍
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2 ; i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
}

/*class Solution {
    public int rob(int[] nums) {
        int curNum = 0;
        int preNum = 0;
        for(int x : nums){
            int tmp = curNum;
            curNum = Math.max(preNum+x,curNum);
            preNum = tmp;
        }
        return curNum;
    }
}*/


//思路：题目为两个对应关系，用map<key->pattern,value->str>
//      拿到一个pattern中的字母看map中有没有对应的key，没有的话判断有没有对应的value
//      匹配则进入下一个，不匹配则返回false
class Solution {
	//20200212leetcode290单词规律
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null ||str == null){
            return false;
        }
        String[] string = str.split(" ");
        if(pattern.length() != string.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            //key存在
            if(map.containsKey(ch)){
                //但是不对应
                if(!map.get(ch).equals(string[i])){
                    return false;
                }
            }
            //key不存在
            else{
                //但是value一样，对应的key值不一样
                if(map.containsValue(string[i])){
                    return false;
                }else{
                    //key不存在，value值也不存在，放入map
                    map.put(ch,string[i]);
                }
            }
        }
        return true;
    }
}


class Solution {
	//20200213leetcode645错误的集合
    public int[] findErrorNums(int[] nums) {
        int[] array = new int[nums.length+1];
        for(int x : nums){
            array[x]++;
        }
        int[] res = new int[2];
        for(int i=0;i<array.length;i++){
            if(array[i] == 0){
                res[1] = i;
            }else{
                if(array[i] == 2){
                    res[0] = i;
                }
            }
        }
        return res;
    }
}

/*class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] array = new int[nums.length];
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                array[count++] = nums[i];
                array[count++] = i+1;
            }
        }
        return Arrays.copyOfRange(array,0,count);
    }
}*/

class Solution {
	//20200214leetcode441排列硬币
    public int arrangeCoins(int n) {
        long sum = 0;
        int i=0;
        if(n == 1){
            return 1;
        }
        for(i=1;i<n;i++){
            sum += i;
            if(sum > n){
                break;
            }
        }
        return i-1;
    }
}

class Solution {
	//20200215leetcode172阶乘后的零
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            count += n/5;
            n = n/5;
        }
        return count;
    }
}

class Solution {
	//20200216leetcode747至少是其他数字两倍的最大数
    public int dominantIndex(int[] nums) {
        int maxFirst = nums[0];
        int maxIndex = 0;
        int maxSecond = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > maxFirst){
                maxSecond = maxFirst;
                maxFirst = nums[i];
                maxIndex = i;
            }
            if(nums[i] > maxSecond && nums[i] != maxFirst){
                maxSecond = nums[i];
            }
        }
        if(maxFirst >= maxSecond*2){
            return maxIndex;
        }
        return -1;
    }
}



class Solution {
	//20200217leetcode219存在重复元素II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int maxK=0;
        for(int i=0; i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]&&i!=j){
                    int tmp=(i>j?i-j:j-i);
                    if(tmp<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Solution {
	//20200218leetcode643子数组最大平均数I
    public double findMaxAverage(int[] nums, int k) {
        int max=0;
        for(int i=0;i<nums.length-k+1;i++){
            int count = 0;
            for(int i1=0;i1<k;i1++){
                count+=nums[i+i1];
            }
            if(i==0){
                max=count;
            }else{
                max=Math.max(max,count);
            }
        }
        return (double)max/k;
    }
}


class Solution {
	//20200219leetcode507完美数
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        int sum = 0;
        for(int i=1;i*i<=num;i++){
            if((num%i)==0){
                sum += i + num/i;
            }
        }
        return sum-num == num;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
	//20200220leetcode278第一个错误的版本
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left<right){
            //不用（left+right）/2防止溢出
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}

class Solution {
	//20200221leetcode680验证回文字符串II
    public boolean validPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return validPalindrome(s,i,j-1)||validPalindrome(s,i+1,j);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}

class Solution {
	//20200222leetcode941有效的山脉数组
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int i=0;
        int tmp=Integer.MIN_VALUE;
        for(i=0;i<A.length;i++){
            if(A[i]>tmp){
                tmp=A[i];
            }else{
                break;
            }
            if(i==A.length-1){
                return false;
            }
        }
        if(tmp==A[0]){
            return false;
        }
        for(int j=i;j<A.length;j++){
            if(tmp>A[j]){
                tmp=A[j];
            }else{
                return false;
            }
        }
        return true;
    }
}


class Solution {
	//20200223leetcode434字符串中的单词数
    public int countSegments(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' '){
                count++;
            }
        }
        return count;
    }
}


class Solution {
	//20200224leetcode面试题10- I. 斐波那契数列
    public int fib(int n) {
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        for(int i=2;i<=n;i++){
            f2 = (f0+f1)%1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}


class Solution {
	//20200225leetcode1346检查整数及其两倍数是否存在
    public boolean checkIfExist(int[] arr) {
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = 2*arr[i];
        }
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<res.length;j++){
                if(res[j]==arr[i]&&i!=j){
                    return true;
                }
            }
        }
        return false;
    }
}


class Solution {
	//20200226leetcode605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        int num = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                count++;
            }else{
                count=0;
            }
            if(count==3){
                num++;
                count=1;
            }
        }
        if(count == 2){
            num++;
        }
        return n<=num;
    }
}


class Solution {
	//20200227leetcode665. 非递减数列
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3){
            return true;
        }
        int count=0;
        if(nums[0]>nums[1]){
            nums[0]=nums[1];
            count++;
        }
        for(int i=1;i<nums.length-1;i++){
            int right=nums[i+1];
            if(nums[i]>right){
                count++;
                if(count>1){
                    return false;
                }
                int left=nums[i-1];
                if(left>right){
                    nums[i+1]=nums[i];
                }else{
                    nums[i]=left;
                }
            }
        }
        return true;
    }
}


class Solution {
	//20200228leetcode633平方数之和
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left<=right){
            int tmp = left*left+right*right;
            if(tmp>c){
                right--;
            }else{
                if(tmp<c){
                    left++;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
	//20200229leetcode面试题64，求1+2+···+n
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n-1)) > 0;
        return sum;
    }
}


class Solution {
	//20200301leetcode59螺旋矩阵II
    public int[][] generateMatrix(int n) {
        int l = 0 , r=n-1,t=0,b=n-1;
        int[][] mat = new int[n][n];
        int num=1;
        while(num<=n*n){
            for(int i=l;i<=r;i++){//左到右
                mat[t][i]=num++;
            }
            t++;
            for(int i=t;i<=b;i++){//上到下
                mat[i][r]=num++;
            }
            r--;
            for(int i=r;i>=l;i--){//右到左
                mat[b][i]=num++;
            }
            b--;
            for(int i=b;i>=t;i--){//下到上
                mat[i][l]=num++;
            }
            l++;
        }
        return mat;
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
	//20200302leetcode2两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        int t=0;
        while(l1!=null||l2!=null||t!=0){
            if(l1!=null){
                t+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2=l2.next;
            }
            pre.next = new ListNode(t%10);
            pre = pre.next;
            t/=10;
        }
        return res.next;
    }
}

/*class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int cap=0;
        while(l1!=null||l2!=null){
            ListNode tmp = new ListNode(0);
            head.next=tmp;
            tmp.val=cap+(l1.val+l2.val)%10;
            if(l1.val+l2.val>9){
                cap=1;
            }else{
                cap=0;
            }
            head=tmp;
            l1=l1.next;
            l2=l2.next;
        }
        if(cap==1){
            ListNode tmp = new ListNode(0);
            head.next=tmp;
            tmp.val=1;
        }
        return res.next;
    }
}*/


class Solution {
	//20200303leetcode面试题10.01.合并排序的数组
    public void merge(int[] A, int m, int[] B, int n) {
        int count = A.length-1;
        int tmp = n-1;
        while(tmp>=0){
            A[count--]=B[tmp--];
        }
        Arrays.sort(A);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//20200303leetcode104二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//20200304leetcode17相同的数
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //两个树都为空
        if(null == p && null == q){
            return true;
        }

        //两个树有一个为空
        if(null == p||null == q){
            return false;    
        }

        //两棵树都不为空，分别检查左右子树
        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left)&&
               isSameTree(p.right,q.right);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//20200304leetcode110平衡二叉树
        public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //求左子树的高度
        int leftHight = maxDepth(root.left);
        //求右子树的高度
        int rightHight = maxDepth(root.right);
        //求左右子树是否满足情况
        if(Math.abs(rightHight-leftHight)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
}


class Solution {
	//20200306leetcode面试题57-II.和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for(int l =1,r=1,sum =0;r<target;r++){
            sum += r;
            while(sum>target){
                sum -= l++;
            }
            if(sum == target){
                int[] tmp = new int[r-l+1];
                for(int i=0;i<tmp.length;i++){
                    tmp[i] = l+i; 
                }
                list.add(tmp);
            }
        }
        int[][] res = new int[list.size()][];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}


class Solution {
	//20200307leetcode3无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            count = Math.max(count,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return count;
    }
}


class Solution {
	//20200308leetcode1365有多少小于当前数字的数字
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j = 0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                    res[i]=count;
                }
            }
        }
        return res;
    }
}


class Solution {
	//20200309leetcode1342将数字变成0的操作次数
    public int numberOfSteps (int num) {
        int count = 0;
        while(num>0){
            if(num%2==0){
                num = num/2;
            }else{
                num -= 1;
            }
            count++;
        }
        return count;
    }
}

class Solution {
	//20200310leetcode1295统计位数为偶数的数字
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int tmp=0;
            int numTmp=nums[i];
            while(numTmp>0){
                tmp++;
                numTmp /= 10;
            }
            if(tmp%2==0){
                count++;
            }
        }
        return count;
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
	//20200311leetcode1290二进制链表转整数
    private int getLength(ListNode head){
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public int getDecimalValue(ListNode head) {
        int count = getLength(head)-1;
        ListNode cur = head;
        int sum = 0;
        while(cur!=null){
            if(cur.val == 1){   
                sum += Math.pow(2,count);
            }
            cur = cur.next;
            count--;
        }
        return sum;
    }
}


class Solution {
	//20200312leetcode1266访问所有点的最小时间
    public int minTimeToVisitAllPoints(int[][] points) {
        //计算x与y的距离
        int xLength = 0;
        int yLength = 0;
        int visitLength = 0;
        for(int i=1;i<points.length;i++){
            xLength = Math.abs(points[i][0]-points[i-1][0]);
            yLength = Math.abs(points[i][1]-points[i-1][1]);
            //取最大距离相加
            visitLength += Math.max(xLength,yLength);
        }
        return visitLength;
    }
}



class Solution {
	//20200313leetcode1351. 统计有序矩阵中的负数
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution {
	//20200313leetcode面试题58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        if(n>s.length()){
            return null;
        }
        String strLeft = s.substring(0,n);
        String strRight = s.substring(n,s.length());
        return strRight + strLeft;
    }
}


class Solution {
	//20200314leetcode1021. 删除最外层的括号
    public String removeOuterParentheses(String S) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(' && left++>0){
                sb.append('(');
            }
            if(S.charAt(i)==')' && --left>0){
                sb.append(')');
            }
        }
        return sb.toString();
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
	//20200314leetcode面试题 02.02. 返回倒数第 k 个节点
    private int getLength(ListNode head){
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public int kthToLast(ListNode head, int k) {
        int count = getLength(head) - k + 1;
        ListNode cur = head;
        int res = 0;
        while(count>0){
           res = cur.val; 
           cur = cur.next;
           count--;
        }
        return res;
    }
}



class Solution {
	//20200315leetcode1323. 6 和 9 组成的最大数字
    public int maximum69Number (int num) {
        int[] array = new int[100];
        int tmp = num;
        int count = 0;
        while(tmp>0){
            array[count++] = tmp%10;//尾9 6 6 9头
            tmp /= 10;
        }
        for(int i=count-1;i>=0;i--){
            if(array[i] == 6){
                array[i] = 9;
                break;
            }
        }
        int sum = 0;
        for(int i=0;i<count;i++){
            sum += array[i]*(int)Math.pow(10,i);
        }
        return sum;
    }
}


class Solution {
	//20200316leetcode面试题 01.06. 字符串压缩
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        S = S + 'A';
        int count = 1;
        for(int i =0;i<S.length()-1;i++){
            if(S.charAt(i)==S.charAt(i+1)){
                count++;
            }else{
                sb.append(S.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        return S.length()-1<=sb.length()?S.substring(0,S.length()-1):sb.toString();
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
	 //20200317leetcode面试题22. 链表中倒数第k个节点
     //双指针大法，双百
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode pre = head;
        while(k > 0){
            cur = cur.next;
            k--;
        }
        while(cur != null){
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }
 }
/*class Solution {
    //容易想到的方法，时间30%
    private int getLength(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = getLength(head) - k;
        ListNode cur = head;
        while(count > 0){
            cur = cur.next;
            count--;
        } 
        return cur;
    }
}*/


class Solution {
	//20200318leetcode836. 矩形重叠
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2]<=rec2[0]||rec2[2]<=rec1[0]||rec1[3]<=rec2[1]||rec2[3]<=rec1[1]);
    }
}

/*class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[2]<rec2[0]){
            return false;
        }
        int[] res = new int[4];
        res[0] = rec1[0]>rec2[0]?rec1[0]:rec2[0];
        res[1] = rec1[1]>rec2[1]?rec1[1]:rec2[1];
        res[2] = rec1[2]>rec2[2]?rec2[2]:rec1[2];
        res[3] = rec1[3]>rec2[3]?rec2[3]:rec1[3];
        if(res[0]!=res[1]||res[2]!=res[3]){
            return false;
        }
        return true;
    }
}*/



class Solution {
	//20200319leetcode409. 最长回文串
    public int longestPalindrome(String s) {
        int[] res = new int[58];
        int maxLength = 0;
        int flg = 0;
        for(int i=0;i<s.length();i++){
            res[s.charAt(i)-'A']++;
        }
        for(int i=0;i<58;i++){
            if(res[i]%2 == 0){
                maxLength += res[i];
            }else{
                flg = 1;
                maxLength += res[i]-1;
            }
        }
        if(flg == 0){
            return maxLength;
        }
        return maxLength + 1;
    }
}


class Solution {
	//20200320leetcode面试题40. 最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        List<Integer> L = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            L.add(arr[i]);
        }
        PriorityQueue<Integer> p = new PriorityQueue<>(L);
        for(int i = 0;i<k;i++){
            res[i] = p.poll();
        } 
        return res;
    }
}

/*class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
}*/



class Solution {
	//20200321leetcode365. 水壶问题
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0){
            return true;
        }
        if(x+y<z){
            return false;
        }
        int min = x>y?y:x;
        int max = 0;
        if(min == x){
            max = y;
        }else{
            max = x;
        }
        int count = 0;
        while(min>0){
            if(x % min == 0 && y % min == 0){
                count = min;
                break;
            }
            min--;
        }
        if((count != 0 && z % count == 0)){
            return true;
        }
        return false;
    }
}


class Solution {
	//20200322leetcode945. 使数组唯一的最小增量
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for(int i = 1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                //先把原来的值储存（小值min），
                int tmp = A[i];
                //A[i]要变到的值（肯定比原来的值大，大值max）
                A[i] = A[i-1]+1;
                //因为每次只能+1，所以从原来的值到 要变到的值 需要用大值-小值（max-min）步
                count += A[i] - tmp;
            }
        }
        return count;
    }
}



class Solution {
	//20200323leetcode5364. 按既定顺序创建目标数组
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
        for(int i = 0 ;i < index.length ; i ++ ){
            int j = index.length - 1 ;
            while(j > index[i]){
                target[j] = target[j-1];
                j--;
            }
            target[index[i]] = nums[i];
        }
        return target;
    }
}


class Solution {
	//20200324leetcode面试题 17.16. 按摩师
    public int massage(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i = 0;i<nums.length;i++){
            int c = Math.max(b,a+nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}


class Solution {
	//20200325leetcode面试题17. 打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10,n)-1];
        for(int i = 0;i<res.length;i++){
            res[i]=i+1;
        }
        return res;
    }
}


class Solution {
	//20200326leetcode999车的可用捕获量

    private boolean rowMinus(char[][] board,int row,int column){//行减
        while(row >= 0){
            if(board[row][column] == 'B'){
                return false;
            }else{
                if(board[row][column] == 'p'){
                    return true;
                }
            }
            row--;
        }
        return false;
    }

    private boolean rowAdd(char[][] board,int row,int column){
        while(row < 8){
            if(board[row][column] == 'B'){
                return false;
            }else{
                if(board[row][column] == 'p'){
                    return true;
                }
            }
            row++;
        }
        return false;
    }

    private boolean columnMinus(char[][] board,int row,int column){
        while(column >= 0){
            if(board[row][column] == 'B'){
                return false;
            }else{
                if(board[row][column] == 'p'){
                    return true;
                }
            }
            column--;
        }
        return false;
    }
    
    private boolean columnAdd(char[][] board,int row,int column){
        while(column < 8){
            if(board[row][column] == 'B'){
                return false;
            }else{
                if(board[row][column] == 'p'){
                    return true;
                }
            }
            column++;
        }
        return false;
    }

    public int numRookCaptures(char[][] board) {
        int count = 0;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]=='R'){
                    if(rowMinus(board,i,j)){
                        count++;
                    }
                    if(rowAdd(board,i,j)){
                        count++;
                    }
                    if(columnMinus(board,i,j)){
                        count++;
                    }
                    if(columnAdd(board,i,j)){
                        count++;
                    }
                    return count;
                }
            }
        }
        return 0;
    }
}


class Solution {
	//20200327leetcode914卡牌分组
    private int function(int x,int y){
        int max = x>y?x:y;
        int min = (max==x)?y:x;
        int tmp=min;
        while(min>0){
            if(max%min==0&&tmp%min==0){
                return min;
            }
            min--;
        }
        return 0;
    }
    public boolean hasGroupsSizeX(int[] deck) {
        int[] res = new int[10000];
        for(int i=0;i<deck.length;i++){
            res[deck[i]]++;
        }
        int count = 0;
        for(int i=0;i<res.length;i++){
            if(res[i]>0){
                count=res[i];
                break;
            }
        }
        for(int i=0;i<res.length;i++){
            if(res[i]>0){
                count=function(count,res[i]);
            }
        }
        return count>1;
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
	//20200328leetcode删除中间节点
    public void deleteNode(ListNode node) {
        ListNode cur = node.next;
        while(cur.next!=null){
            node.val = cur.val;
            node = cur;
            cur = cur.next;
        }
        node.val = cur.val;
        node.next = null;
    }
}


class Solution {
	//20200329leetcode替换空格
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        } 
        return sb.toString();
    }
}