package com.ahmed.testforapp.screens.mainScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ahmed.testforapp.R;
import com.ahmed.testforapp.adapter.ArticleAdapter;
import com.ahmed.testforapp.base.BaseActivity;
import com.ahmed.testforapp.base.BaseFragment;
import com.ahmed.testforapp.di.helper.ViewModelFactory;
import com.ahmed.testforapp.interfaces.OnAdapterClick;
import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.screens.detailScreen.DetailFragment;
import com.ahmed.testforapp.screens.detailScreen.DetailViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainFragment extends BaseFragment implements OnAdapterClick<Article> {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @BindView(R.id.loading_view)
    View loadingView;
    @Inject
    ViewModelFactory viewModelFactory;
    private MainViewModel viewModel;
    @Override
    protected int layoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData(){
        viewModel = ViewModelProviders.of(getBaseActivity(),viewModelFactory).get(MainViewModel.class);

        viewModel.getData();
        List<Article> articleServerList = viewModel.getRepos().getValue();
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        observableViewModel();

        if(articleServerList !=null){
            recyclerView.setAdapter(new ArticleAdapter(getBaseActivity(),viewModel,this));
        }
    }
    private void observableViewModel(){
        viewModel.getRepos().observe(this,articleList->{
            if (articleList!=null){
                recyclerView.setAdapter(new ArticleAdapter(getBaseActivity(),viewModel,this));
                recyclerView.setVisibility(View.VISIBLE);
            }

        });
        viewModel.getError().observe(this, error -> {
            if(error!=null){
                if(error){
                    errorTextView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    errorTextView.setText(getResources().getString(R.string.error));
                }
            }
        });
        viewModel.getLoading().observe(getBaseActivity(), isLoading -> {
            if(isLoading!=null){
                if(isLoading){
                    loadingView.setVisibility(View.VISIBLE);
                    errorTextView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }else {
                    loadingView.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(Article article) {
        DetailViewModel detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailViewModel.class);
        detailsViewModel.setSelectedArticle(article);
        BaseActivity baseActivity = (BaseActivity) getBaseActivity();
        baseActivity.fragmentMoveAddBackStack(new DetailFragment());
    }
}
