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
    
    private ArrayList<String> noteTitles;
    private ArrayList<String> noteBodies;
    private Context mContext;

    public Adapter (ArrayList<String> noteTitles, ArrayList<String> noteBodies, Context mContext) {
        this.noteTitles = noteTitles;
        this.noteBodies = noteBodies;
        this.mContext = mContext;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
    
        TextView noteTitle;
        TextView noteBody;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.NoteTitle);
            noteBody = itemView.findViewById(R.id.NoteBody);
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

        viewHolder.noteTitle.setText(noteTitles.get(i));
        viewHolder.noteBody.setText(noteBodies.get(i));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + noteTitles.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteBodies.size();
    }

    public void toast(String message){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(mContext, message, duration);
        toast.show();
    }

}
