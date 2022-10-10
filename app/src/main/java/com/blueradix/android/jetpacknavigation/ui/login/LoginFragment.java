package com.blueradix.android.jetpacknavigation.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigation.R;
import com.blueradix.android.jetpacknavigation.databinding.LoginFragmentBinding;
import com.blueradix.android.jetpacknavigation.user.User;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    private LoginFragmentBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);




        binding.logonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Navigate to the next Destination
                NavController navController = Navigation.findNavController(view);
                //First code this, show the transition works, then comment this line and pass the bundle.
//                navController.navigate(R.id.action_loginFragment_to_mainMenuFragment);

                String username = binding.usernameEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();
                //create the user object
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                Bundle bundle = new Bundle();
                bundle.putSerializable("LoggedInUser", user);

                navController.navigate(R.id.action_loginFragment_to_mainMenuFragment, bundle);
            }
        });



    }
}