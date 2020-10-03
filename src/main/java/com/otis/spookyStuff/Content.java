package com.otis.spookyStuff;

import java.util.function.Supplier;

import com.mojang.datafixers.types.Type;

import com.otis.spookyStuff.fetures.RedstonePumpkin;
import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;

public class Content {
    
  
    public final Block jack_o_lantern_soul;
    public final Item dried_pumpkin_seeds;
    public final Block jack_o_lantern_redstone;


    public Content(RegistryHelper registry) {
		this.jack_o_lantern_soul = registry.blocks.register(new CarvedPumpkinBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).setLightLevel((state) -> {
		      return 15;
		   })), "jack_o_lantern_soul");
        this.jack_o_lantern_redstone = registry.blocks.register(new RedstonePumpkin(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).setLightLevel(com.otis.spookyStuff.Util.getLightValueLit(15))), "jack_o_lantern_redstone");




		 Food.Builder dried_pumpkin_seedsBuilder = new Food.Builder().fastToEat().hunger(3).saturation(0.06f);
		this.dried_pumpkin_seeds = registry.items.register(new Item(new Item.Properties().food(dried_pumpkin_seedsBuilder.build())),"dried_pumpkin_seeds");

    }
    
    
    
    @Deprecated 
    private static <T extends TileEntity> TileEntityType<T> register (String key, Supplier<? extends T> factoryIn, Block... validBlocks) {
        
        final Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, "spookystuff:" + key);
        final TileEntityType.Builder<T> builder = TileEntityType.Builder.create(factoryIn, validBlocks);
        final TileEntityType<T> tileType = builder.build(type);
        tileType.setRegistryName("spookystuff", key);
        return tileType;
    }
 
}