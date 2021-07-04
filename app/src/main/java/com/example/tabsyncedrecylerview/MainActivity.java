package com.example.tabsyncedrecylerview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    LinearLayoutManager linearLayoutManager;
    TabLayout myTabLayout;
    private ArrayList<String> tabsCat = new ArrayList<>();
    private ArrayList<Object> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setTabs();
        setRecyclerView();
    }

    private void setRecyclerView() {
        int x = 0;
        for (int i = 0; i < tabsCat.size() * 50; i = i + 50) {
            list.add(new HeaderModel(tabsCat.get(x), x));
            for (int j = i; j < i + 50; j++) {
                list.add(new LayoutModel("Demo", x));
            }
            x += 1;
        }
        myAdapter = new MyAdapter(MainActivity.this, list);
        myRecyclerView.setAdapter(myAdapter);

        myRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int itemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                Object item = myAdapter.getItem(itemPosition);
                if (item instanceof HeaderModel) {
                    HeaderModel header = (HeaderModel) item;
                    TabLayout.Tab tab = myTabLayout.getTabAt(header.getTabId());
                    tab.select();
                } else {
                    LayoutModel layout = (LayoutModel) item;
                    TabLayout.Tab tab = myTabLayout.getTabAt(layout.getTabId());
                    tab.select();
                }
            }
        });
    }

    private void setTabs() {
        tabsCat.add("Live Stream");
        tabsCat.add("Products");
        tabsCat.add("Categories");
        for (int i = 0; i < tabsCat.size(); i++) {
            TabLayout.Tab firstTab = myTabLayout.newTab(); // Create a new Tab names
            firstTab.setText(tabsCat.get(i));
            // set the Text for the first Tab
            myTabLayout.addTab(firstTab);
        }

        for (int tabCount = 0; tabCount < myTabLayout.getTabCount(); tabCount++) {
            View tabView = ((ViewGroup) myTabLayout.getChildAt(0)).getChildAt(tabCount);
            final String tabText = tabsCat.get(tabCount);
            tabView.setOnClickListener(v -> {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof HeaderModel) {
                        HeaderModel headerModel = (HeaderModel) list.get(i);
                        if (tabText.equalsIgnoreCase(headerModel.getHeader())) {
                            linearLayoutManager.scrollToPositionWithOffset(i, 0);
                        }
                    }
                }
            });
        }
    }

    private void initView() {
        myTabLayout = findViewById(R.id.myTabLayout);
        myRecyclerView = findViewById(R.id.myRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setHasFixedSize(true);
    }
}