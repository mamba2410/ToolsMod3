package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomHoe extends ItemHoe{
	
	String igname = "";
	String unlocalname;
	ToolMaterial mat;

	public CustomHoe(ToolMaterial mat) {
		super(mat);
		unlocalname = mat.name() + "Hoe";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_hoe");
		setCreativeTab(null);
		this.mat = mat;
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromToolMat(mat)) + " Hoe";
		
		registering(unlocalname, igname);
	}
	
	private void registering(String unlocalisedname, String igname){
		GameRegistry.registerItem(this, unlocalisedname);
		//LanguageRegistry.addName(this, unlocalisedname);
		LanguageRegistry.instance().addStringLocalization("item." + unlocalisedname + ".name", "en_US", igname);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int num, boolean bln) {
		String name = ToolHelper.getHeadNameFromToolMat(mat);
		if(name.equals("Universe") || name.equals("GalaxyEllipse") || name.equals("GalaxySpiral") || name.equals("GalaxyIrregular")){
			stack.setItemDamage(0);
		}
	};
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		//API.hideItem(par1ItemStack);
		return super.getUnlocalizedName(par1ItemStack);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass){
		if(pass == 0){
			return IconHelper.getHoe(ToolHelper.getHeadNameFromToolMat(mat), "Head");
		} else {
			return IconHelper.getHoe(ToolHelper.getRodNameFromToolMat(mat), "Rod");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final int getRenderPasses(int metadata) {
		return 2;
	}

}
