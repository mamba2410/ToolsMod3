package mamba2410.toolsmod3.item.base;

import java.util.List;

import mamba2410.toolsmod3.lib.MetadataItemNames;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import mamba2410.toolsmod3.util.IconHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SubItemCore extends SubItemBase{
	
	private int types = 1;
	private String[] names;
	private IIcon[] icons;
	public IIcon tailIcon = null;
	private String tnp;
	
	public SubItemCore(String unlocalizedname, String texturenameprefix, String[] names, String[] local){
		this.setUnlocalizedName(unlocalizedname);
		this.setCreativeTab(CreativeTabsHandler.modtab);
		this.setHasSubtypes(true);
		this.types = names.length;
		this.names = names;
		this.tnp = texturenameprefix;
		
		for(int i = 0; i < names.length; i++)
			LanguageRegistry.instance().addStringLocalization("item." + this.names[i] + ".name", "en_US", local[i]);
	}
	
	public SubItemCore(String unlocalizedname, String texturenameprefix, String[] names, String suffix, String[] local){
		this.setUnlocalizedName(unlocalizedname);
		this.setCreativeTab(CreativeTabsHandler.modtab);
		this.setHasSubtypes(true);
		this.types = names.length;
		this.names = names.clone();
		this.tnp = texturenameprefix;
		for(int i = 0; i < names.length; i++)
			this.names[i] += suffix;
		for(int i = 0; i < names.length; i++)
			LanguageRegistry.instance().addStringLocalization("item." + this.names[i] + ".name", "en_US", local[i]);
	}
	
	public SubItemCore(String unlocalizedname, String texturenameprefix, String[] names){
		this.setUnlocalizedName(unlocalizedname);
		this.setCreativeTab(CreativeTabsHandler.modtab);
		this.setHasSubtypes(true);
		this.types = names.length;
		this.names = names;
		this.tnp = texturenameprefix;
	}
	
	public SubItemCore(String unlocalizedname, String texturenameprefix, String[] names, String suffix){
		this.setUnlocalizedName(unlocalizedname);
		this.setCreativeTab(CreativeTabsHandler.modtab);
		this.setHasSubtypes(true);
		this.types = names.length;
		this.names = names.clone();
		for(int i = 0; i < names.length; i++)
			this.names[i] += suffix;
		this.tnp = texturenameprefix;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0; i < types; i++)
			list.add(new ItemStack(item, 1, i));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return "item." + names[Math.min(types - 1, par1ItemStack.getItemDamage())];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return icons[Math.min(icons.length - 1, par1)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[types];
		for(int i = 0; i < icons.length; i++)
			icons[i] = IconHelper.forName(par1IconRegister, names[i].toLowerCase(), tnp);

		tailIcon = IconHelper.forName(par1IconRegister, "tail", tnp);
	}

}
