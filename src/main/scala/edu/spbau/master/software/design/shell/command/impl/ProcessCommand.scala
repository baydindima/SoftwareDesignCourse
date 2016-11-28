package edu.spbau.master.software.design.shell.command.impl

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

import scala.language.postfixOps
import scala.sys.process._

/**
  * Execute external process
  */
class ProcessCommand extends Command{
  /**
    * Execute external process
    */
  override def execute(command: CommandModel): ReturnType = {
      (Seq(command.name.name) ++ command.args.map(_.value)).!!
  }
}
