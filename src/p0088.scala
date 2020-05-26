// https://leetcode.com/problems/merge-sorted-array
object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i1 = m - 1
    var i2 = n - 1
    var ri = m + n - 1
    while (ri >= 0) {
      if (i1 < 0 || i2 >= 0 && nums1(i1) < nums2(i2)) {
        nums1(ri) = nums2(i2)
        i2 -= 1
      }
      else {
        nums1(ri) = nums1(i1)
        i1 -= 1
      }
      ri -= 1
    }
  }
}