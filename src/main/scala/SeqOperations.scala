class SeqOperations[T] (val newSeq: Seq[T] = Seq.empty[T]) extends CRUDOperations[T] {

  // Creates a new SeqOperations instance with the provided element added to the sequence
  override def create (element: T): SeqOperations[T] = {
    new SeqOperations(newSeq :+ element)
  }

  // Returns the underlying sequence.
  override def read () : Seq[T] = newSeq

  // Updates an element in the sequence with a new element and returns a new SeqOperations
  override def update (prevElement: T, newElement: T): SeqOperations[T] = {
    val index = newSeq.indexOf(prevElement)
    if (index >= 0) {
      val updatedSeq = newSeq.updated(index, newElement)
      new SeqOperations(updatedSeq)
    } else {
      this
    }
  }

  // Deletes an element from the sequence and returns a new SeqOperations instance
  override def delete (element: T): SeqOperations[T] = {
    val index = newSeq.indexOf(element)
    if (index >= 0) {
      val updatedSeq = newSeq.take(index) ++ newSeq.drop(index + 1)
      new SeqOperations(updatedSeq)
    } else {
      this
    }
  }
}
