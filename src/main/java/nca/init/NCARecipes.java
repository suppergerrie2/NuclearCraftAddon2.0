package nca.init;

import nc.block.NCBlock;
import nc.init.NCFluids;
import nc.recipe.NCRecipes;
import nc.recipe.ingredient.EmptyItemIngredient;
import nc.recipe.ingredient.FluidIngredient;
import nc.util.FluidRegHelper;
import nca.blocks.TritiumLamp;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NCARecipes {

	public static FluidIngredient fluidStack(String fluidName, int stackSize) {
		if (!FluidRegHelper.fluidExists(fluidName)) return null;
		return new FluidIngredient(fluidName, stackSize);
	}

	public static void init() {
		GameRegistry.addSmelting(ModItems.cornseeds, new ItemStack(ModItems.popcorn, 1), 1f);

		NCRecipes.Type.INFUSER.getRecipeHandler().addRecipe(ModBlocks.tritiumlightframe, fluidStack("tritium", 2000), ModBlocks.tritiumlamp);
		//NCRecipes.Type.INFUSER.getRecipeHandler().addRecipe(ModBlocks.tritiumlampframe, fluidStack("tritium", 2000), ModBlocks.tritiumlamp);

		
		//NCRecipes.Type.EXTRACTOR.getRecipeHandler().addRecipe(Items.WHEAT, new EmptyItemIngredient(), fluidStack("water", 1000));
		
		
		NCRecipes.Type.DISSOLVER.getRecipeHandler().addRecipe(ModItems.cornseeds, fluidStack("water", 1000), fluidStack("lava", 1000) );

		
	}

}
