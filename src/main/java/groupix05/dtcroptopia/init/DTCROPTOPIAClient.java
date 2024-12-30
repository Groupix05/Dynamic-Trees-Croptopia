package groupix05.dtcroptopia.init;

import com.ferreusveritas.dynamictrees.api.client.ModelHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DTCROPTOPIAClient {

    public static void setup (){
        registerRenderLayers();
        registerColorHandlers();

    }

    private static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(DTCROPTOPIABlocks.BANANA_SUCKER_BLOCK.get(), RenderType.cutout());
    }

    private static void registerColorHandlers() {

        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        final ItemColors itemColors = Minecraft.getInstance().getItemColors();


    }

}
