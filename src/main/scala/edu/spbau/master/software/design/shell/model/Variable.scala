package edu.spbau.master.software.design.shell.model

import scala.language.implicitConversions

/**
  * Holder of variable name and value
  */
case class Variable(name: VariableName,
                    value: VariableValue) {

  require(name != null, "Variable name is null!")
  require(value != null, "Variable value is null!")
}

/**
  * Holder of variable name
  * @param name string variable name
  */
case class VariableName(name: String) extends AnyVal

/**
  * Holder of variable value
  * @param value string variable value
  */
case class VariableValue(value: String) extends AnyVal

object VariableValue {

  /**
    * Return empty string value
    */
  def empty = VariableValue("")

}