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


