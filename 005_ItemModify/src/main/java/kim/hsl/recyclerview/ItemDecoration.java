package kim.hsl.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent,
                       @NonNull RecyclerView.State state) {
        // 1. 获取当前的组件个数
        int itemCount = parent.getChildCount();

        // 2. 遍历当前的所有组件
        for (int i = 0; i < itemCount; i++) {
            // 3. 获取组件 View 对象
            View view = parent.getChildAt(i);

            // 4. 获取 item 组件相对于父容器的坐标
            int left = view.getLeft();
            int top = view.getTop();
            int right = view.getRight();
            int bottom = view.getBottom();

            // 5. 根据上述坐标进行绘图
            if (i % 4 == 0){
                // 给每一行的第一个元素绘制红色矩形背景, 向外延展 5 像素
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                //c.drawRect(left - 5, top - 5, right + 5, bottom + 5, paint);
            }
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent,
                           @NonNull RecyclerView.State state) {
        // 1. 获取当前的组件个数
        int itemCount = parent.getChildCount();

        // 2. 遍历当前的所有组件
        for (int i = 0; i < itemCount; i++) {
            // 3. 获取组件 View 对象
            View view = parent.getChildAt(i);

            // 4. 获取 item 组件相对于父容器的坐标
            int left = view.getLeft();
            int top = view.getTop();
            int right = view.getRight();
            int bottom = view.getBottom();

            // 5. 根据上述坐标进行绘图
            if (i % 2 == 0){
                // 偶数序号的元素绘制蓝色圆形遮罩
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5F);
                //c.drawCircle((left + right) / 2F, (top + bottom) / 2F, (right - left) / 4F, paint);

            }else{
                // 奇数序号的元素绘制红色矩形遮罩
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5F);
                //c.drawRect(left + 20, top + 20, right - 20, bottom - 20, paint);
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {

        // 1. 获取当前设置边距的位置
        int currentPosition = parent.getChildAdapterPosition(view);

        // 2. 针对不同的位置设置不同的边距
        // 每排最左侧和最右侧的左右边距设置成 20 像素, 其余 4 个边距一律设置成 5
        if (currentPosition % 4 == 0){
            // 每排最左侧的边距
            outRect.left = 40;
            outRect.top = 20;
            outRect.right = 20;
            outRect.bottom = 20;

        }else if (currentPosition %4 == 3){
            // 每排最右侧的边距
            outRect.left = 20;
            outRect.top = 20;
            outRect.right = 40;
            outRect.bottom = 20;

        }else{
            // 普通元素的边距都是 5
            outRect.left = 20;
            outRect.top = 20;
            outRect.right = 20;
            outRect.bottom = 20;
        }

    }
}
