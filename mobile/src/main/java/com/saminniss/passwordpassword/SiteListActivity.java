package com.saminniss.passwordpassword;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.saminniss.passwordpassword.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Sites. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SiteDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class SiteListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    Context sla_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);
        sla_context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        View recyclerView = findViewById(R.id.site_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.site_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration());
    }



    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.site_list_content, parent, false);
            return new ViewHolder(view);
        }

        List<ArrayList<String>> site_colors = new ArrayList<ArrayList<String>>(){{
            add(0, new ArrayList<String>(){{add("#eeeeee");add("#224477");}}); // facebook
            add(1, new ArrayList<String>(){{add("#dc2020");add("#ffffff");}}); // google
            add(2, new ArrayList<String>(){{add("#ff6622");add("#181818");}}); // amazon
            add(3, new ArrayList<String>(){{add("#ffffff");add("#44aaff");}}); // microsoft
            add(4, new ArrayList<String>(){{add("#55d055");add("#181818");}}); // hulu
            add(5, new ArrayList<String>(){{add("#ffffff");add("#409040");}}); // spotify
            add(6, new ArrayList<String>(){{add("#ee3333");add("#181818");}}); // netflix
            add(7, new ArrayList<String>(){{add("#eeeeee");add("#202050");}}); // sony
            add(8, new ArrayList<String>(){{add("#333333");add("#aaaaaa");}}); // apple
            add(9, new ArrayList<String>(){{add("#ffffff");add("#64baff");}}); // twitter
            add(10, new ArrayList<String>(){{add("#ffffff");add("#7044bd");}}); // twitch
            add(11, new ArrayList<String>(){{add("#101010");add("#f77623");}}); // reddit
            add(12, new ArrayList<String>(){{add("#ffffff");add("#8854ff");}}); // instagram
        }};
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mContentView.setText(mValues.get(position).content);
            holder.mContentView.setTextColor(Color.parseColor(site_colors.get(position).get(0)));
            ((View) holder.mContentView.getParent()).setBackgroundColor(
                                            Color.parseColor(site_colors.get(position).get(1)));

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(SiteDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        SiteDetailFragment fragment = new SiteDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.site_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, SiteDetailActivity.class);
                        intent.putExtra(SiteDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                // WHERE THE MAGIC HAPPENS
                mView = view;
                mContentView = (TextView) view.findViewById(R.id.content);

                mContentView.setTextColor(ContextCompat.getColor(sla_context, R.color.my_text));
                mView.setBackgroundColor(ContextCompat.getColor(sla_context, R.color.my_text_bg));
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = 40;
            outRect.bottom = 18;
        }
    }
}
