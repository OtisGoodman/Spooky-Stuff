package com.otis.spookyStuff.fetures;

import com.otis.spookyStuff.SpookyStuff;
import com.otis.spookyStuff.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

public class SpookyGuide extends Item{

    public SpookyGuide(Properties properties) {
        super(properties);
    }
    private void openDocs(PlayerEntity playerIn){
        Util.openWebpage("https://otisgoodman.github.io/Spooky-Stuff/wiki");
        final ITextComponent component = TextComponentUtils.wrapWithSquareBrackets(new StringTextComponent("A pumpkin has opened the spooky stuff website for you!").modifyStyle( (style) -> {
            return style.setFormatting(TextFormatting.DARK_PURPLE);
        }));
        }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (handIn.equals(Hand.MAIN_HAND)) {
            openDocs(playerIn);
            return new ActionResult<ItemStack>(ActionResultType.PASS,playerIn.getHeldItem(Hand.MAIN_HAND));
        }else
        if (handIn.equals(Hand.OFF_HAND)) {
            openDocs(playerIn);
            return new ActionResult<ItemStack>(ActionResultType.PASS,playerIn.getHeldItem(Hand.OFF_HAND));
        }
        return null;
    }
}

