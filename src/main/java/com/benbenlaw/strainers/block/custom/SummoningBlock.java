package com.benbenlaw.strainers.block.custom;

import com.benbenlaw.strainers.recipe.NoInventoryRecipe;
import com.benbenlaw.strainers.recipe.SummoningRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Predicate;

public class SummoningBlock extends Block {
    public SummoningBlock(Properties properties) {
        super(properties);
    }



    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide) {

            for (SummoningRecipe summoningRecipe: level.getRecipeManager().getRecipesFor(SummoningRecipe.Type.INSTANCE, NoInventoryRecipe.INSTANCE, level)) {

                String blockBelow = summoningRecipe.getBlockBelow();
                Block blockBelowAsBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(blockBelow));

                if (summoningRecipe.getInputItem().get(0).test(player.getItemInHand(hand))){

                BlockState stateBelow = level.getBlockState(pos.below());
                    if (stateBelow.is(blockBelowAsBlock)) {

                        EntityType<?> entity = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(summoningRecipe.getSummonedMob()));

                        if (entity != null) {
                            Entity summonedEntity = entity.create(level);
                            Entity mob = summonedEntity;
                            mob .setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                            level.addFreshEntity(mob);
                            player.getItemInHand(hand).shrink(1);
                            level.playSound(null,pos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 0.3f, 0.2f);
                        }

                    }

                }

            }



        }



        return super.use(state, level, pos, player, hand, hitResult);
    }

}
