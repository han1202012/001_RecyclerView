package kim.hsl.recyclerview;

import android.graphics.Canvas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class Callback extends ItemTouchHelper.Callback {

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int fromPos, @NonNull RecyclerView.ViewHolder target, int toPos, int x, int y) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
    }

    /**
     * 设置上下左右动作
     * 只有在此处打开了指定方向的设置 , 才可以应用具体方向的拖动
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        // 设置拖动方向, 此处设置上下拖动事件
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // 设置滑动方向, 此处设置左右侧滑事件
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        // 应用 拖动 和 滑动 设置
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /**
     * 监听滑动事件
     * 滑动分 水平 / 垂直 两个方向
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    /**
     * 用户滑动距离, 设置的是比例值, 返回值为 0.2 , 就意味着滑动宽高的 1/5
     * @param viewHolder
     * @return
     */
    @Override
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return 0.2f;
    }

    /**
     * 滑动消失距离, 小于该值不消失, 大于该值消失
     * @param defaultValue
     * @return
     */
    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 10f;
    }

    /**
     * 手指离开后的动画持续时间
     * @param recyclerView
     * @param animationType
     * @param animateDx
     * @param animateDy
     * @return
     */
    @Override
    public long getAnimationDuration(@NonNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 200L;
    }

    /**
     * 滑动时的回调操作
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        // 滑动指定的距离, 达到一定幅度后, 就会触发该方法回调
        // 这里做的是滑动删除功能, 直接删除滑动项
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
