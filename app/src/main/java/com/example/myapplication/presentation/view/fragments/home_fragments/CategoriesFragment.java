package com.example.myapplication.presentation.view.fragments.home_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentCategoriesBinding;
import com.example.myapplication.presentation.view.activities.MainActivity;
import com.example.myapplication.presentation.view.fragments.adapters.CategoryAdapter;

public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding binding;

    private RecyclerView recyclerView;

    private ProgressBar progressBar;


    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using ViewBinding
        binding = FragmentCategoriesBinding.inflate(inflater, container, false);
        initListeners();
        return binding.getRoot();
    }

    private void initListeners(){
        progressBar = binding.progressBar;
        recyclerView = binding.categoriesRecycleView;
        initObservers();
        showProgressDialog();
        MainActivity.mainViewModel.getCategories();

    }

    private void initObservers() {
        MainActivity.allCategoriesLiveData.observe(this, categories -> {
            hideProgressDialog();
            CategoryAdapter categoryAdapter = new CategoryAdapter(categories, getParentFragment());
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(categoryAdapter);
        });
    }

    private void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }


}