package nca.blocks;

import nca.tab.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;

public class TritiumLampFrame extends Block {

	public TritiumLampFrame (String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(blockSoundType.METAL);
		setHarvestLevel("Pickaxe", 1);
		this.setHardness(.2F); 

	} 

	@Override 
	public boolean isOpaqueCube(IBlockState state) {
		return false; 

	}

	@Override 
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;  

	}		

}
