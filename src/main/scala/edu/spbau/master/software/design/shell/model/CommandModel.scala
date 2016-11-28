package edu.spbau.master.software.design.shell.model

/**
  * Holder of command name and args
  */
case class CommandModel(name: CommandName,
                        args: CommandArg*) {
  require(name != null, "Command name is null!")
  require(args != null, "Command args is null!")
}

/**
  * Holder of command name
  * @param name string command name
  */
case class CommandName(name: String) extends AnyVal

/**
  * Holder of command arg value
  * @param value string arg value
  */
case class CommandArg(value: String) extends AnyVal