package com.otis.spookyStuff.fetures;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class RedstonePumpkin extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public RedstonePumpkin(Properties properties) {
        super(properties);
        BlockState defaultState = this.stateContainer.getBaseState();
        defaultState = defaultState.with(LIT, false);
        defaultState = defaultState.with(FACING, Direction.NORTH);

        this.setDefaultState(defaultState);
    }

    @Override
    public BlockState getStateForPlacement (BlockItemUseContext context) {


        BlockState placedState = super.getStateForPlacement(context);
        assert placedState != null;
        placedState = placedState.with(LIT, context.getWorld().isBlockPowered(context.getPos()));
        placedState = placedState.with(FACING,  context.getPlacementHorizontalFacing().getOpposite());

        return placedState;
    }
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean flag = state.get(LIT);
            if (flag != worldIn.isBlockPowered(pos)) {
                if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                } else {
                    worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
                }
            }

        }
    }
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(LIT) && !worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
        }

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT);
        builder.add(FACING);

    }
}

