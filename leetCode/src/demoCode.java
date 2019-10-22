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