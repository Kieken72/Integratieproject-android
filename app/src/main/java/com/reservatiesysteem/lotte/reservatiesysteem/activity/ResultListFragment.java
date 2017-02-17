package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.adapter.BranchAdapter;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class ResultListFragment extends Fragment {

    @BindView(R.id.listBranches) ListView lvBranches;


    //transfer data from searchfragment
    private String chosenDate = "";
    private String chosenTime = "";
    private String chosenNumberOfPersons = "";
    private int chosenPostalCode;

    public ResultListFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //transfer data from searchfragment
        View view = inflater.inflate(R.layout.fragment_listresult, container, false);
        ButterKnife.bind(this,view);

        Bundle bundle = getArguments();

        if(bundle != null){
            chosenPostalCode = bundle.getInt("chosenPostalCode", 0);
            chosenDate = bundle.getString(SearchFragment.CHOSEN_DATE);
            chosenTime = bundle.getString(SearchFragment.CHOSEN_TIME);
            chosenNumberOfPersons = bundle.getString(SearchFragment.CHOSEN_NUMBEROFPERSONS);
        }

        getBranches();

        return view;
    }

    private void getBranches(){
       try{
        API_Service service = API.createService(API_Service.class);
           if(chosenPostalCode > 0) {
               Call<List<Branch>> call = service.getBranchById(chosenPostalCode);
               call.enqueue(new Callback<List<Branch>>() {
                   @Override
                   public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {
                       final BranchAdapter branchAdapter = new BranchAdapter(getActivity().getApplicationContext(), R.layout.view_branch_entry, response.body());

                       if (lvBranches != null) {
                           lvBranches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                               @Override
                               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                   StartActivity activity = (StartActivity) getActivity();

                                   //transfering data to ResultListFragment
                                   DetailsFragment detailsFragment = new DetailsFragment();


                                   activity.changeFragment(detailsFragment,2);
                               }
                           });
                       }
                       lvBranches.setAdapter(branchAdapter);
                   }

                   @Override
                   public void onFailure(Call<List<Branch>> call, Throwable t) {
                       Log.d("Error receiving branche", t.getMessage());
                   }
               });
           }
    }catch (NullPointerException e){
           Toast.makeText(getActivity().getApplicationContext(),"Branches kunnen niet opgehaald worden", Toast.LENGTH_LONG).show();
       }
    }
}
