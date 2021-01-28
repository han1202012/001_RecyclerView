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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Adapter adapter = new Adapter();
        recycler_view.setAdapter(adapter);
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
            holder.text.setText("" + position);
        }

        @Override
        public int getItemCount() {
            return 100;
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
