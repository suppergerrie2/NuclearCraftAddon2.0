package nca.init;


import nca.blocks.MoissaniteOre;
import nca.blocks.BunkerBlocks;
import nca.blocks.FakeDiamond;
import nca.blocks.Ore;
import nca.blocks.Microwave;
import nca.blocks.NCABlockDoor;
import nca.blocks.TritiumLamp;
import nca.blocks.TritiumLightFrame;
import nca.tab.NCAddonTab;
import nca.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {

	public static Block fakediamond;
	public static Block microwave;
	public static Block reactordoor;
	public static Block moissaniteore;
	
 

	//Bunker Blocks
	public static Block oldconcrete; 
	public static Block tritiumlamp;
	public static Block tritiumlightframe;


	public static void init() {
		fakediamond = new FakeDiamond("fake_diamond", Material.IRON);
		microwave = new Microwave("microwave", Material.IRON);
		reactordoor = new NCABlockDoor("reactor_door", Material.IRON); 
		
		
		moissaniteore = new MoissaniteOre("moissanite_ore", Material.ROCK); 
		moissaniteore.setHardness(2f);
		
		
		//Bunker Blocks
		oldconcrete = new BunkerBlocks("old_concrete", Material.ROCK); 
		tritiumlamp  = new TritiumLamp("tritium_lamp", Material.GROUND); 
		tritiumlightframe = new TritiumLightFrame("tritium_light_frame", Material.GROUND);


		//Creative Tab
		fakediamond.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		microwave.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		reactordoor.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 
		moissaniteore.setCreativeTab(NCAddonTab.NC_ADDON_TAB);


		//Bunker Blocks
		oldconcrete.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 
		tritiumlamp.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlightframe.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 

	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(fakediamond);
		event.getRegistry().registerAll(microwave);
		event.getRegistry().registerAll(reactordoor);
		event.getRegistry().registerAll(moissaniteore);



		//Bunker Blocks
		event.getRegistry().registerAll(oldconcrete);
		event.getRegistry().registerAll(tritiumlamp);
		event.getRegistry().registerAll(tritiumlightframe);

	}

	@SubscribeEvent
	public static void regiterItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(fakediamond).setRegistryName(fakediamond.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(microwave).setRegistryName(microwave.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(moissaniteore).setRegistryName(moissaniteore.getRegistryName()));



		//Bunker Blocks
		event.getRegistry().registerAll(new ItemBlock(oldconcrete).setRegistryName(oldconcrete.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tritiumlamp).setRegistryName(tritiumlamp.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tritiumlightframe).setRegistryName(tritiumlightframe.getRegistryName()));
		
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(fakediamond));
		registerRender(Item.getItemFromBlock(microwave));
		registerRender(Item.getItemFromBlock(reactordoor));
		registerRender(Item.getItemFromBlock(moissaniteore));


		//Bunker Blocks
		registerRender(Item.getItemFromBlock(oldconcrete));
		registerRender(Item.getItemFromBlock(tritiumlamp));
		registerRender(Item.getItemFromBlock(tritiumlightframe));


	}

	public static void registerRender(Item item ) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));

	}

}



