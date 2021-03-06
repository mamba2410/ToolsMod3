package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.LogHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomSword extends ItemSword{
	
	String igname = "";
	String unlocalname;
	ToolMaterial mat;

	public CustomSword(ToolMaterial mat) {
		super(mat);
		unlocalname = mat.name() + "Sword";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_sword");
		setCreativeTab(null);
		this.mat = mat;
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromToolMat(mat)) + " Sword";
		
		registering(unlocalname, igname);
	}
	
	private void registering(String unlocalisedname, String igname){
		GameRegistry.registerItem(this, unlocalisedname);
		//LanguageRegistry.addName(this, unlocalisedname);
		//LogHelper.info("Adding Local ");
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
			return IconHelper.getSword(ToolHelper.getHeadNameFromToolMat(mat), "Head");
		} else {
			return IconHelper.getSword(ToolHelper.getRodNameFromToolMat(mat), "Rod");
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
