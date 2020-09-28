package ke.co.nevon.stdportal;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public FragmentAdapter(@NonNull FragmentManager fm, Context myContext, int totalTabs) {
        super(fm);
        this.myContext = myContext;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Academic academic = new Academic();
                return academic;
            case 1:
                Finance finance= new Finance();
                return finance;
            case 2:
                Extra extra = new Extra();
                return extra;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }

}
