package nca.init; 
import nca.entity.EntityNuclearMonster;
import nca.items.BeerCan;
import nca.items.DiamondIngot;
import nca.items.DragonTemp;
import nca.items.ItemModFood;
import nca.items.NCAItemDoor;
import nca.items.TestItem;
import nca.items.UraniumIngot;
import nca.tab.NCAddonTab;
import nca.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {

	public static Item beercan;
	public static Item cornseeds;
	public static Item popcorn;
	public static Item testitem;
	public static Item uraniuminfusedbeer;
	public static Item uraniumingot;
	public static Item reactordoor;
	public static Item diamondingot; 
	public static Item nuclearbread; 






	//Initialize 		
	public static void init() {

		beercan = new BeerCan("beer_can"); 
		testitem = new TestItem("test_item");
		uraniumingot = new UraniumIngot("uranium_ingot");
		diamondingot = new DiamondIngot("diamond_ingot"); 

		reactordoor = new NCAItemDoor("reactor_door", ModBlocks.reactordoor);

		//Item Foods

		cornseeds = new ItemModFood("corn_seeds", 4, 4, true);
		popcorn = new ItemModFood("popcorn", 15, 10, true);
		uraniuminfusedbeer = new ItemModFood("uranium_infused_beer", 3, 4, false, new PotionEffect(MobEffects.BLINDNESS, 600, 2), new PotionEffect(MobEffects.NAUSEA, 550, 2, false, false));
		nuclearbread = new ItemModFood("nuclear_bread", 15, 15, false, new PotionEffect(MobEffects.GLOWING, 600, 3));

		//potion id 15 = Blindness;
		//potion id 9 = Nausea;
		//potion id 17 = Hunger;
		// 24 = glowing

		// CreativeTabs Item Register 

		beercan.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		testitem.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		uraniumingot.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		reactordoor.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		diamondingot.setCreativeTab(NCAddonTab.NC_ADDON_TAB);

		//CreativeTabs ItemFood Register

		cornseeds.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		popcorn.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		uraniuminfusedbeer.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		nuclearbread.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 



	}



	@SubscribeEvent

	//Register

	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(beercan, cornseeds, popcorn, nuclearbread, testitem, uraniuminfusedbeer, uraniumingot, reactordoor, diamondingot);


	}

	@SubscribeEvent
	public static void RegisterRenders(ModelRegistryEvent event) {

		//Register Render

		registerRender(beercan);
		registerRender(cornseeds);
		registerRender(popcorn);
		registerRender(testitem);
		registerRender(uraniuminfusedbeer);
		registerRender(uraniumingot);
		registerRender(reactordoor);
		registerRender(nuclearbread); 
		registerRender(diamondingot); 



	}

	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));



	}

}
	