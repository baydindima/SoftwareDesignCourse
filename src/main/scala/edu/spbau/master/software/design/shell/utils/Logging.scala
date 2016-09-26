package edu.spbau.master.software.design.shell.utils

import org.slf4j.LoggerFactory

/**
  * Util trait for logging
  */
trait Logging {

  protected val log = LoggerFactory.getLogger(loggerClass)

  /**
    * Specifies class whose name will be used as logger name
    */
  protected def loggerClass: Class[_] = this.getClass

}
