package network.dhammakaya.testbase3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    private FloatingActionButton mFab;
    private Center1Fragment mCenter1Fragment;
    private Center2Fragment mCenter2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        bindWidget();
        setupEventWidget();


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    private void setupEventWidget() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                tabLayout.getTabAt(position).select(); //บังคับให้ tab ไปเลือกตาม Fragment

                if(position == 0) {
                    mFab.hide();
                } else {
                    mFab.show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mFab.setVisibility(View.INVISIBLE);
    }

    private void bindWidget() {
        mViewPager = (ViewPager) findViewById(R.id.container);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (mCenter1Fragment == null) {
                        mCenter1Fragment = new Center1Fragment();
                    }
                    return mCenter1Fragment;

                default:
                    if (mCenter2Fragment == null) {
                        mCenter2Fragment = new Center2Fragment();
                    }
                    return mCenter2Fragment;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
