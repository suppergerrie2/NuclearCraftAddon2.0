package nca.blocks;

import java.util.Random;

import javax.swing.text.html.parser.Entity;

import nca.init.ModBlocks;
import nca.tileentity.TileEntityMicrowave;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Microwave extends BasicBlock implements ITileEntityProvider {


	public static final PropertyDirection FACING = BlockHorizontal.FACING; 
	public static final PropertyBool BURNING = PropertyBool.create("burning"); 


	public Microwave (String name, Material material) {
		super(name, Material.IRON);
		this.setHardness(2F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));
		setSoundType(SoundType.METAL); 
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.microwave);

	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModBlocks.microwave);
	}

	@Override 
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {


		if(!worldIn.isRemote) {
			

		IBlockState north = worldIn.getBlockState(pos.north()); 
		IBlockState south = worldIn.getBlockState(pos.south()); 
		IBlockState west = worldIn.getBlockState(pos.west()); 
		IBlockState east = worldIn.getBlockState(pos.east()); 
		EnumFacing face = (EnumFacing)state.getValue(FACING); 

		if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH; 
		else if (face == EnumFacing.SOUTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.NORTH;
		else if (face == EnumFacing.WEST && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.EAST;
		else if (face == EnumFacing.EAST && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.WEST;
		worldIn.setBlockState(pos, state.withProperty(FACING, face), 2); 

	}
		}

public static void setstate(boolean active,World worldIn, BlockPos pos) {

	IBlockState state = worldIn.getBlockState(pos);
	TileEntity tileentity = worldIn.getTileEntity(pos); 

	if(active)worldIn.setBlockState(pos, ModBlocks.microwave.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3); 
	else worldIn.setBlockState(pos, ModBlocks.microwave.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3); 


	if(tileentity != null) {
		tileentity.validate();
		worldIn.setTileEntity(pos, tileentity);
		
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileEntityMicrowave(); 
		
	}

	@Override 
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()); 
		
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, playerIn.getHorizontalFacing().getOpposite()), 2); 
		return true; 
		
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityMicrowave tileentity = (TileEntityMicrowave)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL; 
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING))); 
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING ))); 
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BURNING,FACING}); 
	} 

	@Override
	public IBlockState getstatefromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() ==  EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing); 
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return((EnumFacing)state.getValue(FACING)).getIndex(); 
	}
}
	













