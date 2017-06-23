package example.tweetlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import example.helpers.ReachabilityHelper;

public class MainActivity extends AppCompatActivity {

    //constants
    public static String EXTRA_MESSAGE = "com.example.activities.MainActivity.MESSAGE";

    //view groups
    private EditText mThemeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mThemeEditText = (EditText) this.findViewById(R.id.editText);
    }

    /**
     * called when user tap search button
     */
    public void searchAction(View v) {

        // get edited text keywords
        String mThemeText = mThemeEditText.getText().toString();

        //check reachability before launch intent
        if(ReachabilityHelper.isOnline(getApplicationContext())){

            //create intent to launch new activity with extra message
            Intent intent = new Intent(this, TweetListActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mThemeText);
            startActivity(intent);
        }


    }
}
