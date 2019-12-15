package com.salihyusufcankurt.mvvmbaseproject.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.salihyusufcankurt.mvvmbaseproject.interfaces.LoginResultCallbacks;
import com.salihyusufcankurt.mvvmbaseproject.model.UserModel;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private UserModel user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new UserModel();
    }

    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setEmail(editable.toString().toLowerCase());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(editable.toString().toLowerCase());
            }
        };
    }

    public void onLoginClicked(View view){
        int errorCode = user.isValidData();
        if(errorCode ==0)
            loginResultCallbacks.onFailure("You must enter email address!");
        else if(errorCode==1)
            loginResultCallbacks.onFailure("Your email is invalid");
        else if(errorCode==2)
            loginResultCallbacks.onFailure("Password length must be greater than 6 characters");
        else
            loginResultCallbacks.onSuccess("Login success!");

    }

}
