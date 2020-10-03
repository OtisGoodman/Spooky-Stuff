package com.otis.spookyStuff;

import java.util.ArrayList;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ContentClient extends Content {
    
	
    public ContentClient(RegistryHelper registry) {
        
        super(registry);
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, this::addTooltips);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

    }
    
    private void addTooltips (ItemTooltipEvent event) {
        final ItemStack stack = event.getItemStack();
        
        if (!stack.isEmpty() && stack.getItem() != null) {
            
            final ResourceLocation id = stack.getItem().getRegistryName();
            
            if (id != null && "spookystuff".equals(id.getNamespace())) {
                
                event.getToolTip().add(new TranslationTextComponent("tooltip.spookystuff." + id.getPath()).mergeStyle(TextFormatting.GRAY));
            }
        }
    }
    
    private void onClientSetup (FMLClientSetupEvent event) {
        
     
    }
}