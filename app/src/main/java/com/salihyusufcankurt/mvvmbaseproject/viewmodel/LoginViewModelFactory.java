package com.salihyusufcankurt.mvvmbaseproject.viewmodel;

import com.salihyusufcankurt.mvvmbaseproject.interfaces.LoginResultCallbacks;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModelFactory(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        return (T) new LoginViewModel(loginResultCallbacks);
    }
}
