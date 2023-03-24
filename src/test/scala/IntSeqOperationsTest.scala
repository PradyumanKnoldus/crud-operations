import org.scalatest.flatspec.AnyFlatSpec

class IntSeqOperationsTest extends AnyFlatSpec {

  "A SeqOperations" should "be created with an empty sequence by default" in {
    val seqOps = new SeqOperations[Int]()
    assert(seqOps.read() == Seq.empty[Int])
  }

  it should "create a new SeqOperations instance with the provided element added to the sequence" in {
    val seqOps = new SeqOperations[Int]()
    val updatedSeqOps = seqOps.create(1).create(2)
    assert(updatedSeqOps.read() == Seq(1, 2))
  }

  it should "return the underlying sequence when read is called" in {
    val initialSeq = Seq(1, 2, 3)
    val seqOps = new SeqOperations[Int](initialSeq)
    val result = seqOps.read()
    assert(result == initialSeq)
  }

  it should "update an element in the sequence with a new element and return a new SeqOperations instance" in {
    val initialSeq = Seq(1, 2, 3)
    val seqOps = new SeqOperations[Int](initialSeq)
    val updatedSeqOps = seqOps.update(2, 4)
    assert(updatedSeqOps.read() == Seq(1, 4, 3))
  }

  it should "delete an element from the sequence and return a new SeqOperations instance" in {
    val initialSeq = Seq(1, 2, 3)
    val seqOps = new SeqOperations[Int](initialSeq)
    val updatedSeqOps = seqOps.delete(2)
    assert(updatedSeqOps.read() == Seq(1, 3))
  }

  it should "not update an element if it does not exist in the sequence" in {
    val initialSeq = Seq(1, 2, 3)
    val seqOps = new SeqOperations[Int](initialSeq)
    val updatedSeqOps = seqOps.update(4, 5)
    assert(updatedSeqOps.read() == initialSeq)
  }

  it should "not delete an element if it does not exist in the sequence" in {
    val initialSeq = Seq(1, 2, 3)
    val seqOps = new SeqOperations[Int](initialSeq)
    val updatedSeqOps = seqOps.delete(4)
    assert(updatedSeqOps.read() == initialSeq)
  }
}
