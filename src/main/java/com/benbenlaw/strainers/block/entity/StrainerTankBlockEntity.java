package com.benbenlaw.strainers.block.entity;

import com.benbenlaw.strainers.networking.ModMessages;
import com.benbenlaw.strainers.networking.packets.PacketSyncFluidToClient;
import com.benbenlaw.strainers.util.IFluidHandlingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Objects;

public class StrainerTankBlockEntity extends BlockEntity implements IFluidHandlingBlockEntity {

    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    public final FluidTank FLUID_TANK = new FluidTank(1000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            assert level != null;
            if(!level.isClientSide()) {
                ModMessages.sendToClients(new PacketSyncFluidToClient(this.fluid, worldPosition));
            }
        }
    };

    public void setFluid(FluidStack stack) {
        this.FLUID_TANK.setFluid(stack);
    }

    public FluidStack getFluidStack() {
        return this.FLUID_TANK.getFluid();
    }

    public StrainerTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STRAINER_TANK_BLOCK_ENTITY.get(), pos, state);

    }

    /*
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap, side);
    }


     */
    @Override
    public void onLoad() {
        super.onLoad();
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyFluidHandler.invalidate();


    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag = FLUID_TANK.writeToNBT(tag);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        FLUID_TANK.readFromNBT(tag);

    }

    public boolean onPlayerUse(Player player, InteractionHand hand) {
        return FluidUtil.interactWithFluidHandler(player, hand, FLUID_TANK);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }


}
