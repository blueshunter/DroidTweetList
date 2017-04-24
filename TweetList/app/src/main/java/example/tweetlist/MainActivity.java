package example.tweetlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import example.manager.TwitterManager;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity {

    private EditText themeEditText;
    private String themeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initUI();
    }

    private void initUI(){

        themeEditText = (EditText) this.findViewById(R.id.editText);
    }

    public void showTweets(List<Tweet> tweets){

        Intent intent = new Intent(this, TweetListActivity.class);

        List<String> tweetsIds = new ArrayList<>();
        for(Tweet  tweet : tweets){
            tweetsIds.add(tweet.idStr);
        }



        intent.putExtra("tweets", (Serializable)tweetsIds);
        startActivity(intent);
    }

    public void searchAction(View v){


        themeText = themeEditText.getText().toString();

        //put theme on tweet list activity

        //TODO check reachability before launch intent
        Intent intent = new Intent(this, TweetListActivity.class);
        intent.putExtra("search", themeText);
        startActivity(intent);
    }
}
