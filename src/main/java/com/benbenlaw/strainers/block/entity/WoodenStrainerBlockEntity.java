package com.benbenlaw.strainers.block.entity;

import com.benbenlaw.strainers.block.custom.IInventoryHandlingBlockEntity;
import com.benbenlaw.strainers.item.ModItems;
import com.benbenlaw.strainers.networking.ModMessages;
import com.benbenlaw.strainers.networking.packets.PacketSyncItemStackToClient;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.screen.WoodenStrainerMenu;
import com.benbenlaw.strainers.util.ModTags;
import com.ibm.icu.util.Output;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class WoodenStrainerBlockEntity extends BlockEntity implements MenuProvider, IInventoryHandlingBlockEntity {

    private final ItemStackHandler itemHandler = new ItemStackHandler(12) {
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
                    Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 3 && i <= 11,
                            (i, s) -> false)),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return !stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return !stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return !stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return !stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })),

                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> {
                                if (index == 1 && itemHandler.isItemValid(1, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                if (index == 2 && itemHandler.isItemValid(2, stack)) {
                                    // Add a condition to check for the specific item you want to allow
                                    return !stack.getTags().anyMatch(ModTags.Items.MESHES::equals);
                                }
                                return false;
                            })));




    public final ContainerData data;
    private int progress = 0;
    private int maxProgress = 80;

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
        return Component.literal("Wooden Strainer");
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
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("wooden_strainer.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick() {

        Level pLevel = this.level;
        BlockPos pPos = this.worldPosition;
        assert pLevel != null;
        BlockState pState = pLevel.getBlockState(pPos);
        WoodenStrainerBlockEntity pBlockEntity = this;


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

    private boolean hasRecipe(WoodenStrainerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<StrainerRecipe> match = level.getRecipeManager()
                .getRecipeFor(StrainerRecipe.Type.INSTANCE, inventory, level);

        match.ifPresent(recipe -> {
            int duration = recipe.getDuration();

            if (entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_DURATION_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_EVERYTHING_UPGRADE.get())){
                maxProgress = (int) (duration * 0.75);
            }
            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_DURATION_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_EVERYTHING_UPGRADE.get())){
                maxProgress = (int) (duration * 0.5);
            }
            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_DURATION_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_EVERYTHING_UPGRADE.get())){
                maxProgress = (int) (duration * 0.25);
            }
            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_DURATION_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_EVERYTHING_UPGRADE.get())){
                maxProgress = 10;
            }

            else maxProgress = duration;
        });

        BlockPos blockPos = entity.worldPosition.above(1);
        BlockState blockAbove = level.getBlockState(blockPos);
        FluidState fluidAbove = level.getFluidState(blockPos);




        if (match.isPresent()) {
            Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(match.get().getFluidAbove()));
            Block blockInRecipe = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(match.get().getBlockAbove()));

            if ((blockAbove.is(blockInRecipe) || match.get().getBlockAbove().isEmpty())
                    && (fluidAbove.is(fluid) || match.get().getFluidAbove().isEmpty())) {
                return match.filter(currentRecipe ->
                        hasMeshItem(entity, currentRecipe)
                                && hasInputItem(entity, currentRecipe)
                                && canStartRecipe(inventory, currentRecipe.getOutput9())
                                && hasDuration(currentRecipe)).isPresent();
            }
        }
        return false;
    }

    private void craftItem(@NotNull WoodenStrainerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        Optional<StrainerRecipe> match = level.getRecipeManager()
                .getRecipeFor(StrainerRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {

            //REMOVE IN ITEM (WITH UPGRADES)

            if (entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_INPUT_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_EVERYTHING_UPGRADE.get()) && Math.random() < 0.25) {
                entity.itemHandler.extractItem(2, 0, false);
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_INPUT_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_EVERYTHING_UPGRADE.get()) && Math.random() < 0.50) {
                entity.itemHandler.extractItem(2, 0, false);
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_INPUT_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_EVERYTHING_UPGRADE.get()) && Math.random() < 0.75) {
                entity.itemHandler.extractItem(2, 0, false);
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_INPUT_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_EVERYTHING_UPGRADE.get())) {
                entity.itemHandler.extractItem(2, 0, false);
            }

            else {
                entity.itemHandler.extractItem(2, 1, false);
            }


            //DAMAGE MESH ITEM (WITH UPGRADES)

            if (entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_MESH_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_EVERYTHING_UPGRADE.get())  && Math.random() < 0.25) {
                if (entity.itemHandler.getStackInSlot(1).hurt(0, RandomSource.create(), null)) {
                    entity.itemHandler.extractItem(1, 1, false);
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_MESH_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_EVERYTHING_UPGRADE.get())  && Math.random() < 0.5) {
                if (entity.itemHandler.getStackInSlot(1).hurt(0, RandomSource.create(), null)) {
                    entity.itemHandler.extractItem(1, 1, false);
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_MESH_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_EVERYTHING_UPGRADE.get())  && Math.random() < 0.75) {
                if (entity.itemHandler.getStackInSlot(1).hurt(0, RandomSource.create(), null)) {
                    entity.itemHandler.extractItem(1, 1, false);
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_MESH_UPGRADE.get()) || entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_EVERYTHING_UPGRADE.get()) ) {
                if (entity.itemHandler.getStackInSlot(1).hurt(0, RandomSource.create(), null)) {
                    entity.itemHandler.extractItem(1, 1, false);
                }
            }

            else if (entity.itemHandler.getStackInSlot(1).hurt(1, RandomSource.create(), null)) {
                entity.itemHandler.extractItem(1, 1, false);
            }

            //OUTPUT CALCULATIONS

            ItemStack[] outputs = new ItemStack[]{
                    match.get().getOutput1(),
                    match.get().getOutput2(),
                    match.get().getOutput3(),
                    match.get().getOutput4(),
                    match.get().getOutput5(),
                    match.get().getOutput6(),
                    match.get().getOutput7(),
                    match.get().getOutput8(),
                    match.get().getOutput9()
            };

            double[] outputChances = new double[]{
                    match.get().getOutputChance1(),
                    match.get().getOutputChance2(),
                    match.get().getOutputChance3(),
                    match.get().getOutputChance4(),
                    match.get().getOutputChance5(),
                    match.get().getOutputChance6(),
                    match.get().getOutputChance7(),
                    match.get().getOutputChance8(),
                    match.get().getOutputChance9()
            };

            if (entity.itemHandler.getStackInSlot(0).is(ModItems.IMPROVED_OUTPUT_UPGRADE.get())) {
                for (int run = 0; run < 2; run++) {
                    for (int outputIndex = 0; outputIndex < outputs.length; outputIndex++) {
                        if (!outputs[outputIndex].isEmpty() && Math.random() < outputChances[outputIndex]) {
                            for (int i = 3; i <= 11; i++) {
                                if (entity.itemHandler.isItemValid(i, outputs[outputIndex].getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(outputs[outputIndex].getItem(), outputs[outputIndex].getCount()), false).isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.STURDY_OUTPUT_UPGRADE.get())) {
                for (int run = 0; run < 3; run++) {
                    for (int outputIndex = 0; outputIndex < outputs.length; outputIndex++) {
                        if (!outputs[outputIndex].isEmpty() && Math.random() < outputChances[outputIndex]) {
                            for (int i = 3; i <= 11; i++) {
                                if (entity.itemHandler.isItemValid(i, outputs[outputIndex].getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(outputs[outputIndex].getItem(), outputs[outputIndex].getCount()), false).isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.REINFORCED_OUTPUT_UPGRADE.get())) {
                for (int run = 0; run < 4; run++) {
                    for (int outputIndex = 0; outputIndex < outputs.length; outputIndex++) {
                        if (!outputs[outputIndex].isEmpty() && Math.random() < outputChances[outputIndex]) {
                            for (int i = 3; i <= 11; i++) {
                                if (entity.itemHandler.isItemValid(i, outputs[outputIndex].getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(outputs[outputIndex].getItem(), outputs[outputIndex].getCount()), false).isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            else if (entity.itemHandler.getStackInSlot(0).is(ModItems.EVERLASTING_OUTPUT_UPGRADE.get())) {
                for (int run = 0; run < 5; run++) {
                    for (int outputIndex = 0; outputIndex < outputs.length; outputIndex++) {
                        if (!outputs[outputIndex].isEmpty() && Math.random() < outputChances[outputIndex]) {
                            for (int i = 3; i <= 11; i++) {
                                if (entity.itemHandler.isItemValid(i, outputs[outputIndex].getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(outputs[outputIndex].getItem(), outputs[outputIndex].getCount()), false).isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            else {
                for (int outputIndex = 0; outputIndex < outputs.length; outputIndex++) {
                    if (!outputs[outputIndex].isEmpty() && Math.random() < outputChances[outputIndex]) {
                        for (int i = 3; i <= 11; i++) {
                            if (entity.itemHandler.isItemValid(i, outputs[outputIndex].getItem().getDefaultInstance()) && entity.itemHandler.insertItem(i, new ItemStack(outputs[outputIndex].getItem(), outputs[outputIndex].getCount()), false).isEmpty()) {
                                break;
                            }
                        }
                    }
                }
            }

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasDuration(StrainerRecipe recipe) {
        return 0 <= recipe.getDuration();
    }

    private boolean hasMeshItem(WoodenStrainerBlockEntity entity, StrainerRecipe recipe) {
        ItemStack[] items = recipe.getIngredients().get(0).getItems();
        ItemStack slotItem = entity.itemHandler.getStackInSlot(1);

        for (ItemStack item : items) {
            if (ItemStack.isSameItem(item, slotItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasInputItem(WoodenStrainerBlockEntity entity, StrainerRecipe recipe) {

        ItemStack[] items = recipe.getIngredients().get(1).getItems();
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

        for (int i = 3; i <= 11; i++) {
            ItemStack itemStack = inventory.getItem(i);

            if (itemStack.isEmpty()) {
                emptySlotCounter++;
            } else if (itemStack.getItem() == stack.getItem()) {
                // Calculate the available space in the slot
                int availableSpace = itemStack.getMaxStackSize() - itemStack.getCount();

                if (availableSpace >= stack.getCount()) {
                    // There's enough space for the entire stack, continue checking other slots
                    continue;
                } else {
                    return false; // Item already present in a slot, recipe should not start
                }
            } else {
                occupiedSlotCounter++;
            }

            // If any slot is full, return false
            if (itemStack.getCount() >= itemStack.getMaxStackSize()) {
                return false;
            }
        }

        // Return false if all slots are occupied or if there are no empty slots
        return occupiedSlotCounter != 9 && emptySlotCounter != 0;
    }




}
