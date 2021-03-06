package mamba2410.toolsmod3.block.base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mamba2410.toolsmod3.lib.References;
import mamba2410.toolsmod3.util.CreativeTabsHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCore extends Block{
	
	public BlockCore(Material mat, String unlocalisedname, String igname){
		super(mat);
		setBlockName(unlocalisedname);
		setCreativeTab(CreativeTabsHandler.modtab);
		setBlockTextureName(References.TEXTUREPREFIX + unlocalisedname.toLowerCase());
		setStepSound(soundTypeStone);
		setHardness(5.0f);
		setResistance(5.0f);
		setHarvestLevel("pickaxe", 0);
		
		registering(unlocalisedname, igname);
	}
	
	private void registering(String u, String l){
		GameRegistry.registerBlock(this, u);
		LanguageRegistry.addName(this, u);
		LanguageRegistry.instance().addStringLocalization("tile." + u + ".name", "en_US", l);
	}
	
	public void addDetails(float hardness, float resistance, int harvestlevel, String tool){
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestlevel);
	}

}
