package edu.spbau.master.software.design.shell.app

import edu.spbau.master.software.design.shell.model.{VariableName, VariableValue}

/**
  * This class stores variables values
  * @param variables init state of environment
  */
class Environment(variables: Map[VariableName, VariableValue]) {

  private var privateVariables: Map[VariableName, VariableValue] = variables

  /**
    * Update or add value of variable in environment
    * @param variableName name of variable
    * @param variableValue value of variable
    */
  def updateVariableValue(variableName: VariableName,
                          variableValue: VariableValue): Unit =
    privateVariables += (variableName → variableValue)

  /**
    * Return value of variable in environment
    * @param variableName name of variable
    * @return value of variable if exist or else empty string
    */
  def getVariableValue(variableName: VariableName): VariableValue =
    privateVariables.getOrElse(variableName, VariableValue.empty)

}
