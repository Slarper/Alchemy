package com.github.slarper.item;

import com.github.slarper.Alchemy;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AlchemyItems {

    public static void load(){}

    private static Item register(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier("slarper_alchemy", id), item);
    }

    public static final Item SAGE_STONE;

    static {
        SAGE_STONE = register("sagestone", new SageStoneItem((new FabricItemSettings()).group(ItemGroup.MATERIALS)));
    }
}
