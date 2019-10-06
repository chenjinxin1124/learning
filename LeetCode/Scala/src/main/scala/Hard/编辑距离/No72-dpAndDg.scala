package main.scala.Hard.编辑距离

object No72 extends App {

  val word1 = "horse"
  val word2 = "ros"
  val res = Solution.minDistance(word1, word2)
  println(res)

}

object Solution {

  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 0 to m) dp(i)(0) = i
    for (i <- 0 to n) dp(0)(i) = i
    for (i <- 1 to m)
      for (j <- 1 to n) {
        if (word1(i - 1) == word2(j - 1))
          dp(i)(j) = dp(i - 1)(j - 1)
        else
          dp(i)(j) = scala.math.min(scala.math.min(dp(i - 1)(j - 1), dp(i - 1)(j)), dp(i)(j - 1)) + 1
      }
    dp(m)(n)
  }

  def minDistance2(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length
    val memo = Array.ofDim[Int](m, n)
    helper(word1, 0, word2, 0, memo)
  }

  def helper(word1: String, i: Int, word2: String, j: Int, memo: Array[Array[Int]]): Int = {
    if (i == word1.length) return word2.length - j
    if (j == word2.length) return word1.length - i
    if (memo(i)(j) > 0) return memo(i)(j)
    var res: Int = 0
    if (word1(i) == word2(j)) {
      return helper(word1, i + 1, word2, j + 1, memo)
    } else {
      val insertCnt = helper(word1, i, word2, j + 1, memo)
      val deleteCnt = helper(word1, i + 1, word2, j, memo)
      val replaceCnt = helper(word1, i + 1, word2, j + 1, memo)
      res = scala.math.min(scala.math.min(insertCnt, deleteCnt), replaceCnt) + 1
    }
    res
  }

}