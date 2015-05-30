package app.legalsoft.ve;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


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
        GoogleMap map=((MapFragment)getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();

        if(map!=null){
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(23.597966, 58.215920)) // latitude and longitude info is given here
                    .title("Titklene")); // title for the marker
        }

        return v;
    }


}
