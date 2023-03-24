import org.scalatest.flatspec.AnyFlatSpec

class StringSeqOperationsTest extends AnyFlatSpec {

  "A SeqOperations with String type" should "be created with an empty sequence by default" in {
    val seqOps = new SeqOperations[String]()
    assert(seqOps.read() == Seq.empty[String])
  }

  it should "create a new SeqOperations instance with the provided element added to the sequence" in {
    val seqOps = new SeqOperations[String]()
    val updatedSeqOps = seqOps.create("hello").create("world")
    assert(updatedSeqOps.read() == Seq("hello", "world"))
  }

  it should "return the underlying sequence when read is called" in {
    val initialSeq = Seq("hello", "world")
    val seqOps = new SeqOperations[String](initialSeq)
    val result = seqOps.read()
    assert(result == initialSeq)
  }

  it should "update an element in the sequence with a new element and return a new SeqOperations instance" in {
    val initialSeq = Seq("hello", "world")
    val seqOps = new SeqOperations[String](initialSeq)
    val updatedSeqOps = seqOps.update("world", "everyone")
    assert(updatedSeqOps.read() == Seq("hello", "everyone"))
  }

  it should "delete an element from the sequence and return a new SeqOperations instance" in {
    val initialSeq = Seq("hello", "world")
    val seqOps = new SeqOperations[String](initialSeq)
    val updatedSeqOps = seqOps.delete("world")
    assert(updatedSeqOps.read() == Seq("hello"))
  }

  it should "not update an element if it does not exist in the sequence" in {
    val initialSeq = Seq("hello", "world")
    val seqOps = new SeqOperations[String](initialSeq)
    val updatedSeqOps = seqOps.update("everyone", "goodbye")
    assert(updatedSeqOps.read() == initialSeq)
  }

  it should "not delete an element if it does not exist in the sequence" in {
    val initialSeq = Seq("hello", "world")
    val seqOps = new SeqOperations[String](initialSeq)
    val updatedSeqOps = seqOps.delete("everyone")
    assert(updatedSeqOps.read() == initialSeq)
  }
}
