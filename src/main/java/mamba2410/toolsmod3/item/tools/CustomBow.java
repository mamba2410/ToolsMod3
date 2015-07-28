package mamba2410.toolsmod3.item.tools;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomBow extends ItemBow{
	
	String igname = "";
	String unlocalname;
	String name;

	public CustomBow(int dura, String name) {
		unlocalname = name + "Bow";
		this.name = name;
		setUnlocalizedName(unlocalname);
		setMaxDamage(dura);
		setTextureName("minecraft:bow");
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromString(name)) + " Bow";
		setFull3D();
		setCreativeTab(null);
		
		registering(unlocalname, igname);
	}
	
	private void registering(String unlocalisedname, String igname){
		GameRegistry.registerItem(this, unlocalisedname);
		LanguageRegistry.instance().addStringLocalization("item." + unlocalisedname + ".name", "en_US", igname);
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int num, boolean bln) {
		String name_ = ToolHelper.getHeadNameFromString(name);
		if(name_.equals("Universe") || name_.equals("GalaxyEllipse") || name_.equals("GalaxySpiral") || name_.equals("GalaxyIrreqular")){
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
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final int getRenderPasses(int metadata) {
		return 2;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {
	        if(pass == 0)
	    		return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 0);
	    	else
	    		return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 0);
	   }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
	        if (usingItem == null) {
	        	if(pass == 0)
	    			return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 0);
	    		else
	    			return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 0);
	        }
	        
	        int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
	        
	        if (ticksInUse > 17) {
	        	if(pass == 0)
	    			return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 3);
	    		else
	    			return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 3);
	        } else if (ticksInUse > 13) {
	        	if(pass == 0)
	    			return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 2);
	    		else
	    			return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 2);
	        } else if (ticksInUse > 0) {
	        	if(pass == 0)
	    			return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 1);
	    		else
	    			return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 1);
	        } else {
	        	if(pass == 0)
	    			return IconHelper.getBow(ToolHelper.getHeadNameFromString(name), "Head", 0);
	    		else
	    			return IconHelper.getBow(ToolHelper.getBowStringNameFromString(name), "Rod", 0);
	        }
	    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		 ArrowNockEvent event = new ArrowNockEvent(player, stack);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return event.result;
	        }

	        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow))
	        {
	        	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
	        }
		return stack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if (flag || p_77615_3_.inventory.hasItem(Items.arrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(p_77615_2_, p_77615_3_, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
            {
                entityarrow.setFire(100);
            }

            p_77615_1_.damageItem(1, p_77615_3_);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                p_77615_3_.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
        }
    }

}
