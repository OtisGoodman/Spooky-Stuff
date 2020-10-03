package com.otis.spookyStuff;

import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;

import java.util.function.ToIntFunction;

public class Util {
    public static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
}
