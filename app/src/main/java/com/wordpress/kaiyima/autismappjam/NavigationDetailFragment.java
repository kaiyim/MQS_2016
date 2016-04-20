package com.wordpress.kaiyima.autismappjam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;

import com.wordpress.kaiyima.autismappjam.dummy.DummyContent;

/**
 * A fragment representing a single Navigation detail screen.
 * This fragment is either contained in a {@link NavigationListActivity}
 * in two-pane mode (on tablets) or a {@link NavigationDetailActivity}
 * on handsets.
 */
public class NavigationDetailFragment extends Fragment {
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
    public NavigationDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    buttonListener activityCommander;

    public interface buttonListener{
        public void buttonClicked(String command);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCommander = (buttonListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_detail, container, false);

        final Button playGameButton = (Button) rootView.findViewById(R.id.PlayGameButton);

        playGameButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );

        return rootView;
    }

    public void buttonClicked(View view){
        activityCommander.buttonClicked("play");
    }
}
