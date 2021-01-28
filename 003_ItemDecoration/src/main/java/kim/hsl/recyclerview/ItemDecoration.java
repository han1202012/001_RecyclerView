package kim.hsl.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent,
                       @NonNull RecyclerView.State state) {
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent,
                           @NonNull RecyclerView.State state) {
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
            outRect.left = 20;
            outRect.top = 5;
            outRect.right = 5;
            outRect.bottom = 5;

        }else if (currentPosition %4 == 3){
            // 每排最右侧的边距
            outRect.left = 5;
            outRect.top = 5;
            outRect.right = 20;
            outRect.bottom = 5;

        }else{
            // 普通元素的边距都是 5
            outRect.left = 5;
            outRect.top = 5;
            outRect.right = 5;
            outRect.bottom = 5;
        }

    }
}
