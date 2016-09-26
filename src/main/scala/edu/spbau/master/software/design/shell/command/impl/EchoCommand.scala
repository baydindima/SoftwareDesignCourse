package edu.spbau.master.software.design.shell.command.impl

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

/**
  * Return args values as concatenated strings
  */
class EchoCommand extends Command {
  /**
    * Return args values as concatenated strings
    */
  override def execute(command: CommandModel): ReturnType = {
    command.args.map(_.value).mkString(" ")
  }
}
