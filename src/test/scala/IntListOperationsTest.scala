import org.scalatest.flatspec.AnyFlatSpec

class IntListOperationsTest extends AnyFlatSpec {

  "A ListOperations" should "be created with an empty list by default" in {
    val listOps = new ListOperations[Int]()
    assert(listOps.read() == List.empty[Int])
  }

  it should "create a new ListOperations instance with the provided element added to the list" in {
    val listOps = new ListOperations[Int]()
    val updatedListOps = listOps.create(1).create(2)
    assert(updatedListOps.read() == List(1, 2))
  }

  it should "return the current list" in {
    val listOps = new ListOperations[Int](List(1, 2, 3))
    assert(listOps.read() == List(1, 2, 3))
  }

  it should "update an element in the list with a new element and return a new ListOperations instance" in {
    val listOps = new ListOperations[Int](List(1, 2, 3))
    val updatedListOps = listOps.update(2, 4)
    assert(updatedListOps.read() == List(1, 4, 3))
  }

  it should "delete an element from the list and return a new ListOperations instance" in {
    val listOps = new ListOperations[Int](List(1, 2, 3))
    val updatedListOps = listOps.delete(2)
    assert(updatedListOps.read() == List(1, 3))
  }

  it should "not update an element if it does not exist in the list" in {
    val listOps = new ListOperations[Int](List(1, 2, 3))
    val updatedListOps = listOps.update(4, 5)
    assert(updatedListOps.read() == List(1, 2, 3))
  }

  it should "not delete an element if it does not exist in the list" in {
    val listOps = new ListOperations[Int](List(1, 2, 3))
    val updatedListOps = listOps.delete(4)
    assert(updatedListOps.read() == List(1, 2, 3))
  }
}
