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
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {

        // 1. 获取当前设置边距的位置
        int currentPosition = parent.getChildAdapterPosition(view);

        // 2. 针对不同的位置设置不同的边距
        outRect.bottom = 20;

    }
}
