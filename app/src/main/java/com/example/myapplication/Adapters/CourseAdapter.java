package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.Course;
import com.example.myapplication.R;
import com.example.myapplication.UI.CourseDetails;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    //Grabbing the view from our recycler view layout file
    //Kind of like in the onCreate method
    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseItemView;
        private CourseViewHolder(View itemView){
            super(itemView);
            //courseListItemID is in the term_list_item
            courseItemView = itemView.findViewById(R.id.courseListItemID);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Course current = mCourses.get(position);
                    //This is where we set up what happens on click
                    Intent intent = new Intent(context, CourseDetails.class);
                    intent.putExtra("id", current.getCourseID());
                    intent.putExtra("name", current.getCourseTitle());
                    intent.putExtra("startDate", current.getCourseStartDate());
                    intent.putExtra("endDate", current.getCourseEndDate());
                    intent.putExtra("status", current.getCourseStatus());
                    intent.putExtra("instructorName", current.getInstructorName());
                    intent.putExtra("instructorPhone", current.getInstructorPhone());
                    intent.putExtra("instructorEmail", current.getInstructorEmail());
                    intent.putExtra("termID", current.getTermID());
                    context.startActivity(intent);
                }
            });
        }
    }

    private List<Course> mCourses;
    private final Context context;
    private final LayoutInflater mInflator;
    public CourseAdapter(Context context) {
        mInflator = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where we inflate the layout (Giving a look to our rows)
        View itemView = mInflator.inflate(R.layout.course_list_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        //Assigning values to the view we created in the layout file
        //Based on the position of the recycler view
        if (mCourses != null) {
            Course current = mCourses.get(position);
            String name = current.getCourseTitle();
            holder.courseItemView.setText(name);
        }
        else {
            holder.courseItemView.setText("No Course Name");
        }
    }

    public void setCourses(List<Course> course) {
        mCourses = course;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
