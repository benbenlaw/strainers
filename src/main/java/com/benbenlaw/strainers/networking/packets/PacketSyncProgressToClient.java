package com.benbenlaw.strainers.networking.packets;

import com.benbenlaw.opolisutilities.util.inventory.IInventoryHandlingBlockEntity;
import com.benbenlaw.strainers.block.entity.WoodenStrainerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSyncProgressToClient {
    private final int progress;
    private final int maxProgress;
    private final BlockPos pos;

    public PacketSyncProgressToClient(int progress, int maxProgress, BlockPos pos) {
        this.progress = progress;
        this.maxProgress = maxProgress;
        this.pos = pos;
    }

    public PacketSyncProgressToClient(FriendlyByteBuf buf) {
        this.progress = buf.readInt();
        this.maxProgress = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(progress);
        buf.writeInt(maxProgress);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {

                if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof WoodenStrainerBlockEntity blockEntity) {
                    blockEntity.progress = progress;
                    blockEntity.maxProgress = maxProgress;

                    // Logging the received progress values
               //     System.out.println("Received progress: " + progress);
                //    System.out.println("Received maxProgress: " + maxProgress);
                }


        });
        return true;
    }

    /*
    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT YES
            assert Minecraft.getInstance().level != null;
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof IInventoryHandlingBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
        });
        return true;
    }

     */
}