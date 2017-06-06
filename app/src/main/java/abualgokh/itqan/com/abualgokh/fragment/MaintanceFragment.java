package abualgokh.itqan.com.abualgokh.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import abualgokh.itqan.com.abualgokh.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaintanceFragment extends Fragment {



    //views
    private Button btnOpenCamera;
    private Button btnBrowse;
    private ImageView imageView;
    private Toolbar toolbar;

    private  int TAKE_PICTURE_CODE_THIS_FRAGMENT = 1;

    private  int PICK_IMAGE_FROM_YOUR_GALLERY = 2 ;
    Bitmap myBitmap;
    public MaintanceFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_maintance,container,false);



        //toolbar
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);





        //Views


        btnOpenCamera = (Button)view.findViewById(R.id.btnopencamera);
        imageView = (ImageView)view.findViewById(R.id.imageview);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCamera();
            }
        });
        btnBrowse=(Button)view.findViewById(R.id.btnbrowse);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_FROM_YOUR_GALLERY);
            }
        });
        return view;
    }

    private void OpenCamera(){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, TAKE_PICTURE_CODE_THIS_FRAGMENT);
    }

    private void processCameraImage(Intent intent) {

        myBitmap = (Bitmap) intent.getExtras().get("data");

        imageView.setImageBitmap(myBitmap);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (TAKE_PICTURE_CODE_THIS_FRAGMENT == requestCode) {

            //set data to processCameraImage()
            processCameraImage(data);

        }else
        if (requestCode == PICK_IMAGE_FROM_YOUR_GALLERY && resultCode == RESULT_OK && data != null && data.getData() != null) {
           Pick_Image_From_Gallery_Deivce(data);
        }
    }

    private void Pick_Image_From_Gallery_Deivce(Intent data){

        Uri uri = data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
