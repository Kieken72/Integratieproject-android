package com.reservatiesysteem.lotte.reservatiesysteem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lotte on 15/02/2017.
 */

public class BranchAdapter extends BaseAdapter {

    private List<Branch> branches = new ArrayList<>();
    private Context context;

    public BranchAdapter(Context context, int resource, List<Branch> branches) {
        this.branches = branches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return branches.size();
    }

    @Override
    public Branch getItem(int position) {
        return branches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return branches.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Branch branch = getItem(position);

        View v;

        if(convertView == null){
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_branch_entry, parent, false);
        }
        else {
            v = convertView;
        }

        //api call

        TextView txtBranchName = (TextView) v.findViewById(R.id.branchName);
        TextView txtBranchStreet = (TextView) v.findViewById(R.id.branchStreet);
        TextView txtBranchMail = (TextView) v.findViewById(R.id.branchMail);
        txtBranchName.setText(branch.getName());
        txtBranchStreet.setText(branch.getStreet());
        txtBranchMail.setText(branch.getEmail());

        return v;
    }

}
