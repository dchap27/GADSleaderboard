package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadsleaderboard.services.LeaderBoardService;
import com.example.gadsleaderboard.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();
    private View mPopupDialogView;
    private TextView mResponseMessage;
    private ImageView mResponseImage;
    private TextView mSubmitQuestion;
    private Button mAnswerButton;
    private ConstraintLayout mQuestionContainer;
    private ConstraintLayout mResponseContainer;
    private boolean[] answer;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private EditText mLink;
    private ConstraintLayout formContainer;
    private LinearLayout formView;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        TextView title = (TextView) findViewById(R.id.text_submit_title);
        title.setText("Project Submission");

        mFirstName = (EditText) findViewById(R.id.text_view_firstname);
        mLastName = (EditText) findViewById(R.id.text_view_lastname);
        mEmail = (EditText) findViewById(R.id.text_view_email);
        mLink = (EditText) findViewById(R.id.text_view_projectlink);

        formContainer = (ConstraintLayout) findViewById(R.id.ConstraintLayout_submission_container);
        formView = findViewById(R.id.linearLayout_submit_form);

        submitButton = (Button) findViewById(R.id.button_project_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                formContainer.setBackgroundColor(getResources().getColor(R.color.submission_color));
                formView.setVisibility(View.GONE);
                submitButton.setVisibility(View.GONE);

                checkSubmission();
            }
        });


    }

    private void checkSubmission() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        initializePopupDialog();
        alertDialogBuilder.setView(mPopupDialogView);
        mQuestionContainer.setVisibility(View.VISIBLE);
        mResponseContainer.setVisibility(View.INVISIBLE);
        mSubmitQuestion.setText("Are you Sure?");
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        mAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
                alertDialog.cancel();
            }
        });
    }

    private void submit(){
        String fName = mFirstName.getText().toString();
        String lname = mLastName.getText().toString();
        String emailAddress = mEmail.getText().toString();
        String projectLink = mLink.getText().toString();
        String SUBMISSION_URL = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

        if (validateInputDetails()) {

            LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
            Call<Void> leaderBoardRequest = leaderBoardService.submitEntry(SUBMISSION_URL,
                    fName, lname, emailAddress, projectLink);
            Log.d(TAG, "Post data to " + SUBMISSION_URL);
            leaderBoardRequest.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.d(TAG, "Post data successful ");
                    loadSuccessMessage();
                    Intent intent = new Intent(SubmissionActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.d(TAG, "Post data failed! " + t);
                    Toast.makeText(SubmissionActivity.this,
                            "Failed to retrieve leaderboards", Toast.LENGTH_LONG).show();
                    loadFailureMessage();
                    formContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    formView.setVisibility(View.VISIBLE);
                    submitButton.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private boolean validateInputDetails() {
        if(mFirstName.getText().toString().trim().isEmpty()){
            Toast.makeText(SubmissionActivity.this, "First name entry is required.", Toast.LENGTH_SHORT).show();
            mFirstName.requestFocus();
            return false;
        }
        if(mLastName.getText().toString().trim().isEmpty()){
            Toast.makeText(SubmissionActivity.this, "Last name entry is required.", Toast.LENGTH_SHORT).show();
            mLastName.requestFocus();
            return false;
        }
        if(mEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(SubmissionActivity.this, "Email entry is required.", Toast.LENGTH_SHORT).show();
            mEmail.requestFocus();
            return false;
        }
        if(mLink.getText().toString().trim().isEmpty()){
            Toast.makeText(SubmissionActivity.this, "Link url entry is required.", Toast.LENGTH_SHORT).show();
            mLink.requestFocus();
            return false;
        }
        return true;
    }

    private void loadSuccessMessage() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        initializePopupDialog();
        alertDialogBuilder.setView(mPopupDialogView);
        mQuestionContainer.setVisibility(View.GONE);
        mResponseContainer.setVisibility(View.VISIBLE);
        mResponseMessage.setText("Submission Successful");
        mResponseImage.setImageDrawable(getDrawable(R.drawable.ic_check_circle_black_24dp));
        mResponseImage.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.success_color)));
        // alertDialogBuilder.setCancelable(false);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    private void loadFailureMessage(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        initializePopupDialog();
        alertDialogBuilder.setView(mPopupDialogView);
        mQuestionContainer.setVisibility(View.GONE);
        mResponseContainer.setVisibility(View.VISIBLE);
        mResponseMessage.setText("Submission not Successuful");
        mResponseImage.setImageDrawable(getDrawable(R.drawable.ic_report_problem_black_24dp));
        mResponseImage.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.failure_color)));
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void initializePopupDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(SubmissionActivity.this);
        mPopupDialogView = layoutInflater.inflate(R.layout.response_message, null);
        mResponseMessage = mPopupDialogView.findViewById(R.id.text_response_view);
        mQuestionContainer = mPopupDialogView.findViewById(R.id.ConstraintLayout_validate);
        mResponseContainer = mPopupDialogView.findViewById(R.id.ConstraintLayout_response);
        mResponseImage = mPopupDialogView.findViewById(R.id.image_response);
        mSubmitQuestion = mPopupDialogView.findViewById(R.id.text_submit_question);
        mAnswerButton = mPopupDialogView.findViewById(R.id.button_yes_submit);

        // Containers to be Invisible until needed
        mQuestionContainer.setVisibility(View.INVISIBLE);
        mResponseContainer.setVisibility(View.INVISIBLE);
    }
}
