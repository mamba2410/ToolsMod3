package mamba2410.toolsmod3.item.base;

import mamba2410.toolsmod3.lib.References;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import mamba2410.toolsmod3.util.IconHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCore extends Item{
	
	public ItemCore(String unlocalisedname, String igname){
		super();
		setUnlocalizedName(unlocalisedname);
		setTextureName(References.TEXTUREPREFIX + unlocalisedname.toLowerCase());
		setCreativeTab(CreativeTabsHandler.modtab);
		
		registering(unlocalisedname, igname);
	}
	
	public ItemCore(String unlocalisedname, String igname, boolean texture){
		this(unlocalisedname, igname);
		setTextureName("minecraft:snowball");
	}
	
	private void registering(String unlocalisedname, String igname){
		
		GameRegistry.registerItem(this, unlocalisedname);
		LanguageRegistry.addName(this, unlocalisedname);
		LanguageRegistry.instance().addStringLocalization("item." + unlocalisedname + ".name", "en_US", igname);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		IconHelper.addIcons(iconRegister);
		super.registerIcons(iconRegister);
	}

}
