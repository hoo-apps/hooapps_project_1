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

public class QuizFragment extends Fragment {

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private int score = 0;
    private int questionNum = 0;

    private TextView questionTextView;
    private TextView scoreTextView;
    private Button trueButton;
    private Button falseButton;

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

        return rootView;
    }

    private void checkAnswer(boolean answer) {
        if (answer == questionList.get(questionNum).getAnswer()) {
            Toast.makeText(this.getActivity(), "Correct",
                    Toast.LENGTH_SHORT).show();
            score++;
            scoreTextView.setText("Score: " + score);
        } else {
            Toast.makeText(this.getActivity(), "Incorrect",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void advanceToNextQuestion() {
        questionNum++;
        if (questionNum >= questionList.size()) {
            questionNum = 0;
            score = 0;
            scoreTextView.setText("Score: " + score);
            Collections.shuffle(questionList);
            Toast.makeText(this.getActivity(), "Game complete. Restarting...",
                    Toast.LENGTH_SHORT).show();
        }
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
