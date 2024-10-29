package com.benbenlaw.strainers.event;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.block.custom.StrainerTankBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

//@EventBusSubscriber(modid = Strainers.MOD_ID)
public class ModEvents {


    /*
    public static Fluid targetedFluid;

    //Horrible way of setting fluid kinda works but HORRIBLE
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = event.getEntity().level();

        ItemStack itemStack = player.getMainHandItem();
        if (itemStack.is(ModBlocks.STRAINER_TANK.asItem())) {

            double reachDistance = 5.0;

            Vec3 eyePosition = player.getEyePosition(1.0F);
            Vec3 lookDirection = player.getLookAngle().scale(reachDistance);

            HitResult hitResult = level.clip(new ClipContext(
                    eyePosition,
                    eyePosition.add(lookDirection),
                    ClipContext.Block.OUTLINE,
                    ClipContext.Fluid.ANY,
                    player
            ));

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockPos blockPos = blockHitResult.getBlockPos();
                BlockState blockState = level.getBlockState(blockPos);

                if (!blockState.getFluidState().isEmpty() ) {
                    Fluid fluid = blockState.getFluidState().getType();

                    if (blockState.getFluidState().isSourceOfType(fluid)) {
                        targetedFluid = fluid;
                    }
                }
            }
        }


    }

     */


}
