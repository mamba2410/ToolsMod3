package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomAllTool extends ItemPickaxe{
	
	ToolMaterial mat;
	String igname = "";
	String unlocalname;
	boolean isInstant;
	
	private Block[] invalidBlocks = {Blocks.air, Blocks.bedrock, Blocks.command_block};
	private Material[] mats = {Material.circuits, Material.clay, Material.craftedSnow, Material.glass,
			Material.gourd, Material.grass, Material.ground, Material.ice, Material.iron, Material.leaves,
			Material.packedIce, Material.piston, Material.rock, Material.sand, Material.snow, Material.wood};

	public CustomAllTool(ToolMaterial mat, boolean instant) {
		super(mat);
		unlocalname = mat.name() + "AllTool";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_pickaxe");
		setCreativeTab(null);
		this.mat = mat;
		this.isInstant = instant;
		
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
	public float getDigSpeed(ItemStack stack, Block block, int meta){
		boolean foundMatch = false;
		if(isInstant){
			return Float.POSITIVE_INFINITY;
		} else {
			for(int i = 0; i < mats.length; i++){
				if(block.getMaterial()==mats[i]){
					return efficiencyOnProperMaterial;
				}
			}
			return super.getDigSpeed(stack, block, meta);
		}
	}
	
	@Override
	 public boolean onBlockStartBreak(ItemStack stack, int X, int Y, int Z, EntityPlayer player){
		int state = stack.getTagCompound().getInteger("ts_state");
		if(!player.isSneaking() && state > 0)
			onAOEBreak(stack, X, Y, Z, player, state);
		return false;
	 }
	
	public void onAOEBreak(ItemStack stack, int X, int Y, int Z, EntityPlayer player, int range){
		MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(player.worldObj, player, true);
		int side;
		if(pos != null)
			side = pos.sideHit;
		else
			side = 0;
		int[] dif = new int[3];
		dif[0] = side==4 || side==5? 0 : range;
		dif[1] = side==0 || side==1? 0 : range;
		dif[2] = side==2 || side==3? 0 : range;
		int[][] area = new int[3][dif.length*range+1];
		area[0][0] = X;
		area[1][0] = Y;
		area[2][0] = Z;
		
		for(int i = -dif[0]; i <= dif[0]; i++) area[0][i+dif[0]] = X+i;
		for(int i = -dif[1]; i <= dif[1]; i++) area[1][i+dif[1]] = Y+i;
		for(int i = -dif[2]; i <= dif[2]; i++) area[2][i+dif[2]] = Z+i;
		
		for(int k = 0; k < mats.length; k++){
			for(int l = 0; l < invalidBlocks.length; l++){
				for(int ix = 0; ix < area[0].length; ix++){
					for(int iy = 0; iy < area[1].length; iy++){
						for(int iz = 0; iz < area[2].length; iz++){
							Block block = player.worldObj.getBlock(area[0][ix], area[1][iy], area[2][iz]);
							if(block.getMaterial() == mats[k] &&
								block.getBlockHardness(player.worldObj, area[0][ix], area[1][iy], area[2][iz]) >= 0
								&& block != invalidBlocks[l]){
							
									block.harvestBlock(player.worldObj, player, area[0][ix], area[1][iy], area[2][iz],
											block.getDamageValue(player.worldObj, area[0][ix], area[1][iy], area[2][iz]));
									block.onBlockHarvested(player.worldObj, area[0][ix], area[1][iy], area[2][iz],
											block.getDamageValue(player.worldObj, area[0][ix], area[1][iy], area[2][iz]), player);
									block.onBlockDestroyedByPlayer(player.worldObj, area[0][ix], area[1][iy], area[2][iz],
											block.getDamageValue(player.worldObj, area[0][ix], area[1][iy], area[2][iz]));
									player.worldObj.setBlockToAir(area[0][ix], area[1][iy], area[2][iz]);
									stack.damageItem(1, player);
							}
						}	
					}
				}
			}
		}
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		int state = 0;
		if(stack.getTagCompound() != null)
			state = stack.getTagCompound().getInteger("ts_state");
		else{
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("ts_state", 0);
			stack.setTagCompound(nbt);
		}
		onSelfRightClick(stack, player, world, state);
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
	public ItemStack onSelfRightClick(ItemStack stack, EntityPlayer player, World world, int state) {
		if(stack.getTagCompound() == null){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("ts_state", 0);
			stack.setTagCompound(nbt);
		}
		
		if(player.isSneaking() && !world.isRemote)
			setState(player, stack, state);

		return stack;
	}
	
	public void setState(EntityPlayer player, ItemStack stack, int state){
		if(state < 2)state++;else state = 0;
		stack.getTagCompound().setInteger("ts_state", state);
		player.addChatMessage(new ChatComponentText("AOE mode set to " + ((2*state)+1) + "x" + ((2*state)+1)));
	}

}
