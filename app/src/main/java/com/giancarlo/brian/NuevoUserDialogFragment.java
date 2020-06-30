package com.giancarlo.brian;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.giancarlo.brian.db.entity.UserEntity;

public class NuevoUserDialogFragment extends DialogFragment {

    public static NuevoUserDialogFragment newInstance() {
        return new NuevoUserDialogFragment();
    }
    private View view;
    private EditText etName,etPassword;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Introdusca los Datos de Usuario")
                .setPositiveButton("Guardar!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = etName.getText().toString();
                        String password = etPassword.getText().toString();

                        NuevoUserDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUserDialogViewModel.class);
                        mViewModel.insertarUser(new UserEntity(name,password));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nuevo_user_dialog_fragment, null);

        etName = view.findViewById(R.id.editTextName);
        etPassword = view.findViewById(R.id.editTextPassword);

        builder.setView(view);

        return builder.create();
    }
}