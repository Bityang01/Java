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