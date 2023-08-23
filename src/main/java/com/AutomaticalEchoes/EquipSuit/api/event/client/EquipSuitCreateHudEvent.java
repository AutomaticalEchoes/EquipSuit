package com.AutomaticalEchoes.EquipSuit.api.event.client;

import com.AutomaticalEchoes.EquipSuit.api.modInterfcae.gui.EquipSuitHudInterface;
import com.AutomaticalEchoes.EquipSuit.client.gui.EquipSuitHud;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.eventbus.api.Event;

import java.util.Optional;

public class EquipSuitCreateHudEvent extends Event {
    Optional<EquipSuitHudInterface> equipSuitHUD;
    //    client level
    public EquipSuitCreateHudEvent(GuiGraphics guiGraphics){
        equipSuitHUD = Optional.of( EquipSuitHud.Create(guiGraphics));
    }

    public Optional<EquipSuitHudInterface> getEquipSuitHUD() {
        return equipSuitHUD;
    }

    public void setEquipSuitHUD(Optional<EquipSuitHudInterface> equipSuitHUD) {
        this.equipSuitHUD = equipSuitHUD;
    }
}
