package edu.spbau.master.software.design.shell.app.signals

/**
  * Holder of isExit signal value.
  * Object which implement this trait, can check that program should be completed.
  */
trait ExitSignalListener {
  def isExit: Boolean
}


/**
  * Updater of isExit signal.
  * Should be used together with [[ExitSignalListener]].
  * When isExit changed a connected listener should reads a new value and break self execution.
  */
class ExitSignalUpdater {
  var isExit: Boolean = false
}

