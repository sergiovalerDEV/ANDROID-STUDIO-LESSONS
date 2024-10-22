package com.example.wallapop.register_user;

import com.example.wallapop.beans.User;

public interface ContractRegisterUser {
    interface View {
        void successRegister(User user);
        void failureRegister(String err);
    }

    interface Presenter {
        void register(User user);
    }

    interface Model {
        interface OnRegisterUserListener {
            void onFinished(User user);
            void onFailure(String err);
        }

        void registerApi(User user, OnRegisterUserListener onRegisterUserListener);
    }
}