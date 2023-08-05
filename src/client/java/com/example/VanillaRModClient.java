package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mine_lovers.vanillarmod.item.VanillaRItems;

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
	}
}