package com.otis.spookyStuff;

import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.state.properties.BlockStateProperties;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.function.ToIntFunction;

public class Util {
    public static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
    public static void openWebPage(String url) {
        try {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(url));
            }
            throw new NullPointerException();
        } catch (Exception e) {
            SpookyStuff.LOG.error(e.getMessage());
        }
    }
    public enum cursedBone implements IItemTier{
        CURSED_BONE;

        @Override
        public int getMaxUses() {
            return 32;
        }

        @Override
        public float getEfficiency() {
            return 7.0f;
        }

        @Override
        public float getAttackDamage() {
            return 2.0f;
        }

        @Override
        public int getHarvestLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 22;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(SpookyStuff.content.cb_shard);
        }
    }
    }


