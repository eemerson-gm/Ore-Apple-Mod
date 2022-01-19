package com.kupoapo.oreapplemod.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.apache.commons.lang3.SerializationUtils;
import org.jline.utils.Log;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleItems extends Item {

    private String appleName;
    private ArrayList<EffectInstance> appleEffects = new ArrayList<EffectInstance>();

    public AppleItems(String name, EffectInstance... effects){
        super(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(4).saturationMod(2.4f).alwaysEat().build()));
        appleEffects.addAll(Arrays.asList(effects));
        appleName = name;
    }

    public AppleItems(String name, Effect effect, int duration, int power, float probability) {
        super(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(4).saturationMod(2.4f).effect(
                () -> new EffectInstance(effect, duration, power), probability).alwaysEat().build()));
        appleName = name;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag flag) {
        tooltips.add(new TranslationTextComponent("tooltip.oreapplemod." + appleName));
        if(!appleEffects.isEmpty()){
            for(int e = 0; e < appleEffects.size() - 1; e++){
                tooltips.add(new TranslationTextComponent("tooltip.oreapplemod." + appleName + (e + 2)));
            }
        }
    }

    @Override
    public void onUseTick(World world, LivingEntity player, ItemStack stack, int tick) {
        if(tick == 1){
            if(!appleEffects.isEmpty()){
                for(EffectInstance e : appleEffects){
                    EffectInstance t = new EffectInstance(e);
                    player.addEffect(t);
                }
            }
        }
    }
}
