package groupix05.dtcroptopia.init;

import com.ferreusveritas.dynamictrees.api.applier.ApplierRegistryEvent;
import com.ferreusveritas.dynamictrees.deserialisation.PropertyAppliers;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import com.google.gson.JsonElement;
import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import groupix05.dtcroptopia.trees.FruitLogSpecies;
import groupix05.dtcroptopia.trees.GenOnExtraSoilSpecies;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DynamicTreesCROPTOPIA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class RegisterJSONAppliers {

    @SubscribeEvent
    public static void registerAppliersSpecies(final ApplierRegistryEvent.Reload<Species, JsonElement> event) {
        registerSpeciesAppliers(event.getAppliers());
    }

//    @SubscribeEvent
//    public static void registerAppliersFruit(final ApplierRegistryEvent.Reload<Fruit, JsonElement> event) {
//        registerFruitAppliers(event.getAppliers());
//    }
//
//    @SubscribeEvent
//    public static void registerAppliersPod(final ApplierRegistryEvent.Reload<Pod, JsonElement> event) {
//        registerPodAppliers(event.getAppliers());
//    }

    public static void registerSpeciesAppliers(PropertyAppliers<Species, JsonElement> appliers) {
        appliers.register("extra_soil_for_worldgen", GenOnExtraSoilSpecies.class, Block.class,
                        GenOnExtraSoilSpecies::setExtraSoil)
                .register("log_drop_item", FruitLogSpecies.class, Item.class, FruitLogSpecies::setDropItem)
                //.register("log_drop_item", FruitLogSpecies.class, ResourceLocation.class, FruitLogSpecies::setDropItem)
                .register("log_drop_multiplier", FruitLogSpecies.class, Float.class, FruitLogSpecies::setMultiplier)
                .register("log_drop_fake_log", FruitLogSpecies.class, Item.class, FruitLogSpecies::setFakeLog);
    }

//    public static void registerFruitAppliers(PropertyAppliers<Fruit, JsonElement> appliers) {
//        appliers.register("item_stack", DTCROPTOPIAFruit.class, ResourceLocation.class, DTCROPTOPIAFruit::setItemStackLoc)
//                .register("item_stack", FallingFruit.class, ResourceLocation.class, DTCROPTOPIAFruit::setItemStackLoc)
//                .register("item_stack", OffsetFruit.class, ResourceLocation.class, DTCROPTOPIAFruit::setItemStackLoc);
//    }
//    public static void registerPodAppliers(PropertyAppliers<Pod, JsonElement> appliers) {
//        appliers.register("item_stack", DTCROPTOPIAPod.class, ResourceLocation.class, DTCROPTOPIAPod::setItemStackLoc);
//    }

    @SubscribeEvent public static void registerAppliersSpecies(final ApplierRegistryEvent.GatherData<Species, JsonElement> event) { registerSpeciesAppliers(event.getAppliers()); }
//    @SubscribeEvent public static void registerAppliersFruit(final ApplierRegistryEvent.GatherData<Fruit, JsonElement> event) {
//        registerFruitAppliers(event.getAppliers());
//    }
//    @SubscribeEvent public static void registerAppliersPod(final ApplierRegistryEvent.GatherData<Pod, JsonElement> event) { registerPodAppliers(event.getAppliers()); }

}