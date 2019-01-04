package nca.items;

import nca.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;

public class NCAItemDoor extends ItemDoor{

	public NCAItemDoor(String nameIn, Block block) {
		super(block);
		setUnlocalizedName(Reference.MODID);
		setRegistryName(new ResourceLocation(Reference.MODID, nameIn)); 
		
	}
}
