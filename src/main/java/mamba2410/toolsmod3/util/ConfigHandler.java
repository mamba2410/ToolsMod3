package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.ToolsMod;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static ConfigHandler instance;
	public static ToolsMod modinstance;
	public static Configuration config;
	
	public static final String celestial_NAME = "Enable or disable the celestial section of the mod.";
	public static final String celestial_tools_NAME = "Enable or disable the celestial tools. (Requires celestial to be true)";
	public static final String enchant_repair_NAME = "Set the ID for the repair enchantment.";
	public static final String enchant_repair_rarity_NAME = "Set the rarity of the repair enchantment";
	
	public static boolean celestial = true;
	public static boolean celestial_tools = false;
	public static int repair_id = 156;
	public static int repair_rarity = 2;
	
	public static void syncConfig(){
		celestial = loadBoolean("item.celestial.enabled", celestial_NAME, true);
		celestial_tools = loadBoolean("item.tool.celestial.enabled", celestial_tools_NAME, false);
		repair_id = loadInt("enchant.repair.id", enchant_repair_NAME, 156);
		repair_rarity = loadInt("enchant.repair.rarity", enchant_repair_rarity_NAME, 2);
		
		if(config.hasChanged())
			config.save();
	}
	
	public static int loadInt(String name, String desc, int default_){
		Property prop = config.get(Configuration.CATEGORY_GENERAL, name, default_);
		prop.comment = desc;
		//LogHelper.info(String.format("Getting integer %s for %s", prop.getInt(default_), name));
		return prop.getInt(default_);
	}
	
	public static boolean loadBoolean(String name, String desc, boolean default_){
		Property prop = config.get(Configuration.CATEGORY_GENERAL, name, default_);
		prop.comment = desc;
		//LogHelper.info(String.format("Getting boolean %s for %s", prop.getBoolean(default_), name));
		return prop.getBoolean(default_);
	}
	
	public void PreInit(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
	}
	public void Init(){}
	public void PostInit(){}
	
	
	
	public ConfigHandler(ToolsMod mod){
		instance = this;
		modinstance = mod;
		FMLCommonHandler.instance().bus().register(this);
	}

}
