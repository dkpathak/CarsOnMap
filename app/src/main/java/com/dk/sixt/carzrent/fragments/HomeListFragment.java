package com.dk.sixt.carzrent.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.sixt.carzrent.R;
import com.dk.sixt.carzrent.adapters.CarsAdapter;
import com.dk.sixt.carzrent.apis.ApiInterface;
import com.dk.sixt.carzrent.apis.ApiManager;
import com.dk.sixt.carzrent.models.Cars;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private List<Cars> carList;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param carsList Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeListFragment newInstance(List carsList, String param2) {
        HomeListFragment fragment = new HomeListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, (ArrayList<? extends Parcelable>) carsList);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            carList = getArguments().getParcelableArrayList(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.cars_recycler_view);
//        getData();
        updateUI(carList);
        super.onViewCreated(view, savedInstanceState);

    }

    private void getData() {
        ApiInterface apiInterface = ApiManager.getInstance(getActivity()).getApiInterface();
        Call<List<Cars>> carListCall = apiInterface.getCars();
        carListCall.enqueue(new Callback<List<Cars>>() {
            @Override
            public void onResponse(Call<List<Cars>> call, Response<List<Cars>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    List<Cars> carsList = response.body();
                    updateUI(carsList);
                }
            }

            @Override
            public void onFailure(Call<List<Cars>> call, Throwable t) {
                Log.i("Cardata","Failed");

            }
        });
    }

    private void updateUI(List<Cars> carsList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CarsAdapter(getContext(),carsList));
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
