package com.benbenlaw.strainers.networking.packets;

import com.benbenlaw.strainers.util.IFluidHandlingBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSyncFluidToClient {
    private final FluidStack fluidStack;
    private final BlockPos pos;

    public PacketSyncFluidToClient(FluidStack fluidStack, BlockPos pos) {
        this.fluidStack = fluidStack;
        this.pos = pos;
    }

    public PacketSyncFluidToClient(FriendlyByteBuf buf) {
        this.fluidStack = buf.readFluidStack();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFluidStack(fluidStack);
        buf.writeBlockPos(pos);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            assert Minecraft.getInstance().level != null;
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof IFluidHandlingBlockEntity blockEntity) {
                blockEntity.setFluid(this.fluidStack);
            }
        });
    }
}