package com.example.androidgoapp.androidgoapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidgoapp.androidgoapp.R;

/**
 * Created by Schokomonsterchen on 12.01.2017.
 */

public class GroupMembersFragment extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private int groupID; // platzhalter

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        if(admin()) {
            view = inflater.inflate(R.layout.groupmembers_fragment_admin, container, false);
        } else {
            view = inflater.inflate(R.layout.groupmembers_fragment, container, false);
        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        //performance boost
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MemberAdapter(groupID);
        mRecyclerView.setAdapter(mAdapter);

        view.findViewById(R.id.groupname_button).setOnClickListener(this);
        if(admin()) {
            view.findViewById(R.id.appointment_button).setOnClickListener(this);
            view.findViewById(R.id.add_member_button).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (R.id.groupname_button == id) {
            Fragment groupMapFragment;
            if (go()) {
                groupMapFragment = new GroupMapGoFragment();
            } else {
                groupMapFragment = new GroupMapNotGoFragment();
            }    getFragmentManager().beginTransaction()
                    .replace(R.id.group_container, groupMapFragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        } else if (R.id.appointment_button == id) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.group_container, new GroupAppointmentFragment())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        } else if (R.id.add_member_button == id) {

        }

    }

    private boolean admin() {
        //TODO: überprüfen, ob dieser Client admin ist
        return true;
    }

    private boolean go() {
        //TODO: überprüfen, ob go gedrückt ist
        return true;
    }

}
