package abualgokh.itqan.com.abualgokh;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abualgokh.itqan.com.abualgokh.fragment.ContactUsFragment;
import abualgokh.itqan.com.abualgokh.fragment.MaintanceFragment;

public class MainActivity extends AppCompatActivity {

  //  MaintanceFragment maintanceFragment;


    ContactUsFragment contactUsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        contactUsFragment = new ContactUsFragment();
       // maintanceFragment = new MaintanceFragment();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction().
                add(R.id.contactusfragment,contactUsFragment);

        fragmentTransaction.commit();

    }
}
