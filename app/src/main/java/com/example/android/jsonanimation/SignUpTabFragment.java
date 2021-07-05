package com.example.android.jsonanimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class SignUpTabFragment extends Fragment {

    EditText email, pass, fName, lName;
    AppCompatButton login;
    float v = 0;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

////        don't know why we used root
//        email = root.findViewById(R.id.email);
//        pass = root.findViewById(R.id.pass);
//        fName = root.findViewById(R.id.user_FirstName);
//        lName = root.findViewById(R.id.user_lastName);
//        login = root.findViewById(R.id.signup_button);
//
//        // Applying Animations
//        email.setTranslationX(800);
//        pass.setTranslationX(800);
//        fName.setTranslationX(800);
//        lName.setTranslationX(800);
//        login.setTranslationX(800);
//
//        email.setAlpha(v);
//        pass.setAlpha(v);
//        fName.setAlpha(v);
//        lName.setAlpha(v);
//        login.setAlpha(v);
//
//        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
//        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
//        fName.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
//        lName.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
//        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
