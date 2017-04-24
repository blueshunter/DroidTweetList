package example.manager;

/**
 * Created by JavaJazz on 20/04/2017.
 */
import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;

import java.io.IOException;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;

public class TwitterManager {

    static private TwitterAuthConfig authConfig;


    static public void authenticate(Context baseContext){

        try{
            String consumerKey = baseContext.getString(example.tweetlist.R.string.twitter_consumer_api_key);
            String consumerSecret = baseContext.getString(example.tweetlist.R.string.twitter_consumer_secret_api_key);
            TwitterManager.authConfig = new TwitterAuthConfig(consumerKey, consumerSecret);
            Fabric.with(baseContext, new Twitter(authConfig));
        }
        catch(Exception e){

            //TODO show error
        }

    }

    static public void getTweetsByTheme(String theme) throws Exception{




    }
}
