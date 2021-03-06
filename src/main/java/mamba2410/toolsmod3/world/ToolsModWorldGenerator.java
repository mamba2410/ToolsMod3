package mamba2410.toolsmod3.world;

import java.util.Random;

import mamba2410.toolsmod3.util.BlockHandler;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ToolsModWorldGenerator implements IWorldGenerator{

	public void generate(Random rand, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSapphire(world, rand, chunkX * 16, chunkZ * 16);
			generateEnergerium(world, rand, chunkX * 16, chunkZ * 16);
			generateFluxinite(world, rand, chunkX * 16, chunkZ * 16);
			generatePlatinum(world, rand, chunkX * 16, chunkZ * 16);
			generateBedrock(world, rand, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSapphire(World world, Random rand, int chunkX,int chunkZ) {
		for (int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHandler.sapphireOre, 5)).generate(world,rand, randPosX, randPosY, randPosZ);
		}
	}

	private void generateEnergerium(World world, Random rand, int chunkX,int chunkZ) {
		for (int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHandler.energeriumOre, 5)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	private void generateFluxinite(World world, Random rand, int chunkX,int chunkZ) {
		for (int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHandler.fluxiniteOre, 5)).generate(world,rand, randPosX, randPosY, randPosZ);
		}
	}

	private void generatePlatinum(World world, Random rand, int chunkX,int chunkZ) {
		for (int i = 0; i < 2; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHandler.platinumOre, 5)).generate(world,rand, randPosX, randPosY, randPosZ);
		}
	}
	
	private void generateBedrock(World world, Random rand, int chunkX,int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHandler.bedrockOre, 5, Blocks.bedrock)).generate(world,rand, randPosX, randPosY, randPosZ);
		}
	}
	
}
