package com.avondrix.score;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.avondrix.score.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ScoreViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }
}
