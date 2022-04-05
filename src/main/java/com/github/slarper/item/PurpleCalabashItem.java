package com.github.slarper.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import java.util.Objects;
import java.util.Optional;

public class PurpleCalabashItem extends Item {


    public PurpleCalabashItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        // try to reveal mob from nbt
        Optional<Entity> optional = EntityType.getEntityFromNbt(context.getStack().getOrCreateSubNbt(EntityType.ENTITY_TAG_KEY),context.getWorld());
        if (optional.isPresent()){
            Entity entity = optional.get();
            entity.setPosition(context.getHitPos());
            context.getWorld().spawnEntity(entity);
            ItemStack calabash = new ItemStack(AlchemyItems.GOLDEN_CALABASH);
            Objects.requireNonNull(context.getPlayer()).setStackInHand(context.getHand(),calabash);
        }

        return super.useOnBlock(context);
    }
}
