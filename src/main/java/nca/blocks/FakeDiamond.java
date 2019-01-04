package nca.blocks;

import nca.tab.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class FakeDiamond extends Block {

		public FakeDiamond(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("Pickaxe", 1);
		setSoundType(blockSoundType.METAL); 
		this.setHardness(2F); 
	}		

		
		@Override
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
	        EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    
	        if (!worldIn.isRemote)
	      
	        playerIn.sendMessage(new TextComponentString("Ting. sounds like diamond, but what is it really made of?.")); 
	        return true; 

	}
}

	

	