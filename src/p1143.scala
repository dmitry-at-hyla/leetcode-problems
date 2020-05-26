// https://leetcode.com/problems/longest-common-subsequence
object Solution {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val cache = new scala.collection.mutable.HashMap[(Int, Int), Int]

    def len(i: Int, j: Int): Int = {
      if (i == 0 || j == 0) 0
      else cache.getOrElseUpdate((i, j), {
        if (text1(i - 1) == text2(j - 1))
          len(i - 1, j - 1) + 1
        else
          Math.max(len(i - 1, j), len(i, j - 1))
      })
    }

    len(text1.length, text2.length)
  }
}