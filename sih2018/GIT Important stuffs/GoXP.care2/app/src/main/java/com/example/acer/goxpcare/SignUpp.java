package com.example.acer.goxpcare;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpp extends Fragment {

    TextInputEditText esignupfullname;
    View inflatedView = null;
    Button eclosebuttonsignup;
    Activity parentActivity;

    public void referance(Activity activity){
        this.parentActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_upp, container, false);
        this.inflatedView = view;
        eclosebuttonsignup = inflatedView.findViewById(R.id.closebuttonsignup);
        eclosebuttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentActivity.onBackPressed();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();

        esignupfullname = inflatedView.findViewById(R.id.signupfullname);
        esignupfullname.requestFocus();
        esignupfullname.setFocusableInTouchMode(true);
        new Handler().postDelayed(new Runnable(){
//
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(esignupfullname, InputMethodManager.SHOW_IMPLICIT);
            }
        },500);
    }

}
