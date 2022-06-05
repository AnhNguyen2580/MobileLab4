package com.lab4.tvmovie.Presenter;

import android.graphics.drawable.Drawable;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import androidx.core.content.ContextCompat;

import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lab4.tvmovie.Model.Movie;
import com.lab4.tvmovie.R;

public class CardPresenter extends Presenter {

    private static final int CARD_WIDTH = 410;
    private static final int CARD_HEIGHT = 266;

    private static int sSelectedBackgroundColor;
    private static int sDefaultBackgroundColor;
    private Drawable mDefaultCardImage;

    private static void updateCardBackgroundColor(ImageCardView view, boolean selected) {
        int color = selected ? sSelectedBackgroundColor : sDefaultBackgroundColor;

        view.setBackgroundColor(color);
        view.setInfoAreaBackgroundColor(color);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        sDefaultBackgroundColor =
                ContextCompat.getColor(parent.getContext(), R.color.default_background);
        sSelectedBackgroundColor =
                ContextCompat.getColor(parent.getContext(), R.color.selected_background);
        mDefaultCardImage = ContextCompat.getDrawable(parent.getContext(), R.drawable.movie);

        ImageCardView cardView =
                new ImageCardView(parent.getContext()) {
                    @Override
                    public void setSelected(boolean selected) {
                        updateCardBackgroundColor(this, selected);
                        super.setSelected(selected);
                    }
                };
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        updateCardBackgroundColor(cardView, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;

        if (movie.getCardImageUrl() != null) {

//            Create feature for card
            cardView.setTitleText(movie.getTitle());
            cardView.setContentText(movie.getStudio());
            cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);

            Glide.with(viewHolder.view.getContext())
                    .load(movie.getCardImageUrl())
                    .fitCenter()
                    .error(mDefaultCardImage)
                    .into(cardView.getMainImageView());

        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

        ImageCardView cardView = (ImageCardView) viewHolder.view;

        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }
}