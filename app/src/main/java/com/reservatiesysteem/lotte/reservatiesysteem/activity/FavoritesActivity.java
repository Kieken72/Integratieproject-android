package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
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
public class FavoritesActivity extends BaseActivity {
    @BindView(R.id.lvFavorites)
    ListView lvFavorites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ButterKnife.bind(this);
        getFavorites();
    }

    private void getFavorites() {
        try {
            API_Service service = API.createService(API_Service.class);
            Call<List<Branch>> call = service.getBranchById(2550);
            call.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {
                    final List<Branch> branches = response.body();
                    final BranchAdapter branchAdapter = new BranchAdapter(getApplicationContext(), 0, null, branches);
                    lvFavorites.setAdapter(branchAdapter);
                    lvFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("branchId", (int) id);
                            bundle.putInt("chosenPostalCode", Integer.parseInt(branches.get(i).getCity().getPostalCode()));
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Branch>> call, Throwable t) {
                    Log.d("Error receiving branche", t.getMessage());
                }
            });

        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Branches kunnen niet opgehaald worden", Toast.LENGTH_LONG).show();
        }
    }
}
