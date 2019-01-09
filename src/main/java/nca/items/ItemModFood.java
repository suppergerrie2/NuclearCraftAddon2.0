package nca.items;

import nca.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {


	private PotionEffect[] effects;

	public ItemModFood(String UnlocalizedName, int amount, boolean isWolfFood, PotionEffect...potionEffects, String Lore) {
		super(amount, isWolfFood);
		this.setUnlocalizedName(UnlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, UnlocalizedName));
		this.effects = potionEffects;


	}

	public ItemModFood(String UnlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects, String Lore) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(UnlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, UnlocalizedName));
		this.effects = potionEffects; 

	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		for(PotionEffect effect : effects) {
			player.addPotionEffect(new PotionEffect(effect));
		}
	}
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(I18n.format(Lore));
    }

}

