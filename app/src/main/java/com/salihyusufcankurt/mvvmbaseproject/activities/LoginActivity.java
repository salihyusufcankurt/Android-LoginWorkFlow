package com.salihyusufcankurt.mvvmbaseproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import es.dmoral.toasty.Toasty;

import android.os.Bundle;
import android.widget.Toast;

import com.salihyusufcankurt.mvvmbaseproject.interfaces.LoginResultCallbacks;
import com.salihyusufcankurt.mvvmbaseproject.R;
import com.salihyusufcankurt.mvvmbaseproject.viewmodel.LoginViewModel;
import com.salihyusufcankurt.mvvmbaseproject.viewmodel.LoginViewModelFactory;
import com.salihyusufcankurt.mvvmbaseproject.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModel(ViewModelProviders.of
                (this, new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
