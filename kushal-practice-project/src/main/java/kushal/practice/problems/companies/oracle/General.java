package kushal.practice.problems.companies.oracle;

import java.util.HashMap;

public class General
{
    public void flattenDictionary(HashMap<String, String> dict, String key, Object value)
    {
        if (value instanceof String)
        {
            dict.put(key, (String) value);
        }
        else if (value instanceof HashMap)
        {
            for (final String k : ((HashMap<String, String>) value).keySet())
            {
                Object v = dict.get(k);
                flattenDictionary(dict, key + "." + k, v);
            }
        }
    }

    public long minimumResizing(int start, int k, int[] nums, Long[][] dp)
    {
        if (start == nums.length)
        {
            return 0;
        }
        if (k == -1)
        {
            return Integer.MAX_VALUE;
        }
        if (dp[start][k] != null)
        {
            return dp[start][k];
        }
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        int max = nums[start], sum = 0;
        for (int i = start; i < n; i++)
        {
            max = Math.max(nums[i], max);
            sum = sum + nums[i];
            ans = Math.min(ans, ((i - start + 1) * max - sum) + minimumResizing(i + 1, k - 1, nums, dp));
        }
        return dp[start][k] = ans;
    }

    public int minSpaceWastedKResizing(int[] nums, int k)
    {
        return (int) minimumResizing(0, k, nums, new Long[nums.length][k + 1]);
    }
}
