package net.mine_lovers.vanillarmod.item;

import net.mine_lovers.vanillarmod.VanillaRMod;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

//this file handles calls that need 1 instance but are not effects, effects are handled using mixins and not on the client

public class ArmorEffectsClient {

    /* stores if the effect is negative(false) or positive(true),
    negative effects are given with one piece of armour
     positive effects are given with the full armour */
    HashMap<String, Boolean> EffectQuality = new HashMap<>();

    public ItemStack oldSelectedItem;

    public ArmorEffectsClient(){
        EffectQuality.put("puredwarvengold",true);
        oldSelectedItem = new ItemStack(Items.AIR);
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
    public void puredwarvengold(PlayerEntity player){

        ItemStack selectedItem = player.getInventory().getMainHandStack();




        if(!ItemStack.areEqual(selectedItem, oldSelectedItem)){

            VanillaRMod.LOGGER.info("Current "+ selectedItem);
            VanillaRMod.LOGGER.info("Old "+ oldSelectedItem);

            //remove enchant
            //this code first finds the level of fortune, iterates to find all the
            // fortune and remove them, then it creates a new fortune with minus one level
            try {
                int fortuneLevel = EnchantmentHelper.getLevel(Enchantments.FORTUNE, oldSelectedItem);

                NbtCompound compound = oldSelectedItem.getNbt();
                assert compound != null;
                NbtElement element = compound.get("Enchantments");

                if (element != null) {
                    NbtList enchantmentsList = (NbtList) element;
                    for (int i = enchantmentsList.size() - 1; i >= 0; i--) {
                        NbtCompound enchantmentCompound = enchantmentsList.getCompound(i);
                        if (Objects.equals(enchantmentCompound.getString("id"), "minecraft:fortune")) {
                            enchantmentsList.remove(i);
                        }
                    }
                }

                oldSelectedItem.addEnchantment(Enchantments.FORTUNE, fortuneLevel - 1);
            }catch(Exception e){
                VanillaRMod.LOGGER.info("Error while removing enchant :"+ e);
            }

            //add enchant
            //it works the same but adds 1
            try {
                int fortuneLevel = EnchantmentHelper.getLevel(Enchantments.FORTUNE, selectedItem);

                NbtCompound compound = selectedItem.getNbt();
                assert compound != null;
                NbtElement element = compound.get("Enchantments");

                if (element != null) {
                    NbtList enchantmentsList = (NbtList) element;
                    for (int i = enchantmentsList.size() - 1; i >= 0; i--) {
                        NbtCompound enchantmentCompound = enchantmentsList.getCompound(i);
                        if (Objects.equals(enchantmentCompound.getString("id"), "minecraft:fortune")) {
                            enchantmentsList.remove(i);
                        }
                    }
                }

                selectedItem.addEnchantment(Enchantments.FORTUNE, fortuneLevel + 1);
            }catch(Exception e){
                VanillaRMod.LOGGER.info("Error while adding enchant :"+ e);
            }
            //update reference
            oldSelectedItem = selectedItem;
        }

    }

}
