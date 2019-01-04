package nca.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class UraniumInfusedBeer extends Item{
    
	  @Override
	    public EnumAction getItemUseAction(ItemStack stack) {
	    	return EnumAction.DRINK; }
	    
    public UraniumInfusedBeer(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);    

    }
}

