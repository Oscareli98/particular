package particular;

import particular.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Particular {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Register blocks & items
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		//Register events
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//Interact with other mods
	}
	
	
	
}
