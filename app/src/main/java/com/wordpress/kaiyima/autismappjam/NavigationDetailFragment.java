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
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

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
    public static final String ARG_USER_NAME = "user_name";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;
    private String userName;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NavigationDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_USER_NAME)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
//            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_USER_NAME));
//
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle("Play Game");
            }
            userName = getArguments().getString(ARG_USER_NAME);
//            Toast.makeText(this.getActivity(), userName, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_detail, container, false);

        final ImageButton playGameButton = (ImageButton) rootView.findViewById(R.id.PlayGameButton);

        playGameButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        playButtonClicked(v);
                    }
                }
        );

        final ImageButton playGameButton2 = (ImageButton) rootView.findViewById(R.id.PlayGameButton2);

        playGameButton2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        playButtonClicked(v);
                    }
                }
        );

        final ImageButton playGameButton3 = (ImageButton) rootView.findViewById(R.id.PlayGameButton3);

        playGameButton3.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        playButtonClicked(v);
                    }
                }
        );

        return rootView;
    }

    public void playButtonClicked(View view){
        Intent intent = new Intent(getActivity(), QuestionList.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

}
