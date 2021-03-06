package mamba2410.toolsmod3.util;

import java.util.HashMap;
import java.util.Map.Entry;

import mamba2410.toolsmod3.lib.MetadataItemNames;
import mamba2410.toolsmod3.lib.References;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class IconHelper {
	
	public static IconHelper instance;
	
	public static HashMap<String, IIcon> pickheadIcons = new HashMap();
	public static HashMap<String, IIcon> axeheadIcons = new HashMap();
	public static HashMap<String, IIcon> spadeheadIcons = new HashMap();
	public static HashMap<String, IIcon> swordheadIcons = new HashMap();
	public static HashMap<String, IIcon> hoeheadIcons = new HashMap();
	public static HashMap<String, IIcon> ninjaswordheadIcons = new HashMap();
	public static HashMap<String, IIcon> pickrodIcons = new HashMap();
	public static HashMap<String, IIcon> axerodIcons = new HashMap();
	public static HashMap<String, IIcon> spaderodIcons = new HashMap();
	public static HashMap<String, IIcon> hoerodIcons = new HashMap();
	public static HashMap<String, IIcon> swordrodIcons = new HashMap();
	public static HashMap<String, IIcon> ninjaswordrodIcons = new HashMap();
	public static HashMap<String, IIcon> bowheadIcons0 = new HashMap();
	public static HashMap<String, IIcon> bowheadIcons1 = new HashMap();
	public static HashMap<String, IIcon> bowheadIcons2 = new HashMap();
	public static HashMap<String, IIcon> bowheadIcons3 = new HashMap();
	public static HashMap<String, IIcon> bowstringIcons0 = new HashMap();
	public static HashMap<String, IIcon> bowstringIcons1= new HashMap();
	public static HashMap<String, IIcon> bowstringIcons2 = new HashMap();
	public static HashMap<String, IIcon> bowstringIcons3 = new HashMap();
	
	public static HashMap<String, String> pickheadlocations = new HashMap();
	public static HashMap<String, String> axeheadlocations = new HashMap();
	public static HashMap<String, String> spadeheadlocations = new HashMap();
	public static HashMap<String, String> swordheadlocations = new HashMap();
	public static HashMap<String, String> hoeheadlocations = new HashMap();
	public static HashMap<String, String> ninjaswordheadlocations = new HashMap();
	public static HashMap<String, String> pickrodlocations = new HashMap();
	public static HashMap<String, String> axerodlocations = new HashMap();
	public static HashMap<String, String> spaderodlocations = new HashMap();
	public static HashMap<String, String> hoerodlocations = new HashMap();
	public static HashMap<String, String> swordrodlocations = new HashMap();
	public static HashMap<String, String> ninjaswordrodlocations = new HashMap();
	public static HashMap<String, String> bowheadlocations0 = new HashMap();
	public static HashMap<String, String> bowheadlocations1 = new HashMap();
	public static HashMap<String, String> bowheadlocations2 = new HashMap();
	public static HashMap<String, String> bowheadlocations3 = new HashMap();
	public static HashMap<String, String> bowstringlocations0 = new HashMap();
	public static HashMap<String, String> bowstringlocations1 = new HashMap();
	public static HashMap<String, String> bowstringlocations2 = new HashMap();
	public static HashMap<String, String> bowstringlocations3 = new HashMap();
	
	public static void initMaps(){
		String[] headnames = MetadataItemNames.HeadNames;
		String[] rodnames = MetadataItemNames.RodNames;
		String[] bowstringnames = MetadataItemNames.BowStringNames;
		for(int i = 0; i < headnames.length; i++){
			//LogHelper.info(String.format("Looking for %s_pick_head.png in %s", headnames[i].toLowerCase(), headnames[i]));
			pickheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_pick_head");
			axeheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_axe_head");
			spadeheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_spade_head");
			swordheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_sword_head");
			hoeheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_hoe_head");
			ninjaswordheadlocations.put(headnames[i], "toolsmod3:tools/heads/" + headnames[i].toLowerCase() + "_ninjasword_head");
			
			bowheadlocations0.put(headnames[i], String.format("toolsmod3:tools/heads/%s_bow_head_%s", headnames[i].toLowerCase(), 0));
			bowheadlocations1.put(headnames[i], String.format("toolsmod3:tools/heads/%s_bow_head_%s", headnames[i].toLowerCase(), 1));
			bowheadlocations2.put(headnames[i], String.format("toolsmod3:tools/heads/%s_bow_head_%s", headnames[i].toLowerCase(), 2));
			bowheadlocations3.put(headnames[i], String.format("toolsmod3:tools/heads/%s_bow_head_%s", headnames[i].toLowerCase(), 3));

		}
		
		for(int i = 0; i < rodnames.length; i++){
			//LogHelper.info(String.format("Looking for %s_pick_rod.png in %s", rodnames[i].toLowerCase(), rodnames[i]));
			pickrodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_pick_rod");
			axerodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_axe_rod");
			spaderodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_spade_rod");
			swordrodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_sword_rod");
			hoerodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_hoe_rod");
			ninjaswordrodlocations.put(rodnames[i], "toolsmod3:tools/rods/" + rodnames[i].toLowerCase() + "_ninjasword_rod");
		}
		
		for(int i = 0; i < bowstringnames.length; i++){
			bowstringlocations0.put(bowstringnames[i], "toolsmod3:tools/strings/" + bowstringnames[i].toLowerCase() + "_bowstring_0");
			bowstringlocations1.put(bowstringnames[i], "toolsmod3:tools/strings/" + bowstringnames[i].toLowerCase() + "_bowstring_1");
			bowstringlocations2.put(bowstringnames[i], "toolsmod3:tools/strings/" + bowstringnames[i].toLowerCase() + "_bowstring_2");
			bowstringlocations3.put(bowstringnames[i], "toolsmod3:tools/strings/" + bowstringnames[i].toLowerCase() + "_bowstring_3");

		}
	}
	
	public static void addIcons(IIconRegister iconRegister){
		
		for(Entry<String, String> entry : pickheadlocations.entrySet())
			pickheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : axeheadlocations.entrySet())
			axeheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : spadeheadlocations.entrySet())
			spadeheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : swordheadlocations.entrySet())
			swordheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : ninjaswordheadlocations.entrySet())
			ninjaswordheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : hoeheadlocations.entrySet())
			hoeheadIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : pickrodlocations.entrySet())
			pickrodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : axerodlocations.entrySet())
			axerodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : spaderodlocations.entrySet())
			spaderodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : swordrodlocations.entrySet())
			swordrodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : hoerodlocations.entrySet())
			hoerodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : ninjaswordrodlocations.entrySet())
			ninjaswordrodIcons.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowheadlocations0.entrySet())
				bowheadIcons0.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowstringlocations0.entrySet())
				bowstringIcons0.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowheadlocations1.entrySet())
				bowheadIcons1.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowstringlocations1.entrySet())
				bowstringIcons1.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowheadlocations2.entrySet())
				bowheadIcons2.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowstringlocations2.entrySet())
				bowstringIcons2.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowheadlocations3.entrySet())
				bowheadIcons3.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
		for(Entry<String, String> entry : bowstringlocations3.entrySet())
				bowstringIcons3.put(entry.getKey(), iconRegister.registerIcon(entry.getValue()));
		
	}
	
	public static IIcon getPickaxe(String name, String part){
		if(part == "Head")
			return pickheadIcons.get(name);
		else
			return pickrodIcons.get(name);
	}
	public static IIcon getAxe(String name, String part){
		if(part == "Head")
			return axeheadIcons.get(name);
		else
			return axerodIcons.get(name);
	}
	public static IIcon getSpade(String name, String part){
		if(part == "Head")
			return spadeheadIcons.get(name);
		else
			return spaderodIcons.get(name);
	}
	public static IIcon getSword(String name, String part){
		if(part == "Head")
			return swordheadIcons.get(name);
		else
			return swordrodIcons.get(name);
	}
	public static IIcon getHoe(String name, String part){
		if(part == "Head")
			return hoeheadIcons.get(name);
		else
			return hoerodIcons.get(name);
	}
	public static IIcon getNinjaSword(String name, String part){
		if(part == "Head")
			return ninjaswordheadIcons.get(name);
		else
			return ninjaswordrodIcons.get(name);
	}
	public static IIcon getBow(String name, String part, int stage){
		if(part == "Head"){
			switch(stage){
			case 1: return bowheadIcons1.get(name);
			case 2:	return bowheadIcons2.get(name);
			case 3: return bowheadIcons3.get(name);
			default: return bowheadIcons0.get(name);
			}
		} else {
			switch(stage){
			case 1: return bowstringIcons1.get(name);
			case 2: return bowstringIcons2.get(name);
			case 3: return bowstringIcons3.get(name);
			default: return bowstringIcons0.get(name);
			}
		}
	}
	
	public static IIcon forName(IIconRegister ir, String name, String prefix){
		return ir.registerIcon(References.TEXTUREPREFIX + prefix + name);
	}
	
	public static IIcon forItem(IIconRegister ir, Item item, String prefix) {
		return forName(ir, item.getUnlocalizedName().replaceAll("item\\.", ""), prefix);
	}
	
	public static IIcon forBlock(IIconRegister ir, Block block, String prefix) {
		return forName(ir, block.getUnlocalizedName().replaceAll("tile\\.", ""), prefix);
	}

}
