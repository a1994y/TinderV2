package com.example.tinderv2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnketADAPTER extends RecyclerView.Adapter<AnketADAPTER.AnketViewHolder> {


    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "LIKE";



    private Context mContext;
    private ArrayList<String> mNameHuman;


    public AnketADAPTER(Context mContext, ArrayList<String> mNameHuman) {
        this.mContext = mContext;
        this.mNameHuman = mNameHuman;
    }

    @NonNull
    @Override
    public AnketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anket, parent, false);
        AnketViewHolder holder = new AnketViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnketViewHolder holder, final int position) {

        holder.nameHuman.setText(mNameHuman.get(position));
        holder.likeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);

                Toast.makeText(mContext, mNameHuman.get(position), Toast.LENGTH_SHORT).show();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                        .setSmallIcon(R.drawable.noavatar)
                        .setContentTitle("Уведомление")
                        .setContentText("Вам понравилась(ся) " + mNameHuman.get(position))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                notificationManager.notify(NOTIFY_ID, builder.build());


            }
        });


    }

    @Override
    public int getItemCount() {
        return mNameHuman.size();
    }

    class AnketViewHolder extends RecyclerView.ViewHolder {


        TextView nameHuman;
        Button likeBTN;


        public AnketViewHolder(@NonNull View itemView) {
            super(itemView);

            nameHuman = itemView.findViewById(R.id.nameAnket);
            likeBTN = itemView.findViewById(R.id.likeBTN);

        }
    }

}
