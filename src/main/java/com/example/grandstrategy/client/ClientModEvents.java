package com.example.grandstrategy.client;

import com.example.grandstrategy.GrandStrategyMod;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

/** Client-only registration for the mod's remappable key binding. */
@Mod.EventBusSubscriber(
        modid = GrandStrategyMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public final class ClientModEvents {
    public static final KeyBinding OPEN_REALM_OVERVIEW = new KeyBinding(
            "key.grandstrategy.open_realm_overview",
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_M,
            "key.categories.grandstrategy"
    );

    private ClientModEvents() {
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        // ClientRegistry registration belongs to FMLClientSetupEvent in Forge 1.16.5.
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(OPEN_REALM_OVERVIEW));
    }
}
