package com.reservatiesysteem.lotte.reservatiesysteem.activity;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.reservatiesysteem.lotte.reservatiesysteem.R;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.vwpHome) ViewPager viewPager;
    @BindView(R.id.lytSearch) LinearLayout lytSearch;
    @BindView(R.id.lytList) LinearLayout lytList;
    @BindView(R.id.lytDetails) LinearLayout lytDetails;
    @BindView(R.id.lytBook) LinearLayout lytBook;
    HomePagerAdapter homePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homePagerAdapter);

        lytList.setEnabled(false);
        lytDetails.setEnabled(false);
        lytBook.setEnabled(false);

        lytSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

    }

    public void changeFragment(Fragment fragment,int currentItem){
        homePagerAdapter.setMaxVisibleItems(currentItem+1);
        homePagerAdapter.setFragment(fragment,currentItem);
        viewPager.setAdapter(homePagerAdapter);
        viewPager.setCurrentItem(currentItem);
        lytList.setEnabled(true);
    }

    private class HomePagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment>fragments = new ArrayList<>();
        private int maxVisibleItems;
        public HomePagerAdapter(FragmentManager fm) {
            super(fm);
            maxVisibleItems = 1;

            fragments.add(new SearchFragment());
            fragments.add(new ResultListFragment());
            fragments.add(new DetailsFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return maxVisibleItems;
        }
        public void setMaxVisibleItems(int maxVisibleItems){
            this.maxVisibleItems = maxVisibleItems;
        }
        public void setFragment(Fragment fragment,int id){
            fragments.set(id,fragment);
        }


    }
}
