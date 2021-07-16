package kim.hsl.recyclerview;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class Callback extends ItemTouchHelper.Callback {

    private static final String TAG = "Callback";

    private MainActivity.Adapter mAdapter;

    public Callback(MainActivity.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    /**
     * 设置上下左右动作
     * 只有在此处打开了指定方向的设置 , 才可以应用具体方向的拖动
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        // 设置拖动方向, 此处设置上下拖动事件
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // 设置滑动方向, 此处设置左右侧滑事件
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        // 应用 拖动 和 滑动 设置
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /*
        以下是拖动相关方法
     */

    /**
     * 是否启用长按拖动功能
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * 拖动幅度设置
     * 组件在宽度 / 高度 上移动超过该比例 , 就认为拖动触发, 执行拖动相关操作
     * @param viewHolder
     * @return
     */
    @Override
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        // 该案例中, 拖动操作只能上下进行
        // 拖动超过条目组件高度超过 0.9 倍, 即可触发拖动操作
        return 0.9f;
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
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder target) {
        // 拖动后交换数据, 该方法中交换 Adapter 中的数据, 并刷新界面
        Log.i(TAG, "触发拖动交换条目");
        mAdapter.changeItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /*
        以下是滑动相关方法
     */

    /**
     * 是否启用滑动操作
     * @return 是否启用 true 启用, false 不启用
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /**
     * 用户滑动距离, 设置的是比例值, 返回值为 0.5 , 就意味着滑动宽度/高度的一半, 才触发侧滑 onSwiped 方法
     * @param viewHolder
     * @return
     */
    @Override
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return 0.5f;
    }

    /**
     * 滑动判定速度, 每秒移动的像素个数, 达到该速度后, 才可以被判定为滑动
     * @param defaultValue
     * @return
     */
    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 5000f;
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
    public long getAnimationDuration(@NonNull RecyclerView recyclerView,
                                     int animationType,
                                     float animateDx, float animateDy) {
        return 200L;
    }

    /**
     * 滑动时的回调操作
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        Log.i(TAG, "触发侧滑删除条目");
        // 滑动指定的距离, 达到一定幅度后, 就会触发该方法回调
        // 这里做的是滑动删除功能, 直接删除滑动项
        // 该方法中删除指定条目, 并刷新界面
        mAdapter.deleteItem(viewHolder.getAdapterPosition());
    }
}
