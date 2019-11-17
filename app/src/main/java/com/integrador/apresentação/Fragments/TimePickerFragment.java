package com.integrador.apresentação.Fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    private Calendar calendar = Calendar.getInstance();
    private Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
    private Integer minuto = calendar.get(Calendar.MINUTE);

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), this.hora, this.minuto, DateFormat.is24HourFormat(getActivity()));
    }
}
