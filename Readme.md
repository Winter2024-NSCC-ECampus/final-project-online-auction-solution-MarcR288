Online Auction Solution						Marc Remillard

1. Introduction
Overview: The purpose of this design document is to plan an efficient Online Auction Solution.
Objective: The goals of this design document are:
Choose the most efficient algorithm(algo) in terms of time complexity
Define a solution for storing and processing a large number of bids efficiently



2. Part A: Time Complexity Analysis
Analysis of Time Complexities:


O(n³): Refers to an algo whose execution time grows as the cube of the size of input. For large values of n, the time complexity becomes inefficient swiftly. Rating: Bad.
Ω(n³): Refers to an algo that best-case, the algo will take at least n³ operations. Again, for large values of n, the time complexity b-ecomes inefficient swiftly. Rating: Pretty Bad.
O(n² log n): This algo would perform n² operations that are each multiplied by the logarithmic factor log n. This type of complexity is commonly used in algos that combine quadratic algos with logarithmic subproblems.(Divide and conquer algos) For large values of n, it is more efficient than O(n³). Rating: Good but not great
O(2ⁿ): Represents exponential time complexity, where the number of operations grow exponentially as the input size n increases. Rating: Don’t even bother
Θ(n² log n): Describes the exact bound of an algos time complexity, the algos performance will grow at a rate proportional to n² log n for both the worst-case and the best-case scenarios. Θ(n² log n) guarantees that regardless of the input, the time complexity will always grow at the same rate. Good for predicting performance accurately. This is the time complexity we will be utilizing in our solution. Rating: Best choice for relatively large n


3. Part B: Data Structures for Bid Storage and Processing
Solution Requirements:
Bidders, identified by their ID’s, submit their bids until the auction is closed.
Everyone can submit a number of bids.
Bids must be integer values, in CAD, and higher than the minimum
Bids of less than the required minimum are discarded
As soon as the auction is closed, the highest bidders are found.
In the event of a tie, the auction is restarted with the minimum bid of the current highest bid + $1
If the highest unique bid is found, the bidder who placed it wins



3.1 Bid Storage and Processing Solution
Data Structures Used:
Priority Queue/Heap: A priority queue (or heap) is a data structure that can be used to efficiently find the highest bid at any point. Specifically, a max-heap (or priority queue that returns the maximum element) would be ideal for this case, as it always ensures that the highest bid is at the root.
A max-heap or priority queue is ideal for this scenario. It allows us to efficiently retrieve the largest bid at any time while maintaining the structure's properties.
Heap Operations:
Inserting a bid can be done in O(log n) time, which is efficient for processing large numbers of bids.
Retrieving the maximum (the highest bid) is an O(1) operation, which is fast.
The heap ensures that the highest bid is always at the root.
The heap will store (bid_value, bidder_id) pairs. This helps to track the highest bid as well as the bidder who placed it.

3.2 Tie-Breaker Scenario 
Problem Statement: The max-heap will allow us to find the highest bid efficiently. If a tie occurs, you can use the hash table to track which bidders placed the highest bid and restart the auction as needed.


Modifications to the Solution based on if the bidder with highest bid placed first won:


1. Modify the Priority Queue to Store Timestamps: To resolve this issue, you need to modify the elements in the priority queue to store both the bid amount and the timestamp (the order in which the bid was placed). This allows the system to compare both the bid value and the time of placement when resolving ties.
2. Priority Queue Element Structure :Each entry in the priority queue (max-heap) will now contain the following:
Bidder ID: To identify who placed the bid.


Bid Amount: The amount of the bid.


Timestamp: The timestamp or a counter indicating the order in which the bid was placed.


3. Handling Tie Resolution in the Priority Queue
When inserting a bid into the priority queue, you would compare first by the bid amount. If two bids have the same amount, you would then compare the timestamp to determine which bidder placed their bid first.


You can modify the priority queue’s comparison function to use a secondary comparison based on the timestamp if the bid amounts are equal. This ensures that, in the case of a tie, the bidder who placed their bid earlier is considered first.


4. Updated Operations:
Insert: When inserting a bid, in addition to adding the bid amount, you add the current timestamp.


Extract-Max: When extracting the highest bid, the priority queue will first ensure that the highest bid is returned. If there’s a tie, the timestamp will ensure that the first placed bid is returned first.



4. Code Implementation
Introduction:
We will use a maxHeap to store bids
Bidder class to add bidder objects to the maxHeap
Scanner to capture bidder ID and bid amount
System.currentTimeMillis() to set the auction time
Wrapper to set the minimum bid from the bidder.placebid() function
Bids of less than the minimum are not added to the heap
Code pushed to:







5. Conclusion
Using a max-heap for efficient access to the highest bid, provides a nice solution for processing large numbers of bids. The solution is scalable, efficient, and well-suited for handling the needs of an auction system.
