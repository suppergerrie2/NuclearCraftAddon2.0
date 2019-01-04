package nca.blocks;

import java.util.Random;

import nca.init.ModItems;
import nca.items.NCAItemDoor;
import nca.util.Reference;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NCABlockDoor extends BlockDoor {

	public NCABlockDoor(String name, Material material) {
		super(material);
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(new ResourceLocation(Reference.MODID, name));
		setHarvestLevel("pickaxe", 0);
		setHardness(2f);
		setResistance(3000.0f);

	}

	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
		return false;
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(getItem());

	}

	private Item getItem() {
		return ModItems.reactordoor;

	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : this.getItem();
	}

}
