package com.example.h.session2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by h on 2016/4/25.
 */
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        GridView gridview = (GridView) findViewById(R.id.gridview);

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<6;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            switch (i)
            {
                case 0:map.put("ItemImage", R.drawable.chizaocan);//添加图像资源的ID
                    break;
                case 1:map.put("ItemImage", R.drawable.huahua);//添加图像资源的ID
                    break;
                case 2:map.put("ItemImage", R.drawable.kanshu);//添加图像资源的ID
                    break;
                case 3:map.put("ItemImage", R.drawable.lianzi);//添加图像资源的ID
                    break;
                case 4:map.put("ItemImage", R.drawable.paobu);//添加图像资源的ID
                    break;
                case 5:map.put("ItemImage", R.drawable.zaoshui);//添加图像资源的ID
                    break;
            }

            map.put("ItemText", "NO."+String.valueOf(i));//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
        SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释
                                                        lstImageItem,//数据来源
                                                         R.layout.first_layout,//night_item的XML实现

                                                        //动态数组与ImageItem对应的子项
                                                         new String[] {"ItemImage","ItemText"},

                                                         //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                                                        new int[] {R.id.ItemImage,R.id.ItemImage});
        //添加并且显示
        gridview.setAdapter(saImageItems);
        //添加消息处理
        gridview.setOnItemClickListener(new ItemClickListener());
    }
    //当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class  ItemClickListener implements AdapterView.OnItemClickListener
    {

        public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened
                                View arg1,//The view within the AdapterView that was clicked
                                int arg2,//The position of the view in the adapter
                                long arg3//The row id of the item that was clicked
        ) {
            //在本例中arg2=arg3
            HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);
            //显示所选Item的ItemText
            setTitle((String)item.get("ItemText"));
        }

    }
}
