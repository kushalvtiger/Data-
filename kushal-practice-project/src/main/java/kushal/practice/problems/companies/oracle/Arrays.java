package kushal.practice.problems.companies.oracle;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Arrays
{
    public int firstMissingPositive(int[] nums)
    {
        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1)
            {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++)
        {
            if ((nums[i] <= 0) || (nums[i] > n))
            {
                nums[i] = 1;
            }
        }
        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++)
        {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n)
            {
                nums[0] = -Math.abs(nums[0]);
            }
            else
            {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > 0)
            {
                return i;
            }
        }
        if (nums[0] > 0)
        {
            return n;
        }
        return n + 1;
    }

    public boolean canAttendMeetings(int[][] intervals)
    {
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++)
        {
            if (intervals[i][1] > intervals[i + 1][0])
            {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(int[][] intervals)
    {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0)
        {
            return 0;
        }
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        // Sort the intervals by end time
        java.util.Arrays.sort(end, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return a - b;
            }
        });
        // Sort the intervals by start time
        java.util.Arrays.sort(start, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return a - b;
            }
        });
        // The two pointers in the algorithm: e_ptr and s_ptr.
        int startPointer = 0, endPointer = 0;
        // Variables to keep track of maximum number of rooms used.
        int usedRooms = 0;
        // Iterate over intervals.
        while (startPointer < intervals.length)
        {
            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startPointer] >= end[endPointer])
            {
                usedRooms -= 1;
                endPointer += 1;
            }
            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer += 1;
        }
        return usedRooms;
    }
    
    public int[][] kClosest(int[][] points, int k) {
        // Use a lambda comparator to sort the PQ by farthest distance
        Queue<int[]> maxPQ = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) 
        {
            int[] entry = {squaredDistance(points[i]), i};
            if (maxPQ.size() < k) 
            {
                // Fill the max PQ up to k points
                maxPQ.add(entry);
            } else if (entry[0] < maxPQ.peek()[0]) 
            {
                // If the max PQ is full and a closer point is found,
                // discard the farthest point and add this one
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }
        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = maxPQ.poll()[1];
            answer[i] = points[entryIndex];
        }
        return answer;
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
