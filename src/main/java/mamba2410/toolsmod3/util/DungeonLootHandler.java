package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.ToolsMod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class DungeonLootHandler {
	
	public static DungeonLootHandler instance;
	public static ToolsMod modinstance;
	
	private void addLoot(){}
	
	public void PreInit(){
		addLoot();
	}
	public void Init(){}
	public void PostInit(){}
	
	private void addItem(String where, ItemStack stack, int min, int max, int weight){
		ChestGenHooks.addItem(where, new WeightedRandomChestContent(stack.getItem(), stack.getItemDamage(), min, max, weight));
	}
	
	public DungeonLootHandler(ToolsMod tm){
		instance = this;
		modinstance = tm;
	}

}
