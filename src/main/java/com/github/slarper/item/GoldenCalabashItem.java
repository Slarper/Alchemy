package com.github.slarper.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GoldenCalabashItem extends Item {
    public GoldenCalabashItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        // Only catch passive
        if (!(entity instanceof AnimalEntity)) {
            return ActionResult.PASS;
        }
        // delete the mob
        entity.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
        // give user a new calabash with mob
        ItemStack calabash = new ItemStack(AlchemyItems.PURPLE_CALABASH);
        entity.saveSelfNbt(calabash.getOrCreateSubNbt(EntityType.ENTITY_TAG_KEY));
        user.setStackInHand(hand,calabash);

        return super.useOnEntity(stack, user, entity, hand);
    }
}
