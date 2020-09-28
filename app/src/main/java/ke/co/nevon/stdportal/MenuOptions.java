package ke.co.nevon.stdportal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MenuOptions extends AppCompatActivity {
    TabLayout tabLayout;
     ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tabLayout =findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("academic"));
        tabLayout.addTab(tabLayout.newTab().setText("finance"));
        tabLayout.addTab(tabLayout.newTab().setText("extra-curriculum"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),getApplicationContext(),tabLayout.getTabCount());
         viewPager.setAdapter(fragmentAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                SharedPreferences sharedPreferences=getSharedPreferences(LoginPage.MyPREFERENCES, Context.MODE_PRIVATE);
                String regNo=sharedPreferences.getString("reg","");
                Toast.makeText(getApplicationContext(),regNo,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}