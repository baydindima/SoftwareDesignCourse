package edu.spbau.master.software.design.shell.command.impl

import java.io.File

import edu.spbau.master.software.design.shell.model.{CommandArg, CommandModel, CommandName}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}


/**
  * @author Alexey Stepanov
  */
@RunWith(classOf[JUnitRunner])
class CdCommandSpec extends FlatSpec with Matchers {

  it should "should return current directory" in {
    val currentDirectoryName = new File(".").getName
    new CdCommand().execute(CommandModel(CommandName("cd"), CommandArg("..")))
    new CdCommand().execute(CommandModel(CommandName("cd"), CommandArg(currentDirectoryName)))
    new PwdCommand().execute(
      CommandModel(CommandName("pwd"))) shouldEqual new File(".").getAbsolutePath
  }

}
