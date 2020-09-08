package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearnerRecyclerAdapter extends RecyclerView.Adapter<LearnerRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private List<LearnersInfo> mLearners;
    private final LayoutInflater mLayoutInflater;

    public LearnerRecyclerAdapter(Context context, List<LearnersInfo> learners) {
        this.mContext = context;
        mLearners = learners;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_learner_list, parent, false);
        return new ViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearnersInfo learner = mLearners.get(position);
        holder.mTextLearner.setText(learner.getmName());
        holder.mTextHoursWatched.setText(learner.getmHoursWatched()+ " learning hours, " + learner.getmCountry());
    }

    @Override
    public int getItemCount() {
        return mLearners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextLearner;
        public final TextView mTextHoursWatched;

        public ViewHolder(View itemView){
            super(itemView);
            mTextLearner = (TextView) itemView.findViewById(R.id.text_name_view);
            mTextHoursWatched = (TextView) itemView.findViewById(R.id.text_score_view);

        }
    }

}
