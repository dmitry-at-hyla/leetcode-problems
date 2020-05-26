// https://leetcode.com/problems/search-in-rotated-sorted-array
object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = nums.length - 1

    while (hi >= lo) {
      val mid = (lo + hi) / 2
      var midVal = nums(mid)
      if (midVal == target) return mid
      if ((target >= nums(0)) != (midVal >= nums(0))) {
        midVal = if (target >= nums(0)) Int.MaxValue else Int.MinValue
      }
      if (midVal > target) {
        hi = mid - 1
      }
      else {
        lo = mid + 1
      }
    }
    return -1
  }
}