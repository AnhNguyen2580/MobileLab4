package com.lab4.tvmovie.Model;

import com.lab4.tvmovie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    public static final String MOVIE_CATEGORY = "Favorite movie";

    private static List<Movie> list;
    private static long count = 0;

    public static List<Movie> getList() {
        if (list == null) {
            list = setupMovies();
        }
        return list;
    }

    public static List<Movie> setupMovies() {
        list = new ArrayList<>();
        String title[] = {
                "Sherlock Holmes",
                "Moon Knight (2022)",
                "The Flash (2014)",
                "Halo (2022)",
                "Fantastic Beasts: The Secrets of Dumbledore (2022)"
        };

        String description[] = {
                "Eccentric consulting detective Sherlock Holmes and Doctor John Watson battle to bring down a new nemesis and unravel a deadly plot that could destroy England. "
                , "When Steven Grant, a mild-mannered gift-shop employee, becomes plagued with blackouts and memories of another life, he discovers he has dissociative identity disorder and shares a body with mercenary Marc Spector. As Steven/Marc’s enemies converge upon them, they must navigate their complex identities while thrust into a deadly mystery among the powerful gods of Egypt. "
                , "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash. "
                , "Depicting an epic 26th-century conflict between humanity and an alien threat known as the Covenant, the series weaves deeply drawn personal stories with action, adventure and a richly imagined vision of the future. "
                , "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers. "
               };
        String studio[] = {
                "BBC One", "Marvel|Disney+", " DC Comics", "Paramount +", "Marvel"
        };
        String videoUrl[] = {
                "https://firebasestorage.googleapis.com/v0/b/fir-fe0e1.appspot.com/o/movie%2FSherlock%20Holmes%203-%20The%20Last%20Investigation%20-%20New%20Trailer%20%5BHD%5D%20Robert%20Downey%20Jr..mp4?alt=media&token=345aa2cc-e71f-4cb2-89d7-484ddaa07452",
                "https://firebasestorage.googleapis.com/v0/b/fir-fe0e1.appspot.com/o/movie%2FMarvel%20Studios%E2%80%99%20Moon%20Knight%20-%20Official%20Trailer%20-%20Disney%2B.mp4?alt=media&token=51a1f978-c5e5-4259-b093-59a3c5d7a2e6",
                "https://firebasestorage.googleapis.com/v0/b/fir-fe0e1.appspot.com/o/movie%2FTHE%20FLASH%20Trailer%20(2022).mp4?alt=media&token=a224bd69-d2ac-4886-bd8b-013d60d490cd",
                "https://firebasestorage.googleapis.com/v0/b/fir-fe0e1.appspot.com/o/movie%2FHalo%20The%20Series%20(2022)%20-%20Official%20Trailer%202%20-%20Paramount%2B.mp4?alt=media&token=bf3762c5-5fd4-413b-8d0d-2976588b8697",
                "https://firebasestorage.googleapis.com/v0/b/fir-fe0e1.appspot.com/o/movie%2FFantastic%20Beasts-%20The%20Secrets%20of%20Dumbledore%20%E2%80%93%20Official%20Trailer%202.mp4?alt=media&token=35ebfe58-4aee-4f42-abca-d752c45ced8d"
        };
        String bgImageUrl[] = {
                "https://static2.vieon.vn/vieplay-image/thumbnail_v4/2022/02/21/q31z3ezc_1920x1080-sherlockholmes.jpg",
                "https://voices.shortpedia.com/wp-content/uploads/2022/05/moon-knight-poster-1200x900@superherohype.jpg",
                "https://i.ytimg.com/vi/xKsf54hLb6o/maxresdefault.jpg",
                "https://laptopmedia.com/wp-content/uploads/2020/11/1577748571_364773_1577791063_portada_normal.jpg",
                "https://telusworldofscienceedmonton.ca/media/images/1216311.2e16d0ba.fill-1920x1080.format-webp.webp",
        };
        String cardImageUrl[] = {
                "https://static2.vieon.vn/vieplay-image/thumbnail_v4/2022/02/21/q31z3ezc_1920x1080-sherlockholmes.jpg",
                "https://images.thedirect.com/media/article_full/moon-knight-review.jpg",
                "https://www.studyphim.vn/system/movies/121/thumbnails/original/1.jpg",
                "https://scx2.b-cdn.net/gfx/news/2019/haloreachcom.jpg",
                "https://media.molistar.com/original/2022/04/10/XT/62525083a867d_1.jpg"
        };

        for (int index = 0; index < title.length; ++index) {
            list.add(
                    buildMovieInfo(
                            title[index],
                            description[index],
                            studio[index],
                            videoUrl[index],
                            cardImageUrl[index],
                            bgImageUrl[index]));
        }

        return list;
    }

    private static Movie buildMovieInfo(
            String title,
            String description,
            String studio,
            String videoUrl,
            String cardImageUrl,
            String backgroundImageUrl) {
        Movie movie = new Movie();
        movie.setId(count++);
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setStudio(studio);
        movie.setCardImageUrl(cardImageUrl);
        movie.setBackgroundImageUrl(backgroundImageUrl);
        movie.setVideoUrl(videoUrl);
        return movie;
    }
}