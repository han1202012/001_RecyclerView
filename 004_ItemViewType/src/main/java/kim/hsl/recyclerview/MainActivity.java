package kim.hsl.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 . 从布局中获取 RecyclerView
        RecyclerView recycler_view = findViewById(R.id.recycler_view);

        //2 . 创建并设置布局管理器
        //创建布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);

        // 添加分隔符
        recycler_view.addItemDecoration(new ItemDecoration());

        //3 . 创建并设置列表适配器
        Adapter adapter = new Adapter();
        recycler_view.setAdapter(adapter);
    }

    /**
     * RecyclerView 适配器
     * RecyclerView.Adapter 中的 ViewHolder 泛型设置为 RecyclerView.ViewHolder
     * 同理 onBindViewHolder 中的泛型也要是该类型的
     */
    public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public static final int VIEW_TYPE_1 = 0;
        public static final int VIEW_TYPE_2 = 1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            // 根据不同的组件类型加载不同类型的布局文件
            switch (viewType){
                case VIEW_TYPE_1:
                    return new ViewHolder(
                            LayoutInflater.from(MainActivity.this)
                                    .inflate(R.layout.item_recyclerview, parent, false)
                    );


                case VIEW_TYPE_2:
                    return new ViewHolder2(
                            LayoutInflater.from(MainActivity.this)
                                    .inflate(R.layout.item_recyclerview2, parent, false)
                    );
            }

            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            // 根据 position 获取布局类型 , 然后绑定数据
            switch (getItemViewType(position)){
                case VIEW_TYPE_1:
                    ((ViewHolder)holder).text.setText("" + position);
                    break;

                case VIEW_TYPE_2:
                    ((ViewHolder2)holder).text.setText("" + position);
                    ((ViewHolder2)holder).image.setImageResource(R.mipmap.ic_launcher);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        @Override
        public int getItemViewType(int position) {
            // 返回 View 布局类型, 奇数序号组件类型为 VIEW_TYPE_2, 偶数序号组件类型为 VIEW_TYPE_1
            return position % 2;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }

        public class ViewHolder2 extends RecyclerView.ViewHolder {
            TextView text;
            ImageView image;
            public ViewHolder2(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
                image = itemView.findViewById(R.id.image);
            }
        }
    }

}
