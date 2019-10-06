package Hard

object No4 {
  def main(args: Array[String]): Unit = {
    val nums1 = Array(1, 2, 3)
    val nums2 = Array(2, 3)
    println(findMedianSortedArrays2(nums1, nums2))
  }

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val m = nums1.length
    val n = nums2.length
    val left = (m + n + 1) / 2
    val right = (m + n + 2) / 2
    return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) * 0.5
  }

  def findKth(nums1: Array[Int], i: Int, nums2: Array[Int], j: Int, k: Int): Double = {
    if (i >= nums1.length) return nums2(j + k - 1)
    if (j >= nums2.length) return nums1(i + k - 1)
    if (k == 1) return Math.min(nums1(i), nums2(j))
    val midVal1 = if (i + k / 2 - 1 < nums1.length) nums1(i + k / 2 - 1)
    else Integer.MAX_VALUE
    val midVal2 = if (j + k / 2 - 1 < nums2.length) nums2(j + k / 2 - 1)
    else Integer.MAX_VALUE
    if (midVal1 < midVal2) return findKth(nums1, i + k / 2, nums2, j, k - k / 2)
    else return findKth(nums1, i, nums2, j + k / 2, k - k / 2)
  }

  def findMedianSortedArrays2(nums1: Array[Int], nums2: Array[Int]): Double = {
    val n = nums1.length
    val m = nums2.length
    val left = (n + m + 1) / 2
    val right = (n + m + 2) / 2
    (findKth2(nums1, 0, n - 1, nums2, 0, m - 1, left) + findKth2(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5
  }

  private def findKth2(nums1: Array[Int], start1: Int, end1: Int, nums2: Array[Int], start2: Int, end2: Int, k: Int): Int = {
    val len1 = end1 - start1 + 1
    val len2 = end2 - start2 + 1
    if (len1 > len2) return findKth2(nums2, start2, end2, nums1, start1, end1, k)
    if (len1 == 0) return nums2(start2 + k - 1)
    if (k == 1) return Math.min(nums1(start1), nums2(start2))
    val i = start1 + Math.min(len1, k / 2) - 1
    val j = start2 + Math.min(len2, k / 2) - 1
    if (nums1(i) > nums2(j)) findKth2(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1))
    else findKth2(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1))
  }

}

