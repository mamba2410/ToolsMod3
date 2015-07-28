package mamba2410.toolsmod3.item.base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mamba2410.toolsmod3.lib.References;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import net.minecraft.item.ItemFood;

public class FoodCore extends ItemFood{
	
	public FoodCore(String unlocalisedname, String igname, int saturation, boolean canDogs){
		super(saturation, canDogs);
		setUnlocalizedName(unlocalisedname);
		setTextureName(References.TEXTUREPREFIX + unlocalisedname.toLowerCase());
		setCreativeTab(CreativeTabsHandler.modtab);
		
		registering(unlocalisedname, igname);
	}
	
	private void registering(String unlocalisedname, String igname){
		
		GameRegistry.registerItem(this, unlocalisedname);
		LanguageRegistry.addName(this, unlocalisedname);
		LanguageRegistry.instance().addStringLocalization("item." + unlocalisedname + ".name", "en_US", igname);
	}

}
