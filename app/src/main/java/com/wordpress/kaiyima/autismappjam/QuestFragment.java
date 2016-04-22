package com.wordpress.kaiyima.autismappjam;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER_NAME = "user_name";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mUserName;
    private ProfileDBManager mDataBase;
    public TextView QuestString;
    public TextView questText;

    private OnFragmentInteractionListener mListener;

    public QuestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestFragment newInstance(String param1, String param2) {
        QuestFragment fragment = new QuestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_USER_NAME);
            mDataBase = new ProfileDBManager(getActivity(), null, null, 1);
            UserProfile user = mDataBase.getProfile(mUserName);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quest, container, false);

        QuestString = (TextView) rootView.findViewById(R.id.questString);
        QuestString.setText("Nice to see you, " + mUserName + "! Let's see what we can find today!");

//        Create Image Buttons
        final ImageButton chest1 = (ImageButton) rootView.findViewById(R.id.chest1);

        chest1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        onButtonPressed(1);
                    }
                }
        );
        final ImageButton chest2 = (ImageButton) rootView.findViewById(R.id.chest2);

        chest1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        onButtonPressed(2);
                    }
                }
        );
        final ImageButton chest3 = (ImageButton) rootView.findViewById(R.id.chest3);

        chest1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        onButtonPressed(3);
                    }
                }
        );

//        Create Quest Text
        questText = (TextView)rootView.findViewById(R.id.questText);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int quest) {
        if (mListener != null) {
            questText.setText("Your Quest: Complete 5 question in the game(20xp).       Finished: 0/5");
            mListener.createQuest(quest);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void createQuest(int quest);
    }
}
