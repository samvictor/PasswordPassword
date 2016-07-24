package com.saminniss.passwordpassword;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saminniss.passwordpassword.dummy.DummyContent;

/**
 * A fragment representing a single Site detail screen.
 * This fragment is either contained in a {@link SiteListActivity}
 * in two-pane mode (on tablets) or a {@link SiteDetailActivity}
 * on handsets.
 */
public class SiteDetailFragment extends Fragment {

    Context context_sdf;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SiteDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context_sdf = this.getContext();

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            TextView detail_text = ((TextView) rootView.findViewById(R.id.site_detail));
            detail_text.setText(mItem.details);
            detail_text.setTextColor(ContextCompat.getColor(context_sdf, R.color.my_text));
            detail_text.setBackgroundColor(ContextCompat.getColor(context_sdf, R.color.my_text_bg));
        }

        return rootView;
    }
}
