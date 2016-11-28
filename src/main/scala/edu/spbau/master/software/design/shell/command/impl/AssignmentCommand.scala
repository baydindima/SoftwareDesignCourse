package edu.spbau.master.software.design.shell.command.impl

import edu.spbau.master.software.design.shell.app.Environment
import edu.spbau.master.software.design.shell.command.Command
import edu.spbau.master.software.design.shell.command.Command.ReturnType
import edu.spbau.master.software.design.shell.model.{CommandModel, VariableName, VariableValue}

/**
  * Add variable value to environment.
  */
class AssignmentCommand(environment: Environment) extends Command {
  /**
    * Add variable value to environment.
    */
  override def execute(command: CommandModel): ReturnType = {
    require(command.args.length == 2, "Assign must have 2 args")

    environment.updateVariableValue(VariableName(command.args.head.value),
      VariableValue(command.args(1).value))

    command.args(1).value
  }

}
