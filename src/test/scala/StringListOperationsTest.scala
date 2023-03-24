import org.scalatest.flatspec.AnyFlatSpec

class StringListOperationsTest extends AnyFlatSpec {

  "A ListOperations" should "be created with an empty list by default" in {
    val listOps = new ListOperations[String]()
    assert(listOps.read() == List.empty[String])
  }

  it should "create a new ListOperations instance with the provided element added to the list" in {
    val listOps = new ListOperations[String]()
    val updatedListOps = listOps.create("hello").create("world")
    assert(updatedListOps.read() == List("hello", "world"))
  }

  it should "return the current list when read is called" in {
    val initialList = List("hello", "world")
    val listOps = new ListOperations[String](initialList)
    val result = listOps.read()
    assert(result == initialList)
  }

  it should "update an element in the list with a new element and return a new ListOperations instance" in {
    val initialList = List("hello", "world", "scala")
    val listOps = new ListOperations[String](initialList)
    val updatedListOps = listOps.update("world", "programming")
    assert(updatedListOps.read() == List("hello", "programming", "scala"))
  }

  it should "delete an element from the list and return a new ListOperations instance" in {
    val initialList = List("hello", "world", "scala")
    val listOps = new ListOperations[String](initialList)
    val updatedListOps = listOps.delete("world")
    assert(updatedListOps.read() == List("hello", "scala"))
  }

  it should "not update an element if it does not exist in the list" in {
    val initialList = List("hello", "world", "scala")
    val listOps = new ListOperations[String](initialList)
    val updatedListOps = listOps.update("java", "programming")
    assert(updatedListOps.read() == initialList)
  }

  it should "not delete an element if it does not exist in the list" in {
    val initialList = List("hello", "world", "scala")
    val listOps = new ListOperations[String](initialList)
    val updatedListOps = listOps.delete("java")
    assert(updatedListOps.read() == initialList)
  }
}
