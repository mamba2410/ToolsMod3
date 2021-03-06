package mamba2410.toolsmod3.util;

import mamba2410.toolsmod3.ToolsMod;
import mamba2410.toolsmod3.item.tools.CustomNinjaken;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class UtilEventHandler {
	
	public static UtilEventHandler instance;
	private static ToolsMod modinstance;
	
	public UtilEventHandler(ToolsMod mod){
		modinstance = mod;
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e){
		if(e.entityLiving instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer)e.entityLiving;
			
			for(int i = 0; i < p.inventory.getSizeInventory(); i++){
				ItemStack stack = p.inventory.getStackInSlot(i);
				if(EnchantmentHelper.getEnchantmentLevel(ConfigHandler.repair_id, stack) > 0){
					if(p.ticksExisted % Math.floor(100.0f / EnchantmentHelper.getEnchantmentLevel(ConfigHandler.repair_id, stack)) == 0)
						stack.setItemDamage(stack.getItemDamage() - 1);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerHit(LivingHurtEvent e){
		if(e.entity != null && e.entityLiving != null){
			if(e.entityLiving instanceof EntityPlayer){
				EntityPlayer p = (EntityPlayer)e.entityLiving;
			
				if(p.getHeldItem() != null){
					if(p.isBlocking()){
						if(p.getHeldItem().getItem() instanceof CustomNinjaken)
							p.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 1));
					}
				}
			}
		
		}
	}

}
