package com.example.androidgoapp.androidgoapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidgoapp.androidgoapp.R;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by Schokomonsterchen on 13.01.2017.
 */

public class GroupMapFragmentGo extends GroupMapFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected View defineView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.group_map_fragment_go, container, false);
    }

    @Override
    protected void go(MapView mapView) {
        GroupMapFragment groupMapFragment = new GroupMapFragment();
        groupMapFragment.setActuallView(mapView.getMapCenter(), mapView.getZoomLevel());
        getFragmentManager().beginTransaction()
                .replace(R.id.group_container, groupMapFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}