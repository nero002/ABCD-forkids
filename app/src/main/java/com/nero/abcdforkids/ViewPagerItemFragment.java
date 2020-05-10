package com.nero.abcdforkids;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nero.abcdforkids.models.Alphabet;

public class ViewPagerItemFragment extends Fragment {

    private ImageView mImageView;


    //vars
    private Alphabet mAlphabet;

    public static ViewPagerItemFragment getInstance(Alphabet alphabet){
        ViewPagerItemFragment fragment = new ViewPagerItemFragment();

        if(alphabet  != null){
            Bundle bundle = new Bundle();
            bundle.putParcelable("alphabet", alphabet);
            fragment.setArguments(bundle);
        }
        return fragment;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null)
        {
            mAlphabet = getArguments().getParcelable("alphabet");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viewpager_item,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mImageView = view.findViewById(R.id.image);

        init();
    }
    private void init(){
        if(mAlphabet !=null){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            Glide.with(getActivity())
                    .setDefaultRequestOptions(options)
                    .load(mAlphabet.getImage())
                    .into(mImageView);

        }
    }
}
