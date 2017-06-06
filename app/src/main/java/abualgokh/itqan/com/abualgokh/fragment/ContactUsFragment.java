package abualgokh.itqan.com.abualgokh.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import abualgokh.itqan.com.abualgokh.R;
import abualgokh.itqan.com.abualgokh.model.locationcompany;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment  {




    private Button btnlocation;
    private Toolbar toolbar;
    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        btnlocation=(Button)view.findViewById(R.id.btnlocation);
        final locationcompany locationcompany = new locationcompany();
        locationcompany.setLatitude("30.035264");
        locationcompany.setLangtitude("31.279304");
        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String urlAddress = "http://maps.google.com/maps?q=" + locationcompany.getLatitude() + "," + locationcompany.getLangtitude()+ "("+ "AbuAlgokh" + ")";
                    Intent maps = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAddress));
                    startActivity(maps);

            }
        });
        return  view;
    }





}
