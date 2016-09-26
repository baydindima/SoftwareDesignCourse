package edu.spbau.master.software.design.shell.parser

/**
  * @author Baidin Dima
  */
class ParserException(val cause: String) extends RuntimeException(cause)

object ParserException {
  def apply(inputString: String, failureMsg: String): ParserException =
    new ParserException(s"Failure during parse $inputString with msg $failureMsg")
}
