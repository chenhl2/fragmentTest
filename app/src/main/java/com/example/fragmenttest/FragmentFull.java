package com.example.fragmenttest;

import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

public class FragmentFull extends Fragment {
    private static final String TAG = "FragmentFull";
    private ImageView mImageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate" );

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full, null);
        mImageView = view.findViewById(R.id.imageview_james_full);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(),"mImageView onClick",Toast.LENGTH_SHORT).show();
                FragmentDetails fragmentDetails = new FragmentDetails();
                // 设置共享元素的转场动画
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
