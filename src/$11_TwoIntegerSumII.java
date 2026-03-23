class $11_TwoIntegerSumII1 {
    public int[] twoSum(int[] numbers, int target) {

        for(int i = 0;i<numbers.length;i++){
            for(int j = 0;j < numbers.length;j++){
                if(i!=j){
                    if(numbers[i] + numbers[j] == target){
                        int[] arr = new int[2];
                        arr[1] = i > j ? i : j;
                        arr[0] = i < j ? i : j;
                        return new int[] {arr[0]+1, arr[1]+1};
                    }
                }
            }
        }

        return new int[2];
    }
}

class $11_TwoIntegerSumII2 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] arr = new int[2];


        while(low <= high){
            int mid = low + (high-low)/2;
            int sum = numbers[low] + numbers[high];
            if(target == sum) return new int[] {low+1, high+1};
            if(target < sum) high--;
            else low++;
        }
        return new int[]{};
    }
}

