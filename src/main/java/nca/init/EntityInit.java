package nca.init;



import nca.config.NCAConfig;
import nca.entity.EntityNuclearMonster;
import nca.tab.NCAddonTab;
import nca.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	
	public static void registerEntities() {
		registerEntity("nuclear_monster", EntityNuclearMonster.class, Reference.ENTITY_NUCLEAR_MONSTER, 50, 11437146, 000000);
	}
	
	private static void registerEntity(String name, Class<?extends Entity> entity, int id, int range, int colour1, int colour2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, NCAConfig.instance, range, 1, true, colour1, colour2);
	}
}
