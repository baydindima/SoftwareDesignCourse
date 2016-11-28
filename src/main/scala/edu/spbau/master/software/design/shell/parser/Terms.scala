package edu.spbau.master.software.design.shell.parser

/**
  * @author Baidin Dima
  */

/**
  * Base class for terms
  */
private[parser] sealed trait Term {
  def value: String
}

/**
  * Term with single quot
  * 'value'
  */
private[parser] case class SingleQuotBlockTerm(value: String) extends Term

/**
  * Term with double quot
  * "value"
  */
private[parser] case class DoubleQuotBlockTerm(value: String) extends Term

/**
  *  Term without quot as
  *  value
  */
private[parser] case class NonQuotBlockTerm(value: String) extends Term

/**
  * Base class for expressions
  */
private[parser] sealed trait Expression

/**
  * Assigning expression as
  * name=value
  */
private[parser] case class AssigningTerm(name: NonQuotBlockTerm, value: Term) extends Expression

/**
  * Command expression
  *
  * commandName commandArg1 commandArg2
  */
private[parser] case class CommandTerm(name: NonQuotBlockTerm, args: Seq[Term]) extends Expression

