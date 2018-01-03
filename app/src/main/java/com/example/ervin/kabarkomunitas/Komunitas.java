package com.example.ervin.kabarkomunitas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Komunitas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Komunitas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Komunitas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private OnFragmentInteractionListener mListener1;

    private RelativeLayout menu1;
    private RelativeLayout menu2;


    public Komunitas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Komunitas.
     */
    // TODO: Rename and change types and number of parameters
    public static Komunitas newInstance(String param1, String param2) {
        Komunitas fragment = new Komunitas();
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
        View rootView = inflater.inflate(R.layout.fragment_komunitas, container, false);
        // Inflate the layout for this fragment
        menu1 = (RelativeLayout) rootView.findViewById(R.id.menu1);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "KOMA", Toast.LENGTH_SHORT).show();

                Intent goPindah = new Intent(getActivity(), koma.class);
                startActivity(goPindah);
            }
        });
        return rootView;
    }


    public View onCreateView1(LayoutInflater inflater1, ViewGroup container1,
                              Bundle savedInstanceState) {
        View viewView = inflater1.inflate(R.layout.fragment_komunitas, container1, false);

        menu2 = (RelativeLayout) viewView.findViewById(R.id.menu2);

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View w) {
                Toast.makeText(getActivity(), "HMIF", Toast.LENGTH_SHORT).show();

                Intent goMove = new Intent(getActivity(), HMIF.class);
                startActivity(goMove);
            }
        });
        return viewView;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

