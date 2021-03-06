package mamba2410.toolsmod3.block.base;

import java.util.ArrayList;
import java.util.Random;

import mamba2410.toolsmod3.util.ItemHandler;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreCore extends BlockCore{
	
	private Random rand = new Random();
	private ItemStack drops;

	public OreCore(Material mat, String unlocalisedname, String igname, ItemStack drops) {
		super(mat, unlocalisedname, igname);
		this.drops = drops;
	}
	
	@Override
	public int getExpDrop(IBlockAccess block, int int1, int int2) {
		if (this.getItemDropped(int1, rand, int2) != Item.getItemFromBlock(this)) {
			return 1 + rand.nextInt(5);
		}
		return 0;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ItemStack stack;
		if(fortune >= 0)
			stack = new ItemStack(drops.getItem(), 1+rand.nextInt(fortune+1), drops.getItemDamage());
		else
			stack = new ItemStack(drops.getItem(), 1, drops.getItemDamage());
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(stack);
		return list;
	}

	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(1) + 1;
	}

}
