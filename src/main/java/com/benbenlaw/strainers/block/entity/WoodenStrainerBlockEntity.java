package com.benbenlaw.strainers.block.entity;

import com.benbenlaw.opolisutilities.recipe.UpgradeRecipeUtil;
import com.benbenlaw.opolisutilities.util.inventory.IInventoryHandlingBlockEntity;
import com.benbenlaw.opolisutilities.util.inventory.WrappedHandler;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.networking.ModMessages;
import com.benbenlaw.strainers.networking.packets.PacketSyncItemStackToClient;
import com.benbenlaw.strainers.networking.packets.PacketSyncProgressToClient;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.screen.WoodenStrainerMenu;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public class WoodenStrainerBlockEntity extends BlockEntity implements MenuProvider, IInventoryHandlingBlockEntity {

    private final ItemStackHandler itemHandler = new ItemStackHandler(27) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            assert level != null;
            if (!level.isClientSide()) {
                ModMessages.sendToClients(new PacketSyncItemStackToClient(this, worldPosition));
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(
                    Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (i, s) -> false)),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().noneMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().noneMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().noneMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().noneMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 26,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().noneMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })));

    public final ContainerData data;
    public int progress = 0;
    public int maxProgress = 1000;

    public void setHandler(ItemStackHandler handler) {
        copyHandlerContents(handler);
    }

    private void copyHandlerContents(ItemStackHandler handler) {
        for (int i = 0; i < handler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, handler.getStackInSlot(i));
        }
    }

    public ItemStackHandler getItemStackHandler() {
        return this.itemHandler;
    }

    public WoodenStrainerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.WOODEN_STRAINER_BLOCK_ENTITY.get(), blockPos, blockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> WoodenStrainerBlockEntity.this.progress;
                    case 1 -> WoodenStrainerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> WoodenStrainerBlockEntity.this.progress = value;
                    case 1 -> WoodenStrainerBlockEntity.this.maxProgress = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Strainer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerID, @NotNull Inventory inventory, @NotNull Player player) {
        return new WoodenStrainerMenu(containerID, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return directionWrappedHandlerMap.get(side).cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        for (Direction dir : Direction.values()) {
            if (directionWrappedHandlerMap.containsKey(dir)) {
                directionWrappedHandlerMap.get(dir).invalidate();
            }
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("wooden_strainer.progress", progress);
        tag.putInt("wooden_strainer.maxProgress", maxProgress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("wooden_strainer.progress");
        maxProgress = nbt.getInt("wooden_strainer.maxProgress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    double durationMultiplier = 1.0;
    double outputChance = 0.0;
    int outputRuns = 0;
    double inputMultiplier = 1.0;
    double meshMultiplier = 1.0;
    int meshExtraDamage = 0;
    int inputItemExtraAmount = 0;
    ItemStack upgradeItem = ItemStack.EMPTY;

    public void tick() {

        Level pLevel = this.level;


        assert level != null;
        if (!level.isClientSide) {

        //    ModMessages.sendToClients(new PacketSyncItemStackToClient(itemHandler, worldPosition));
        //    ModMessages.sendToClients(new PacketSyncProgressToClient(progress, maxProgress, worldPosition));

            BlockPos pPos = this.worldPosition;
            BlockState pState = pLevel.getBlockState(pPos);
            WoodenStrainerBlockEntity pBlockEntity = this;

            if (!this.itemHandler.getStackInSlot(0).is(upgradeItem.getItem())) {
                updateUpgrades(pBlockEntity);
            }

            if (this.itemHandler.getStackInSlot(0).isEmpty()) {
                upgradeItem = ItemStack.EMPTY;
                durationMultiplier = 1.0;
                outputChance = 0.0;
                outputRuns = 0;
                inputMultiplier = 1.0;
                meshMultiplier = 1.0;
                meshExtraDamage = 0;
                inputItemExtraAmount = 0;
            }

            if (hasRecipe(pBlockEntity)) {
                pBlockEntity.progress++;
                setChanged(pLevel, pPos, pState);
                if (pBlockEntity.progress > pBlockEntity.maxProgress) {
                    craftItem(pBlockEntity);
                }
            } else {
                pBlockEntity.resetProgress();
                setChanged(pLevel, pPos, pState);
            }
        }

    }

    private boolean hasRecipe(@NotNull WoodenStrainerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<StrainerRecipe> match = level.getRecipeManager()
                .getRecipeFor(StrainerRecipe.Type.INSTANCE, inventory, level);

        List<StrainerRecipe> allRecipes = level.getRecipeManager().getAllRecipesFor(StrainerRecipe.Type.INSTANCE);

        List<StrainerRecipe> matchingRecipes = allRecipes.stream()
                .filter(recipe -> recipe.matches(inventory, level))
                .collect(Collectors.toList());


        BlockPos blockPos = entity.worldPosition.above(1);
        BlockState blockAbove = level.getBlockState(blockPos);
        FluidState fluidAbove = level.getFluidState(blockPos);



        if (!matchingRecipes.isEmpty()) {
            for (StrainerRecipe matching : matchingRecipes) {

                entity.maxProgress = (int) (matching.getDuration() * durationMultiplier); //New Upgrade System

                @Nullable Fluid fluidInRecipe = null;
                if (matching.getBlockAbove().isEmpty()) {
                    fluidInRecipe = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(matching.getFluidAbove()));
                }

                @Nullable Block blockInRecipe = null;
                if (matching.getFluidAbove().isEmpty()) {
                    blockInRecipe = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(matching.getBlockAbove()));
                }


                // Check Block / Fluid
                if (!blockAbove.isAir() || blockAbove.is(blockInRecipe)) {

                    FluidState fluidInTank = null;
                    if (blockAbove.is(ModBlocks.STRAINER_TANK.get())) {
                        fluidInTank = ((StrainerTankBlockEntity) level.getBlockEntity(blockPos)).getFluidStack().getFluid().defaultFluidState();
                    }

                    if (fluidInTank == null) {
                        fluidInTank = fluidAbove;
                    }

                    boolean isFluidMatching = fluidInTank.is(fluidInRecipe) || fluidAbove.is(fluidInRecipe);

                    boolean isBlockMatching = blockAbove.is(blockInRecipe) && (matching.getBlockAbove().isEmpty() && !blockAbove.is(ModBlocks.STRAINER_TANK.get())) && fluidAbove.is(Fluids.EMPTY);

                    boolean isAirBlockRecipe = blockAbove.is(blockInRecipe);

                    if (isFluidMatching || isBlockMatching || isAirBlockRecipe) {
                        return match.filter(currentRecipe ->
                                hasMeshItem(entity, currentRecipe)
                                        && hasInputItem(entity, currentRecipe)
                                        && canStartRecipe(inventory, currentRecipe.getOutput())
                                        && hasCorrectCountInInputUpgrading(entity)
                                        && hasDuration(currentRecipe)).isPresent();
                    }
                }

            }
        }
        return false;
    }

    private void updateUpgrades(@NotNull WoodenStrainerBlockEntity entity) {

        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        List<UpgradeRecipeUtil> upgradeRecipe = level.getRecipeManager().getAllRecipesFor(UpgradeRecipeUtil.Type.INSTANCE);

        List<UpgradeRecipeUtil> matchingUpgradeRecipes = upgradeRecipe.stream()
                .filter(recipe -> recipe.matches(inventory, level))
                .collect(Collectors.toList());

        if (!matchingUpgradeRecipes.isEmpty()) {
            for (UpgradeRecipeUtil matchingUpgrade : matchingUpgradeRecipes) {
                if (itemHandler.getStackInSlot(0).is(matchingUpgrade.getUpgradeItem().getItem())) {
                    durationMultiplier = matchingUpgrade.getDurationMultiplier();
                    outputChance = matchingUpgrade.getOutputIncreaseChance();
                    upgradeItem = matchingUpgrade.getUpgradeItem();
                    outputRuns = matchingUpgrade.getOutputIncreaseAmount();
                    inputMultiplier = matchingUpgrade.getInputItemConsumeChance();
                    meshMultiplier = matchingUpgrade.getMeshUseChance();
                    meshExtraDamage = matchingUpgrade.getMeshExtraDamage();
                    inputItemExtraAmount = matchingUpgrade.getInputItemExtraAmount();
                    break;
                }
            }
        } else {
            outputChance = 0.0;
            upgradeItem = ItemStack.EMPTY;
        }

    }

    private void craftItem(@NotNull WoodenStrainerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        List<StrainerRecipe> allRecipes = level.getRecipeManager().getAllRecipesFor(StrainerRecipe.Type.INSTANCE);

        List<StrainerRecipe> matchingRecipes = allRecipes.stream()
                .filter(recipe -> recipe.matches(inventory, level))
                .collect(Collectors.toList());

        if (!matchingRecipes.isEmpty()) {
            for (StrainerRecipe match : matchingRecipes) {
                Random random = new Random();
                double chance = random.nextDouble();
                int additionalOutputRuns = 0;
                if (chance > outputChance && outputChance != 0.0) {
                    additionalOutputRuns = 1;
                }

                additionalOutputRuns = additionalOutputRuns + outputRuns;

                // Normal output processing
                for (int run = 0; run < (1 + additionalOutputRuns); run++) {
                    Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(match.getFluidAbove()));
                    Block blockInRecipe = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(match.getBlockAbove()));

                    BlockPos blockPos = entity.worldPosition.above(1);
                    BlockState blockAbove = level.getBlockState(blockPos);

                    FluidState fluidAbove = level.getFluidState(blockPos);
                    if (blockAbove.is(ModBlocks.STRAINER_TANK.get())) {
                        fluidAbove = ((StrainerTankBlockEntity) level.getBlockEntity(blockPos)).getFluidStack().getFluid().defaultFluidState();
                    }


                    if ((blockAbove.is(blockInRecipe) || match.getBlockAbove().isEmpty())
                            && (fluidAbove.is(fluid) || match.getFluidAbove().isEmpty())) {

                        int meshTierStrainer = getMeshTierInStrainer(entity, match);
                        int outputBoost = meshTierStrainer - match.getMeshTier();

                        if (!match.getOutput().isEmpty() && Math.random() < match.getOutputChance() + (match.getChanceIncreasePerTier() * outputBoost)) {
                            for (int i = 3; i <= 26; i++) {
                                if (entity.itemHandler.isItemValid(i, match.getOutput().getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(match.getOutput().getItem(), match.getOutput().getCount()), false).isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            // Upgrade Effects

            if (!entity.itemHandler.getStackInSlot(2).isDamageableItem() || entity.itemHandler.getStackInSlot(2).is(ModTags.Items.REMOVE_ITEM_NO_DAMAGE_IN_STRAINER)) {

                if (inputMultiplier != 1.0) {

                    if (Math.random() > inputMultiplier) {
                        entity.itemHandler.extractItem(2, 0, false);
                    } else {
                        entity.itemHandler.extractItem(2, 1 + inputItemExtraAmount, false);
                    }
                }

                else {
                    entity.itemHandler.extractItem(2, 1 + inputItemExtraAmount, false);
                }
            }


            if (entity.itemHandler.getStackInSlot(2).isDamageableItem()) {

                if (inputMultiplier != 1.0) {
                    if (Math.random() > inputMultiplier) {
                        if (entity.itemHandler.getStackInSlot(2).hurt(0, RandomSource.create(), null)) {
                            entity.itemHandler.extractItem(2, 0, false);
                        }
                    } else {
                        if (entity.itemHandler.getStackInSlot(2).hurt(1 + inputItemExtraAmount, RandomSource.create(), null)) {
                            entity.itemHandler.extractItem(2, 1 + inputItemExtraAmount, false);
                        }
                    }
                } else {
                    if (entity.itemHandler.getStackInSlot(2).hurt(1 + inputItemExtraAmount, RandomSource.create(), null)) {
                        entity.itemHandler.extractItem(2, 1 + inputItemExtraAmount, false);
                    }
                }
            }

            if (meshMultiplier != 1.0) {
                if (Math.random() > meshMultiplier) {
                    if (entity.itemHandler.getStackInSlot(1).hurt(0, RandomSource.create(), null)) {
                        entity.itemHandler.extractItem(1, 0, false);
                    } else if (entity.itemHandler.getStackInSlot(1).hurt(1 + meshExtraDamage, RandomSource.create(), null)) {
                        entity.itemHandler.extractItem(1, 1, false);
                    }
                }
            } else if (entity.itemHandler.getStackInSlot(1).hurt(1 + meshExtraDamage, RandomSource.create(), null)) {
                entity.itemHandler.extractItem(1, 1, false);

            }

            entity.resetProgress();

        }
    }

    public void updateProgressValues(WoodenStrainerBlockEntity entity) {

        progress = entity.progress;
        maxProgress = entity.maxProgress;

    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 1000;
    }

    private boolean hasDuration(StrainerRecipe recipe) {
        return 0 <= recipe.getDuration();
    }

    private boolean hasMeshItem(WoodenStrainerBlockEntity entity, StrainerRecipe recipe) {
        ItemStack meshItem = entity.itemHandler.getStackInSlot(1);
        if (recipe.getMeshTier() == 1) {
            return meshItem.is(ModTags.Items.TIER_1_MESHES) || meshItem.is(ModTags.Items.TIER_2_MESHES) || meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        else if (recipe.getMeshTier() == 2) {
            return meshItem.is(ModTags.Items.TIER_2_MESHES) || meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        else if (recipe.getMeshTier() == 3) {
            return meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        else if (recipe.getMeshTier() == 4) {
            return meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        else if (recipe.getMeshTier() == 5) {
            return meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        else if (recipe.getMeshTier() == 6) {
            return meshItem.is(ModTags.Items.TIER_6_MESHES);
        }
        return false;
    }

    public int getMeshTierInStrainer(WoodenStrainerBlockEntity entity, StrainerRecipe recipe) {
        if (hasMeshItem(entity, recipe)) {
            Item meshItem = entity.itemHandler.getStackInSlot(1).getItem();

            if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_6_MESHES)) {
                return 6;
            }
            else if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_5_MESHES)) {
                return 5;
            }
            else if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_4_MESHES)) {
                return 4;
            }
            else if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_3_MESHES)) {
                return 3;
            }
            else if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_2_MESHES)) {
                return 2;
            }
            else if (meshItem.asItem().getDefaultInstance().is(ModTags.Items.TIER_1_MESHES)) {
                return 1;
            }
        }
        return 0;
    }

    private boolean hasInputItem(@NotNull WoodenStrainerBlockEntity entity, @NotNull StrainerRecipe recipe) {

        ItemStack[] items = recipe.getIngredients().get(0).getItems();
        ItemStack slotItem = entity.itemHandler.getStackInSlot(2);

        for (ItemStack item : items) {
            if (ItemStack.isSameItem(item, slotItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean canStartRecipe(SimpleContainer inventory, ItemStack stack) {
        int emptySlotCounter = 0;
        int occupiedSlotCounter = 0;

        for (int i = 3; i <= 26; i++) {
            ItemStack itemStack = inventory.getItem(i);

            if (itemStack.isEmpty()) {
                emptySlotCounter++;
            } else if (itemStack.getItem() == stack.getItem()) {
                int availableSpace = stack.getCount(); // Use the entire stack size

                if (availableSpace > 0) {
                    // There's enough space for the entire stack, continue checking other slots
                    continue;
                } else {
                    return false; // Item already present in a slot, recipe should not start
                }
            } else {
                occupiedSlotCounter++;
            }
        }

        // Return false if all slots are occupied or if there are no empty slots
        return occupiedSlotCounter != 26 && emptySlotCounter != 0;
    }

    private boolean hasCorrectCountInInputUpgrading(WoodenStrainerBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getCount() >= inputItemExtraAmount + 1;
    }
}