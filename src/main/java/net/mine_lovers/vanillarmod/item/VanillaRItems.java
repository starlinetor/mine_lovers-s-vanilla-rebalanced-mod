package net.mine_lovers.vanillarmod.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mine_lovers.vanillarmod.VanillaRMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.*;

public class VanillaRItems {

    //upgrading tools
    public static final Item UPGRADING_TOOLS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "upgrading_tools"),
                    new Item(new FabricItemSettings()));
    //studded-leather armor
    public static final DyeableArmorItem STUDDEDLEATHER_HELMET =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "studdedleather_helmet"),
                    new DyeableArmorItem(ModArmorMaterials.STUDDEDLEATHER, ArmorItem.Type.HELMET , new Item.Settings()));
    public static final DyeableArmorItem STUDDEDLEATHER_CHESTPLATE =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "studdedleather_chestplate"),
                    new DyeableArmorItem(ModArmorMaterials.STUDDEDLEATHER, ArmorItem.Type.CHESTPLATE , new Item.Settings()));
    public static final DyeableArmorItem STUDDEDLEATHER_LEGGINGS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "studdedleather_leggings"),
                    new DyeableArmorItem(ModArmorMaterials.STUDDEDLEATHER, ArmorItem.Type.LEGGINGS , new Item.Settings()));
    public static final DyeableArmorItem STUDDEDLEATHER_BOOTS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "studdedleather_boots"),
                    new DyeableArmorItem(ModArmorMaterials.STUDDEDLEATHER, ArmorItem.Type.BOOTS , new Item.Settings()));


    //dwarven gold armor
    public static final ArmorItem DWARVENGOLD_HELMET =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "dwarvengold_helmet"),
                    new ArmorItem(ModArmorMaterials.DWARVENGOLD, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final ArmorItem DWARVENGOLD_CHESTPLATE =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "dwarvengold_chestplate"),
                    new ArmorItem(ModArmorMaterials.DWARVENGOLD, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final ArmorItem DWARVENGOLD_LEGGINGS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "dwarvengold_leggings"),
                    new ArmorItem(ModArmorMaterials.DWARVENGOLD, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final ArmorItem DWARVENGOLD_BOOTS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "dwarvengold_boots"),
                    new ArmorItem(ModArmorMaterials.DWARVENGOLD, ArmorItem.Type.BOOTS, new Item.Settings()));
    //pure dwarven gold armor
    public static final ArmorItem PUREDWARVENGOLD_HELMET =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "puredwarvengold_helmet"),
                    new ArmorItem(ModArmorMaterials.PUREDWARVENGOLD, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final ArmorItem PUREDWARVENGOLD_CHESTPLATE =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "puredwarvengold_chestplate"),
                    new ArmorItem(ModArmorMaterials.PUREDWARVENGOLD, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final ArmorItem PUREDWARVENGOLD_LEGGINGS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "puredwarvengold_leggings"),
                    new ArmorItem(ModArmorMaterials.PUREDWARVENGOLD, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final ArmorItem PUREDWARVENGOLD_BOOTS =
            Registry.register(ITEM, new Identifier(VanillaRMod.MOD_ID, "puredwarvengold_boots"),
                    new ArmorItem(ModArmorMaterials.PUREDWARVENGOLD, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static void registerItems() {
        VanillaRMod.LOGGER.info("Initializing items");
    }
}
