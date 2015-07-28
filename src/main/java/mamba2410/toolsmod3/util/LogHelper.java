package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.lib.References;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
	
	public static void log(Level loglevel, Object object){
		FMLLog.log(References.NAME, loglevel, String.valueOf(object));
	}
	
	public static void all(Object o){log(Level.ALL, o);}
	public static void debug(Object o){log(Level.DEBUG, o);}
	public static void error(Object o){log(Level.ERROR, o);}
	public static void warn(Object o){log(Level.WARN, o);}
	public static void info(Object o){log(Level.INFO, o);}
	public static void off(Object o){log(Level.OFF, o);}

}