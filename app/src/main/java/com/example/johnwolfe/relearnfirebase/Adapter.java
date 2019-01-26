package com.example.johnwolfe.relearnfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

//                                               <ClassName.ViewHolderMethod>
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private static final String TAG = "Adapter";

    private ArrayList<String> noteImages;
    private ArrayList<String> noteTitles;
    private Context mContext;

    public Adapter(ArrayList<String> noteImages, ArrayList<String> noteTitles, Context mContext) {
        this.noteImages = noteImages;
        this.noteTitles = noteTitles;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView noteImage;
        TextView noteTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteImage = itemView.findViewById(R.id.NoteImage);
            noteTitle = itemView.findViewById(R.id.NoteTitle);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Copy paste for any new RecyclerView
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_note, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "New Item Printed: " + i);

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(noteImages.get(i))
                .apply(requestOptions)
                .into(viewHolder.noteImage);

        viewHolder.noteTitle.setText(noteTitles.get(i));
        viewHolder.noteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + noteTitles.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteImages.size();
    }

    public void toast(String message){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(mContext, message, duration);
        toast.show();
    }




}
