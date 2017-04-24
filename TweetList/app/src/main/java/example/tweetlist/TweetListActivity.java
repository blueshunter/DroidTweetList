package example.tweetlist;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import example.manager.TwitterManager;
import retrofit2.Call;



public class TweetListActivity extends AppCompatActivity {


    LinearLayout tweetContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        this.tweetContainer = (LinearLayout) findViewById(R.id.tweet_container);

        Bundle bundle = getIntent().getExtras();
        String extraValue = bundle.getString("search");

        if(extraValue != null)
        {
            this.searchByKeyword(extraValue);
        }
    }

    public void searchByKeyword(String keyword){

        TwitterManager.authenticate(this.getBaseContext());

        long maxId = 10000 ;
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        final SearchService service = Twitter.getApiClient().getSearchService();

        Locale currentLocale = getResources().getConfiguration().locale;
        String lan = currentLocale.getISO3Language().substring(0,2);

        Call<Search> searchCal = service.tweets("%23"+keyword, null, lan, null, "mixed", 30, null, null,
                null, true);

        searchCal.enqueue(new Callback<Search>() {
            @Override
            public void success(Result<Search> result) {

                for(Tweet tweet : result.data.tweets){

                    tweetContainer.addView(new TweetView(TweetListActivity.this, tweet));
                }
            }

            public void failure(TwitterException exception) {

                //TODO implement error gesture
                Toast.makeText(getApplicationContext(),exception.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
