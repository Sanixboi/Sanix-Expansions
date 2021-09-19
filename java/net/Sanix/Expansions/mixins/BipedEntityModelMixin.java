package net.Sanix.Expansions.mixins;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public class BipedEntityModelMixin<T extends LivingEntity> {

    @Shadow public BipedEntityModel.ArmPose rightArmPose;

    @Shadow public BipedEntityModel.ArmPose leftArmPose;

    @Shadow public ModelPart rightArm;

    @Shadow public ModelPart leftArm;

    @Inject(at = @At("HEAD"), method = "positionRightArm", cancellable = true)
    public void swordblockingright(T livingEntity, CallbackInfo info) {
        if (this.rightArmPose.equals(BipedEntityModel.ArmPose.BLOCK)) {
            if (livingEntity.getMainHandStack().getItem() instanceof SwordItem) {
                this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.7424779F;
                this.rightArm.yaw = 0f;
                info.cancel();
            }
        }

    }

    @Inject(at = @At("HEAD"), method = "positionLeftArm", cancellable = true)
    public void swordblockingleft(T livingEntity, CallbackInfo info) {
        if (this.leftArmPose.equals(BipedEntityModel.ArmPose.BLOCK)) {
            if (livingEntity.getOffHandStack().getItem() instanceof SwordItem) {
                this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.7424779F;
                this.leftArm.yaw = 0f;
                info.cancel();
            }
        }
    }
}
