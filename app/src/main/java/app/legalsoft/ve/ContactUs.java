package app.legalsoft.ve;


import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import app.legalsoft.ve.util.CONSTANTS;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {

    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);
        GoogleMap map=((MapFragment)getActivity().getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();

        setHasOptionsMenu(true);

        if (map != null){

            LatLng latLng = new LatLng(CONSTANTS.OFFICE_LATITUDE, CONSTANTS.OFFICE_LONGITUDE);

            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.addMarker(new MarkerOptions()

                    .position(latLng) // latitude and longitude info is given here
                    .title("Titklene")); // title for the marker

            map.getUiSettings().setZoomControlsEnabled(true);
            map.setMyLocationEnabled(true);


            CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(10.0f).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            map.moveCamera(cameraUpdate);

            // Getting LocationManager object from System Service LOCATION_SERVICE
            //LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();

            // Getting the name of the best provider
            //String provider = locationManager.getBestProvider(criteria, true);

            // Getting Current Location
            //Location location = locationManager.getLastKnownLocation(provider);

            //if(location!=null){
            //    onLocationChanged(location);
            //}
            //locationManager.requestLocationUpdates(provider, 20000, 0, this);

        }

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_contact_us, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_contactus_openmaps){
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=" + CONSTANTS.OFFICE_LATITUDE + "," + CONSTANTS.OFFICE_LONGITUDE + " (Shaqsi Advocate Office)"));
            startActivity(intent);
        }

        return true;

    }
}
