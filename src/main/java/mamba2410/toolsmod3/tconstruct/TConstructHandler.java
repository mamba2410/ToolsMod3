package mamba2410.toolsmod3.tconstruct;

import mamba2410.toolsmod3.ToolsMod;
import mamba2410.toolsmod3.util.LogHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.weaponry.ArrowShaftMaterial;
import tconstruct.tools.TinkerTools;
import tconstruct.weaponry.TinkerWeaponry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TConstructHandler {
	
	public static TConstructHandler instance;
	private static ToolsMod modinstance;
	private static PatternBuilder pb = PatternBuilder.instance;
	
	/**
	 * Adds a tool material to TConstruct
	 * 
	 * @param name Name of the material
	 * @param stack The stack used to create the material
	 * @param ID The unique ID of the material
	 * @param mat The base tool material used to generate values
	 * @param tooltipColor The colour in the item tooltip
	 * @param hexColor The actual colour of the Item
	 * @param handleMod The handle modifier of the material
	 * @param reinforced The reinforced trait of the material
	 * @param stonebound The stonebound modifier of the material, negative is jagged
	 * @param maxDamage The base speed of the bow
	 * @param bowMaxSpeed The max speed of the bow
	 * @param arrowWeight The weight of the arrow
	 * @param arrowBreakChance The chance that the arrow will survive on impact
	 * @param inGame The in game name of the material
	 * @param casting Whether or not this needs casting (true) or part building (false)
	 */
	public static void createToolSet(String name, ItemStack stack, int ID, ToolMaterial mat, EnumChatFormatting tooltipColor, int hexColor, float handleMod, int reinforced, float stonebound, int maxDamage, float bowMaxSpeed, float arrowWeight, float arrowBreakChance, String inGame, boolean casting, boolean instant){
		pb.registerMaterialSet(name, new ItemStack(TinkerTools.toolShard, 1, ID), new ItemStack(TinkerTools.toolRod, 1, ID), 32);
	    TConstructClientRegistry.addMaterialRenderMapping(ID, "tinker", name, true);
	    if(Loader.isModLoaded("IguanaTweaksTConstruct"))
	    	//									ID, MaterialName, 	HarvestLevel,	BaseDurability, MiningSpeed, 	Attack, 	handleModifier, ReinforcedLevel, 	stonebound
	    	TConstructRegistry.addToolMaterial(	ID, name, mat.getHarvestLevel()+2, mat.getMaxUses(), instant? Integer.MAX_VALUE : (int)mat.getEfficiencyOnProperMaterial()*100, (int) mat.getDamageVsEntity(), handleMod, reinforced, stonebound, tooltipColor.toString(), hexColor);
	    else
	    	TConstructRegistry.addToolMaterial(ID, name, mat.getHarvestLevel(), mat.getMaxUses(), instant? Integer.MAX_VALUE : (int)mat.getEfficiencyOnProperMaterial()*100, (int) mat.getDamageVsEntity(), handleMod, reinforced, stonebound, tooltipColor.toString(), hexColor);
	    //								MatID, DrawSpeed, maxSpeed
	    TConstructRegistry.addBowMaterial(ID, maxDamage, bowMaxSpeed);
	    //								MatID, Weight, BreakChance
	    TConstructRegistry.addArrowMaterial(ID, arrowWeight, arrowBreakChance);
	    //TinkerTools.registerPatternMaterial(name, 2, name);
	    TConstructRegistry.addDefaultToolPartMaterial(ID);
	    pb.registerFullMaterial(stack, 2, name, new ItemStack(TinkerTools.toolShard, 1, ID), new ItemStack(TinkerTools.toolRod, 1, ID), ID);
	    LanguageRegistry.instance().addStringLocalization("material."+name.toLowerCase(), "en_US", inGame);
	    //LogHelper.info("Looking for %s to localise to %s", "material."+name, inGame);
	    registerWithStations(stack, name, ID);
	    if(!casting) addPartBuilding(ID);
	    //else		 addCasting(null, ID);
	    	
	}
	
	public static void addArrowShaft(int ID, Item stack, int itemDamage, float durmod, float weight, float breakChance, int color){
	    TConstructRegistry.addCustomMaterial(ArrowShaftMaterial.createMaterial(ID, stack, itemDamage, durmod,  weight, breakChance, color));
	}
	
	//public static void addBowString(){}
	
	public static void addPartBuilding(int materialID){
		addItemStackPartBuilding(TConstructRegistry.getItemStack("toolRodPattern"), materialID, new ItemStack(TinkerTools.toolRod, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("pickaxeHeadPattern"), materialID, new ItemStack(TinkerTools.pickaxeHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("shovelHeadPattern"), materialID, new ItemStack(TinkerTools.shovelHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("hatchetHeadPattern"), materialID, new ItemStack(TinkerTools.hatchetHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("swordBladePattern"), materialID, new ItemStack(TinkerTools.swordBlade, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("wideGuardPattern"), materialID, new ItemStack(TinkerTools.wideGuard, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("handGuardPattern"), materialID, new ItemStack(TinkerTools.handGuard, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("crossbarPattern"), materialID, new ItemStack(TinkerTools.crossbar, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("bindingPattern"), materialID, new ItemStack(TinkerTools.binding, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("frypanHeadPattern"), materialID, new ItemStack(TinkerTools.frypanHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("signHeadPattern"), materialID, new ItemStack(TinkerTools.signHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("knifeBladePattern"), materialID, new ItemStack(TinkerTools.knifeBlade, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("chiselHeadPattern"), materialID, new ItemStack(TinkerTools.chiselHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("toughRodPattern"), materialID, new ItemStack(TinkerTools.toughRod, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("toughBindingPattern"), materialID, new ItemStack(TinkerTools.toughBinding, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("largePlatePattern"), materialID, new ItemStack(TinkerTools.largePlate, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("broadAxeHeadPattern"), materialID, new ItemStack(TinkerTools.broadAxeHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("scytheHeadPattern"), materialID, new ItemStack(TinkerTools.scytheBlade, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("excavatorHeadPattern"), materialID, new ItemStack(TinkerTools.excavatorHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("largeBladePattern"), materialID, new ItemStack(TinkerTools.largeSwordBlade, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("hammerHeadPattern"), materialID, new ItemStack(TinkerTools.hammerHead, 1, materialID));
		addItemStackPartBuilding(TConstructRegistry.getItemStack("fullGuardPattern"), materialID, new ItemStack(TinkerTools.fullGuard, 1, materialID));
		addItemStackPartBuilding(new ItemStack(TConstructRegistry.getItem("woodPattern"), 1, 25), materialID, new ItemStack(TinkerWeaponry.arrowhead, 1, materialID));
		addItemStackPartBuilding(new ItemStack(TinkerWeaponry.woodPattern, 1, 0), materialID, new ItemStack(TinkerWeaponry.partShuriken, 1, materialID));
		addItemStackPartBuilding(new ItemStack(TinkerWeaponry.woodPattern, 1, 1), materialID, new ItemStack(TinkerWeaponry.partCrossbowLimb, 1, materialID));
		addItemStackPartBuilding(new ItemStack(TinkerWeaponry.woodPattern, 1, 2), materialID, new ItemStack(TinkerWeaponry.partCrossbowBody, 1, materialID));
		addItemStackPartBuilding(new ItemStack(TinkerWeaponry.woodPattern, 1, 3), materialID, new ItemStack(TinkerWeaponry.partBowLimb, 1, materialID));
		
	}
	
	public static void addCasting(Fluid fluid, int ID){
		//.addCastingRecipe(output, fluid, cast, hardeningDelay)
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toolRod, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("toolRodCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.pickaxeHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("pickaxeHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.shovelHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("shovelHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hatchetHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("hatchetHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.swordBlade, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("swordBladeCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.fullGuard, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("fullGuardCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.wideGuard, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("wideGuardCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.crossbar, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("crossbarCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.binding, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("bindingCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("handGuardCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.frypanHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("frypanHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.signHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("signHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.knifeBlade, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("knifeBladeCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.chiselHead, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("chiselHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughRod, 1, ID),new FluidStack(fluid, (int) (144*3.0D)), TConstructRegistry.getItemStack("toughRodCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughBinding, 1, ID),new FluidStack(fluid, (int) (144*3.0D)), TConstructRegistry.getItemStack("toughBindingCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largePlate, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("largePlateCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.broadAxeHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("broadAxeHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.scytheBlade, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("scytheHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.excavatorHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("excavatorHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largeSwordBlade, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("largeBladeCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hammerHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("hammerHeadCast"),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.arrowhead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), new ItemStack(TConstructRegistry.getItem("metalPattern"), 1, 25),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.partCrossbowBody, 1, ID),new FluidStack(fluid, (int) (144*5.0D)), new ItemStack(TinkerWeaponry.metalPattern, 1, 2),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.partCrossbowLimb, 1, ID),new FluidStack(fluid, (int) (144*4.0D)), new ItemStack(TinkerWeaponry.metalPattern, 1, 1),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.partBowLimb, 1, ID),new FluidStack(fluid, (int) (144*4.0D)), new ItemStack(TinkerWeaponry.metalPattern, 1, 3),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.partShuriken, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), new ItemStack(TinkerWeaponry.metalPattern, 1, 0),50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerWeaponry.partBolt, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), new ItemStack(TinkerTools.toolRod),50);

	}
	
	private static void addItemStackPartBuilding(ItemStack pattern, int materialID, ItemStack part){
		TConstructRegistry.addPartMapping(pattern.getItem(), pattern.getItemDamage(), materialID, part);
	}
	
	private static void registerWithStations(ItemStack material, String materialName, int materialID){
		LogHelper.info("Attempting to add %s to patterns", materialName);
		PatternBuilder.instance.registerFullMaterial(material, 2, materialName, new ItemStack(TinkerTools.toolShard, 1, materialID), new ItemStack(TinkerTools.toolRod, 1, materialID), materialID);
	}
	
	public TConstructHandler(ToolsMod mod){
		instance = this;
		modinstance = mod;
	}

}
