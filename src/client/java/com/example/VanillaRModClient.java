package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mine_lovers.vanillarmod.item.ArmorEffectsClient;
import net.mine_lovers.vanillarmod.item.VanillaRItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class VanillaRModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		//studded leather armour color provider
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {

			if(tintIndex == 0) {

				if(stack.getNbt().getCompound("display").getInt("color")==0){
					return 10511680;
				}else{
					return stack.getNbt().getCompound("display").getInt("color");
				}
			}
			return -1;
		}, VanillaRItems.STUDDEDLEATHER_HELMET);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {

			if(tintIndex == 0) {

				if(stack.getNbt().getCompound("display").getInt("color")==0){
					return 10511680;
				}else{
					return stack.getNbt().getCompound("display").getInt("color");
				}
			}
			return -1;
		}, VanillaRItems.STUDDEDLEATHER_CHESTPLATE);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {

			if(tintIndex == 0) {

				if(stack.getNbt().getCompound("display").getInt("color")==0){
					return 10511680;
				}else{
					return stack.getNbt().getCompound("display").getInt("color");
				}
			}
			return -1;
		}, VanillaRItems.STUDDEDLEATHER_LEGGINGS);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {

			if(tintIndex == 0) {

				if(stack.getNbt().getCompound("display").getInt("color")==0){
					return 10511680;
				}else{
					return stack.getNbt().getCompound("display").getInt("color");
				}
			}
			return -1;
		}, VanillaRItems.STUDDEDLEATHER_BOOTS);


		//get 1 reference of armour effects and run it every tick
		ArmorEffectsClient armorEffectsClient = new ArmorEffectsClient();

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			PlayerEntity player = MinecraftClient.getInstance().player;
			if (player != null) {
				armorEffectsClient.AddEffects(player);
			}
		});
	}
}