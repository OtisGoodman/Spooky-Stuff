package com.otis.spookyStuff;

import net.minecraft.block.BlockState;
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
    }


