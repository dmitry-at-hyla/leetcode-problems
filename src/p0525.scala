// https://leetcode.com/problems/contiguous-array
object Solution {
  class IntMap(n: Int) {
    private val noVal = n + 1
    private val array = Array.fill(2 * n + 1)(noVal)
    def apply(i: Int) = array(i + n)
    def update(i: Int, v: Int) { array(i + n) = v }
    def has(i: Int) = this(i) != noVal
  }

  def findMaxLength(nums: Array[Int]): Int = {
    val sums = new IntMap(nums.length)
    sums(0) = -1

    var currentSum = 0
    var maxLen = 0
    var endIdx = -1
    for (i <- 0 to (nums.length - 1)) {
      currentSum += 2 * nums(i) - 1
      if (sums.has(currentSum)) {
        val len = i - sums(currentSum)
        if (maxLen < len) {
          maxLen = len
          endIdx = i
        }
      }
      else {
        sums(currentSum) = i
      }
    }
    maxLen
  }
}