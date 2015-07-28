package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomAllTool extends ItemPickaxe{
	
	ToolMaterial mat;
	String igname = "";
	String unlocalname;
	
	private Block[] invalidBlocks = {Blocks.air, Blocks.bedrock, Blocks.command_block};
	private Material[] mats = {Material.circuits, Material.clay, Material.craftedSnow, Material.glass,
			Material.gourd, Material.grass, Material.ground, Material.ice, Material.iron, Material.leaves,
			Material.packedIce, Material.piston, Material.rock, Material.sand, Material.snow, Material.wood};

	public CustomAllTool(ToolMaterial mat) {
		super(mat);
		unlocalname = mat.name() + "AllTool";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_pickaxe");
		setCreativeTab(null);
		this.mat = mat;
		
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromToolMat(mat)) + " Digger";
		
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
		if(name.equals("Universe") || name.equals("GalaxyEllipse") || name.equals("GalaxySpiral") || name.equals("GalaxyIrreqular")){
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
	public float getDigSpeed (ItemStack stack, Block block, int meta){
		boolean foundMatch = false;
		for(int i = 0; i < mats.length; i++){
			if(block.getMaterial()==mats[i]){
				return efficiencyOnProperMaterial;
			}
		}
		return super.getDigSpeed(stack, block, meta);
	}

}
