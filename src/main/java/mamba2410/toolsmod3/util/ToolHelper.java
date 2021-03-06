package mamba2410.toolsmod3.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mamba2410.toolsmod3.lib.MetadataItemNames;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ToolHelper {
	
	public static List<ItemStack> headlist = new ArrayList<ItemStack>();
	public static List<ItemStack> rodlist = new ArrayList<ItemStack>();
	public static List<ItemStack> bowstringlist = new ArrayList<ItemStack>();
	
	public static HashMap<String, ItemStack> headItems = new HashMap<String, ItemStack>();
	public static HashMap<String, ItemStack> rodItems = new HashMap<String, ItemStack>();
	public static HashMap<String, ItemStack> bowstringItems = new HashMap<String, ItemStack>();
	
	private static List<Integer> harvestlevellist = new ArrayList<Integer>();
	private static List<Integer> basedurabilitylist = new ArrayList<Integer>();
	private static List<Float> efficiencylist = new ArrayList<Float>();
	private static List<Float> damagelist = new ArrayList<Float>();
	private static List<Integer> enchantabilitylist = new ArrayList<Integer>();
	private static List<Float> durmodlist = new ArrayList<Float>();
	private static List<Float> durmodbowlist = new ArrayList<Float>();
	
	private static HashMap<String, Integer> harvestlevels = new HashMap<String, Integer>();
	private static HashMap<String, Integer> basedurability = new HashMap<String, Integer>();
	private static HashMap<String, Float> efficiency = new HashMap<String, Float>();
	private static HashMap<String, Float> damage = new HashMap<String, Float>();
	private static HashMap<String, Integer> enchantability = new HashMap<String, Integer>();
	private static HashMap<String, Float> durmod = new HashMap<String, Float>();
	private static HashMap<String, Float> durmodbow = new HashMap<String, Float>();
	
	public static HashMap<String, ToolMaterial> custommats = new HashMap<String, ToolMaterial>();
	
	public static String getNameFromBow(ItemStack head, ItemStack string){
		String name = "default";
		for(Map.Entry<String, ItemStack> entry : headItems.entrySet()){
			if(entry.getValue().equals(head)){
				name = entry.getKey();
			}
		}
		for(Map.Entry<String, ItemStack> entry : bowstringItems.entrySet()){
			if(entry.getValue().equals(string)){
				name += "_" + entry.getKey();
			}
		}
		
		return name;
	}
	
	public static String getLocalFromToolName(String name){
		for(int i = 0; i < MetadataItemNames.ToolNames.length; i++){
			if(name.equals(MetadataItemNames.ToolNames[i])){
				return MetadataItemNames.LocalToolNames[i];
			}
		}
		return name;
	}
	
	public static String getLocalFromName(String name){
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			//LogHelper.info(String.format("Attempting to localise %s to %s, comparing it to %s", name, MetadataItemNames.LocalHeadNames[i], MetadataItemNames.HeadNames[i]));
			if(name.equals(MetadataItemNames.HeadNames[i])){
				//LogHelper.info(String.format("Localising %s to %s", name, MetadataItemNames.LocalHeadNames[i]));
				return MetadataItemNames.LocalHeadNames[i];
			}
		}
		//LogHelper.info(String.format("Returning %s to %s", name, name));
		return name;
	}
	
	public static void addNamedMaterial(String name, ItemStack stack, int hl, int bd, float ef, float dg, int ec){
		harvestlevels.put(name, hl);
		basedurability.put(name, bd);
		efficiency.put(name, ef);
		damage.put(name, dg);
		enchantability.put(name, ec);
		headItems.put(name, stack);
		addRawMat(hl, bd, ef, dg, ec);
		addHeadItem(stack);
	}
	
	public static void addNamedModifier(String name, ItemStack stack, float dm){
		durmod.put(name, dm);
		rodItems.put(name, stack);
		addRawRodModifier(dm);
		addRodItem(stack);
	}
	
	public static void addNamedString(String name, ItemStack stack, float dm){
		durmodbow.put(name, dm);
		bowstringItems.put(name, stack);
		durmodbowlist.add(dm);
		bowstringlist.add(stack);
	}
	
	public static String getRodNameFromToolMat(ToolMaterial mat){
		String name = mat.name();
		char[] namea = name.toCharArray();
		for(int i = 0; i < namea.length; i++){
			if(namea[i] == '_'){
				return name.substring(i+1, namea.length);
			}
		}
		
		return "default";
	}
	
	public static String getBowStringNameFromString(String name){
		char[] namea = name.toCharArray();
		for(int i = 0; i < namea.length; i++){
			if(namea[i] == '_'){
				return name.substring(i+1, namea.length);
			}
		}
		
		return "default";
	}
	
	public static String getHeadNameFromString(String name){
		char[] namea = name.toCharArray();
		for(int i = 0; i < namea.length; i++){
			if(namea[i] == '_'){
				return name.substring(0, i);
			}
		}
		
		return "default";
	}
	
	public static String getHeadNameFromToolMat(ToolMaterial mat){
		String name = mat.name();
		char[] namea = name.toCharArray();
		for(int i = 0; i < namea.length; i++){
			if(namea[i] == '_'){
				return name.substring(0, i);
			}
		}
		
		return "default";
	}
	
	public static int getMetadataFromHeadStack(ItemStack stack){
		ItemStack[] stacks = new ItemStack[headlist.toArray().length];
		for(int i = 0; i < headlist.toArray().length; i++){
			stacks[i] = headlist.get(i);
		}
		for(int i = 0; i < stacks.length; i++){
			if(stack.equals(stacks[i])){
				return i;
			}
		}
		return 0;
	}
	
	public static int getMetadataFromRodStack(ItemStack stack){
		ItemStack[] stacks = new ItemStack[rodlist.toArray().length];
		for(int i = 0; i < rodlist.toArray().length; i++){
			stacks[i] = rodlist.get(i);
		}
		for(int i = 0; i < stacks.length; i++){
			if(stack.equals(stacks[i])){
				return i;
			}
		}
		return 0;
	}
	
	public static int getMetadataFromStringStack(ItemStack stack){
		ItemStack[] stacks = new ItemStack[bowstringlist.toArray().length];
		for(int i = 0; i < bowstringlist.toArray().length; i++){
			stacks[i] = bowstringlist.get(i);
		}
		for(int i = 0; i < stacks.length; i++){
			if(stack.equals(stacks[i])){
				return i;
			}
		}
		return 0;
	}
	
	public static Object[] getPickRecipe(ItemStack mat){
		return new Object[] {"mmm", " t ", " t ", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getAxeRecipe(ItemStack mat){
		return new Object[] {"mm", "mt", " t", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getSpadeRecipe(ItemStack mat){
		return new Object[] {"m", "t", "t", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getSwordRecipe(ItemStack mat){
		return new Object[] {"m", "m", "t", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getHoeRecipe(ItemStack mat){
		return new Object[] {"mm", " t", " t", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getNinjaSwordRecipe(ItemStack mat){
		return new Object[] {"  m", "tm ", "mt ", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getRodRecipe(ItemStack mat){
		return new Object[] {"m", "t", "m", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getBowRecipe(ItemStack mat){
		return new Object[] {" mt", "m t", " mt", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	public static Object[] getBowStringRecipe(ItemStack mat){
		return new Object[] {" tm", "t m", " tm", 'm', mat, 't', ItemHandler.instance.getToolPartItem()};
	}
	
	public static ToolMaterial getAppropriateMaterialForNinjaSword(ItemStack head, ItemStack rod){
		String smat = getMaterialName(head, rod);
		ToolMaterial mat;
		if(basedurability.get(getHeadName(head)) >= 1){
			mat = EnumHelper.addToolMaterial(smat,
				harvestlevels.get(getHeadName(head)),
				(int)(basedurability.get(getHeadName(head)) * durmod.get(getRodName(rod))),
				efficiency.get(getHeadName(head)),
				damage.get(getHeadName(head)) + 1.0f,
				enchantability.get(getHeadName(head)));
		} else {
			mat = EnumHelper.addToolMaterial(smat,
					harvestlevels.get(getHeadName(head)),
					100,
					efficiency.get(getHeadName(head)),
					damage.get(getHeadName(head)) + 1.0f,
					enchantability.get(getHeadName(head)));
		}
		mat.setRepairItem(head);
		custommats.put(smat, mat);
		return mat;
	}
	
	public static ToolMaterial getAppropriateMaterial(ItemStack head, ItemStack rod){
		String smat = getMaterialName(head, rod);
		ToolMaterial mat;
		if(basedurability.get(getHeadName(head)) >= 1){
			mat = EnumHelper.addToolMaterial(smat,
				harvestlevels.get(getHeadName(head)),
				(int)(basedurability.get(
						getHeadName(head))
						* durmod.get(
								getRodName(rod))),
				efficiency.get(getHeadName(head)),
				damage.get(getHeadName(head)),
				enchantability.get(getHeadName(head)));
		} else {
			mat = EnumHelper.addToolMaterial(smat,
					harvestlevels.get(getHeadName(head)),
					100,
					efficiency.get(getHeadName(head)),
					damage.get(getHeadName(head)),
					enchantability.get(getHeadName(head)));
		}
		custommats.put(smat, mat);
		mat.setRepairItem(head);
		return mat;
	}
	
	public static int getAppropriateBowDurability(ItemStack head, ItemStack string){
		if(getHeadName(head).equals("Universe") || getHeadName(head).equals("GalaxyEllipse")
				|| getHeadName(head).equals("GalaxySpiral") || getHeadName(head).equals("GalaxyIrregular")){
			return 100;
		} else {
			return (int)(basedurability.get(getHeadName(head)) * durmodbow.get(getStringName(string)));
		}
	}
	
	@Deprecated
	public static void initializeMaps(){
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			ItemStack[] items = new ItemStack[headlist.toArray().length] ;
			for(int j = 0; j < headlist.toArray().length; j++){
				items[j] = headlist.get(j);
			}
			ItemStack item = items[i];
			if(item != null){
				headItems.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.RodNames.length; i++){
			ItemStack[] items = new ItemStack[rodlist.toArray().length] ;
			for(int j = 0; j < rodlist.toArray().length; j++){
				items[j] = rodlist.get(j);
			}
			ItemStack item = items[i];
			if(item != null){
				rodItems.put(MetadataItemNames.RodNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			Integer[] items = new Integer[harvestlevellist.toArray().length] ;
			for(int j = 0; j < harvestlevellist.toArray().length; j++){
				items[j] = harvestlevellist.get(j);
			}
			int item = items[i];
			if(item >= 0){
				harvestlevels.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			Integer[] items = new Integer[basedurabilitylist.toArray().length] ;
			for(int j = 0; j < basedurabilitylist.toArray().length; j++){
				items[j] = basedurabilitylist.get(j);
			}
			int item = items[i];
			if(item >= 0){
				basedurability.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			Float[] items = new Float[efficiencylist.toArray().length] ;
			for(int j = 0; j < efficiencylist.toArray().length; j++){
				items[j] = efficiencylist.get(j);
			}
			float item = items[i];
			if(item >= 0){
				efficiency.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			Float[] items = new Float[damagelist.toArray().length] ;
			for(int j = 0; j < damagelist.toArray().length; j++){
				items[j] = damagelist.get(j);
			}
			float item = items[i];
			if(item >= 0){
				damage.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.HeadNames.length; i++){
			Integer[] items = new Integer[enchantabilitylist.toArray().length] ;
			for(int j = 0; j < enchantabilitylist.toArray().length; j++){
				items[j] = enchantabilitylist.get(j);
			}
			int item = items[i];
			if(item >= 0){
				enchantability.put(MetadataItemNames.HeadNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.RodNames.length; i++){
			Float[] items = new Float[durmodlist.toArray().length] ;
			for(int j = 0; j < durmodlist.toArray().length; j++){
				items[j] = durmodlist.get(j);
			}
			float item = items[i];
			if(item >= 0){
				durmod.put(MetadataItemNames.RodNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.BowStringNames.length; i++){
			ItemStack[] items = new ItemStack[bowstringlist.toArray().length] ;
			for(int j = 0; j < bowstringlist.toArray().length; j++){
				items[j] = bowstringlist.get(j);
			}
			ItemStack item = items[i];
			if(item != null){
				bowstringItems.put(MetadataItemNames.BowStringNames[i], item);
			}
		}
		
		for(int i = 0; i < MetadataItemNames.BowStringNames.length; i++){
			Float[] items = new Float[durmodbowlist.toArray().length] ;
			for(int j = 0; j < durmodbowlist.toArray().length; j++){
				items[j] = durmodbowlist.get(j);
			}
			float item = items[i];
			if(item >= 0){
				durmodbow.put(MetadataItemNames.BowStringNames[i], item);
			}
		}
	}

	public static String getHeadName(ItemStack ihead){
		String head = "";
		
		String[] heads = new String[headItems.keySet().toArray().length];
		for(int i = 0; i < heads.length; i++){
			heads[i] = (String) headItems.keySet().toArray()[i];
		}
		
		for(int i = 0; i < heads.length; i++){
			if(headItems.get(heads[i]) != null){
				if(ihead.equals(headItems.get(heads[i]))){
					head = heads[i];
				}
			}
		}
		return head;
	}
	
	public static String getRodName(ItemStack irod){
		String rod = "";
		
		String[] rods = new String[rodItems.keySet().toArray().length];
		for(int i = 0; i < rods.length; i++){
			rods[i] = (String) rodItems.keySet().toArray()[i];
		}
		
		for(int i = 0; i < rods.length; i++){
			if(rodItems.get(rods[i]) != null){
				if(irod.equals(rodItems.get(rods[i]))){
					rod = rods[i];
				}
			}
		}
		return rod;
	}
	
	public static String getStringName(ItemStack irod){
		String rod = "";
		
		String[] rods = new String[bowstringItems.keySet().toArray().length];
		for(int i = 0; i < rods.length; i++){
			rods[i] = (String) bowstringItems.keySet().toArray()[i];
		}
		
		for(int i = 0; i < MetadataItemNames.BowStringNames.length; i++){
			if(bowstringItems.get(rods[i]) != null){
				if(irod.equals(bowstringItems.get(rods[i]))){
					rod = rods[i];
				}
			}
		}
		return rod;
	}
	
	public static String getMaterialName(ItemStack ihead, ItemStack irod){
		
		String head = getHeadName(ihead);
		String rod = getRodName(irod);
		
		if(head.length() > 0 && rod.length() > 0)
			return head + "_" + rod;
		else
			return "default";
		
	}
	
	private static void addRawMat(int hl, int bd, float ef, float dg, int ec){
		harvestlevellist.add(hl);
		basedurabilitylist.add(bd);
		efficiencylist.add(ef);
		damagelist.add(dg);
		enchantabilitylist.add(ec);
	}
	
	
	
	private static void addRawRodModifier(float dm){
		durmodlist.add(dm);
	}
	
	private static void addHeadItem(ItemStack stack){
		headlist.add(stack);
	}
	
	private static void addRodItem(ItemStack stack){
		rodlist.add(stack);
	}

}
