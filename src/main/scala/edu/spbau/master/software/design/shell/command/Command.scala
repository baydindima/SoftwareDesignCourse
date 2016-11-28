package edu.spbau.master.software.design.shell.command

import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

/**
  * Common interface of command.
  * Every command should implement execute method.
  */
trait Command {

  /**
    * Common interface of command.
    * Every command should implement this method.
    */
  def execute(command: CommandModel): ReturnType

}


object Command {
  type ReturnType = String
}