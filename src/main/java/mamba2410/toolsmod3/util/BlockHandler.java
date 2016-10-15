package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.ToolsMod;
import mamba2410.toolsmod3.block.base.BlockCore;
import mamba2410.toolsmod3.block.base.OreCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockHandler {
	
	public static BlockHandler instance;
	public static ToolsMod modinstance;
	
	public static BlockCore sapphireOre, energeriumOre, fluxiniteOre;
	public static BlockCore bedrockOre, platinumOre;
	//public static BlockCore 
	
	private void initBlocks(){
		
		sapphireOre = new OreCore(Material.rock, "SapphireOre", "Sapphire Ore", new ItemStack(ItemHandler.materials, 1, 10));
		energeriumOre = new OreCore(Material.rock, "EnergeriumOre", "Energerium Ore", new ItemStack(ItemHandler.materials, 1, 12));
		fluxiniteOre = new OreCore(Material.rock, "FluxiniteOre", "Fluxinite Ore", new ItemStack(ItemHandler.materials, 1, 13));
		bedrockOre = new OreCore(Material.rock, "BedrockOre", "Bedrock Infused Stone", new ItemStack(ItemHandler.materials, 1, 14));
		
		platinumOre = new BlockCore(Material.rock, "PlatinumOre", "Platinum Ore");
		
	}
	
	private void addDetails(){
		sapphireOre.addDetails(3.0f, 3.0f, 4, "pickaxe");
		energeriumOre.addDetails(3.0f, 3.0f, 4, "pickaxe");
		fluxiniteOre.addDetails(3.0f, 3.0f, 4, "pickaxe");
		
		bedrockOre.addDetails(10.0f, -1f, 5, "pickaxe");
		platinumOre.addDetails(4.0f, 3.0f, 3, "pickaxe");
	}
	
	private void oreDict(){
		OreDictionary.registerOre("orePlatinum", platinumOre);
		OreDictionary.registerOre("oreSapphire", sapphireOre);
		OreDictionary.registerOre("oreEnergerium", energeriumOre);
		OreDictionary.registerOre("oreFluxinite", fluxiniteOre);
	}
	
	public void PreInit(){
		initBlocks();
		addDetails();
	}
	public void Init(){}
	public void PostInit(){
		oreDict();
	}
	
	public BlockHandler(ToolsMod mod){
		instance = this;
		modinstance = mod;
	}

}
