package com.github.slarper.item;

import com.github.slarper.Alchemy;
import com.github.slarper.mixin.ItemAccessor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class AlchemyItems {

    public static void load(){}

    private static Item register(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Alchemy.MODID, id), item);
    }

    public static final Item SAGESTONE;
    public static final Item SULFUR;
    public static final Item MIXED;
    public static final Item NITER;
    public static final Item CALABASH;
    public static final Item GOLDEN_CALABASH;
    public static final Item PURPLE_CALABASH;


    static {
        SAGESTONE = register("sagestone", new SageStoneItem((new FabricItemSettings()).group(ItemGroup.MATERIALS).rarity(Rarity.EPIC)));
        ((ItemAccessor)SAGESTONE).setRecipeRemainder(SAGESTONE);

        SULFUR = register("sulfur", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        MIXED = register("mixed", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        NITER = register("niter", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        CALABASH = register("calabash", new CalabashItem(new FabricItemSettings().group(ItemGroup.MISC)));
        GOLDEN_CALABASH = register("golden_calabash", new GoldenCalabashItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));
        PURPLE_CALABASH = register("purple_calabash", new PurpleCalabashItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));
    }
}
