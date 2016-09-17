package com.applications.primoz.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.applications.primoz.herome.Activites.MainActivity;
import com.applications.primoz.herome.R;

public class BackstoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button primaryBtn;
    private Button secondaryBtn;
    private Button restartBtn;
    private ImageView superImg;
    private TextView tvDescription;
    private ImageView blankImg;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private BackStoryInteractionListener mListener;
    private TextView tvHero;

    String hero, powerPrimary, powerSecondary;

    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        String powerPicked = MainActivity.POWER_PICKED;
        String powerHow = MainActivity.POWER_HOW;
        String powerActual = MainActivity.POWER_ACTUAL;
        String powerSecondary = MainActivity.POWER_SECONDARY;
        String heroName = MainActivity.HERO_NAME;
        int heroImg = MainActivity.HERO_IMG;
        int primarySRC = MainActivity.POWER_SRC_IMG;
        int secondarySRC = MainActivity.POWER_SRC_SECONDARY_IMG;


        primaryBtn = (Button) view.findViewById(R.id.primaryBtn);
        secondaryBtn = (Button) view.findViewById(R.id.secondaryBtn);
        restartBtn = (Button) view.findViewById(R.id.restartBtn);
        tvHero = (TextView) view.findViewById(R.id.tvHero);
        superImg = (ImageView) view.findViewById(R.id.superImg);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);

        tvHero.setText(heroName);
        superImg.setImageResource(heroImg);

        tvDescription.setText("Your main power is " + powerPicked + " " + powerHow + "OK i don't know how to to describe it...");

        primaryBtn.setText(powerActual);
        primaryBtn.setCompoundDrawablesWithIntrinsicBounds(primarySRC, 0, 0, 0);

        secondaryBtn.setText(powerSecondary);
        secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(secondarySRC, 0, 0, 0);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadMain();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackStoryInteractionListener) {
            mListener = (BackStoryInteractionListener) context;
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
    public interface BackStoryInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
