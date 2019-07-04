public class MaxSubArraySum {

    static int start=0, end=0, s=0;

    int maxSumSubarray(int arr[]){
        int max_sum_so_far=0, max_ending_here=0;

        for(int i=0; i<arr.length; i++){

            max_ending_here = max_ending_here + arr[i];

            if(max_ending_here <0) {
                max_ending_here = 0;
                s = i+1;
            }

            else if(max_ending_here>max_sum_so_far) {
                max_sum_so_far = max_ending_here;
                start=s;
                end=i;
            }
        }

        return max_sum_so_far;

    }

    public static void main (String[] args)
    {
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum.maxSumSubarray(a) + " , Respective indices are, start: " + start + " end : " + end);
    }
}
