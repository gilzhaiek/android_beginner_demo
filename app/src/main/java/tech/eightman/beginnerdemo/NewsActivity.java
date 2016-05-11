package tech.eightman.beginnerdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class NewsActivity extends Activity {
    public static String[] mNewsTitles;
    public static String[] mNewsDetails;

    private FrameLayout mTitlesFrame = null;
    private FrameLayout mDetailsFrame = null;

    private NewsDetailsFragment mDetailsFragment = new NewsDetailsFragment();
    private NewsTitleFragment mNewTitleFragment = null;
    private static final String TITLE_FRAGMENT_TAG = "TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            setContentView(R.layout.activity_news);

            mNewsTitles = getResources().getStringArray(R.array.news_titles);
            mNewsDetails = getResources().getStringArray(R.array.news_details);

            mTitlesFrame = (FrameLayout) findViewById(R.id.news_titles_frame);
            mDetailsFrame = (FrameLayout) findViewById(R.id.news_details_frame);

            mNewTitleFragment = new NewsTitleFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.news_titles_frame, mNewTitleFragment, TITLE_FRAGMENT_TAG);

            fragmentTransaction.commit();
        } else {
            mNewTitleFragment = (NewsTitleFragment)getFragmentManager().findFragmentByTag(TITLE_FRAGMENT_TAG);
        }
    }

    public void onItemSelected(int position) {
        if(!mDetailsFragment.isAdded()) {
            FragmentManager fragmentManager = getFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.news_details_frame, mDetailsFragment);
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
            
            setLayout();
        }

        mDetailsFragment.showNewsDetailsAtIndex(position);
    }

    private void setLayout() {
        if(mDetailsFragment.isAdded()){
            mTitlesFrame.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    1f));

            mDetailsFrame.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    2f));
        } else {
            mTitlesFrame.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            mDetailsFrame.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }
}
