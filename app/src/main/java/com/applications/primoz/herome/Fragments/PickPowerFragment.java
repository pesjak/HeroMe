package com.applications.primoz.herome.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.applications.primoz.herome.Activites.MainActivity;
import com.applications.primoz.herome.R;


public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button turtleBtn;
    Button lightningBtn;
    Button flightBtn;
    Button webSlingingBtn;
    Button laserVisionBtn;
    Button superStrengthBtn;
    Button showBackstoryBtn;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private PickPowerInteractionListerner mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);


        turtleBtn = (Button) view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button) view.findViewById(R.id.lightningBtn);
        flightBtn = (Button) view.findViewById(R.id.flightBtn);
        webSlingingBtn = (Button) view.findViewById(R.id.webSlingingBtn);
        laserVisionBtn = (Button) view.findViewById(R.id.laserVisionBtn);
        superStrengthBtn = (Button) view.findViewById(R.id.superStrengthBtn);
        showBackstoryBtn = (Button) view.findViewById(R.id.showBackstoryBtn);


        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webSlingingBtn.setOnClickListener(this);
        laserVisionBtn.setOnClickListener(this);
        superStrengthBtn.setOnClickListener(this);


        showBackstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadBackstory();
            }
        });

        showBackstoryBtn.setEnabled(false);
        showBackstoryBtn.getBackground().setAlpha(128);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListerner) {
            mListener = (PickPowerInteractionListerner) context;
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

    @Override
    public void onClick(View view) {
        showBackstoryBtn.setEnabled(true);
        showBackstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power, 0, 0, 0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer, 0, 0, 0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest, 0, 0, 0);
        webSlingingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web, 0, 0, 0);
        laserVisionBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision, 0, 0, 0);
        superStrengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength, 0, 0, 0);

        Button btn = (Button) view;
        int leftDrawable = 0;


        if (btn == turtleBtn) {
            leftDrawable = R.drawable.turtle_power;
            MainActivity.POWER_PICKED = "powers of the turtle and ninjas, how awesome is that?";
            MainActivity.POWER_ACTUAL = "TURTLE POWER";
            MainActivity.POWER_SECONDARY = "FLIGHT";
            MainActivity.HERO_NAME = "Ninja Turtle Main";
            MainActivity.HERO_IMG = R.drawable.turtle_power;
            MainActivity.POWER_SRC_IMG = R.drawable.turtle_power;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.super_man_crest;
        } else if (btn == lightningBtn) {
            leftDrawable = R.drawable.thors_hammer;
            MainActivity.POWER_PICKED = "almost like the fastest man alive.";
            MainActivity.POWER_ACTUAL = "LIGHTNING";
            MainActivity.POWER_SECONDARY = "SUPER STRENGTH";
            MainActivity.HERO_NAME = "Electrycity Man";
            MainActivity.HERO_IMG = R.drawable.lightning;
            MainActivity.POWER_SRC_IMG = R.drawable.thors_hammer;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.super_strength;
        } else if (btn == flightBtn) {
            leftDrawable = R.drawable.super_man_crest;
            MainActivity.POWER_PICKED = "nice guy like superman.";
            MainActivity.POWER_ACTUAL = "FLIGHT";
            MainActivity.POWER_SECONDARY = "LASER VISION";
            MainActivity.HERO_NAME = "LightUp Guy";
            MainActivity.HERO_IMG = R.drawable.big_superman_logo;
            MainActivity.POWER_SRC_IMG = R.drawable.super_man_crest;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.laser_vision;
        } else if (btn == webSlingingBtn) {
            leftDrawable = R.drawable.spider_web;
            MainActivity.POWER_PICKED = "consistently sticky hands";
            MainActivity.POWER_ACTUAL = "WEB SLINGING";
            MainActivity.POWER_SECONDARY = "SUPER STRENGTH";
            MainActivity.HERO_NAME = "Spajder Man";
            MainActivity.HERO_IMG = R.drawable.spider_web;
            MainActivity.POWER_SRC_IMG = R.drawable.spider_web;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.turtle_power;
        } else if (btn == laserVisionBtn) {
            leftDrawable = R.drawable.laser_vision;
            MainActivity.POWER_PICKED = "lasers. No need fo anything else.";
            MainActivity.POWER_ACTUAL = "LASER VISION";
            MainActivity.POWER_SECONDARY = "LIGHTNING";
            MainActivity.HERO_NAME = "Red Eye";
            MainActivity.HERO_IMG = R.drawable.laser_vision;
            MainActivity.POWER_SRC_IMG = R.drawable.laser_vision;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.thors_hammer;
        } else if (btn == superStrengthBtn) {
            leftDrawable = R.drawable.super_strength;
            MainActivity.POWER_PICKED = "yup he is strong.";
            MainActivity.POWER_ACTUAL = "SUPER STRENGTH";
            MainActivity.POWER_SECONDARY = "LIGHTNING";
            MainActivity.HERO_NAME = "Helpsyoumove Friend";
            MainActivity.HERO_IMG = R.drawable.super_strength;
            MainActivity.POWER_SRC_IMG = R.drawable.super_strength;
            MainActivity.POWER_SRC_SECONDARY_IMG = R.drawable.spider_web;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);


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
    public interface PickPowerInteractionListerner {
        // TODO: Update argument type and name
        void onFragmentInteraction(String source);
    }
}
