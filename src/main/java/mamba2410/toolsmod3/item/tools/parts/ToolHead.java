package mamba2410.toolsmod3.item.tools.parts;

import mamba2410.toolsmod3.item.base.SubItemCore;
import mamba2410.toolsmod3.lib.MetadataItemNames;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolHead extends SubItemCore{
	
	public ItemStack material;
	public String type;
	public static String[] names = MetadataItemNames.HeadNames.clone();

	public ToolHead(String type) {
		super("ToolHead" + type, "", names, type + "Head");
		setCreativeTab(CreativeTabsHandler.partstab);
		this.type = type;
		for(int i = 0; i < names.length; i++)
		LanguageRegistry.instance().addStringLocalization("item." + names[i] + type + "Head.name", "en_US",
				MetadataItemNames.LocalHeadNames[i] + " " + ToolHelper.getLocalFromToolName(type) + " Head");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		if(type == "Pick")
			return IconHelper.getPickaxe(MetadataItemNames.HeadNames[i], "Head");
		if(type == "Axe")
			return IconHelper.getAxe(MetadataItemNames.HeadNames[i], "Head");
		if(type == "Spade")
			return IconHelper.getSpade(MetadataItemNames.HeadNames[i], "Head");
		if(type == "Sword")
			return IconHelper.getSword(MetadataItemNames.HeadNames[i], "Head");
		if(type == "Hoe")
			return IconHelper.getHoe(MetadataItemNames.HeadNames[i], "Head");
		if(type == "NinjaSword")
			return IconHelper.getNinjaSword(MetadataItemNames.HeadNames[i], "Head");
		if(type == "Bow")
			return IconHelper.getBow(MetadataItemNames.HeadNames[i], "Head", 0);
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {}

}
