package mamba2410.toolsmod3.util;

import cpw.mods.fml.common.registry.LanguageRegistry;
import mamba2410.toolsmod3.ToolsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabsHandler {
	
	public static CreativeTabsHandler instance;
	public static ToolsMod modinstance;
	
	public static CreativeTabs modtab;
	public static CreativeTabs partstab;
	
	private void initTabs(){
		modtab = new CreativeTabs("tabToolsMod3") {
			public Item getTabIconItem() { return Items.apple; }
		};
		partstab = new CreativeTabs("tabToolsMod3Parts") {
			public Item getTabIconItem() { return ItemHandler.pickheads; }
		};
	}
	
	private void localiseTabs(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabToolsMod3","en_US", "Tools Mod 3");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabToolsMod3Parts","en_US", "Tools Mod 3 Parts");

	}
	
	public void PreInit(){
		initTabs();
		localiseTabs();
	}
	public void Init(){}
	public void PostInit(){}
	
	public CreativeTabsHandler(ToolsMod mod){
		instance = this;
		modinstance = mod;
	}

}
