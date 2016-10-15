package mamba2410.toolsmod3.util;

import static mamba2410.toolsmod3.lib.MetadataItemNames.HeadNames;
import static mamba2410.toolsmod3.lib.MetadataItemNames.LocalHeadNames;
import static net.minecraft.util.EnumChatFormatting.AQUA;
import static net.minecraft.util.EnumChatFormatting.BLUE;
import static net.minecraft.util.EnumChatFormatting.DARK_BLUE;
import static net.minecraft.util.EnumChatFormatting.DARK_PURPLE;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.GREEN;
import static net.minecraft.util.EnumChatFormatting.LIGHT_PURPLE;
import static net.minecraft.util.EnumChatFormatting.RED;
import mamba2410.toolsmod3.ToolsMod;
import mamba2410.toolsmod3.enchantment.EnchantmentRepair;
import mamba2410.toolsmod3.item.base.ItemCore;
import mamba2410.toolsmod3.item.base.SubItemCore;
import mamba2410.toolsmod3.item.crafting.Recipe;
import mamba2410.toolsmod3.item.crafting.ShapelessRecipe;
import mamba2410.toolsmod3.item.tools.CustomAllTool;
import mamba2410.toolsmod3.item.tools.CustomAxe;
import mamba2410.toolsmod3.item.tools.CustomBow;
import mamba2410.toolsmod3.item.tools.CustomHoe;
import mamba2410.toolsmod3.item.tools.CustomNinjaken;
import mamba2410.toolsmod3.item.tools.CustomPickSpade;
import mamba2410.toolsmod3.item.tools.CustomPickaxe;
import mamba2410.toolsmod3.item.tools.CustomSpade;
import mamba2410.toolsmod3.item.tools.CustomSword;
import mamba2410.toolsmod3.item.tools.parts.BowString;
import mamba2410.toolsmod3.item.tools.parts.ToolHead;
import mamba2410.toolsmod3.item.tools.parts.ToolRod;
import mamba2410.toolsmod3.lib.MetadataItemNames;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHandler {
	
	public static ItemHandler instance;
	private static ToolsMod modinstance;
	private static int nextID = 110;
	
	private static boolean cfg_celestial;
	private static boolean cfg_celestial_tools;
	
	public static final Enchantment enchantRepair = new EnchantmentRepair(ConfigHandler.repair_id, ConfigHandler.repair_rarity);
	
	public static Item craftingItem;
	public static SubItemCore materials, celestial, metals;
	
	public static SubItemCore pickheads, axeheads, spadeheads, swordheads, hoeheads, ninjaswordheads, bowheads;
	public static SubItemCore toolrods;
	public static SubItemCore bowstrings;
	
	private void createItems(){
		
		craftingItem = new ItemCore("ToolPart", "Tool Part");
		materials = new SubItemCore("TMMaterial", "resource_", MetadataItemNames.MaterialNames, MetadataItemNames.LocalMaterial);
		metals = new SubItemCore("TMMetals", "metal_", MetadataItemNames.MetalNames, "Ingot", MetadataItemNames.LocalMetal);
		celestial = new SubItemCore("TMCelestial", "celestial_", MetadataItemNames.CelestialNames, MetadataItemNames.LocalCelestial);
		
		pickheads = new ToolHead("Pick");
		axeheads = new ToolHead("Axe");
		spadeheads = new ToolHead("Spade");
		swordheads = new ToolHead("Sword");
		hoeheads = new ToolHead("Hoe");
		ninjaswordheads = new ToolHead("NinjaSword");
		toolrods = new ToolRod();
		
		bowheads = new ToolHead("Bow");
		bowstrings = new BowString();
		
	}
	
	/**					TODO NOTE TO SELF!!! TODO
	 * 
	 * 	Make sure you ONLY use MetadataItemNames!
	 *  e.g. MetadataItemNames.HeadNames[i], new ItemStack(item), Harvest Level, Durability, Efficiency, Base Damage, Enchantability
	 *  OR
	 *  e.g. MetadataItemNames.RodNames[i], new ItemStack(item), DurabilityModifier
	 */
	private void createToolMaterials(){
		String[] heads = MetadataItemNames.HeadNames.clone();
		String[] rods = MetadataItemNames.RodNames.clone();
		String[] bowstrings = MetadataItemNames.BowStringNames.clone();
		
		addHead(heads[0], new ItemStack(Items.emerald), 3, 1600, 12.0f, 3.0f, 15);
		addHead(heads[1], new ItemStack(Blocks.obsidian), 3, 2200, 8.0f, 2.0f, 6);
		addHead(heads[2], new ItemStack(metals, 1, 0), 2, 1300, 10.0f, 2.5f, 10);
		addHead(heads[3], new ItemStack(metals, 1, 1), 3, 1350, 11.0f, 4.0f, 8);
		addHead(heads[4], new ItemStack(metals, 1, 2), 3, 1350, 16.0f, 2.0f, 25);
		addHead(heads[5], new ItemStack(metals, 1, 3), 3, 2600, 11.0f, 2.0f, 8);
		addHead(heads[6], new ItemStack(metals, 1, 4), 4, 1860, 13.0f, 3.0f, 16);
		addHead(heads[7], new ItemStack(materials, 1, 11), 5, 1920, 15.0f, 3.0f, 21);
		addHead(heads[8], new ItemStack(metals, 1, 5), 5, 2340, 17.0f, 4.0f, 25);
		addHead(heads[9], new ItemStack(metals, 1, 6), 3, 1300, 14.0f, 3.0f, 26);
		addHead(heads[10], new ItemStack(metals, 1, 7), 5, 3000, 20.0f, 4.0f, 30);
		addHead(heads[11], new ItemStack(celestial, 1, 6), 5, 5000, 50.0f, 10.0f, 35);
		addHead(heads[12], new ItemStack(celestial, 1, 7), 5, 5000, 50.0f, 10.0f, 35);
		addHead(heads[13], new ItemStack(celestial, 1, 8), 5, 8000, 110.0f, 14.0f, 38);
		addHead(heads[14], new ItemStack(celestial, 1, 9), 5, 8000, 110.0f, 14.0f, 38);
		addHead(heads[15], new ItemStack(celestial, 1, 12), 5, -1, 240.0f, 18.0f, 42);
		addHead(heads[16], new ItemStack(celestial, 1, 11), 5, -1, 240.0f, 18.0f, 42);
		addHead(heads[17], new ItemStack(celestial, 1, 10), 5, -1, 240.0f, 18.0f, 42);
		addHead(heads[18], new ItemStack(celestial, 1, 13), 5, -1, 2048.0f, 24.0f, 50);
		
		addRod(rods[0], new ItemStack(Items.stick), 1.0f);
		addRod(rods[1], new ItemStack(materials, 1, 0), 1.2f);
		addRod(rods[2], new ItemStack(materials, 1, 1), 1.3f);
		addRod(rods[3], new ItemStack(materials, 1, 2), 1.4f);
		
		addString(bowstrings[0], new ItemStack(Items.string, 1, 0), 1.0f);
		
		
	}
	
	private void addTConMats(String[] heads){
		// String name, ItemStack stack, EnumChatFormatting cf, int color, float handle, int reinforced, float stonebound, int maxDamage, float bowMax, int arrowWeight, float arrowBreakChance, String inGame, boolean casting){
		createTCon(heads[0], getHeadStack(0), GREEN, 			0x00FF33, 1.3f, 0, 0.0f, 4 , 1.25f, 6, 0.1f , LocalHeadNames[0], false, false);
		createTCon(heads[3], getHeadStack(3), RED, 				0xED1818, 1.2f, 0, 0.0f, 8 , 0.25f, 4, 0.1f , LocalHeadNames[3], false, false);
		createTCon(heads[4], getHeadStack(4), BLUE, 			0x181FED, 1.1f, 0, 0.0f, 8 , 0.25f, 5, 0.05f, LocalHeadNames[4], false, false);
		createTCon(heads[5], getHeadStack(5), LIGHT_PURPLE, 	0xAB0085, 1.0f, 2, 0.5f, 8 , 0.25f, 7, 0.2f , LocalHeadNames[5], false, false);
		createTCon(heads[6], getHeadStack(6), GOLD, 			0xBDB155, 1.3f, 1, 0.0f, 10, 0.1f , 5, 0.08f, LocalHeadNames[6], false, false);
		createTCon(heads[7], getHeadStack(7), DARK_BLUE, 		0x5574BD, 1.1f, 0, 2.0f, 10, 0.25f, 4, 0.14f, LocalHeadNames[7], false, false);
		createTCon(heads[8], getHeadStack(8), AQUA,				0x5CE0E0, 1.4f, 1, 0.0f, 12, 0.25f, 5, 0.08f, LocalHeadNames[8], false, false);
		createTCon(heads[10], getHeadStack(10), DARK_PURPLE,	0x510094, 1.5f, 3, 0.0f, 16, 0.05f, 6, 0.01f, LocalHeadNames[10], false, false);
		
		createTCon(HeadNames[11], getHeadStack(11), DARK_PURPLE, 0x6000A1, 1.50f, 4, 0.0f, 25, 0.01f, 7, 0.0f, LocalHeadNames[11], false, false);
		createTCon(HeadNames[12], getHeadStack(12), GOLD, 		 0xFFAB4A, 1.50f, 4, 0.0f, 25, 0.01f, 7, 0.0f, LocalHeadNames[12], false, false);
		createTCon(HeadNames[13], getHeadStack(13), DARK_PURPLE, 0x692196, 1.75f, 5, 0.0f, 30, 0.01f, 8, 0.0f, LocalHeadNames[13], false, false);
		createTCon(HeadNames[14], getHeadStack(14), GOLD, 		 0xD4934A, 1.75f, 5, 0.0f, 40, 0.01f, 8, 0.0f, LocalHeadNames[14], false, false);
		createTCon(HeadNames[15], getHeadStack(15), LIGHT_PURPLE,0x975FBA, 2.00f, 6, 0.0f, 40, 0.01f, 9, 0.0f, LocalHeadNames[15], false, false);
		createTCon(HeadNames[16], getHeadStack(16), LIGHT_PURPLE,0x975FBA, 2.00f, 6, 0.0f, 40, 0.01f, 9, 0.0f, LocalHeadNames[16], false, false);
		createTCon(HeadNames[17], getHeadStack(17), LIGHT_PURPLE,0x975FBA, 2.00f, 6, 0.0f, 40, 0.01f, 9, 0.0f, LocalHeadNames[17], false, false);
		createTCon(HeadNames[18], getHeadStack(18), LIGHT_PURPLE,0xBF24BA, 2.50f, 7, 0.0f, 50, 0.01f, 10, 0.0f, LocalHeadNames[18], false, true);
	}
	
	private void crafting(){
		recipeo(new ItemStack(craftingItem, 32, 0),"xyx", "yxy", "xyx", 'x', Items.clay_ball, 'y', "stickWood");
		recipe(new ItemStack(materials, 2, 0), "a", "a", "a", 'a', new ItemStack(Blocks.obsidian));
		recipe(new ItemStack(materials, 1, 1), "a", "b", "a", 'a', new ItemStack(Items.blaze_rod), 'b', new ItemStack(materials, 1, 0));
		recipeo(new ItemStack(materials, 1, 2), "a", "b", "b", 'a', "ingotPlatinum", 'b', new ItemStack(materials, 1, 0));
		recipe(new ItemStack(materials, 4, 3), " a ", "aba", " a ", 'a', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.coal_block));
		smelting(new ItemStack(materials, 1, 7), new ItemStack(materials, 1, 4));
		smelting(new ItemStack(materials, 1, 8), new ItemStack(materials, 1, 5));
		smelting(new ItemStack(materials, 1, 9), new ItemStack(materials, 1, 6));
		recipe(new ItemStack(materials, 1, 7), "aaa", "aba", "aaa", 'a', new ItemStack(Items.dye, 1, 4), 'b', new ItemStack(Items.iron_ingot));
		recipe(new ItemStack(materials, 1, 8), "aaa", "aba", "aaa", 'a', new ItemStack(Items.redstone), 'b', new ItemStack(Items.iron_ingot));
		recipe(new ItemStack(materials, 1, 9), "aaa", "aba", "aaa", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(Items.iron_ingot));
		recipe(new ItemStack(materials, 6, 11), "aba", "cbc", "dbd", 'a', new ItemStack(materials, 1, 10), 'b', new ItemStack(Items.diamond), 'c', new ItemStack(materials, 1, 12), 'd', new ItemStack(materials, 1, 13));
		recipes(new ItemStack(materials, 1, 15), new ItemStack(metals, 1, 6), new ItemStack(metals, 1, 5), new ItemStack(materials, 1, 16));
		recipe(new ItemStack(materials, 1, 16), "aaa", "aba", "aaa", 'a', new ItemStack(materials, 1, 14), 'b', new ItemStack(Blocks.obsidian));
		
		recipe(new ItemStack(metals, 4, 0), "aba", "b b", "aba", 'a', new ItemStack(Items.iron_ingot), 'b', new ItemStack(materials, 1, 3));
		recipeos(new ItemStack(metals, 2, 1), new ItemStack(materials, 1, 5), "ingotSteel");
		recipeos(new ItemStack(metals, 2, 2), new ItemStack(materials, 1, 4), "ingotSteel");
		recipeos(new ItemStack(metals, 2, 3), new ItemStack(materials, 1, 6), "ingotSteel");
		recipeo(new ItemStack(metals, 4, 4), "aba", "cbc", "dbd", 'a', new ItemStack(metals, 1, 1), 'b', "ingotSteel", 'c', new ItemStack(metals, 1, 2), 'd', new ItemStack(metals, 1, 3));
		smelting(new ItemStack(BlockHandler.platinumOre), new ItemStack(metals, 1, 6));
		recipes(new ItemStack(metals, 1, 7), forBlock(new ItemStack(materials, 1, 15)));
		
		if(cfg_celestial){
			recipe(new ItemStack(celestial, 1, 0), "aba", "b b", "aba", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(Blocks.glass_pane));
			recipe(new ItemStack(celestial, 1, 1), "aba", "b b", "aba", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(celestial, 1, 0));
			recipe(new ItemStack(celestial, 1, 2), "aba", "b b", "aba", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(celestial, 1, 1));
			recipe(new ItemStack(celestial, 1, 3), "aba", "b b", "aba", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(celestial, 1, 2));
			recipes(new ItemStack(celestial, 1, 4), new ItemStack(Items.coal), new ItemStack(Items.blaze_rod), new ItemStack(Items.fire_charge), new ItemStack(Items.skull, 1, 1));
			recipes(new ItemStack(celestial, 1, 5), new ItemStack(Items.coal), new ItemStack(Items.blaze_rod), new ItemStack(Items.fire_charge), new ItemStack(Blocks.tnt));
			recipes(new ItemStack(celestial, 1, 6), new ItemStack(celestial, 1, 4), new ItemStack(celestial, 1, 15));
			recipes(new ItemStack(celestial, 1, 7),  new ItemStack(celestial, 1, 5), new ItemStack(celestial, 1, 15));
			recipe(new ItemStack(celestial, 1, 8), "aba", 'a', new ItemStack(celestial, 1, 6), 'b', new ItemStack(celestial, 1, 1));
			recipe(new ItemStack(celestial, 1, 9), "aba", 'a', new ItemStack(celestial, 1, 7), 'b', new ItemStack(celestial, 1, 1));
			recipe(new ItemStack(celestial, 1, 10), "a d", "abc", "cdc", 'a', new ItemStack(celestial, 1, 8), 'b', new ItemStack(celestial, 1, 2), 'c', new ItemStack(Blocks.glowstone), 'd', new ItemStack(celestial, 1, 9));
			recipe(new ItemStack(celestial, 1, 11), "ada", "dbc", " cc", 'a', new ItemStack(celestial, 1, 8), 'b', new ItemStack(celestial, 1, 2), 'c', new ItemStack(Blocks.glowstone), 'd', new ItemStack(celestial, 1, 9));
			recipe(new ItemStack(celestial, 1, 12), "a d", "cbc", "dca", 'a', new ItemStack(celestial, 1, 8), 'b', new ItemStack(celestial, 1, 2), 'c', new ItemStack(Blocks.glowstone), 'd', new ItemStack(celestial, 1, 9));
			recipes(new ItemStack(celestial, 1, 13), new ItemStack(celestial, 1, 10), new ItemStack(celestial, 1, 11), new ItemStack(celestial, 1, 12), new ItemStack(celestial, 1, 3));
			recipe(new ItemStack(celestial, 1, 14), "aaa", "aba", "aaa", 'a', new ItemStack(Items.blaze_rod), 'b', new ItemStack(Items.nether_star));
			smelting(new ItemStack(celestial, 1, 14), new ItemStack(celestial, 1, 15));
		}
		
	}
	
	public void PreInit(){
		cfg_celestial = ConfigHandler.celestial;
		cfg_celestial_tools = ConfigHandler.celestial_tools;
		createItems();
		createToolMaterials();
		toolCrafting();
		
	}
	
	public void Init(){
		crafting();
		if(modinstance.tconstructloaded)
			addTConMats(MetadataItemNames.HeadNames.clone());
	}
	public void PostInit(){
		oredict();
	}
	
	private void oredict(){
		OreDictionary.registerOre("stickObsidian", new ItemStack(materials, 1, 0));
		OreDictionary.registerOre("obsidianStick", new ItemStack(materials, 1, 0));
		OreDictionary.registerOre("ingotSteel", new ItemStack(metals, 1, 0));
		OreDictionary.registerOre("steelIngot", new ItemStack(metals, 1, 0));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(metals, 1, 6));
		OreDictionary.registerOre("platinumIngot", new ItemStack(metals, 1, 6));
		OreDictionary.registerOre("gemSapphire", new ItemStack(materials, 1, 10));
		OreDictionary.registerOre("gemEnergerium", new ItemStack(materials, 1, 12));
		OreDictionary.registerOre("gemFluxinite", new ItemStack(materials, 1, 13));
		OreDictionary.registerOre("dustBedrock", new ItemStack(materials, 1, 14));
		OreDictionary.registerOre("nuggetVoid", new ItemStack(materials, 1, 15));
		OreDictionary.registerOre("ingotVoid", new ItemStack(metals, 1, 7));
		OreDictionary.registerOre("ingotRedSteel", new ItemStack(metals, 1, 1));
		OreDictionary.registerOre("ingotBlueSteel", new ItemStack(metals, 1, 2));
		OreDictionary.registerOre("ingotBlackSteel", new ItemStack(metals, 1, 3));
	}
	
	private void toolCrafting(){
		Item curPick, curAxe, curSpade, curSword, curHoe, curNinja, curBow, curPS, curAll;
		for(ItemStack rod : ToolHelper.rodlist){
			for(ItemStack head : ToolHelper.headlist){
				curPick = new CustomPickaxe(ToolHelper.getAppropriateMaterial(head, rod), head.equals(ToolHelper.headItems.get(HeadNames[18])));
				curAxe = new CustomAxe(ToolHelper.getAppropriateMaterial(head, rod), head.equals(ToolHelper.headItems.get(HeadNames[18])));
				curSpade = new CustomSpade(ToolHelper.getAppropriateMaterial(head, rod), head.equals(ToolHelper.headItems.get(HeadNames[18])));
				curSword = new CustomSword(ToolHelper.getAppropriateMaterial(head, rod));
				curHoe = new CustomHoe(ToolHelper.getAppropriateMaterial(head, rod));
				curNinja = new CustomNinjaken(ToolHelper.getAppropriateMaterialForNinjaSword(head, rod));
				curPS = new CustomPickSpade(ToolHelper.getAppropriateMaterial(head, rod), head.equals(ToolHelper.headItems.get(HeadNames[18])));
				curAll = new CustomAllTool(ToolHelper.getAppropriateMaterial(head, rod), head.equals(ToolHelper.headItems.get(HeadNames[18])));
				
				if(head.getItem() != celestial || cfg_celestial_tools){
					//LogHelper.info(String.format("Adding %s to the crafting, config option is %s", ToolHelper.getHeadName(head), cfg_celestial_tools));
					
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curPick),
						new Object[] {
					new ItemStack(pickheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curAxe),
						new Object[] {
					new ItemStack(axeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curSpade),
						new Object[] {
					new ItemStack(spadeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curSword),
						new Object[] {
					new ItemStack(swordheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curHoe),
						new Object[] {
					new ItemStack(hoeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curNinja),
						new Object[] {
					new ItemStack(ninjaswordheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curPS),
						new Object[] {
					new ItemStack(pickheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(spadeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				
				GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curAll),
						new Object[] {
					new ItemStack(pickheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(spadeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(axeheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
					new ItemStack(toolrods, 1, ToolHelper.getMetadataFromRodStack(rod))}));
				}
				
			}
				
		}
		
			for(ItemStack stack : ToolHelper.headlist){
				
				Recipe recipe = new Recipe(new ItemStack(pickheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getPickRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(axeheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getAxeRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(spadeheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getSpadeRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(swordheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getSwordRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(hoeheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getHoeRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(ninjaswordheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getNinjaSwordRecipe(stack));
				GameRegistry.addRecipe(recipe);
				
				recipe = new Recipe(new ItemStack(bowheads, 1,
						ToolHelper.getMetadataFromHeadStack(stack)),
						ToolHelper.getBowRecipe(stack));
				GameRegistry.addRecipe(recipe);
			
			}
			
			for(ItemStack stack : ToolHelper.rodlist){
				Recipe recipe = new Recipe(new ItemStack(toolrods, 2,
						ToolHelper.getMetadataFromRodStack(stack)),
						ToolHelper.getRodRecipe(stack));
				GameRegistry.addRecipe(recipe);
			}
			
			for(ItemStack stack : ToolHelper.bowstringlist){
				Recipe recipe = new Recipe(new ItemStack(bowstrings, 2,
						ToolHelper.getMetadataFromStringStack(stack)),
						ToolHelper.getBowStringRecipe(stack));
				GameRegistry.addRecipe(recipe);
			}
		
		for(ItemStack head : ToolHelper.headlist){
			for(ItemStack string : ToolHelper.bowstringlist){
				curBow = new CustomBow(ToolHelper.getAppropriateBowDurability(head, string), ToolHelper.getNameFromBow(head, string));
				
				if(head.getItem() != celestial || cfg_celestial_tools){
					GameRegistry.addRecipe(new ShapelessRecipe(new ItemStack(curBow),
							new Object[] {
						new ItemStack(bowheads, 1, ToolHelper.getMetadataFromHeadStack(head)),
						new ItemStack(bowstrings, 1, ToolHelper.getMetadataFromStringStack(string))}));
				}
			}
		}
		
		IconHelper.initMaps();
	}
	
	public ItemStack getToolPartItemStack(){
		return new ItemStack(getToolPartItem(), 1, 0);
	}
	
	public Item getToolPartItem(){
		return craftingItem;
	}
	
	private void addHead(String name, ItemStack stack, int hl, int bd, float ef, float dg, int ec){
		ToolHelper.addNamedMaterial(name, stack, hl, bd, ef, dg, ec);
	}
	
	private void addRod(String name, ItemStack stack, float dm){
		ToolHelper.addNamedModifier(name, stack, dm);
	}
	
	private void addString(String name, ItemStack stack, float dm){
		ToolHelper.addNamedString(name, stack, dm);
	}
	
	private void recipe(ItemStack out, Object... in){
		GameRegistry.addShapedRecipe(out, in);
	}
	
	private void recipeo(ItemStack out, Object... in){
		GameRegistry.addRecipe(new ShapedOreRecipe(out, in));
	}
	
	private void recipeos(ItemStack out, Object... in){
		GameRegistry.addRecipe(new ShapelessOreRecipe(out, in));
	}
	
	private void recipes(ItemStack out, Object... in){
		GameRegistry.addShapelessRecipe(out, in);
	}
	
	private void smelting(ItemStack in, ItemStack out){
		GameRegistry.addSmelting(in, out, 5.0f);
	}
	
	private Object[] forBlock(ItemStack item){
		Object[] object = new Object[9];
		for(int i = 0; i < 9; i++){
			object[i] = item;
		}
		return object;
	}
	
	private void createTCon(String name, ItemStack stack, EnumChatFormatting cf, int color, float handle, int reinforced, float stonebound, int maxDamage, float bowMax, int arrowWeight, float arrowBreakChance, String inGame, boolean casting, boolean instant){
		//LogHelper.info("Tool Material is %s, Head %s, Rod %s", ToolHelper.getMaterialName(stack, ToolHelper.rodItems.get(MetadataItemNames.RodNames[0])), ToolHelper.getHeadName(stack), ToolHelper.getRodName(ToolHelper.rodItems.get(MetadataItemNames.RodNames[0])));
		modinstance.tconstruct.createToolSet("tc_"+name.toLowerCase(), stack, nextID, ToolHelper.custommats.get(ToolHelper.getMaterialName(stack, ToolHelper.rodItems.get("Wood"))), cf, color, handle, reinforced, stonebound, maxDamage, maxDamage, arrowWeight, arrowBreakChance, inGame, casting, instant);
		nextID++;
	}
	
	private ItemStack getHeadStack(int i){
		return ToolHelper.headItems.get(MetadataItemNames.HeadNames[i]);
	}
	
	public ItemHandler(ToolsMod mod){
		instance = this;
		modinstance = mod;
	}

}
