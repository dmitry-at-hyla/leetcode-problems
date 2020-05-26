// https://leetcode.com/problems/move-zeroes
object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    var (i1, i2) = (0, 1);
    while (true) {
      while (i2 < nums.length && nums(i2) == 0) i2 += 1;
      if (i2 >= nums.length) return;
      if (nums(i1) == 0) {
        nums(i1) = nums(i2);
        nums(i2) = 0;

        i2 += 1;
      }
      i1 += 1;
      if (i1 == i2) i2 += 1;
    }
  }
}