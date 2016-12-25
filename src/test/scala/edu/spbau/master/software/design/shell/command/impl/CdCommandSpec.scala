package edu.spbau.master.software.design.shell.command.impl

import java.nio.file.Paths

import edu.spbau.master.software.design.shell.model.{CommandArg, CommandModel, CommandName}
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CdCommandSpec extends FlatSpec with Matchers {
  it should "change directory by a given relative path" in {
    val curDir = Paths.get(System.getProperty("user.dir"))
    val resourcesDir = curDir.resolve("../../src/test/resources")

    (new CdCommand).execute(
      CommandModel(
        CommandName("cd"),
        CommandArg("../../src/test/resources")
      )
    )

    val newPath = System.getProperty("user.dir")
    newPath shouldEqual resourcesDir.toString
  }
}
