package net.Sanix.Expansions.items;

import net.Sanix.Expansions.Toolbase.normal.BlockingSwordBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AbilitySwordItem extends BlockingSwordBase {

    public AbilitySwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, boolean glinted) {
        super(toolMaterial, attackDamage, attackSpeed, settings, glinted);
    }

    public void ability(PlayerEntity user, World world, Hand hand){}


}
