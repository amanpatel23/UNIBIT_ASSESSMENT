# UNIBIT_ASSESSMENT
### Problem Statement:
Given an array of integers and a target value, you must determine which two integers' sum
equals the target and return a 2D array. Then merge the array into a single array with sorting (
ascending ) order, in the next step double the target value and find again the combination of
digits (can be multiple digits ) that are equal to the double targeted value and returned into a 2D
array.

Example: 
```
Sample Input : [1, 3, 2, 2, -4, -6, -2, 8];
Target Value = 4,
Output: First Combination For “4” : [ [1,3],[2,2],[-4,8],[-6,2] ];
Merge Into a single Array : [-6,-4,1,2,2,2,3,8];
Second Combination For “8” : [ [ 1,3,2,2], [8,-4,2,2],....,[n,n,n,n] ]
```

### Approach:
The first task was to find all the pairs of elements in the given array that sum to the given target.
So for that I used two nested for loops and stored all the pairs that sum to the given target in a 2d list.
This was of polynomial time complexity task, basically **O(N^2)**, where N = length of the given array.

After that I merged all the pairs into a single list(merged_list) and then I sorted the list in ascending order.

And the last step was to double the given target and find all the combinations of elements from that merged_list
that sum to the doubled target. So for that I used *backtracking*.
This was an exponential time complexity task, basically **(2^N)**, where N = length of the merged_list

So, overall the time complexity of this algorithm is **O(2^N)**.
