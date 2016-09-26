package edu.spbau.master.software.design.shell.parser

/**
  * Wrapper on [[RuntimeException]]
  */
class ParserException(val cause: String) extends RuntimeException(cause)

object ParserException {
  /**
    * Wrapper on [[RuntimeException]]
    */
  def apply(inputString: String, failureMsg: String): ParserException =
    new ParserException(s"Failure during parse $inputString with msg $failureMsg")
}
