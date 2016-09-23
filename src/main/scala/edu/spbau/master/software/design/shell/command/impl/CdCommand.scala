package edu.spbau.master.software.design.shell.command.impl

import java.io.File
import java.nio.file.{Files, Paths}

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

/**
  * Change current directory
  *
  * @author Alexey Stepanov
  */
class CdCommand extends Command {
  override def execute(command: CommandModel): ReturnType = {
    require(command.args.length < 2, " Cd must have 1 arg")
    require(Files.exists(Paths.get(command.args.head.value)), "No such directory")
    System.setProperty("user.dir", new File(command.args.head.value).getCanonicalPath)
    ""
  }
}
