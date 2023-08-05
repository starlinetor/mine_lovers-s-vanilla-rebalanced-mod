package net.mine_lovers.vanillarmod.item;

import net.mine_lovers.vanillarmod.VanillaRMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class ArmourEffects {

    //stores the effectes for each armour type and checks if any are present

    HashMap<String, StatusEffect> ArmourEffect = new HashMap<>();

    /* stores if the effect is negative(false) or positive(true),
    negative effects are given with one piece of armour
     positive effects are given with the full armour */
    HashMap<String, Boolean> EffectQuality = new HashMap<>();

    public ArmourEffects(){
        ArmourEffect.put("netherite", StatusEffects.SLOWNESS);
        EffectQuality.put("netherite", false);

        ArmourEffect.put("leather", StatusEffects.SPEED);
        EffectQuality.put("leather",true);

        ArmourEffect.put("studdedleather", StatusEffects.SPEED);
        EffectQuality.put("studdedleather",true);
    }

    public void AddEffects(PlayerEntity player){
        ArmorMaterial[] materials = new ArmorMaterial[4];

        for(int i=0; i<4; i++){
            if(player.getInventory().getArmorStack(i).getItem() instanceof ArmorItem armor){
                materials[i] = armor.getMaterial();
            }else{
                materials[i] = null;
            }
        }

        if(MaterialsMatch(materials) && EffectQuality.get(materials[0].getName())!=null){
            GiveEffect(materials[0], player);
        }else{
            for(int i=0; i<4; i++){
                if(materials[i] != null && EffectQuality.get(materials[i].getName())!=null && !EffectQuality.get(materials[i].getName())){
                    GiveEffect(materials[i],player);
                }
            }
        }
    }


    public void GiveEffect(ArmorMaterial material, PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(ArmourEffect.get(material.getName()), 20, 0);
        player.addStatusEffect(statusEffect);
    }

    public boolean MaterialsMatch(ArmorMaterial[] materials){
        try{
            boolean match = true;

            for(int i = 0; i<3; i++){
                if(!Objects.equals(materials[i].getName(), materials[i + 1].getName())){
                    match = false;
                }
            }

            return match;

        }catch (Exception e){
            return  false;
        }
    }
}
