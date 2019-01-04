package nca.tab;

import nca.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NCAddonTab extends CreativeTabs{
	
	public NCAddonTab() { 
		super("NC_Addon_Tab");
	}

	@Override 
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.uraniuminfusedbeer);
		
	}
	
	public static final CreativeTabs NC_ADDON_TAB = new NCAddonTab(); 
}
	
