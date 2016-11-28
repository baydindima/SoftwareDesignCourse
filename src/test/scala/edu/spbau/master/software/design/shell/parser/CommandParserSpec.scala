package edu.spbau.master.software.design.shell.parser

import edu.spbau.master.software.design.shell.model.{CommandArg ⇒ CA, CommandModel ⇒ CM, CommandName ⇒ CN, Variable => V, VariableName => VN, VariableValue => VV}
import edu.spbau.master.software.design.shell.parser.TestUtils._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Dmitriy Baidin on 9/26/2016.
  */
@RunWith(classOf[JUnitRunner])
class CommandParserSpec extends FlatSpec with Matchers {

  it should "parse single command" in {
    getCommandParser(V(VN("x"), VV("echo")))("$x 101").get shouldEqual
      Seq(CM(CN("echo"), CA("101")))
  }

  it should "parse single assignment" in {
    getCommandParser(V(VN("x"), VV("2000")))("y=$x").get shouldEqual
      Seq(CM(CN("="), CA("y"), CA("2000")))
  }

  it should "parse pipe" in {
    getCommandParser(V(VN("x"), VV("2000")))("y=$x | echo").get shouldEqual
      Seq(CM(CN("="), CA("y"), CA("2000")), CM(CN("echo")))
  }

}
