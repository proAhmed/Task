package com.ahmed.testforapp.screens.detailScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmed.testforapp.R;
import com.ahmed.testforapp.base.BaseFragment;
import com.ahmed.testforapp.di.helper.ViewModelFactory;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;

public class DetailFragment extends BaseFragment {

    @Inject
    ViewModelFactory viewModelFactory;
    private DetailViewModel detailsViewModel;
    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.tvDetail)
    TextView tvDetail;
    @BindView(R.id.tvCation)
    TextView tvCation;
    @BindView(R.id.tvSource)
    TextView tvSource;
    @BindView(R.id.tvtByLine)
    TextView tvtByLine;
    @BindView(R.id.tvDate)
    TextView tvDate;
    private TextView tv;

    @Override
    protected int layoutRes() {
        return R.layout.detail_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         tv = getBaseActivity().findViewById(R.id.tvToolbar);

        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailViewModel.class);
        detailsViewModel.restoreFromBundle(savedInstanceState);
        displayRepo();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        detailsViewModel.saveToBundle(outState);
    }
    private void displayRepo() {
        detailsViewModel.getSelectedRepo().observe(this, article -> {
            if (article != null) {
                tv.setText(String.valueOf(article.getTitle()));
                imgDetail.setContentDescription(article.getMedia().getCaption());
                Picasso.get().load(article.getMedia().getMediaMetadata().get(2).getUrl()).into(imgDetail);
                tvDetail.setText(article.getAbstract());
                tvSource.setText(article.getSource());
                tvtByLine.setText(article.getByline());
                tvCation.setText(article.getMedia().getCopyright());
                tvDate.setText(article.getPublishedDate());

            }
        });
    }

}
