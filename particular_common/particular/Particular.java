package particular;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import particular.block.ModBlocks;
import particular.core.proxy.CommonProxy;
import particular.creativetab.CreativeTabParticular;
import particular.item.ModItems;
import particular.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Particular {
	
	@Instance(Reference.MOD_ID)
	public static Particular instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tabsParticular = new CreativeTabParticular(
			CreativeTabs.getNextID(), Reference.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Register blocks & items
		ModItems.init();
		ModBlocks.init();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		//Register events
		LanguageRegistry.instance().addStringLocalization("itemGroup.Particular", "Particular");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//Interact with other mods
	}
	
	
	
}
