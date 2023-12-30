package com.shit.babsayeev2.navigation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shit.babsayeev2.R;
import com.shit.babsayeev2.navigation.model.ChildItem;
import com.shit.babsayeev2.navigation.model.GroupItem;

import java.util.List;

public class ExpendableAdapter extends BaseExpandableListAdapter {


    private final Context context;
    private final List<GroupItem> listHeader;


    public ExpendableAdapter(Context context, List<GroupItem> listHeader) {
        this.context = context;
        this.listHeader = listHeader;
    }

    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        try {
            return listHeader.get(i).getChildModelList().size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Object getGroup(int i) {
        return listHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHeader.get(i).getChildModelList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup viewGroup) {

        final GroupItem header = (GroupItem) getGroup(i);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_item, null);
        }

        TextView groupNameTextView = convertView.findViewById(R.id.textView3);
        ImageView leftImage = convertView.findViewById(R.id.imageView3);
        ImageView rightImage = convertView.findViewById(R.id.imageView4);


        groupNameTextView.setText(header.getGroupName());
        leftImage.setImageResource(header.getImgOne());
        //rightImage.setImageResource(groupItems.get(i).getImgTwo());


        if (header.getChildModelList().size() == 0){
            rightImage.setVisibility(View.INVISIBLE);
        }else {
            rightImage.setVisibility(View.VISIBLE);
        }

        if (isExpanded){
            rightImage.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
        }else {
            rightImage.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
        }


        return convertView;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {

        final ChildItem childText = (ChildItem) getChild(i, i1);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item, null);
        }

        TextView childNameTextView = convertView.findViewById(R.id.textView3);
        ImageView leftImage = convertView.findViewById(R.id.imageView3);
        ImageView rightImage = convertView.findViewById(R.id.imageView4);

        childNameTextView.setText(childText.getChildName());
        leftImage.setImageResource(childText.getImgOne());
        rightImage.setImageResource(childText.getImgTwo());


        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        convertView.startAnimation(animation);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
