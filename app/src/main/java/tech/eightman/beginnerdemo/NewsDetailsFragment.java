package tech.eightman.beginnerdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailsFragment extends Fragment {
    private TextView mDetailView = null;
    private int mShownIndex = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDetailView = (TextView)getActivity().findViewById(R.id.detailView);
    }

    public void showNewsDetailsAtIndex(int index){
        if(index == mShownIndex || index < 0) {
            return;
        }
        mShownIndex = index;
        mDetailView.setText(NewsActivity.mNewsDetails[index]);
    }
}
