package net.mine_lovers.vanillarmod.mixin;

import net.mine_lovers.vanillarmod.VanillaRMod;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.mine_lovers.vanillarmod.item.ArmourEffects;

@Mixin(PlayerEntity.class)
public abstract class PlayerTickEventMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onPlayerTick(CallbackInfo info) {
        // Get the player instance
        PlayerEntity player = (PlayerEntity)(Object)this;
        ArmourEffects armourEffects = new ArmourEffects();
        armourEffects.AddEffects(player);
        VanillaRMod.LOGGER.info("Called Player Tick Event");
    }
}
