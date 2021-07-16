package kim.hsl.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    /**
     * 数据源
     */
    private ArrayList<String> names = new ArrayList<String>();

    /**
     * 当前的 RecyclerView 列表
     */
    private RecyclerView recycler_view;

    /**
     * 布局管理器
     */
    private LinearLayoutManager layoutManager;

    /**
     * 适配器
     */
    private Adapter adapter;

    /**
     * 添加拖动处理
     */
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化数据
        initData();

        //1 . 从布局中获取 RecyclerView
        recycler_view = findViewById(R.id.recycler_view);

        //2 . 创建并设置布局管理器
        //创建布局管理器
        layoutManager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false);

        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);

        // 设置边距
        recycler_view.addItemDecoration(new ItemDecoration());

        //3 . 创建并设置列表适配器
        adapter = new Adapter();
        recycler_view.setAdapter(adapter);

        //4. 添加拖动事件
        Callback callback = new Callback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recycler_view);

    }

    /**
     * 初始化数据
     */
    private void initData(){
        names.add("宋江");
        names.add("卢俊义");
        names.add("吴用");
        names.add("公孙胜");
        names.add("关胜");
        names.add("林冲");
        names.add("秦明");
        names.add("呼延灼");
        names.add("花荣");
        names.add("柴进");
        names.add("李应");
        names.add("朱仝");
        names.add("鲁智深");
        names.add("武松");
        names.add("董平");
        names.add("张清");
        names.add("杨志");
        names.add("徐宁");
        names.add("索超");
    }

    /**
     * RecyclerView 适配器
     */
    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        private RecyclerView mRecyclerView;

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.mRecyclerView = recyclerView;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View root_view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_recyclerview, parent, false);
            return new ViewHolder(root_view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.text.setText("" + names.get(position));
        }

        @Override
        public int getItemCount() {
            return names.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }

        /**
         * 删除元素调用的方法
         * @param position
         */
        public void deleteItem(int position) {
            names.remove(position);
            notifyItemRemoved(position);
        }

        /**
         * 交换条目元素
         * @param srcPosition
         * @param dstPosition
         */
        public void changeItem(int srcPosition, int dstPosition) {
            // 交换集合中两个元素位置
            Collections.swap(names, srcPosition, dstPosition);
            // 刷新界面显示
            notifyItemMoved(srcPosition, dstPosition);
        }
    }

}
