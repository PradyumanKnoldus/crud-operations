class ListOperations[T] (val newList: List[T] = List.empty[T]) extends CRUDOperations[T] {

  // Creates a new ListOperations instance with the provided element added to the list
  override def create (element: T): ListOperations[T] = {
    new ListOperations(newList :+ element)
  }

  // Returns the current list
  override def read (): List[T] = newList

  // Updates an element in the list with a new element and returns a new ListOperations
  override def update (prevElement: T, newElement: T): ListOperations[T] = {
    val index = newList.indexOf(prevElement)
    if (index >= 0) {
      val updatedList = newList.updated(index, newElement)
      new ListOperations(updatedList)
    } else {
      this
    }
  }

  // Deletes an element from the list and returns a new ListOperations instance
  override def delete (element: T): ListOperations[T] = {
    val index = newList.indexOf(element)
    if (index >= 0) {
      val updatedList = newList.take(index) ++ newList.drop(index + 1)
      new ListOperations(updatedList)
    } else {
      this
    }
  }
}