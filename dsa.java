/**
 * DSA Sheet
 * 
 * Topics Covered:
 * 1. Pattern Printing (Triangle, Pyramid, Diamond)
 * 2. Number System Conversion (Binary ↔ Decimal)
 * 3. Array Operations (Min/Max, Reversal, Subarrays)
 * 4. Kadane's Algorithm & Pair Sum
 * 5. Majority Element & Product Except Self
 * 6. Binary Search & Rotated Array Search
 * 7. Book Allocation, Painter's Partition, Aggressive Cows
 * 8. Sorting Algorithms (Bubble, Selection, Insertion, Quick, Merge)
 * 9. Inversion Count & Count of Smaller Numbers
 * 10. Recursion & Backtracking (Subsets, Permutations, N-Queens, Sudoku)
 * 11. Linked List Operations
 * 12. Stack & Queue Problems
 * 13. Binary Tree & BST Operations
 */

import java.util.*;

// SECTION 1: PATTERN PRINTING


class PatternPrinting {
    public static void triangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pyramidNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            if (i > 1) {
                for (int l = i - 1; l > 0; l--) {
                    System.out.print(l);
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            int num = i - 1;
            for (int k = 0; k < i + num; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower half
        for (int i = n - 1; i > 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i * 2) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// SECTION 2: NUMBER SYSTEM CONVERSION


class NumberConversion {
    // Binary to Decimal
    public static int binaryToDecimal(int n) {
        int remainder = 0, ans = 0, pow = 1;
        while (n != 0) {
            remainder = n % 10;
            n = n / 10;
            ans = ans + (remainder * pow);
            pow = pow * 2;
        }
        return ans;
    }

    // Decimal to Binary
    public static int decimalToBinary(int n) {
        int mult = 1, ans = 0;
        while (n != 0) {
            int remainder = n % 2;
            n = n / 2;
            ans = (remainder * mult) + ans;
            mult *= 10;
        }
        return ans;
    }
}

// SECTION 3: ARRAY OPERATIONS


class MinMaxFinder {
    public static void findMinMax(int[] arr) {
        int greatest = 0, smallest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[greatest]) greatest = i;
            if (arr[i] < arr[smallest]) smallest = i;
        }
        System.out.println("Greatest: " + arr[greatest] + " at index " + greatest);
        System.out.println("Smallest: " + arr[smallest] + " at index " + smallest);
    }
}

class ArrayReversal {
    // Using for loop
    public static void reverseForLoop(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    // Using two pointers
    public static void reverseTwoPointers(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

class SubarrayPrinter {
    public static void printAllSubarrays(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = k; i < arr.length; i++) {
                for (int j = k; j <= i; j++) {
                    System.out.print(arr[j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// SECTION 4: KADANE'S ALGORITHM & PAIR SUM


class KadanesAlgorithm {
    public static int maxSubarraySum(int[] arr) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (currSum < 0) currSum = 0;
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

class PairSum {
    public static int[] findPair(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (arr[start] + arr[end] == target) {
                return new int[]{arr[start], arr[end]};
            } else if (arr[start] + arr[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }
}


// SECTION 5: MAJORITY ELEMENT & PRODUCT EXCEPT SELF

class MajorityElement {
    // Moore's Voting Algorithm
    public static int findMajority(int[] arr) {
        int ans = arr[0], freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ans == arr[i]) {
                freq++;
            } else {
                freq--;
            }
            if (freq <= 0) {
                freq = 1;
                ans = arr[i];
            }
        }
        return ans;
    }
}

class ProductExceptSelf {
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i - 1] * prefix[i - 1];
        }

        suffix[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = arr[j + 1] * suffix[j + 1];
        }

        for (int k = 0; k < n; k++) {
            suffix[k] = prefix[k] * suffix[k];
        }
        return suffix;
    }
}

// ====================================================================
// SECTION 6: BINARY SEARCH & VARIATIONS
// ====================================================================

class BinarySearch {
    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}

class SearchRotatedArray {
    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;

            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target >= arr[mid] && target <= arr[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}

class PeakMountain {
    public static int findPeak(int[] arr) {
        int start = 1, end = arr.length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid + 1] >= arr[mid] && arr[mid - 1] <= arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}

// SECTION 7: ALLOCATION PROBLEMS

class BookAllocation {
    private static boolean isValid(int[] arr, int m, int maxPages) {
        int student = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxPages < arr[i]) return false;
            if ((sum + arr[i]) <= maxPages) sum += arr[i];
            else {
                student++;
                sum = arr[i];
            }
        }
        return student <= m;
    }

    public static int allocateBooks(int[] arr, int m) {
        if (arr.length < m) return -1;
        int start = Integer.MIN_VALUE, end = 0;
        for (int num : arr) {
            start = Math.max(start, num);
            end += num;
        }
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

class AggressiveCows {
    private static boolean isValid(int[] arr, int m, int minDist) {
        int lastUsed = 0, cow = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastUsed] >= minDist) {
                cow++;
                lastUsed = i;
            }
        }
        return cow >= m;
    }

    public static int findMaxMinDistance(int[] arr, int cows) {
        Arrays.sort(arr);
        int start = 1, end = arr[arr.length - 1];
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, cows, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}

// SECTION 8: SORTING ALGORITHMS


class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }
}

class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) smallest = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}

class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }
}

class QuickSort {
    private static int partition(int[] arr, int start, int end) {
        int tracker = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                tracker++;
                int temp = arr[i];
                arr[i] = arr[tracker];
                arr[tracker] = temp;
            }
        }
        int temp = arr[end];
        arr[end] = arr[tracker + 1];
        arr[tracker + 1] = temp;
        return tracker + 1;
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }
}

