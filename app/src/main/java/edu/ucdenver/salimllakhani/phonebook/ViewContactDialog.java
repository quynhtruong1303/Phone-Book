package edu.ucdenver.salimllakhani.phonebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;

import edu.ucdenver.salimllakhani.phonebook.databinding.DialogViewContactBinding;

public class ViewContactDialog extends DialogFragment {

    private DialogViewContactBinding binding;
    private Contact contact;

    // Constructor to receive the contact object
    public ViewContactDialog(Contact contact) {
        this.contact = contact;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        binding = DialogViewContactBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        // Set all the contact information in the TextViews
        binding.textViewName.setText(contact.getName());
        binding.textViewPhone.setText(contact.getPhone());
        binding.textViewEmail.setText(contact.getEmail());

        // Combine address fields into a single string
        String fullAddress = contact.getAddress() + ", " +
                contact.getCity() + ", " +
                contact.getState() + " " +
                contact.getZip();
        binding.textViewAddress.setText(fullAddress);

        binding.textViewContactType.setText(contact.getContacttype());

        // Set click listener for dismiss button
        binding.buttonDismiss.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        dismiss();
                    }
                }
        );

        return builder.create();
    }
}