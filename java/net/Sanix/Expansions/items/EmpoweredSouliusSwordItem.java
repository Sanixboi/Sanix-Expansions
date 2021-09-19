package net.Sanix.Expansions.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class EmpoweredSouliusSwordItem extends AbilitySwordItem {
    public EmpoweredSouliusSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, boolean glinted) {
        super(toolMaterial, attackDamage, attackSpeed, settings, glinted);
    }

    @Override
    public void ability(PlayerEntity user, World world, Hand hand) {
        Direction direction = user.getMovementDirection();
        System.out.println(direction);
        /*-90 pos X
         *90 neg X
         *0 Pos Z
         *180 negZ
        */
        System.out.println("Pitch: " + user.getPitch());
        System.out.println("Head Yaw: " + user.getHeadYaw());
        System.out.println("Sin Head Yaw: " + Math.sin(Math.floor(user.getHeadYaw())));
        System.out.println("Cos head Yaw: " + Math.cos(Math.floor(user.getHeadYaw())));

        //user.addVelocity(Math.asin(Math.floor(user.getHeadYaw())), 0, Math.cos(Math.floor(user.getHeadYaw())));


        if(user.isOnGround()) {
            if (direction.getAxis().equals(Direction.Axis.X)) {
                if(direction.equals(Direction.EAST)) {
                    user.addVelocity(2, 0, 0);
                } else {
                    user.addVelocity(-2, 0, 0);
                }
            } else if (direction.getAxis().equals(Direction.Axis.Z)) {
                if(direction.equals(Direction.NORTH)) {
                    user.addVelocity(0, 0, -2);
                } else {
                    user.addVelocity(0, 0, 2);
                }
            }
        }

    }
}
