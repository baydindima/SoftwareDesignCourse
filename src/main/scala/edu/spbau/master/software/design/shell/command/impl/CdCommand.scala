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
    require(command.args.length == 1, " Cd must have 1 arg")
    val resolvedPath = Paths.get(System.getProperty("user.dir")).resolve(command.args.head.value).normalize().toAbsolutePath
    require(Files.exists(resolvedPath), "No such directory")
    System.setProperty("user.dir", resolvedPath.toString)
    ""
  }
}
