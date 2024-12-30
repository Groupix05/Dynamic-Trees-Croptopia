package groupix05.dtcroptopia.init;

import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static groupix05.dtcroptopia.init.DTCROPTOPIABlocks.*;

public class DTCROPTOPIAItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DynamicTreesCROPTOPIA.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void acceptToDynamicTreesTab (BuildCreativeModeTabContentsEvent event){
    }

}
