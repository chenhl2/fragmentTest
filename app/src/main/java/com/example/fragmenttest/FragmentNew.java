package com.example.fragmenttest;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

public class FragmentNew extends Fragment {
    private ImageView mImageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new,null);
        mImageView = view.findViewById(R.id.imageview_james);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentDetails fragmentDetails = new FragmentDetails();
                fragmentDetails.setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
                getFragmentManager().beginTransaction()
                        .addSharedElement(view, ViewCompat.getTransitionName(view))
                        .replace(R.id.framelayout_fragment,fragmentDetails)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
