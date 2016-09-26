package edu.spbau.master.software.design.shell.app

import edu.spbau.master.software.design.shell.app.signals.ExitSignalUpdater
import edu.spbau.master.software.design.shell.command.CommandFactory
import edu.spbau.master.software.design.shell.parser.{CommandParser, VariableResolver}

/**
  * Builder of all core classes
  */
object BackendBuilder {

  private def buildEnvironment: Environment = new Environment(Map.empty)

  private def buildCommandParser(environment: Environment) = {
    new CommandParser(new VariableResolver(environment))
  }

  private def buildCommandFactory(environment: Environment,
                                  signalUpdater: ExitSignalUpdater): CommandFactory = {
    new CommandFactory(environment, signalUpdater)
  }

  /**
    * Build of all core classes
    */
  def build(): Backend = {
    val environment = buildEnvironment
    val signalUpdater = new ExitSignalUpdater
    Backend(
      environment = environment,
      commandParser = buildCommandParser(environment),
      signalUpdater = signalUpdater,
      commandFactory = buildCommandFactory(environment, signalUpdater)
    )
  }

}
