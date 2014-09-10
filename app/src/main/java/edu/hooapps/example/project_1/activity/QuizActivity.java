package edu.hooapps.example.project_1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import edu.hooapps.example.project_1.R;
import edu.hooapps.example.project_1.fragment.QuizFragment;

/**
 * Basic activity to host the fragments.
 */
public class QuizActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState == null) {
            // Add a new Quiz fragment to the FrameLayout (R.id.container)
            getFragmentManager().beginTransaction()                 // Start the transcation
                    .add(R.id.container, new QuizFragment())        // Add the new QuizFragment
                    .commit();                                      // Execute the transaction
        }
    }

    // ------------------------------------------------------------------------------------------
    // For now, ignore the next two methods. They are responsible for creating the settings menu
    // when the menu button is pressed. The menu button will be covered in later lessons
    // ------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
