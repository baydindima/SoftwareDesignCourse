package edu.spbau.master.software.design.shell.command.impl

import java.io.File
import java.nio.file.{Files, Paths}

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

/**
  * List files in current directory
  *
  * @author Alexey Stepanov
  */
class LsCommand extends Command {
  override def execute(command: CommandModel): ReturnType = {
    require(command.args.length < 2, " Ls must have not more then 2 args")
    if (command.args.length == 1) {
      require(Files.exists(Paths.get(command.args.head.value)), "No such directory")
    }
    val path = command.args.size match {
      case 1 => command.args.head.value
      case _ => "."
    }

    new File(new File(path).getCanonicalPath).listFiles().map(f => (if (f.isDirectory) "> " else "") + f.getName).mkString("\n")
  }
}
