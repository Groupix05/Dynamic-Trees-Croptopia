package groupix05.dtcroptopia.init;

import com.ferreusveritas.dynamictrees.api.registry.TypeRegistryEvent;
import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.init.DTRegistries;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import com.ferreusveritas.dynamictrees.util.CommonVoxelShapes;
import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import groupix05.dtcroptopia.blocks.DragonFruitLeavesProperties;
import groupix05.dtcroptopia.fruits.*;
import groupix05.dtcroptopia.genfeatures.DTCROPTOPIAGenFeatures;
import groupix05.dtcroptopia.trees.FruitLogSpecies;
import groupix05.dtcroptopia.trees.GenOnExtraSoilSpecies;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class DTCROPTOPIARegistries {

    public static final TagKey<Block> CAN_BE_SPILED = BlockTags.create(DynamicTreesCROPTOPIA.location("can_be_spiled"));

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DynamicTreesCROPTOPIA.MOD_ID);

    public static final RegistryObject<SoundEvent> FRUIT_BONK = registerSound("falling_fruit.bonk");

    public static final VoxelShape DRAGON_FRUIT_CACTUS_SAPLING_SHAPE = Shapes.box(
                    0.375f, 0.0f, 0.375f,
                    0.625f, 0.5f, 0.625f);

    public static final VoxelShape BANANA_SAPLING_SHAPE = Shapes.box(
                    0.375f, 0.0f, 0.375f,
                    0.625f, 0.9375f, 0.625f);

    public static void setup() {
        CommonVoxelShapes.SHAPES.put(DynamicTreesCROPTOPIA.location("dragon_fruit_cactus").toString(), DRAGON_FRUIT_CACTUS_SAPLING_SHAPE);
        CommonVoxelShapes.SHAPES.put(DynamicTreesCROPTOPIA.location("banana_sapling").toString(), BANANA_SAPLING_SHAPE);

    }

    public static RegistryObject<SoundEvent> registerSound (String name){
        return SOUNDS.register(name, ()-> SoundEvent.createVariableRangeEvent(DynamicTreesCROPTOPIA.location(name)));
    }

    @SubscribeEvent
    public static void registerFruitType(final TypeRegistryEvent<Fruit> event) {
        event.registerType(DynamicTreesCROPTOPIA.location("offset_down"), OffsetFruit.TYPE);
        event.registerType(DynamicTreesCROPTOPIA.location("falling_fruit"), FallingFruit.TYPE);
    }

    @SubscribeEvent
    public static void registerPodType(final TypeRegistryEvent<Pod> event) {
        event.registerType(DynamicTreesCROPTOPIA.location("palm"), PalmPod.TYPE);
        event.registerType(DynamicTreesCROPTOPIA.location("falling_palm"), FallingPalmPod.TYPE);
    }

    @SubscribeEvent
    public static void registerLeavesPropertiesType(final TypeRegistryEvent<LeavesProperties> event) {
        event.registerType(DynamicTreesCROPTOPIA.location("dragon_fruit"), DragonFruitLeavesProperties.TYPE);
    }

    @SubscribeEvent
    public static void registerSpeciesType(final TypeRegistryEvent<Species> event) {
        event.registerType(DynamicTreesCROPTOPIA.location("fruit_log"), FruitLogSpecies.TYPE);
        event.registerType(DynamicTreesCROPTOPIA.location("generates_on_extra_soil"), GenOnExtraSoilSpecies.TYPE);
    }

    @SubscribeEvent
    public static void onGenFeatureRegistry (final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<GenFeature> event) {
        DTCROPTOPIAGenFeatures.register(event.getRegistry());
    }

    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        if (event.getTabKey() == DTRegistries.DT_CREATIVE_TAB.getKey()) {
            DTCROPTOPIAItems.acceptToDynamicTreesTab(event);
        }
    }

}
