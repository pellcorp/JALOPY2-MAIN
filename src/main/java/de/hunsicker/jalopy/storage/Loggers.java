/*
 * Copyright (c) 2001-2002, Marco Hunsicker. All rights reserved.
 *
 * This software is distributable under the BSD license. See the terms of the
 * BSD license in the documentation provided with this software.
 */
package de.hunsicker.jalopy.storage;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exposes the loggers that are used throughout the system.
 *
 * @author <a href="http://jalopy.sf.net/contact.html">Marco Hunsicker</a>
 * @version $Revision: 1.3 $
 */
public final class Loggers
{
    //~ Static variables/initializers ----------------------------------------------------

    /** Logging category for all messages. */
    public static final Logger ALL = LoggerFactory.getLogger("de.hunsicker.jalopy");

    /** Logging category for I/O messages. */
    public static final Logger IO = LoggerFactory.getLogger("de.hunsicker.jalopy.io");

    /** Logging category for parsing messages. */
    public static final Logger PARSER =
    		LoggerFactory.getLogger("de.hunsicker.jalopy.language.java");

    /** Logging category for Javadoc parsing messages. */
    public static final Logger PARSER_JAVADOC =
    		LoggerFactory.getLogger("de.hunsicker.jalopy.language.javadoc");

    /** Logging category for printer messages. */
    public static final Logger PRINTER = LoggerFactory.getLogger("de.hunsicker.jalopy.printer");

    /** Logging category for Javadoc printer messages. */
    public static final Logger PRINTER_JAVADOC =
    		LoggerFactory.getLogger("de.hunsicker.jalopy.printerjavadoc");

    /** Logging category for transformation messages. */
    public static final Logger TRANSFORM =
    		LoggerFactory.getLogger("de.hunsicker.jalopy.transform");
    private static Map _config;

    //~ Constructors ---------------------------------------------------------------------

    /**
     * Creates a new Loggers object.
     */
    private Loggers()
    {
    }

    //~ Methods --------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param locale DOCUMENT ME!
     */
    public static void setLocale(Locale locale)
    {
    }
}
