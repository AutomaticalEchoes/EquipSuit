package com.equipsuit.equip_suit_v1.common.network;

import com.equipsuit.equip_suit_v1.EquipSuitChange;
import com.equipsuit.equip_suit_v1.common.CommonModEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final ResourceLocation CHANNEL_NAME=new ResourceLocation(EquipSuitChange.MODID,"network");
    private static final String PROTOCOL_VERSION = new ResourceLocation(EquipSuitChange.MODID,"1").toString();
    public static SimpleChannel RegisterPacket(){
        final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(CHANNEL_NAME)
                .clientAcceptedVersions(version -> true)
                .serverAcceptedVersions(version -> true)
                .networkProtocolVersion(()->PROTOCOL_VERSION)
                .simpleChannel();
        CommonModEvents.NetWork=INSTANCE;
        INSTANCE.messageBuilder(OpenSuitInventory.class,0)
                .encoder(OpenSuitInventory::encode)
                .decoder(OpenSuitInventory::decode)
                .consumerMainThread(OpenSuitInventory::onMessage)
                .add();
        INSTANCE.messageBuilder(SuitChange.class,1)
                .encoder(SuitChange::encode)
                .decoder(SuitChange::decode)
                .consumerMainThread(SuitChange::onMessage)
                .add();
        return INSTANCE;
    }
}
