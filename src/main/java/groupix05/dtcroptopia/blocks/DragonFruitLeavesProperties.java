package groupix05.dtcroptopia.blocks;

import com.ferreusveritas.dynamictrees.api.registry.TypedRegistry;
import com.ferreusveritas.dynamictrees.block.leaves.DynamicLeavesBlock;
import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.block.leaves.PalmLeavesProperties;
import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nonnull;

public class DragonFruitLeavesProperties extends PalmLeavesProperties {

    public static final TypedRegistry.EntryType<LeavesProperties> TYPE = TypedRegistry.newType(DragonFruitLeavesProperties::new);

    public DragonFruitLeavesProperties(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public MapColor getDefaultMapColor() {
        return MapColor.PLANT;
    }

    @Override
    @Nonnull
    protected DynamicLeavesBlock createDynamicLeaves(@Nonnull BlockBehaviour.Properties properties) {
        return new DynamicDragonfruitLeavesBlock(this, properties);
    }

    public static class DynamicDragonfruitLeavesBlock extends DynamicPalmLeavesBlock {

        public DynamicDragonfruitLeavesBlock(LeavesProperties leavesProperties, Properties properties) {
            super(leavesProperties, properties.strength(0.4F).sound(SoundType.WOOL));
        }

        private static final double hurtMovementDelta = 0.003;
        @Override
        public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity) {
            boolean damage = false;

            if (damage) entity.hurt(worldIn.damageSources().cactus(), 1.0F);
        }


    }

}
