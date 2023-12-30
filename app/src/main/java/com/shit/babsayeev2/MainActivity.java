package com.shit.babsayeev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.shit.babsayeev2.navigation.adapter.ExpendableAdapter;
import com.shit.babsayeev2.navigation.model.ChildItem;
import com.shit.babsayeev2.navigation.model.GroupItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ExpandableListView expandableListView;

    NavigationView navigationView;

    DrawerLayout drawer_layout;

    ImageView dashNavBar,dashLoad,settings;

    TextView dashText;


    ConstraintLayout dashboard;

    Dialog popup;



    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //status bar
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        getWindow().setStatusBarColor(getResources().getColor(R.color.olive));

        expandableListView = findViewById(R.id.expandableListView);
        navigationView = findViewById(R.id.nav_view);

        //ImageView Nav Bar find by id
        dashNavBar = findViewById(R.id.dashNavBar);
        dashLoad = findViewById(R.id.dashLoad);
        settings = findViewById(R.id.settings);

        dashText = findViewById(R.id.dashText);
        dashboard = findViewById(R.id.dashboard);

        drawer_layout = findViewById(R.id.drawer_layout);


        navigation();


        //Navigation Drawer Bar Set
        dashNavBar.setOnClickListener(v -> drawer_layout.openDrawer(GravityCompat.START));





    }

    private void navigation() {

        List<GroupItem> groupItems = new ArrayList<>();
        groupItems.add(new GroupItem(getResources().getString(R.string.dashboard),R.drawable.dashboard_nav));




        List<ChildItem> customerItems = new ArrayList<>();
        customerItems.add(new ChildItem(getString(R.string.customer_add),R.drawable.person_nav,R.drawable.baseline_add_circle_24));
        customerItems.add(new ChildItem(getString(R.string.customer_list),R.drawable.person_nav,R.drawable.baseline_add_circle_24));
        customerItems.add(new ChildItem(getString(R.string.customer_group),R.drawable.person_nav,R.drawable.baseline_add_circle_24));

        groupItems.add(new GroupItem(getString(R.string.customer),R.drawable.person_nav,customerItems));


        List<ChildItem> supplierItems = new ArrayList<>();
        supplierItems.add(new ChildItem(getString(R.string.supplier_add),R.drawable.person_nav,R.drawable.baseline_add_circle_24));
        supplierItems.add(new ChildItem(getString(R.string.supplier_list),R.drawable.person_nav,R.drawable.baseline_add_circle_24));
        supplierItems.add(new ChildItem(getString(R.string.supplier_group),R.drawable.person_nav,R.drawable.baseline_add_circle_24));



        groupItems.add(new GroupItem(getString(R.string.supplier),R.drawable.person_nav,supplierItems));



        ExpendableAdapter adapter = new ExpendableAdapter(this,groupItems);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                expandableListView.collapseGroup(lastExpandedPosition);
            }
            lastExpandedPosition = groupPosition;
        });


        expandableListView.setOnGroupClickListener((expandableListView, view, i, l) -> {
           // Toast.makeText(MainActivity.this, "group: "+groupItems.get(i).getGroupName(), Toast.LENGTH_SHORT).show();
            return false;
        });


        expandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
          //  Toast.makeText(MainActivity.this, "child : "+groupItems.get(i).getChildModelList().get(i1).getChildName(), Toast.LENGTH_SHORT).show();
            return false;
        });

    }
}