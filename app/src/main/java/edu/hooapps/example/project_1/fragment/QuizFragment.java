package edu.hooapps.example.project_1.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import edu.hooapps.example.project_1.R;
import edu.hooapps.example.project_1.model.Question;

/**
 * The meat of the app. QuizFragment handles the logic of switching questions as well as
 * displaying content on the screen.
 */
public class QuizFragment extends Fragment {

    // Initialize the private fields to store data
    private ArrayList<Question> questionList = new ArrayList<Question>();
    private int score = 0;
    private int questionNum = 0;

    // Initialize private variables for the relevant views on the fragment
    private TextView questionTextView;
    private TextView scoreTextView;
    private Button trueButton;
    private Button falseButton;

    /**
     * Called when the fragment is first displayed on the screen.
     * Param descriptions from: developer.android.com
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in
     *                 the fragment,
     * @param container If non-null, this is the parent view that the fragment's UI should
     *                  be attached to. The fragment should not add the view itself, but this
     *                  can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a
     *                           previous saved state as given here.
     * @return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Add the Questions to the questionList
        initQuestionList();

        // Retrieve the views from the rootView
        questionTextView = (TextView) rootView.findViewById(R.id.text_question);
        scoreTextView = (TextView) rootView.findViewById(R.id.text_score);
        trueButton = (Button) rootView.findViewById(R.id.button_true);
        falseButton = (Button) rootView.findViewById(R.id.button_false);

        // Display the first question on the screen
        questionTextView.setText(questionList.get(questionNum).getQuestionText());

        // Bind the onClickListeners to the Buttons
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                advanceToNextQuestion();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                advanceToNextQuestion();
            }
        });

        // Return the rootView to be displayed in the FrameLayout
        return rootView;
    }

    /**
     * Checks if the answer the user entered is correct
     * @param answer The user's answer
     */
    private void checkAnswer(boolean answer) {
        // If the answer is correct, update the score
        if (answer == questionList.get(questionNum).getAnswer()) {
            // Display a message to the user
            // NOTE: Be sure to call .show() when using Toast
            Toast.makeText(this.getActivity(), "Correct", Toast.LENGTH_SHORT).show();

            // Increment the score
            score++;

            // Display the score on the scoreTextView
            scoreTextView.setText("Score: " + score);
        }
        // Else, notify the user
        else {
            // Display a message to the user
            Toast.makeText(this.getActivity(), "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Displays the next question on the screen. If the user has answer every question,
     * the score and question count are set to 0 and the quiz is restarted
     */
    private void advanceToNextQuestion() {
        // Increment the question number
        questionNum++;

        // Check if all the questions have been displayed
        if (questionNum >= questionList.size()) {

            // Reset the questionNum and score
            questionNum = 0;
            score = 0;

            // Update the scoreTextView to display the new score (0)
            scoreTextView.setText("Score: " + score);

            // Randomize the list of questions
            Collections.shuffle(questionList);

            // Notify the user that the game is restarting
            Toast.makeText(this.getActivity(), "Game complete. Restarting...",
                    Toast.LENGTH_SHORT).show();
        }

        // Update the text displayed in the questionTextView
        questionTextView.setText(questionList.get(questionNum).getQuestionText());
    }

    /**
     * Create 10 true/false questions in questionList
     */
    private void initQuestionList() {
        Question question0 = new Question("Dr. Seuss was denied admittance to UVA. Rumor has it the name for the fictional town of \"Whoville\" was a pun off the University's nickname, \"Hoos\".", true);
        Question question1 = new Question("The official mascot for UVA is the cavaliers, but they unofficially adopted the Wahoos, a fish that can drink its weight in water, as their second mascot. While it was originally shouted as an insult by an opposing school at a football game, the students at UVA instead adopted it as a name.", true);
        Question question2 = new Question("UVA was founded in 1819 by Thomas Jefferson, who was this nation's first secretary of state, second vice president, and third president.", true);
        Question question3 = new Question("UVA's undergraduate student body is 65% out of state.", true);
        Question question4 = new Question("The founder of MIT was an engineering professor who came from UVA.", true);
        Question question5 = new Question("In May 2005, there was a water slide that went down the middle of the UVA Lawn.", false);
        Question question6 = new Question("The Rotunda has been under construction for 99.1 % of its life.", false);
        Question question7 = new Question("UVA was founded in 1831 by Christopher Columbus.", false);
        Question question8 = new Question("UVA has put 15 monkeys on the moon.", false);
        Question question9 = new Question("UVA's current President is Chuck Norris, and he lives in the Steam Tunnels with the Ninja Turtles.", false);

        questionList.add(question0);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);

        Collections.shuffle(questionList);
    }
}
