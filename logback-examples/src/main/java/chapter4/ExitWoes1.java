/**
 * Logback: the generic, reliable, fast and flexible logging framework.
 * 
 * Copyright (C) 2000-2008, QOS.ch
 * 
 * This library is free software, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation.
 */
package chapter4;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.WriterAppender;
import ch.qos.logback.core.layout.EchoLayout;

public class ExitWoes1 {

  public static void main(String[] args) throws Exception {
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    lc.reset(); // we want to override the default-config.
    WriterAppender<ILoggingEvent> writerAppender = new WriterAppender<ILoggingEvent>();
    writerAppender.setContext(lc);
    writerAppender.setLayout(new EchoLayout<ILoggingEvent>());

    OutputStream os = new FileOutputStream("exitWoes1.log");
    writerAppender.setWriter(new OutputStreamWriter(os));
    writerAppender.setImmediateFlush(false);
    writerAppender.start();
    Logger root = lc.getLogger(Logger.ROOT_LOGGER_NAME);
    root.addAppender(writerAppender);

    Logger logger = lc.getLogger(ExitWoes1.class);

    logger.debug("Hello world.");
  }
}