package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomPickaxe extends ItemPickaxe {
	
	ToolMaterial mat;
	String igname = "";
	String unlocalname;
	boolean instant;

	public CustomPickaxe(ToolMaterial mat, boolean instant) {
		super(mat);
		unlocalname = mat.name() + "Pickaxe";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_pickaxe");
		setCreativeTab(null);
		this.mat = mat;
		this.instant = instant;
		
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromToolMat(mat)) + " Pickaxe";
		
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
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass){
		if(pass == 0){
			return IconHelper.getPickaxe(ToolHelper.getRodNameFromToolMat(mat), "Rod");
		} else {
			return IconHelper.getPickaxe(ToolHelper.getHeadNameFromToolMat(mat), "Head");
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
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		//API.hideItem(par1ItemStack);
		return super.getUnlocalizedName(par1ItemStack);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		if(instant) return Float.POSITIVE_INFINITY; else
		return super.getDigSpeed(stack, block, meta);
	}

}
