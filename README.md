# 【RecyclerView】RecyclerView 最基本用法 ( 添加支持库 | 设置布局文件 | 自定义适配器 )


<br>
<br>

#### I . 添加支持库

---

<br>

**在 Module 中的 build.gradle 的 dependencies 中配置 RecyclerView 的依赖库 ;** 

```java
dependencies {
    implementation "androidx.recyclerview:recyclerview:1.1.0"
}
```


<br>
<br>

#### II . 布局文件中使用 RecyclerView 

<br>


```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

	<!-- 设置列表 -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:scrollbars="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```



<br>
<br>

#### III . 自定义适配器

<br>


```java
    /**
     * RecyclerView 适配器
     */
    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        /**
         * 初始化布局文件
         * @param parent
         * @param viewType
         * @return
         */
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View root_view = LayoutInflater.from(MainActivity.this)
            	.inflate(R.layout.item_recyclerview, parent, false);
            return new ViewHolder(root_view);
        }

        /**
         * 设置每个列表项的显示内容
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.text.setText("" + position);
        }

        /**
         * 获取列表项个数
         * @return
         */
        @Override
        public int getItemCount() {
            return 10;
        }

        /**
         * 布局容器
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }

    }
```



<br>
<br>

#### IV . RecyclerView 设置流程

<br>


**RecyclerView 设置流程 :** 

<br>

**① 初始化 RecyclerView 对象 :** 一般是从布局文件中获取 ; 

**② 创建并设置布局管理器 :** 可以使用预置的布局管理器 , 也可以自定义布局管理器 ; 

**③ 设置适配器 :** 一般是使用自定义的适配器 , 设置给 RecyclerView 对象 ; 

<br>

```java
//1 . 从布局中获取 RecyclerView
RecyclerView recycler_view = findViewById(R.id.recycler_view);

//2 . 创建并设置布局管理器
//创建布局管理器
LinearLayoutManager layoutManager = new LinearLayoutManager(this);
layoutManager.setOrientation(RecyclerView.VERTICAL);
//设置布局管理器
recycler_view.setLayoutManager(layoutManager);

//3 . 创建并设置列表适配器
Adapter adapter = new Adapter();
recycler_view.setAdapter(adapter);
```



<br>
<br>

#### V . RecyclerView 完整 Java 代码示例 

<br>


```java
package kim.hsl.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 . 从布局中获取 RecyclerView
        RecyclerView recycler_view = findViewById(R.id.recycler_view);


        //2 . 创建并设置布局管理器
        //创建布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);


        //3 . 创建并设置列表适配器
        Adapter adapter = new Adapter();
        recycler_view.setAdapter(adapter);
    }


    /**
     * RecyclerView 适配器
     */
    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        /**
         * 初始化布局文件
         * @param parent
         * @param viewType
         * @return
         */
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View root_view = LayoutInflater.from(MainActivity.this)
            	.inflate(R.layout.item_recyclerview, parent, false);
            return new ViewHolder(root_view);
        }

        /**
         * 设置每个列表项的显示内容
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.text.setText("" + position);
        }

        /**
         * 获取列表项个数
         * @return
         */
        @Override
        public int getItemCount() {
            return 10;
        }

        /**
         * 布局容器
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }

    }

}

```


![在这里插入图片描述](https://img-blog.csdnimg.cn/20200321200402211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhbjEyMDIwMTI=,size_16,color_FFFFFF,t_70)




<br>

**代码地址 :** [https://github.com/han1202012/001_RecyclerView](https://github.com/han1202012/001_RecyclerView)
