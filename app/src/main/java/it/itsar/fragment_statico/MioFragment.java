package it.itsar.fragment_statico;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MioFragment extends Fragment {

    private TextView textView;
    private String text;
    private Button button;
    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text);
        textView.setText(text);
        button = view.findViewById(R.id.button);
        frameLayout = view.findViewById(R.id.frame);
        button.setOnClickListener(view1 -> {
            if (textView.getVisibility() == View.VISIBLE) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MioFragment);
        CharSequence myString = a.getText(R.styleable.MioFragment_my_string);
        if (myString != null) {
            text = myString.toString();
            Log.v("TAG", "My string received: " + myString.toString());
        }

        int myNumber = a.getInt(R.styleable.MioFragment_my_number, -1);
        if (myNumber != -1) {
            Log.v("TAG", "My string received: " + myNumber);
        }

        a.recycle();
    }


}