package groupix05.dtcroptopia;

import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.block.rooty.SoilProperties;
import com.ferreusveritas.dynamictrees.init.DTConfigs;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import groupix05.dtcroptopia.init.DTCROPTOPIABlocks;
import groupix05.dtcroptopia.init.DTCROPTOPIAClient;
import groupix05.dtcroptopia.init.DTCROPTOPIARegistries;
import groupix05.dtcroptopia.init.DTCROPTOPIAItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.data.event.GatherDataEvent;

@Mod(DynamicTreesCROPTOPIA.MOD_ID)
@Mod.EventBusSubscriber(modid = DynamicTreesCROPTOPIA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DynamicTreesCROPTOPIA {
    public static final String MOD_ID = "dtcroptopia";

    public DynamicTreesCROPTOPIA() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::gatherData);

        MinecraftForge.EVENT_BUS.register(this);

        RegistryHandler.setup(MOD_ID);

        DTCROPTOPIABlocks.register(bus);
        DTCROPTOPIAItems.register(bus);
        DTCROPTOPIARegistries.setup();
        DTCROPTOPIARegistries.SOUNDS.register(bus);
    }

    private void commonSetup(final FMLConstructModEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        DTCROPTOPIAClient.setup();
    }

    private void gatherData(final GatherDataEvent event) {
        GatherDataHelper.gatherAllData(MOD_ID, event,
                //SoilProperties.REGISTRY,
                Family.REGISTRY,
                Species.REGISTRY,
                LeavesProperties.REGISTRY,
                Fruit.REGISTRY,
                Pod.REGISTRY
        );
    }

    public static ResourceLocation location(final String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