class MergeSort {
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int idx1 = start, idx2 = mid + 1, tempIdx = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) temp[tempIdx++] = arr[idx1++];
            else temp[tempIdx++] = arr[idx2++];
        }
        while (idx1 <= mid) temp[tempIdx++] = arr[idx1++];
        while (idx2 <= end) temp[tempIdx++] = arr[idx2++];
        for (int i = 0; i < temp.length; i++) arr[i + start] = temp[i];
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
}

// SECTION 9: RECURSION & BACKTRACKING

class RecursionBasics {
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }
}

class Subsets {
    private static void generate(int[] arr, List<Integer> list, List<List<Integer>> result, int i) {
        if (i == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        generate(arr, list, result, i + 1);
        list.remove(list.size() - 1);
        generate(arr, list, result, i + 1);
    }

    public static List<List<Integer>> findAll(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, new ArrayList<>(), result, 0);
        return result;
    }
}

class Permutations {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void generate(int[] arr, List<List<Integer>> result, int idx) {
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int val : arr) temp.add(val);
            result.add(temp);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            generate(arr, result, idx + 1);
            swap(arr, i, idx);
        }
    }

    public static List<List<Integer>> findAll(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, result, 0);
        return result;
    }
}

class NQueens {
    private static boolean isSafe(List<String> board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }

    private static void place(List<String> board, List<List<String>> ans, int n, int row) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));
                place(board, ans, n, row + 1);
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }

    public static List<List<String>> solve(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String temp = ".".repeat(n);
        for (int i = 0; i < n; i++) board.add(temp);
        place(board, ans, n, 0);
        return ans;
    }
}

// SECTION 10: LINKED LIST

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; this.next = null; }
}

class LinkedListOperations {
    // Reverse linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Find middle node
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Detect cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Merge two sorted lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // Reverse in K groups
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, st = head, prev = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == k) {
                ListNode nextGroupStart = curr.next;
                ListNode reversed = reverseSegment(st, curr);
                if (prev != null) prev.next = reversed;
                else head = reversed;
                prev = st;
                st.next = nextGroupStart;
                st = nextGroupStart;
                curr = nextGroupStart;
                count = 0;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    private static ListNode reverseSegment(ListNode start, ListNode end) {
        end.next = null;
        ListNode curr = start, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// SECTION 11: STACK & QUEUE

class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                if ((stack.peek() == '(' && c == ')') ||
                    (stack.peek() == '{' && c == '}') ||
                    (stack.peek() == '[' && c == ']')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}

class NextGreaterElement {
    public static int[] findNextGreater(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())) minStack.pop();
        stack.pop();
    }

    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}

class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = previousSmaller(heights);
        int[] nse = nextSmaller(heights);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            max = Math.max(max, heights[i] * width);
        }
        return max;
    }

    private static int[] previousSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}

class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[arr.length - k + 1];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.removeLast();
            dq.addLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            ans[idx++] = arr[dq.peekFirst()];
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.removeLast();
            dq.addLast(i);
        }
        ans[idx++] = arr[dq.peekFirst()];
        return ans;
    }
}

// SECTION 12: BINARY TREE

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
}

class BinaryTreeTraversals {
    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (!q.isEmpty()) q.add(null);
            } else {
                System.out.print(curr.val + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }
}

class BinaryTreeProperties {
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int sumNodes(TreeNode root) {
        if (root == null) return 0;
        return sumNodes(root.left) + sumNodes(root.right) + root.val;
    }

