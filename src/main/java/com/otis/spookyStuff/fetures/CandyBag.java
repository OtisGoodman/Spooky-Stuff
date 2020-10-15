package com.otis.spookyStuff.fetures;

import com.otis.spookyStuff.Content;
import com.otis.spookyStuff.SpookyStuff;
import net.minecraft.client.audio.Sound;
import net.minecraft.command.impl.LootCommand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class CandyBag extends Item {
    public CandyBag(Properties properties) {
        super(properties);
    }
    private ItemStack getCandyFromInt(Integer candy){
        ItemStack ret = null;
        ITextComponent component = TextComponentUtils.toTextComponent(new StringTextComponent("I got a rock :( ").modifyStyle( (style) -> {
            return style.setFormatting(TextFormatting.GRAY);
        }));
        switch (candy){
            case 0: ret = new ItemStack(SpookyStuff.content.candy_c0); break;
            case 1: ret = new ItemStack(SpookyStuff.content.candy_c1); break;
            case 2: ret = new ItemStack(SpookyStuff.content.candy_s0); break;
            case 3: ret = new ItemStack(SpookyStuff.content.candy_s1); break;
            case 4: ret = new ItemStack(SpookyStuff.content.candy_w0); break;
            case 5: ret = new ItemStack(SpookyStuff.content.candy_w1); break;
            case 6: ret = new ItemStack(SpookyStuff.content.candy_w2); break;
            case 7: ret = new ItemStack(Items.APPLE); break;
            case 8: ret = new ItemStack(Items.CLAY_BALL).setDisplayName(component); break;
            case 9: ret = new ItemStack(SpookyStuff.content.dried_pumpkin_seeds); break;
            case 10: ret = new ItemStack(SpookyStuff.content.cb_shard); break;
        }
        return ret;
    }
    private SoundEvent getSoundFromInt(Integer sound){
        SoundEvent ret = null;
        switch (sound){
            case 0: ret = SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST; break;
            case 1: ret = SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR; break;
            case 2: ret = SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE; break;
        }
        return ret;
    }
    private void rollCandy(PlayerEntity player){
        player.getCooldownTracker().setCooldown(this, 40);
        Random rand = new Random();
        Integer count = rand.nextInt(4-1) + 1;
        for (int i = count; i > 0; i--) {
            Integer candyType = rand.nextInt(11);
            player.addItemStackToInventory(getCandyFromInt(candyType));
            player.playSound(getSoundFromInt(rand.nextInt(2)),1f,1.2f);
        }
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (handIn.equals(Hand.MAIN_HAND)) {
            rollCandy(playerIn);
            playerIn.getHeldItem(Hand.MAIN_HAND).shrink(1);
            return new ActionResult<ItemStack>(ActionResultType.CONSUME,playerIn.getHeldItem(Hand.MAIN_HAND));
        }else
        if (handIn.equals(Hand.OFF_HAND)) {
            rollCandy(playerIn);
            playerIn.getHeldItem(Hand.OFF_HAND).shrink(1);
            return new ActionResult<ItemStack>(ActionResultType.CONSUME,playerIn.getHeldItem(Hand.OFF_HAND));
        }
        return null;
    }
}
