package edu.spbau.master.software.design.shell.command.impl

import java.nio.file.Paths

import edu.spbau.master.software.design.shell.model.{CommandModel, CommandName}
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LsCommandSpec extends FlatSpec with Matchers {
  it should "list files and folders in resources directory" in {
    val curDir = Paths.get(System.getProperty("user.dir"))
    val resourcesDir = curDir.resolve("../../src/test/resources")
    System.setProperty("user.dir", resourcesDir.toString)
    val result = (new LsCommand).execute(
      CommandModel(
        CommandName("ls")
      )
    )

    (result contains "test_folder") shouldEqual true
    (result contains "random_text.txt") shouldEqual true
  }
}
