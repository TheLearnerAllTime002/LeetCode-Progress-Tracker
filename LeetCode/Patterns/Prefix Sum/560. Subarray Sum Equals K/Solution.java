class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> SumCountMap = new HashMap<>();
        SumCountMap.put(0, 1);

        int result = 0;
        int prefixsum = 0;

        for (int num : nums) {
            prefixsum += num;
            if (SumCountMap.containsKey(prefixsum - k)) {
                result += SumCountMap.get(prefixsum - k);
            }
            SumCountMap.put(prefixsum, SumCountMap.getOrDefault(prefixsum, 0) + 1);
        }
        return result;
    }
}