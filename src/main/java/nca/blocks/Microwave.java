package nca.blocks;

import nca.tab.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class Microwave extends Block {

		public Microwave(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setHardness(2F); 
	}		
}
	

	