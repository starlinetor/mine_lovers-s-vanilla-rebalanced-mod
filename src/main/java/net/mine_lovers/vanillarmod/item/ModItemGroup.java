package net.mine_lovers.vanillarmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mine_lovers.vanillarmod.VanillaRMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VanillaRItems.UPGRADING_TOOLS))
            .displayName(Text.translatable("VanillaRMod Items"))
            .entries((displayContext, entries) -> {
                entries.add(VanillaRItems.UPGRADING_TOOLS);
            })
            .build();
    private static final ItemGroup ARMOR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VanillaRItems.STUDDEDLEATHER_HELMET))
            .displayName(Text.translatable("VanillaRMod Armors"))
            .entries((displayContext, entries) -> {
                entries.add(VanillaRItems.STUDDEDLEATHER_HELMET);
                entries.add(VanillaRItems.STUDDEDLEATHER_CHESTPLATE);
                entries.add(VanillaRItems.STUDDEDLEATHER_LEGGINGS);
                entries.add(VanillaRItems.STUDDEDLEATHER_BOOTS);
                entries.add(VanillaRItems.DWARVENGOLD_HELMET);
                entries.add(VanillaRItems.DWARVENGOLD_CHESTPLATE);
                entries.add(VanillaRItems.DWARVENGOLD_LEGGINGS);
                entries.add(VanillaRItems.DWARVENGOLD_BOOTS);
                entries.add(VanillaRItems.PUREDWARVENGOLD_HELMET);
                entries.add(VanillaRItems.PUREDWARVENGOLD_CHESTPLATE);
                entries.add(VanillaRItems.PUREDWARVENGOLD_LEGGINGS);
                entries.add(VanillaRItems.PUREDWARVENGOLD_BOOTS);
            })
            .build();


    public static void registerGroups(){

        Registry.register(Registries.ITEM_GROUP, new Identifier("vanillarmod", "item_group"), ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier("vanillarmod", "armor_group"), ARMOR_GROUP);

        VanillaRMod.LOGGER.info("Initializing groups");
    }

}
