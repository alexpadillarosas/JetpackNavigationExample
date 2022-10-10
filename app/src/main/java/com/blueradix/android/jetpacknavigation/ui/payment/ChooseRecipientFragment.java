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
import com.blueradix.android.jetpacknavigation.databinding.ChooseRecipientFragmentBinding;

public class ChooseRecipientFragment extends Fragment {

    private ChooseRecipientViewModel mViewModel;
    private ChooseRecipientFragmentBinding binding;

    public static ChooseRecipientFragment newInstance() {
        return new ChooseRecipientFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ChooseRecipientFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ChooseRecipientViewModel.class);

        binding.recipientNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipientName = binding.recipientEditText.getText().toString();
                NavController navController = Navigation.findNavController(view);

                Bundle bundle = new Bundle();
                bundle.putString("recipientName", recipientName);

                navController.navigate(R.id.action_chooseRecipientFragment_to_paymentDetailsFragment, bundle);
            }
        });

        binding.recipientCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


    }
}