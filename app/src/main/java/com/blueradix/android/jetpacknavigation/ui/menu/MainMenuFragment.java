package com.blueradix.android.jetpacknavigation.ui.menu;

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
import com.blueradix.android.jetpacknavigation.databinding.MainMenuFragmentBinding;
import com.blueradix.android.jetpacknavigation.user.User;

import java.io.Serializable;

public class MainMenuFragment extends Fragment {

    private MainMenuViewModel mViewModel;
    private MainMenuFragmentBinding binding;

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainMenuFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainMenuViewModel.class);

        NavController navController = Navigation.findNavController(view);
//        navController.getCurrentDestination().getAction()

        //check if the we have arguments and if so, also the bundle contains "LoggedInUser"
        User loggedInUser;
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("LoggedInUser")) {
            loggedInUser = (User) getArguments().getSerializable("LoggedInUser");
            binding.welcomeTextView.setText("Welcome " + loggedInUser.getUsername());
        }else{

        }


        binding.sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_mainMenuFragment_to_chooseRecipientFragment);
            }
        });

    }
}