package com.example.wallapop.login_user.presenter;


import com.example.wallapop.beans.User;
import com.example.wallapop.login_user.ContractLoginUser;
import com.example.wallapop.login_user.model.LoginUserModel;

public class LoginUserPresenter implements ContractLoginUser.Presenter, ContractLoginUser.Model.OnLoginUserListener {
    private ContractLoginUser.View view;
    private ContractLoginUser.Model model;

    public LoginUserPresenter(ContractLoginUser.View view){
        this.view = view;
        model = new LoginUserModel();
    }

    @Override
    public void login(User user) {
        if (isValidInput(user)){
            model.loginApi(user, this);
        }else{
            view.failureLogin("El email y la contraseña no pueden estar vacíos");
        }
    }

    private boolean isValidInput(User user){
        return user != null && user.getEmail() != null && !user.getEmail().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty();
    }
    @Override
    public void onFinished(User user) {
        view.successLogin(user);

    }

    @Override
    public void onFailure(String err) {
        view.failureLogin(err);

    }


}
