package edu.spbau.master.software.design.shell.parser

import scala.language.postfixOps
import scala.util.matching.Regex

/**
  * Utils for work with regexp
  */
object RegexpUtil {

  private[parser] val lettersRegex = """[A-Za-z]""" r
  private[parser] val digitsRegex = """[0-9]""" r
  private[parser] val punctuationRegex = """[\.\$\/,!-]""" r

  private[parser] val assignRegex = "=" r
  private[parser] val spaceRegex = """\s""" r
  private[parser] val pipeRegexp = """\|""" r

  private[parser] val wordRegexp = union(lettersRegex, digitsRegex, punctuationRegex)
  private[parser] val blockRegexp = union(wordRegexp, pipeRegexp, spaceRegex, assignRegex)

  private[parser] val variableRegex = """\$""" + wordRegexp.toString r

  private[parser] def union(regexes: Regex*): Regex =
    regexes map (_.toString replaceAllLiterally("()", "")) mkString("(", "|", ")+") r


}
