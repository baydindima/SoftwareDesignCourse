package edu.spbau.master.software.design.shell.command.impl

import java.io.File

import edu.spbau.master.software.design.shell.model.{CommandModel, CommandName}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Alexey Stepanov
  */
@RunWith(classOf[JUnitRunner])
class LsCommandSpec extends FlatSpec with Matchers {
  it should "should return list of current directory" in {
    new LsCommand().execute(
      CommandModel(CommandName("ls"))).mkString shouldEqual new File(System.getProperty("user.dir")).listFiles().map(f => (if (f.isDirectory) "> " else "") + f.getName).mkString("\n")
  }

}
