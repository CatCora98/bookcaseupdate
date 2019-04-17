package com.example.bookcase;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {
    public ViewPagerFragment() {

    }
    public static ViewPagerFragment newInstance(String param1, String param2) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//ini pager
    ViewPager vp;
    PagerAdapter pagerAdapter;
    BookDetailsFragment newFragment;

    Book book;
    ArrayList<Book> booksArrList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_pager, container, false);
        pagerAdapter = new PagerAdapter(getFragmentManager());

        booksArrList = new ArrayList<>();
        viewPager = v.findViewById(R.id.viewPager);

        return v;
    }

    public void addPager(final ArrayList bookArr) {
        booksArrList.clear();
        booksArrList.addAll(bookArr);

        for (int i = 0; i < booksArrList.size(); i++) {
            book = booksArrList.get(i);
            newFragment = BookDetailsFragment.newInstance(book);
            pagerAdapter.add(newFragment);
            pagerAdapter.notifyDataSetChanged();
        }

    }
    class PagerAdapter extends FragmentStatePagerAdapter{

        ArrayList<BookDetailsFragment> pagerFragments;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            pagerFragments = new ArrayList<>();
        }

        public void add(BookDetailsFragment fragment){
            pagerFragments.add(fragment);
        }
         vp.setAdapter(pagerAdapter);

        @Override
        public int getItemPosition(@NonNull Object object) {
            return PagerAdapter.POSITION_NONE;
        }

        @Override
        public Fragment getItem(int i) {
            return pagerFragments.get(i);
        }

        @Override
        public int getCount() {
            return pagerFragments.size();
        }
    }

}
