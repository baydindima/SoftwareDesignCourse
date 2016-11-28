package edu.spbau.master.software.design.shell.command.impl

import java.nio.file.{Files, Paths}

import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.CommandModel

import scala.util.Try

/**
  * Return count of lines, words and chars in string
  */
class WcCommand extends Command {

  /**
    * Return count of lines, words and chars in string
    */
  override def execute(command: CommandModel): ReturnType = {
    require(command.args.length == 1, " Cat must have 1 arg")

    val lines = if (Try(
      Paths.get(command.args.head.value)
    )
      .toOption
      .map(Files.exists(_))
      .exists(p ⇒ p)) {
      scala.io.Source.fromFile(command.args.head.value).getLines()
    } else {
      command.args.head.value.split("\n").toSeq
    }

    val lineCount = lines.size
    val wordCount = lines.flatMap(_.split("\\W+")).size
    val charCount = lines.flatMap(_.toCharArray).size

    Seq(lineCount, wordCount, charCount).mkString(" ")
  }
}
