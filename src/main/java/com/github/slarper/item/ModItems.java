package com.github.slarper.item;

import com.github.slarper.Alchemy;
import com.github.slarper.mixin.ItemAccessor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static void load(){}

    private static Item register(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Alchemy.MODID, id), item);
    }

    public static final Item SAGESTONE;
    public static final Item SULFUR;

    static {
        SAGESTONE = register("sagestone", new SageStoneItem((new FabricItemSettings()).group(ItemGroup.MATERIALS)));
        ((ItemAccessor)SAGESTONE).setRecipeRemainder(SAGESTONE);

        SULFUR = register("sulfur", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    }
}
