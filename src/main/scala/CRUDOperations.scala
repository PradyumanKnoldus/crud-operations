abstract class CRUDOperations[T] {

  // To create a new element
  def create (element: T): CRUDOperations[T]

  // To read all elements
  def read (): Seq[T]

  // To update an existing element
  def update (prevElement: T, newElement: T): CRUDOperations[T]

  // To delete an existing element
  def delete (element: T): CRUDOperations[T]
}
