package groupix05.dtcroptopia.init;

import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import groupix05.dtcroptopia.blocks.BananaSuckerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DTCROPTOPIABlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DynamicTreesCROPTOPIA.MOD_ID);

    public static final RegistryObject<Block> BANANA_SUCKER_BLOCK = registerBlock("banana_sucker", BananaSuckerBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
