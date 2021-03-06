package mamba2410.toolsmod3.item.tools;

import com.google.common.collect.Multimap;

import mamba2410.toolsmod3.util.IconHelper;
import mamba2410.toolsmod3.util.LogHelper;
import mamba2410.toolsmod3.util.ToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomNinjaken extends ItemSword{
	
	String igname = "";
	String unlocalname;
	ToolMaterial mat;
	protected float damage;

	public CustomNinjaken(ToolMaterial mat) {
		super(mat);
		unlocalname = mat.name() + "NinjaSword";
		setUnlocalizedName(unlocalname);
		setTextureName("minecraft:iron_sword");
		setCreativeTab(null);
		this.mat = mat;
		damage = 5.0f + mat.getDamageVsEntity();
		igname = ToolHelper.getLocalFromName(ToolHelper.getHeadNameFromToolMat(mat)) + " " + 
		ToolHelper.getLocalFromToolName("NinjaSword");
		
		registering(unlocalname, igname);
	}
	
	private void registering(String unlocalisedname, String igname){
		GameRegistry.registerItem(this, unlocalisedname);
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
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		//API.hideItem(par1ItemStack);
		return super.getUnlocalizedName(par1ItemStack);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass){
		if(pass == 0){
			return IconHelper.getNinjaSword(ToolHelper.getHeadNameFromToolMat(mat), "Head");
		} else {
			return IconHelper.getNinjaSword(ToolHelper.getRodNameFromToolMat(mat), "Rod");
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
	public boolean hitEntity(ItemStack s, EntityLivingBase l, EntityLivingBase e){
		s.damageItem(1, e);
		l.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 1));
		if(e instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer) e;
			p.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 2));
			p.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 100, 1));
		}
        return false;
    }
	
	@Override
	public Multimap getItemAttributeModifiers(){
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damage, 0));
        return multimap;
    }

}
