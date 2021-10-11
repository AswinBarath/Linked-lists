# SDE Sheet : Linked lists

<p><img src="https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg"></p>

<hr />

## Task list

### Day 5

| Completion Status | Linked List Problem | Solution |
| --- | --- | --- |
| ✅ | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [Java Soultion](./ReverseLL.java) |
| ✅ | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | [Java Soultion](./MiddleOfLL.java) |
| ✅ | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [Java Soultion](./MergeTwoSortedLists.java) |
| ✅ | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/) | [Java Soultion](./RemoveNthNodeFromEndofList.java)
| ✅ | [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/) | [Java Soultion](./DeleteNodeinaLinkedList.java) |
| ✅ | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [Java Soultion](./AddTwoNumbers.java) |

---

### Day 6

| Completion Status | Linked List Problem | Solution |
| --- | --- | --- |
| 🔃 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [Java Soultion]() |
| 🔃 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [Java Soultion]() |
| 🔃 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [Java Soultion]() |
| 🔃 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Java Soultion]() |
| 🔃 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [Java Soultion]() |
| 🔃 | [Flattening a Linked List](https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#) | [Java Soultion]() |
| 🔃 | [Rotate List](https://leetcode.com/problems/rotate-list/) | [Java Soultion]() |


### Intersection of Two Linked Lists

#### Brute Force approach

- Check for every node in second LL to check each node in first LL for equality
- When you found equal nodes return it, else you will reach the end hence return null
- Time Complexity: O(m * n); where m and n are length of LL 1 & 2 respectively

#### Better approach - Hashing

- Traverse through first LL and hash the **Node Address**
- Again traverse for second LL and check for equality
- When you found equal node address from HashMap return it, else you will reach the end hence return null
- Time Complexity: O(m + n); where m and n are length of LL 1 & 2 respectively
- Space Complexity: O(m); where m and n are length of LL 1 & 2 respectively

#### Optimal approach I - ( Lengthier approach )

- Take dummy nodes at head of both LL, and keep a count to store length of both the LL
- Take dummy nodes at head of both LL again, and cover the difference one LL using lengths
- Then, traverse simultaneously both the nodes to reach an intersection point
- When you found equal nodes return it, else you will reach the end hence return null
- Time Complexity = O(m) <= O(2m) <= { O(m) + O(m-n) + O(n) }; where m is length of longer LL and n is length of shorter LL

#### Optimal approach II - ( Concise approach )

- Take two dummy nodes d1 and d2, assign them to head of the LL
- Move d1 and d2 simultaneously till one of them reaches null
- Now, reassign that dummy node that is at null to the head of the other LL
- Repeat the same process for both nodes until them meet at intersection
- When you found equal nodes return it, else you will reach the end hence return null


##### Intuition behind Optimal approach II

- The first iteration is to find the difference directly and reassigning them to equate the difference
- Hence in the second iteration they either meet at intersection if exists or null
- This approach is similar Optimal approach I, but instead of calculating difference, here we directly find it with our logic
- Time Complexity: O(2m); where m is the length of longer LL

