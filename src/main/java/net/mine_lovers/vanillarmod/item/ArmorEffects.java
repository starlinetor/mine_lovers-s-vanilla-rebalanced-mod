package net.mine_lovers.vanillarmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

//this clas can only handle effects or function that do not need 1 instance to be runned
public class ArmorEffects {

    /* stores if the effect is negative(false) or positive(true),
    negative effects are given with one piece of armour
     positive effects are given with the full armour */
    HashMap<String, Boolean> EffectQuality = new HashMap<>();

    public ArmorEffects(){
        EffectQuality.put("netherite", false);
        EffectQuality.put("leather",true);
        EffectQuality.put("studdedleather",true);
        EffectQuality.put("gold",true);
        EffectQuality.put("dwarvengold",true);
        EffectQuality.put("puredwarvengold",true);
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
            //GiveEffect(materials[0], player)
            CallMethod(materials[0],player);
        }else{
            for(int i=0; i<4; i++){
                if(materials[i] != null && EffectQuality.get(materials[i].getName())!=null && !EffectQuality.get(materials[i].getName())){
                    //GiveEffect(materials[i],player);
                    CallMethod(materials[i],player);

                }
            }
        }

    }


    public void CallMethod(ArmorMaterial material,PlayerEntity player){
        java.lang.reflect.Method method = null;

        try {
            method = getClass().getMethod(material.getName(), PlayerEntity.class);
        } catch (SecurityException | NoSuchMethodException ignored) {
        }

        try {
            method.invoke(this, player);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ignored) {
        }
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

    //function for each armor
    public void netherite(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0);
        player.addStatusEffect(statusEffect);
    }
    public void leather(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.SPEED, 40, 0);
        player.addStatusEffect(statusEffect);
    }
    public void studdedleather(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.SPEED, 40, 0);
        player.addStatusEffect(statusEffect);
    }
    public void gold(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0);
        player.addStatusEffect(statusEffect);
    }
    public void dwarvengold(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0);
        player.addStatusEffect(statusEffect);
        statusEffect = new StatusEffectInstance(StatusEffects.HASTE, 40, 0);
        player.addStatusEffect(statusEffect);
    }
    public void puredwarvengold(PlayerEntity player){
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0);
        player.addStatusEffect(statusEffect);
        statusEffect = new StatusEffectInstance(StatusEffects.HASTE, 40, 0);
        player.addStatusEffect(statusEffect);
        //remove in the future

    }
}
