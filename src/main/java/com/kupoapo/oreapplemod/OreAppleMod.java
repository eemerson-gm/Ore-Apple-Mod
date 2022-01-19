package com.kupoapo.oreapplemod;
import com.kupoapo.oreapplemod.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OreAppleMod.MOD_ID)
public class OreAppleMod
{
    public static final String MOD_ID = "oreapplemod";
    public OreAppleMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
