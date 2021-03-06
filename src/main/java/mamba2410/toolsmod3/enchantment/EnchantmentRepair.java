package mamba2410.toolsmod3.enchantment;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentRepair extends Enchantment{

	public EnchantmentRepair(int id, int rarity) {
		super(id, rarity, EnumEnchantmentType.breakable);
		setName("TMRepair");
		LanguageRegistry.instance().addStringLocalization("enchantment.TMRepair", "en_US", "Repair");
	}
	
	public int getMaxLevel(){
        return 3;
    }

    public boolean canApply(ItemStack stack){
        return stack.isItemStackDamageable() ? true : super.canApply(stack);
    }
    
    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 50;
    }
    
    public int getMinEnchantability(int level)
    {
        return 10 + (level - 1) * 8;
    }

}
