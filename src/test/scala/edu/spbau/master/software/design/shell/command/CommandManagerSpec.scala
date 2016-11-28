package edu.spbau.master.software.design.shell.command

import edu.spbau.master.software.design.shell.app.Environment
import edu.spbau.master.software.design.shell.app.signals.ExitSignalUpdater
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import edu.spbau.master.software.design.shell.model.{CommandArg => CA, CommandModel => CM, CommandName => CN}

/**
  * @author Dmitriy Baidin on 9/27/2016.
  */
@RunWith(classOf[JUnitRunner])
class CommandManagerSpec extends FlatSpec with Matchers {

  it should "Execute single command" in {
    getCommandManager.executeWithPipe(Seq(CM(CN("echo"), CA("42")))) shouldEqual "42"
  }

  it should "Execute commands in pipe" in {
    getCommandManager.executeWithPipe(Seq(CM(CN("echo"), CA("42"), CA("ahaha")), CM(CN("wc")))) shouldEqual
     "1 2 8"
  }

  private def getCommandManager = new CommandManager(new CommandFactory(new Environment(Map.empty), new ExitSignalUpdater)) {
    override def isExit: Boolean = false
  }


}
