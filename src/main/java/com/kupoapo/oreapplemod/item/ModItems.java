package com.kupoapo.oreapplemod.item;

import net.minecraft.item.Item;
import com.kupoapo.oreapplemod.OreAppleMod;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OreAppleMod.MOD_ID);

    public static final RegistryObject<Item> APPLE_COAL = ITEMS.register("apple_coal",
            () -> new AppleItems("apple_coal", Effects.DIG_SPEED, 2400, 0, 1.0f));

    public static final RegistryObject<Item> APPLE_IRON = ITEMS.register("apple_iron",
            () -> new AppleItems("apple_iron", Effects.DAMAGE_RESISTANCE, 600, 0, 1.0f));

    public static final RegistryObject<Item> APPLE_LAPIS = ITEMS.register("apple_lapis",
            () -> new AppleItems("apple_lapis", Effects.MOVEMENT_SPEED, 1200, 0, 1.0f));

    public static final RegistryObject<Item> APPLE_REDSTONE = ITEMS.register("apple_redstone",
            () -> new AppleItems("apple_redstone", Effects.REGENERATION, 100, 0, 1.0f));

    public static final RegistryObject<Item> APPLE_DIAMOND = ITEMS.register("apple_diamond",
            () -> new AppleItems("apple_diamond",
                    new EffectInstance(Effects.REGENERATION, 300, 1),
                        new EffectInstance(Effects.ABSORPTION, 1200, 2),
                            new EffectInstance(Effects.LUCK, 600, 0),
                                new EffectInstance(Effects.DAMAGE_BOOST, 600, 0)));

    public static final RegistryObject<Item> APPLE_EMERALD = ITEMS.register("apple_emerald",
            () -> new AppleItems("apple_emerald", Effects.LUCK, 1200, 0, 1.0f));

    public static final RegistryObject<Item> APPLE_QUARTZ = ITEMS.register("apple_quartz",
            () -> new AppleItems("apple_quartz", Effects.FIRE_RESISTANCE, 2400, 0, 1.0f));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
