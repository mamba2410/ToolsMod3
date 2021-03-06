package mamba2410.toolsmod3.item.tools.parts;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mamba2410.toolsmod3.item.base.SubItemCore;
import mamba2410.toolsmod3.lib.MetadataItemNames;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import mamba2410.toolsmod3.util.IconHelper;

public class BowString extends SubItemCore{
	
	public BowString() {
		super("BowString", "", MetadataItemNames.BowStringNames.clone(), "BowString");
		setCreativeTab(CreativeTabsHandler.partstab);
		for(int i = 0; i < MetadataItemNames.BowStringNames.length; i++)
			LanguageRegistry.instance().addStringLocalization("item." + MetadataItemNames.BowStringNames[i] + "BowString.name", "en_US",
					MetadataItemNames.LocalBowStringNames[i] + " Bowstring");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return IconHelper.getBow(MetadataItemNames.BowStringNames[i], "String", 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {}

}