    private static int maxDiameter = 0;
    
    public static int diameter(TreeNode root) {
        if (root == null) return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        maxDiameter = Math.max(maxDiameter, lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public static int getDiameter(TreeNode root) {
        maxDiameter = 0;
        diameter(root);
        return maxDiameter;
    }
}

// SECTION 13: BINARY SEARCH TREE

class BSTOperations {
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    public static boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        if (key < root.val) return search(root.left, key);
        return search(root.right, key);
    }

    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) root.left = delete(root.left, val);
        else if (val > root.val) root.right = delete(root.right, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

// SECTION 14: UTILITY & MATHEMATICAL FUNCTIONS


class MathUtilities {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static boolean isPalindrome(int n) {
        int original = n, reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
    }

    public static boolean isArmstrong(int n) {
        int sum = 0, original = n;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit * digit;
            n /= 10;
        }
        return original == sum;
    }

    public static double power(double x, int n) {
        long power = Math.abs((long)n);
        double result = 1, base = x;
        while (power > 0) {
            if (power % 2 == 1) result *= base;
            base *= base;
            power /= 2;
        }
        return n < 0 ? 1 / result : result;
    }
}

// SECTION 15: DEMONSTRATION (MAIN METHOD)


public class DSACompleteSheet {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("DSA COMPLETE SHEET - ALL ALGORITHMS DEMONSTRATION");
        System.out.println("=".repeat(60));

        // 1. Pattern Printing
        System.out.println("\n--- Pattern Printing ---");
        System.out.println("Triangle:");
        PatternPrinting.triangle(5);
        System.out.println("\nDiamond:");
        PatternPrinting.diamond(4);

        // 2. Number Conversion
        System.out.println("\n--- Number Conversion ---");
        System.out.println("Binary 1010 to Decimal: " + NumberConversion.binaryToDecimal(1010));
        System.out.println("Decimal 10 to Binary: " + NumberConversion.decimalToBinary(10));

        // 3. Array Operations
        System.out.println("\n--- Array Operations ---");
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        System.out.print("Original array: " + Arrays.toString(arr));
        MinMaxFinder.findMinMax(arr);
        
        // 4. Kadane's Algorithm
        System.out.println("\n--- Kadane's Algorithm ---");
        int[] kadaneArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + KadanesAlgorithm.maxSubarraySum(kadaneArr));

        // 5. Sorting
        System.out.println("\n--- Sorting Algorithms ---");
        int[] sortArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original: " + Arrays.toString(sortArr));
        BubbleSort.sort(sortArr.clone());
        System.out.println("\nBubble Sorted: " + Arrays.toString(sortArr));

        // 6. Binary Search
        System.out.println("\n--- Binary Search ---");
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Search for 5: Index " + BinarySearch.search(sortedArr, 5));

        // 7. Recursion
        System.out.println("\n--- Recursion ---");
        System.out.println("Factorial of 5: " + RecursionBasics.factorial(5));
        System.out.println("Fibonacci of 6: " + RecursionBasics.fibonacci(6));

        // 8. Subsets & Permutations
        System.out.println("\n--- Subsets & Permutations ---");
        int[] nums = {1, 2, 3};
        System.out.println("All subsets of [1,2,3]: " + Subsets.findAll(nums));
        System.out.println("All permutations of [1,2,3]: " + Permutations.findAll(nums));

        // 9. Valid Parentheses
        System.out.println("\n--- Valid Parentheses ---");
        System.out.println("'()[]{}' is valid: " + ValidParentheses.isValid("()[]{}"));
        System.out.println("'([)]' is valid: " + ValidParentheses.isValid("([)]"));

        // 10. Math Utilities
        System.out.println("\n--- Math Utilities ---");
        System.out.println("Is 17 prime? " + MathUtilities.isPrime(17));
        System.out.println("GCD of 48 and 18: " + MathUtilities.gcd(48, 18));
        System.out.println("LCM of 12 and 18: " + MathUtilities.lcm(12, 18));
        System.out.println("2^10 = " + MathUtilities.power(2, 10));

        // 11. N-Queens
        System.out.println("\n--- N-Queens (4x4) ---");
        List<List<String>> solutions = NQueens.solve(4);
        System.out.println("Number of solutions for 4-Queens: " + solutions.size());

        System.out.println("\n" + "=".repeat(60));
        System.out.println("All algorithms loaded successfully!");
        System.out.println("Check the source code for complete implementations.");
        System.out.println("=".repeat(60));
    }
}