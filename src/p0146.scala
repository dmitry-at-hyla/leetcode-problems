// https://leetcode.com/problems/lru-cache
class LRUCache(_capacity: Int) {

  import scala.collection.mutable.LinkedHashMap

  private val cache = new LinkedHashMap[Int, Int]

  def get(key: Int): Int = {
    cache.get(key).fold(-1) { found =>
      cache.remove(key)
      cache.put(key, found)
      found
    }
  }

  def put(key: Int, value: Int) {
    cache.get(key) match {
      case Some(_) =>
        cache.remove(key)
      case None if cache.size == _capacity =>
        cache.remove(cache.head._1)
      case _ =>
    }

    cache.put(key, value)
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */