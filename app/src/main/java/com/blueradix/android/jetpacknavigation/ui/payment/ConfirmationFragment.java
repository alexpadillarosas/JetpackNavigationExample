package com.blueradix.android.jetpacknavigation.ui.payment;

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
import com.blueradix.android.jetpacknavigation.databinding.ConfirmationFragmentBinding;

public class ConfirmationFragment extends Fragment {

    private ConfirmationViewModel mViewModel;
    private ConfirmationFragmentBinding binding;

    public static ConfirmationFragment newInstance() {
        return new ConfirmationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ConfirmationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConfirmationViewModel.class);

        String recipientName = getArguments().getString("recipientName");
        Double amount = getArguments().getDouble("amount");
        binding.confirmationMessageTextView.setText("You have sent " + amount.toString() + " to " + recipientName);

        binding.confirmationGoBackHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_confirmationFragment_to_mainMenuFragment);
            }
        });

    }
}