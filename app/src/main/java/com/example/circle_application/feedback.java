package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioGroup optionsRadioGroup1;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private RatingBar ratingBar;
    private Button submitButton;
    private TextView thankYouTextView; // Add this line

    private String[] questions = {
            "How was your booking experience?",
            "Did you encounter any difficulties during the booking process?Then clicked on appropriate problem you faced. ",
            "What was the behaviour of the driver?",
            "How was the overall experience?",
            "Please rate our app"
    };

    private String[][] options = {
            {"Very nice", "Good" , "Decent", "Worse"},
            {"Payment method", "User interface ", "Lagging problem", "Crashing"},
            {"very nice", "Good", "Decent", " Bad"},
            {"Very good", "Good", "Decent", "Worse"},
            {}
    };

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        optionsRadioGroup1 = findViewById(R.id.optionsRadioGroup1);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        ratingBar = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitButton);
        thankYouTextView = findViewById(R.id.thankYouTextView); // Add this line

        showQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.length-1 ) {
                    // If it's not the last question, move to the next question
                    currentQuestionIndex++;

                    if (!validateAnswer()) {
                        // If no option is selected, show a toast and return
                        Toast.makeText(feedback.this, "Please select an option", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    showQuestion();
                } else {
                    // If it's the last question, process the feedback
                    processFeedback();
                }
            }

            private boolean validateAnswer() {
                int selectedOptionId1=-1;
                int selectedOptionId2=-1;
                selectedOptionId1 = optionsRadioGroup.getCheckedRadioButtonId();
                selectedOptionId2 = optionsRadioGroup1.getCheckedRadioButtonId();
                return selectedOptionId1 != -1 || selectedOptionId2!=-1;
            }

        });
    }

    private void showQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        ratingBar.setVisibility(View.GONE);
        thankYouTextView.setVisibility(View.GONE); // Add this line

        // Reset radio buttons
        optionsRadioGroup.clearCheck();
        optionsRadioGroup1.clearCheck();


        String[] questionOptions = options[currentQuestionIndex];
        if (questionOptions.length == 4) {
            option1RadioButton.setText(questionOptions[0]);
            option2RadioButton.setText(questionOptions[1]);
            option3RadioButton.setText(questionOptions[2]);
            option4RadioButton.setText(questionOptions[3]);
        } else {
            // Hide options radio group if no options available
            optionsRadioGroup.setVisibility(View.GONE);
            optionsRadioGroup1.setVisibility(View.GONE);
        }

        // Hide options for the last question
        if (currentQuestionIndex == questions.length-1) {
            optionsRadioGroup.setVisibility(View.GONE);
            optionsRadioGroup1.setVisibility(View.GONE);
            ratingBar.setVisibility(View.VISIBLE);
        }
    }


    private void processFeedback() {
        // Process the feedback here, for example, you can collect the selected ratings/options
        // For demonstration purpose, just showing a toast with the rating
        float rating = ratingBar.getRating();
        thankYouTextView.setVisibility(View.VISIBLE); // Add this line
        Toast.makeText(feedback.this, "Thank you for your feedback! Rating: " + rating, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent booking = new Intent(feedback.this, slideBar.class);
                startActivity(booking);
                finish();
            }
        },3000);
    }


    }
