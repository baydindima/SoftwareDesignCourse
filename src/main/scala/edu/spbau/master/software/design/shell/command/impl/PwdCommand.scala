package edu.spbau.master.software.design.shell.command.impl

import java.io.File

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

import scala.language.postfixOps

/**
  * Return current directory
  */
class PwdCommand extends Command {
  /**
    * Return current directory
    */
  override def execute(command: CommandModel): ReturnType = {
    require(command.args.isEmpty, "Pwd must have 0 args")

    new File(".") getAbsolutePath
  }
}
