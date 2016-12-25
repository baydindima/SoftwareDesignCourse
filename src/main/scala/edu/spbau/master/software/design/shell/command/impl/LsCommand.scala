package edu.spbau.master.software.design.shell.command.impl

import java.nio.file.{Files, Path, Paths}
import java.util.stream.Collectors

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

/**
  * Created by dsavvinov on 20.10.16.
  *
  * Implementation of "ls" command.
  *
  * Usage:
  * `$ ls`
  *
  * Outputs list of files and folders in current dir.
  *
  * **Note** that this command uses system property 'user.dir' of JVM.
  */
class LsCommand extends Command {
  override def execute(command: CommandModel): ReturnType = {
    val curFolder: Path = Paths.get(System.getProperty("user.dir"))
    curFolder.toFile.list().mkString("\n")
  }
}
