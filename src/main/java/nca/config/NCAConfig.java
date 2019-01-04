package nca.config;

import nca.init.EntityInit;
import nca.init.ModBlocks;
import nca.init.ModItems;
import nca.init.NCARecipes;
import nca.proxy.CommonProxy;
import nca.util.Reference;
import nca.worldgen.OreGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = nca.util.Reference.MODID, name = nca.util.Reference.NAME, version = nca.util.Reference.VERSION)
public class NCAConfig {



	@Instance
	public static NCAConfig instance; 

	@SidedProxy(clientSide = "nca.proxy.ClientProxy", serverSide = "nca.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + ":preInit");
		ModBlocks.init();
		ModItems.init();

		EntityInit.registerEntities();
		MinecraftForge.EVENT_BUS.register(new NCARecipes());


	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {

		NCARecipes.init();

		GameRegistry.registerWorldGenerator(new OreGen(), 0);

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

	}

}

