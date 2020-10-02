package com.otis.spookyStuff;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;

public class Content {
    
  
    public final Block jack_o_lantern_soul;
    
    public Content(RegistryHelper registry) {
		this.jack_o_lantern_soul = registry.blocks.register(new CarvedPumpkinBlock(null), "jack_o_lantern_soul");;
        
          }
    
 
}