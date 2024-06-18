package com.benbenlaw.strainers.screen.custom;

import com.benbenlaw.opolisutilities.screen.slot.utils.*;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.block.entity.WoodenStrainerBlockEntity;
import com.benbenlaw.strainers.screen.ModMenuTypes;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class WoodenStrainerMenu extends AbstractContainerMenu {
    protected final WoodenStrainerBlockEntity blockEntity;
    protected final Level level;
    protected final ContainerData data;
    protected Player player;
    protected BlockPos blockPos;

    public WoodenStrainerMenu(int containerID, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerID, inventory, extraData.readBlockPos(), new SimpleContainerData(25));
    }

    public WoodenStrainerMenu(int containerID, Inventory inventory, BlockPos blockPos, ContainerData data) {
        super(ModMenuTypes.WOODEN_STRAINER_MENU.get(), containerID);
        this.player = inventory.player;
        this.blockPos = blockPos;
        this.level = inventory.player.level();
        this.blockEntity = (WoodenStrainerBlockEntity) this.level.getBlockEntity(blockPos);
        this.data = data;

        checkContainerSize(inventory, 25);
        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);


        assert blockEntity != null;

        this.addSlot(new BlacklistTagInputSlot(blockEntity.getItemStackHandler(), WoodenStrainerBlockEntity.INPUT_SLOT, 8, 35, ModTags.Items.MESHES, 64)); //Upgrade
        this.addSlot(new WhitelistTagInputSlot(blockEntity.getItemStackHandler(), WoodenStrainerBlockEntity.MESH_SLOT, 8, 17, ModTags.Items.MESHES, 1)); //Mesh

        this.addSlot(new SlotItemHandler(blockEntity.getItemStackHandler(), WoodenStrainerBlockEntity.SPEED_UPGRADE, 17, 55));
        this.addSlot(new SlotItemHandler(blockEntity.getItemStackHandler(), WoodenStrainerBlockEntity.MESH_UPGRADE, 35, 55));
        this.addSlot(new SlotItemHandler(blockEntity.getItemStackHandler(), WoodenStrainerBlockEntity.OUTPUT_UPGRADE, 53, 55));

        //Outputs

        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 5, 80, 9));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 6, 98, 9));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 7, 116, 9));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 8, 134, 9));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 9, 152, 9));

        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 10,80,  27));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 11,98,  27));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 12,116, 27));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 13,134, 27));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 14,152, 27));

        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 15, 80, 45));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 16, 98, 45));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 17, 116, 45));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 18, 134, 45));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 19, 152, 45));

        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 20, 80, 63));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 21, 98, 63));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 22, 116, 63));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 23, 134, 63));
        this.addSlot(new ModResultSlot(blockEntity.getItemStackHandler(), 24, 152, 63));

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0 ;
    }

    public int getScaledProgress() {

        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 20; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 25;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(player.level(), blockPos),
                player, ModBlocks.WOODEN_STRAINER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}
