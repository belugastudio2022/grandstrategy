package com.example.grandstrategy.client;

import com.example.grandstrategy.GrandStrategyMod;
import com.example.grandstrategy.client.gui.RealmOverviewScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Handles key presses on the client thread. */
@Mod.EventBusSubscriber(
        modid = GrandStrategyMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE,
        value = Dist.CLIENT
)
public final class ClientTickHandler {
    private ClientTickHandler() {
    }

    @SubscribeEvent
    public static void onClientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        final Minecraft minecraft = Minecraft.getInstance();

        // isPressed() consumes one queued key press in the 1.16.5 MCP snapshot mappings.
        while (ClientModEvents.OPEN_REALM_OVERVIEW.isPressed()) {
            // Only open the management screen while a player is in a loaded world.
            // Do not replace another screen (inventory, chat, pause menu, etc.).
            if (minecraft.player != null
                    && minecraft.world != null
                    && minecraft.currentScreen == null) {
                minecraft.displayGuiScreen(new RealmOverviewScreen());
            }
        }
    }
}
