package Easy.两数之和1

object No1 {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 11, 15)
    val target = 9
    twoSum(nums,target).map(x => print(x+" "))
  }
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var m: Map[Int, Int] = Map()
    for (i <- 0 to nums.size) {
      if (m.contains(target - nums(i))){
        return Array(m(target - nums(i)), i)
      }
      m += (nums(i) -> i)
    }
    return Array()
  }
}
