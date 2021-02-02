package kim.hsl.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * 数据源
     */
    private ArrayList<String> names = new ArrayList<String>();

    /**
     * 适配器
     */
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化数据
        initData();

        //1 . 从布局中获取 RecyclerView
        RecyclerView recycler_view = findViewById(R.id.recycler_view);

        //2 . 创建并设置布局管理器
        //创建布局管理器

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                4,
                RecyclerView.VERTICAL);

        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);

        // 设置边距
        recycler_view.addItemDecoration(new ItemDecoration());

        //3 . 创建并设置列表适配器
        adapter = new Adapter();
        recycler_view.setAdapter(adapter);

        // 初始化点击事件
        initClick();
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

    void initClick(){

        // 增加单个数据
        findViewById(R.id.insert_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在集合开始添加一个元素
                names.add(0, "戴宗");

                // 通知适配器新元素添加
                adapter.notifyItemInserted(0);
            }
        });

        // 增加多个数据
        findViewById(R.id.insert_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在集合开始添加多个元素
                names.add(0, "戴宗");
                names.add(0, "刘唐");
                names.add(0, "李逵");

                // 通知适配器多个新元素添加
                adapter.notifyItemRangeInserted(0, 3);
            }
        });

        // 删除单个数据
        findViewById(R.id.delete_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除第 0 个元素
                names.remove(0);

                // 通知适配器
                adapter.notifyItemRemoved(0);
            }
        });

        // 删除多个数据
        findViewById(R.id.delete_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除第 0 ~ 2 个元素
                names.remove(0);
                names.remove(0);
                names.remove(0);

                // 通知适配器
                adapter.notifyItemRangeRemoved(0, 3);
            }
        });


        // 修改单个数据
        findViewById(R.id.modify_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 替换第 0 个元素
                names.set(0, "宋江江");

                // 通知适配器
                adapter.notifyItemChanged(0);
            }
        });

        // 修改多个数据
        findViewById(R.id.modify_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 替换第 0, 1, 2 个元素
                names.set(0, "宋江江");
                names.set(1, "卢俊俊");
                names.set(2, "吴用用");

                // 通知适配器
                adapter.notifyItemRangeChanged(0, 3);
            }
        });

        // 移动数据
        findViewById(R.id.move_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 先移除第 0 个
                names.remove(0);
                // 然后在第 7 个位置插入, 此时变为第 7 个元素
                names.add(7, "宋江");

                // 通知适配器
                adapter.notifyItemMoved(0, 7);
            }
        });

        // 数据改变
        findViewById(R.id.data_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 先移除第 0 个
                names.remove(0);
                // 然后在第 7 个位置插入, 此时变为第 7 个元素
                names.add(7, "宋江");

                // 删除第 0 ~ 2 个元素
                names.remove(0);
                names.remove(0);
                names.remove(0);

                adapter.notifyDataSetChanged();
            }
        });


    }

    /**
     * RecyclerView 适配器
     */
    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

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
    }


}
