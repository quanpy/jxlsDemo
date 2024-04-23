package org.example.jxlstest;

import org.jxls.common.PoiExceptionLogger;
import org.slf4j.Logger;

/**
 * @author Ocean
 * @date 2024/4/23 15:32
 * @description Slf4jJxlsLogger
 */
public class Slf4jJxlsLogger extends PoiExceptionLogger {
    private final Logger logger;

    public Slf4jJxlsLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(String msg) {
        logger.debug(msg);
    }

    @Override
    public void info(String msg) {
        logger.info(msg);
    }

    @Override
    public void warn(String msg) {
        logger.warn(msg);
    }

    @Override
    public void warn(Throwable e, String msg) {
        logger.warn(msg, e);
    }

    @Override
    public void error(String msg) {
        logger.error(msg);
    }

    @Override
    public void error(Throwable e, String msg) {
        logger.error(msg, e);
    }
}