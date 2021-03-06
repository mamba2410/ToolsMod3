package mamba2410.toolsmod3.item.tools.parts;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import mamba2410.toolsmod3.item.base.SubItemCore;
import mamba2410.toolsmod3.lib.MetadataItemNames;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import mamba2410.toolsmod3.util.IconHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolRod extends SubItemCore{

	public ToolRod() {
		super("ToolRod", "", MetadataItemNames.RodNames.clone(), "Rod");
		setCreativeTab(CreativeTabsHandler.partstab);
		for(int i = 0; i < MetadataItemNames.RodNames.length; i++)
			LanguageRegistry.instance().addStringLocalization("item." + MetadataItemNames.RodNames[i] + "Rod.name", "en_US",
					MetadataItemNames.LocalRodNames[i] +" Rod");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return IconHelper.getPickaxe(MetadataItemNames.RodNames[i], "Rod");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {}

}
