# Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.


![螺旋矩阵1](https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg)
~~~~
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
~~~~

~~~~
Input: n = 1
Output: [[1]]
~~~~

# Notes
* **Loop invariant !**
* [ , )? ( , ]? <- stick to one rule!
* example: using **[ , )** !
![螺旋矩阵2](https://img-blog.csdnimg.cn/2020121623550681.png)

~~~~
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0;//row
        int startY = 0;//column
        int loop = n / 2; //right, down, left, up as 1 cycle -> loop = no.of cycle; if odd center cell handled separately
        int offset = 1; // for each loop, what is the length of each side?
        int mid = n/2; 
        int count = 1; // the number to be filled in the cell

        while (loop > 0) {
            int i = startX;
            int j = startY;

            // top side, from left -> right
            for (; j < startY + n - offset; j++) {
                result[startX][j] = count++;
            }

            // right side, from top -> down
            for (; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }

            // bottom side, form right -> left
            for (; j > startY; j--) {
                result[i][j] = count++;
            }

            // left side, form bottom -> up
            for (; i > startX; i--) {
                result[i][startY] = count++;
            }

            loop--;
            startX++;
            startY++;

            offset += 2;
        }
        if (n%2 == 1) { //odd we handle center number
            result[mid][mid] = count;
        }
        return result;
    }
}
~~~~