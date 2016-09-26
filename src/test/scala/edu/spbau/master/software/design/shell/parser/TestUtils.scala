package edu.spbau.master.software.design.shell.parser

import edu.spbau.master.software.design.shell.app.Environment
import edu.spbau.master.software.design.shell.model.Variable
import org.scalatest.FlatSpec

import scala.language.postfixOps

/**
  * @author Baidin Dima
  */
object TestUtils extends FlatSpec{

  private[parser] def checkCommandListEquals(expected: Expression*)(actual: Expression*): Unit = {
    if (expected.size != actual.size) {
      fail(s"Expected size doesn't match actual size! expected: $expected, actual: $actual")
    }

    expected.zip(actual).foreach { case (exp, act) ⇒ if (exp != act) {
      fail(s"Expected doesn't match actual! expected: $exp; actual: $act")
    }
    }
  }

  def getCommandParser(variables: Variable*): CommandParser = new CommandParser(getVariableResolver(variables: _*))


  def getVariableResolver(variables: Variable*): VariableResolver = {
    new VariableResolver(
      new Environment(variables map (v ⇒ (v name, v value)) toMap)
    )
  }

}
