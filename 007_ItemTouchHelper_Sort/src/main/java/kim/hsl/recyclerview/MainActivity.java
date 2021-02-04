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
     * 当前的 RecyclerView 列表
     */
    private RecyclerView recycler_view;

    /**
     * 网格布局管理器
     */
    private GridLayoutManager layoutManager;

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
        recycler_view = findViewById(R.id.recycler_view);

        //2 . 创建并设置布局管理器
        //创建布局管理器
        layoutManager = new GridLayoutManager(
                this,
                4,
                RecyclerView.VERTICAL,
                false);

        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);

        // 设置边距
        recycler_view.addItemDecoration(new ItemDecoration());

        //3 . 创建并设置列表适配器
        adapter = new Adapter();
        recycler_view.setAdapter(adapter);
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
