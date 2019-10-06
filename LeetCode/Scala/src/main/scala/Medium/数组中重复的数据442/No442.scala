package Medium.数组中重复的数据442

object No442 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1,2,2,3,3,4,5)
    findDuplicates(nums).map(x => print(x+" "))
  }
  def findDuplicates(nums: Array[Int]): List[Int] = {
    var res = scala.collection.mutable.ListBuffer[Int]()
    for (i <- nums) {
      val idx = if (i > 0) i-1 else -i-1
      if (nums(idx) < 0) {
        res += idx + 1
      }
      nums(idx) = -nums(idx)
    }
    res.filter(_ > 0).toList
  }
}
