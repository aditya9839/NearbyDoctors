package com.example.acer.goxpcare;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Fragment {

    Button mclose;
    TextInputEditText eloginemail5;

    View inflatedView = null;
    KeyListener originalKeyListener;

    public Login() {


    }

    @Override
    public void onResume() {
        super.onResume();
        eloginemail5 = inflatedView.findViewById(R.id.loginemail5);
//        eloginemail5.setKeyListener(originalKeyListener);
        eloginemail5.requestFocus();
        eloginemail5.setFocusableInTouchMode(true);

        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(eloginemail5, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        this.inflatedView = view;
        mclose = inflatedView.findViewById(R.id.closebutton);

        return view;

    }

}
