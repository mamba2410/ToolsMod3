package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.lib.References;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
	
	public static void log(Level loglevel, Object object){
		FMLLog.log(References.NAME, loglevel, String.valueOf(object));
	}
	
	public static void all(String s, Object... o){log(Level.ALL, String.format(s, o));}
	public static void debug(String s, Object... o){log(Level.DEBUG, String.format(s, o));}
	public static void error(String s, Object... o){log(Level.ERROR, String.format(s, o));}
	public static void warn(String s, Object... o){log(Level.WARN, String.format(s, o));}
	public static void info(String s, Object... o){log(Level.INFO, String.format(s, o));}
	public static void off(String s, Object... o){log(Level.OFF, String.format(s, o));}

}
