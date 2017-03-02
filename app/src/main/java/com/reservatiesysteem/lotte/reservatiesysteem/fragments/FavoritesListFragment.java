package com.reservatiesysteem.lotte.reservatiesysteem.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.activity.FavoritesActivity;
import com.reservatiesysteem.lotte.reservatiesysteem.adapter.BranchAdapter;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jasper on 27/02/2017.
 */

public class FavoritesListFragment extends Fragment {
    @BindView(R.id.listBranches)ListView lvFavorites;


    public FavoritesListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listresult,container,false);
        ButterKnife.bind(this,view);

        getFavorites();

        lvFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                FavoritesActivity favoritesActivity = (FavoritesActivity) getActivity();
                FavoriteBranchDetailsFragment favoBranchFragment = new FavoriteBranchDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("branchId", (int) id);
                favoBranchFragment.setArguments(bundle);
                favoritesActivity.changeFragment(favoBranchFragment,1);
            }
        });
        return view;
    }

    private void getFavorites() {
        try {
            API_Service service = API.createService(API_Service.class);
            Call<List<Branch>> call = service.getBranchById(2550);
            call.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {
                    final List<Branch> branches = response.body();
                    final BranchAdapter branchAdapter = new BranchAdapter(getActivity(), 0, null, branches);
                    lvFavorites.setAdapter(branchAdapter);
                }

                @Override
                public void onFailure(Call<List<Branch>> call, Throwable t) {
                    Log.d("Error receiving branche", t.getMessage());
                }
            });
        } catch (NullPointerException e) {
            Toast.makeText(getActivity().getApplicationContext(), "Branches kunnen niet opgehaald worden", Toast.LENGTH_LONG).show();
        }
    }
}
